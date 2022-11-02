package com.rniyablog.service.impl;

import com.rniyablog.dao.admin.BlogsDao;
import com.rniyablog.dao.admin.CommentDao;
import com.rniyablog.entity.Comment;
import com.rniyablog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月29日 14:52
 * @Description:
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private BlogsDao blogsDao;
    private List<Comment> tempReplys = new ArrayList<>();

    @Override
    public List<Comment> listCommentByBlogId(Long blogId) {
        //查询父节点
        List<Comment> comments = commentDao.getBlogIdParentIdIsNull(blogId);
        for (Comment comment : comments) {
            Long id = comment.getId();
            String parentNickName1 = comment.getNickname();
            List<Comment> childComments = commentDao.getBlogIdParentIdNotNull(blogId,id);
            //查询子评论
            combineChildren(blogId,childComments,parentNickName1);
            comment.setReplyComments(tempReplys);
            tempReplys = new ArrayList<>();
        }
        return comments;
    }

    //查询出子评论

    private void combineChildren(Long blogId, List<Comment> childComments, String parentNickname1) {
        //判断是否有一级子评论
        if (childComments.size() > 0) {
            //循环找出子评论的id
            for (Comment childComment : childComments) {
                String parentNickname = childComment.getNickname();
                childComment.setParentNickname(parentNickname1);
                tempReplys.add(childComment);
                Long childId = childComment.getId();
                //查询出子二级评论
                recursively(blogId, childId, parentNickname);
            }
        }
    }
    //循环迭代找出子集回复

    private void recursively(Long blogId, Long childId, String parentNickname1) {
        //根据子一级评论的id找到子二级评论
        List<Comment> replayComments = commentDao.findByBlogIdAndReplayId(blogId, childId);

        if (replayComments.size() > 0) {
            for (Comment replayComment : replayComments) {
                String parentNickname = replayComment.getNickname();
                replayComment.setParentNickname(parentNickname1);
                Long replayId = replayComment.getId();
                tempReplys.add(replayComment);
                recursively(blogId, replayId, parentNickname);
            }
        }
    }

    @Override
    public int saveComment(Comment comment, Comment parentComment) {
        comment.setCreateTime(new Date());
        int comments = commentDao.saveComment(comment);
        blogsDao.getCommentCountById(comment.getBlogId());
        return comments;
    }

    @Override
    public void deleteComment(Comment comment, Long id) {

        Long blogId = comment.getBlogId();
        //通过id查找父级评论
        Comment comment1 = commentDao.findBlogIdParentIdIsNull(blogId,id);
        String parentNickName1 = comment.getNickname();
        List<Comment> childComments = commentDao.getBlogIdParentIdNotNull(blogId,id);
        //查询子评论
        combineChildren(blogId,childComments,parentNickName1);
        comment1.setReplyComments(tempReplys);
        for (Comment replyComment : comment1.getReplyComments()){
            commentDao.deleteComment(replyComment.getId());
        }
        commentDao.deleteComment(id);
        blogsDao.getCommentCountById(comment.getBlogId());
    }
}
