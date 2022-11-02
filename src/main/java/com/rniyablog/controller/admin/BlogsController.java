package com.rniyablog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rniyablog.entity.Blog;
import com.rniyablog.entity.User;
import com.rniyablog.queryvo.BlogTags;
import com.rniyablog.queryvo.SearchBlog;
import com.rniyablog.queryvo.TagBlogs;
import com.rniyablog.service.BlogsService;
import com.rniyablog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月06日 15:52
 * @Description:Blog控制类
 */
@Controller
@RequestMapping("/admin")
public class BlogsController {

    @Autowired
    private BlogsService blogsService;

    @Autowired
    private TagService tagService;

    //展示博客列表
    @RequestMapping("/blogs")
    public String findAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        //排序
        String orderBy = "create_time desc";
        PageHelper.startPage(pageNum,5, orderBy);
        List<Blog> list = blogsService.getAllBlog();
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/blogs";
    }

    //跳转新增页面
    @RequestMapping("/blogsInput")
    public String inputAction(Model model) {
        model.addAttribute("blog",new Blog());
        model.addAttribute("tags",tagService.findAll());
        return "admin/blogs-input";
    }

    //新增博客
    @PostMapping("/blogs/input")
    public String blogInput(Blog blog, RedirectAttributes attributes, HttpSession session) {
        blog.setUser((User)session.getAttribute("user"));
        blog.setUserId(blog.getUser().getId());
        String message = blogsService.saveBlog(blog);
        attributes.addFlashAttribute("message",message);
        return "redirect:/admin/blogs";
    }

    //删除博客
    @GetMapping("/blogs/{id}/delete")
    public String blogDelete(@PathVariable Long id, RedirectAttributes attributes) {
        blogsService.delete(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/blogs";
    }

    //跳转修改页面
    @GetMapping("/blogs/{id}/edit")
    public String blogUpdate(@PathVariable Long id, Model model) {
        Blog blog = blogsService.getBlogById(id);
        List<TagBlogs> tags = tagService.findAll();
        model.addAttribute("tags",tags);
        model.addAttribute("blog", blog);
        return "admin/blogs-input";
    }

    @PostMapping("/blogs/{id}/update")
    public String editPost(@Validated Blog blog, RedirectAttributes attributes,HttpSession session) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setUserId(blog.getUser().getId());
        int b =blogsService.updateBlog(blog);
        if (b==0){
            attributes.addFlashAttribute("message","修改失败");
        } else {
            attributes.addFlashAttribute("message","修改成功");
        }
        return "redirect:/admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String searchByCondition(SearchBlog searchBlog, Model model,@RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        List<Blog> list = blogsService.searchByCondition(searchBlog);
        PageHelper.startPage(pageNum, 10, "createTime desc");
        PageInfo<Blog> pageInfo = new PageInfo<Blog>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "/admin/blogs";
    }



}
