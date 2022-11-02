package com.rniyablog.dao.admin;

import com.rniyablog.entity.Blog;
import com.rniyablog.entity.Tag;
import com.rniyablog.queryvo.BlogTags;
import com.rniyablog.queryvo.TagBlogs;
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
public interface TagDao {
    List<TagBlogs> findAll();
    int deleteTag(Long id);

    Tag getTagById(Long id);

    int updateTag(Tag tag);
    Tag getTagByName(String tagName);
    int saveTag(Tag tag);
    List<BlogTags> getTagByBlogId(Long id);

    int saveBlogTags(List<BlogTags> blogTags);

    void deleteBlogTagsByBlogId(Blog blog);

    void deleteTagById(Long id);
}
