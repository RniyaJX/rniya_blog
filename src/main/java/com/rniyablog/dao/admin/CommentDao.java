package com.rniyablog.dao.admin;

import com.rniyablog.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月19日 20:45
 * @Description:
 */

@Mapper
@Repository
public interface CommentDao {

    List<Comment> getAllComment();

    List<Comment> getCommentByBlogId(Long blogId);

    List<Comment> getBlogIdParentIdNotNull(Long blogId, Long id);

    List<Comment> findByBlogIdAndReplayId(Long blogId, Long childId);

    List<Comment> getBlogIdParentIdIsNull(Long blogId);

    int saveComment(Comment comment);

    void deleteComment(Long id);

    Comment findBlogIdParentIdIsNull(Long blogId, Long id);
}
