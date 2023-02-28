package com.rniyablog.service.impl;

import com.rniyablog.NotFoundException;
import com.rniyablog.dao.admin.BlogsDao;
import com.rniyablog.dao.admin.CommentDao;
import com.rniyablog.dao.admin.TagDao;
import com.rniyablog.dao.admin.UserDao;
import com.rniyablog.entity.Blog;
import com.rniyablog.queryvo.*;
import com.rniyablog.service.BlogsService;
import com.rniyablog.util.MarkdownUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * @author: Rniya
 * @date: 2022年09月07日 16:19
 * @Description:
 */
@Service
public class BlogsServiceImpl implements BlogsService {

    @Autowired
    private BlogsDao blogsDao;
    @Autowired
    private CommentDao commentDao;
    @Autowired
    private TagDao tagDao;
    @Autowired
    private UserDao userDao;

    //查询博客列表
    @Override
    public List<Blog> getAllBlog() {
        return blogsDao.getAllBlog();
    }

    @Override
    public List<BlogList> getBlogList() {
        return blogsDao.getBlogList();
    }

    //保存博客
    @Override
    @Transactional
    public String saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setViews(0);
        int b = blogsDao.saveBlog(blog);
        String message = "";
        if(b == 0){
            message = "操作失败";
        }else {
            if(addBlogTags(splitTagIds(blog.getTagIds()),blog) == 0){
                message = "标签添加失败";
            }else{
                message = "操作成功";
            }
        }
        return message;
    }

    @Transactional
    public int addBlogTags(List<String> tagIds,Blog blog){
        List<BlogTags> blogTags = new ArrayList<>();
        tagDao.deleteBlogTagsByBlogId(blog);
        for (String id : tagIds){
            BlogTags bt = new BlogTags();
            bt.setBlogId(blog.getId());
            bt.setTagId(Long.valueOf(id));
            blogTags.add(bt);
        }
        return tagDao.saveBlogTags(blogTags);
    }

    public List<String> splitTagIds(String tags){
        List<String> tagIds = Arrays.asList(tags.split(","));
        return tagIds;
    }

    //删除博客
    @Override
    public void delete(Long id) {
        blogsDao.deleteBlog(id);
        tagDao.deleteTagById(id);
    }

    @Override
    public Blog getBlogById(Long id) {
        return blogsDao.getBlogById(id);
    }

    @Override
    public int updateBlog(Blog blog) {
        addBlogTags(splitTagIds(blog.getTagIds()),blog);
        return blogsDao.updateBlog(blog);
    }

    @Override
    public List<Blog> searchByCondition(SearchBlog searchBlog) {
        return blogsDao.searchByCondition(searchBlog);
    }

    @Override
    public IndexSelect selectIndexMessage() {
        return blogsDao.getIndexMessage();
    }

    @Override
    public List<Blog> getBlogByTitle(String name) {
        return blogsDao.getBlogByTitle(name);
    }

    //查询博客详情
    @Override
    public BlogParticular getBlogParticularById(Long id) {
        BlogParticular blogParticular = blogsDao.getBlogParticularById(id);
        if (blogParticular==null){
            throw new NotFoundException("该博客不存在");
        }
        String content = blogParticular.getContent();
        blogParticular.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        //文章访问量更新
        blogsDao.updateViews(id);
        blogParticular.setUser(userDao.getUserByUserId(blogParticular.getUserId()));
        blogParticular.setBlogTags(tagDao.getTagByBlogId(id));
        return blogParticular;
    }

    @Override
    public List<BlogList> getBlogListByTagId(Long tagId) {
        return blogsDao.getBlogListByTagId(tagId);
    }

    @Override
    public Map<String, List<Blog>> getArchive() {
        List<String> years = blogsDao.getGroupYear();
        Map<String,List<Blog>> blogMap = new HashMap<>();
        for (String year : years){
            blogMap.put(year,blogsDao.getBlogByYear(year));
        }
        return blogMap;
    }

}
