package com.rniyablog.service;

import com.rniyablog.entity.Tag;
import com.rniyablog.queryvo.BlogTags;
import com.rniyablog.queryvo.TagBlogs;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月19日 20:39
 * @Description:
 */
public interface TagService {
    List<TagBlogs> findAll();

    int delete(Long id);

    Tag getTagById(Long id);

    int updateTag(Tag tag);

    String saveTag(Tag tag);

    List<BlogTags> getTagByBlogId(Long blogId);
}
