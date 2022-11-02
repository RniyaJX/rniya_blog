package com.rniyablog.service;

import com.rniyablog.entity.Blog;
import com.rniyablog.queryvo.BlogList;
import com.rniyablog.queryvo.BlogParticular;
import com.rniyablog.queryvo.IndexSelect;
import com.rniyablog.queryvo.SearchBlog;

import java.util.List;
import java.util.ListResourceBundle;
import java.util.Map;

/**
 * @author: Rniya
 * @date: 2022年09月07日 16:16
 * @Description:
 */
public interface BlogsService {

    //查询所有博客
    List<Blog> getAllBlog();

    //博客列表
    List<BlogList> getBlogList();

    //新建博客保存
    String saveBlog(Blog blog);

    //删除指定博客
    void delete(Long id);

    //按id查找博客
    Blog getBlogById(Long id);

    //修改博客保存
    int updateBlog(Blog blog);

    List<Blog> searchByCondition(SearchBlog searchBlog);

    IndexSelect selectIndexMessage();

    List<Blog> getBlogByTitle(String name);

    BlogParticular getBlogParticularById(Long id);

    List<BlogList> getBlogListByTagId(Long tagId);

    //获取归档页面内容
    Map<String, List<Blog>> getArchive();
}
