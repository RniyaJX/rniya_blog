package com.rniyablog.dao.admin;

import com.rniyablog.entity.Blog;
import com.rniyablog.queryvo.BlogList;
import com.rniyablog.queryvo.BlogParticular;
import com.rniyablog.queryvo.IndexSelect;
import com.rniyablog.queryvo.SearchBlog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月07日 16:20
 * @Description:
 */

@Mapper
@Repository
public interface BlogsDao {

    //查询所有博客
    List<Blog> getAllBlog();

    //保存博客
    int saveBlog(Blog blog);

    //删除博客
    void deleteBlog(Long id);

    Blog getBlogById(Long id);

    int updateBlog(Blog blog);

    List<Blog> searchByCondition(SearchBlog searchBlog);

    IndexSelect getIndexMessage();

    List<Blog> getBlogByTitle(String name);

    BlogParticular getBlogParticularById(Long id);

    void updateViews(Long id);

    void getCommentCountById(Long blogId);

    List<BlogList> getBlogList();

    List<BlogList> getBlogListByTagId(Long tagId);

    List<String> getGroupYear();

    List<Blog> getBlogByYear(String year);

    Blog getBlogIdByTitleAndUserId(String title, Long userId);
}
