package com.rniyablog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rniyablog.queryvo.BlogList;
import com.rniyablog.queryvo.IndexSelect;
import com.rniyablog.queryvo.TagBlogs;
import com.rniyablog.service.BlogsService;
import com.rniyablog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年10月09日 17:43
 * @Description:
 */
@Controller
public class BlogTagController {

    @Autowired
    private TagService tagService;

    @Autowired
    private BlogsService blogsService;

//    @RequestMapping("/tag")
//    public String tagList(Model model){
//        List<TagBlogs> tags = tagService.findAll();
//        model.addAttribute("tags",tags);
//        model.addAttribute("blogs",null);
//        return "/blog/tags";
//    }

    @GetMapping(value = {"/tag/{tagId}", "/tag/blogList/{tagId}"})
    public String tagBlogList(Model model, @PathVariable Long tagId, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum){
        String orderBy = "create_time desc";
        List<TagBlogs> tags = tagService.findAll();
        if (tagId == -1){
            tagId = tags.get(0).getTagId();
        }
        PageHelper.startPage(pageNum, 5, orderBy);
        List<BlogList> list = blogsService.getBlogListByTagId(tagId);
        PageInfo<BlogList> pageInfo = new PageInfo<BlogList>(list);
        model.addAttribute("tags",tags);
        model.addAttribute("pageInfo", pageInfo);
        return "/blog/tags";
    }

}
