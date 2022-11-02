package com.rniyablog.controller;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rniyablog.entity.Blog;
import com.rniyablog.entity.Comment;
import com.rniyablog.queryvo.BlogList;
import com.rniyablog.queryvo.BlogParticular;
import com.rniyablog.queryvo.IndexSelect;
import com.rniyablog.queryvo.TagBlogs;
import com.rniyablog.service.BlogsService;
import com.rniyablog.service.CommentService;
import com.rniyablog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;

/**
 * @author: Rniya
 * @date: 2022年09月04日 16:09
 * @Description: 博客页面控制类
 */
@Controller
@RequestMapping("/")
public class BlogIndexController {

    @Autowired
    private BlogsService blogsService;
    @Autowired
    private TagService tagService;
    @Autowired
    private CommentService commentService;

    //博客列表
    @RequestMapping(value = {"/", "/index",})
    public String index(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "create_time desc";
        IndexSelect indexSelect = blogsService.selectIndexMessage();
        PageHelper.startPage(pageNum, 5, orderBy);
        List<BlogList> list = blogsService.getBlogList();
        PageInfo<BlogList> pageInfo = new PageInfo<BlogList>(list);
        List<TagBlogs> tags = tagService.findAll();
        model.addAttribute("tags", tags);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("indexSelect", indexSelect);
        return "/blog/index";
    }

    //搜索博客
    @GetMapping("/blog/search")
    public String search(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,String title) {
        String orderBy = "create_time desc";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<Blog> list = blogsService.getBlogByTitle(title);
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "/blog/blog-search";
    }

    //跳转博客详情页面
    @GetMapping("/blog/{id}")
    public String blog(Model model,@PathVariable Long id){
        BlogParticular blogParticular = blogsService.getBlogParticularById(id);
        List<Comment> comments = commentService.listCommentByBlogId(id);
        model.addAttribute("comments",comments);
        model.addAttribute("blogParticular",blogParticular);
        return "blog/blog-particular";
    }

    @RequestMapping("/archive")
    public String archive(Model model){
        Map<String,List<Blog>> archiveList = blogsService.getArchive();
        int count = 0;
        for (String key : archiveList.keySet()){
            List<Blog> blogs = archiveList.get(key);
            count += blogs.size();
        }
        model.addAttribute("count",count);
        model.addAttribute("archiveList",archiveList);
        return "blog/archive";
    }

    @RequestMapping("/about")
    public String about(){
        return "blog/about";
    }


}
