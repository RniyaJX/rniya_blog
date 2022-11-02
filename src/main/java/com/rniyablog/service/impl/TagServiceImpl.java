package com.rniyablog.service.impl;

import com.rniyablog.dao.admin.TagDao;
import com.rniyablog.entity.Tag;
import com.rniyablog.queryvo.BlogTags;
import com.rniyablog.queryvo.TagBlogs;
import com.rniyablog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月19日 20:41
 * @Description:
 */
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public List<TagBlogs> findAll() {
        return tagDao.findAll();
    }

    @Override
    public int delete(Long id) {
        return tagDao.deleteTag(id);
    }

    @Override
    public Tag getTagById(Long id) {
        return tagDao.getTagById(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    @Override
    public String saveTag(Tag tag) {
        String message = "" ;
        int t = 0;
        if(tagDao.getTagByName(tag.getTagName()) == null){
            t = tagDao.saveTag(tag);
            if (t == 0) {
                message="添加失败！";
            }else{
                message="添加成功！";
            }
        }else {
            message = "标签已存在！";
        }
        return message;
    }

    @Override
    public List<BlogTags> getTagByBlogId(Long blogId) {
        return tagDao.getTagByBlogId(blogId);
    }
}
