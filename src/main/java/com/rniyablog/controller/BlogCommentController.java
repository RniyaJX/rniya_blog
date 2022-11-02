package com.rniyablog.controller;

import com.rniyablog.annotation.AccessLimit;
import com.rniyablog.entity.Comment;
import com.rniyablog.entity.User;
import com.rniyablog.queryvo.BlogParticular;
import com.rniyablog.service.BlogsService;
import com.rniyablog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

/**
 * @author: Rniya
 * @date: 2022年10月05日 14:19
 * @Description:
 */
@Controller
public class BlogCommentController {

    @Autowired
    private CommentService commentService;

    @Autowired
    private BlogsService blogsService;
    @Value("${comment.avatar}")
    private String avatar;

    //添加评论
    @PostMapping("/comments")
    @AccessLimit(seconds = 15, maxCount = 3) //15秒内最多允许请求3次
    public String addComment(Comment comment, HttpSession session, Model model) {
        Long blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        //设置头像与是否管理员评论
        if(user != null){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            if(Objects.equals(comment.getAvatar(), "")){
                comment.setAvatar(avatar);
            }
        }
        Long parentId = comment.getParentComment().getId();
        Comment parentComment = null;
        if (comment.getParentComment().getId() != null){
            comment.setParentCommentId(parentId);
        }
        commentService.saveComment(comment,parentComment);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments",comments);
        return "blog/blog-particular :: commentList";
    }

    //查询评论列表
    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog/blog-particular :: commentList";
    }

    //删除评论
    @GetMapping("/comment/{blogId}/{id}/delete")
    public String deleteComment(@PathVariable Long blogId, @PathVariable Long id, Comment comment, HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user != null) {
            commentService.deleteComment(comment,id);
        }
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        BlogParticular blogParticular = blogsService.getBlogParticularById(blogId);
        model.addAttribute("blogParticular",blogParticular);
        model.addAttribute("comments", comments);
        return "redirect:/blog/" + blogId;
    }


}
