package com.rniyablog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rniyablog.entity.Tag;
import com.rniyablog.queryvo.TagBlogs;
import com.rniyablog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月19日 20:35
 * @Description:
 */
@Controller
@RequestMapping("admin")
public class TagController {

    @Autowired
    private TagService tagService;

    //查询所有标签
    @GetMapping("/tags")
    public String findAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {

        String orderBy = "tag_name";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<TagBlogs> list = tagService.findAll();
        PageInfo<TagBlogs> pageInfo = new PageInfo<TagBlogs>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    //    删除标签
    @GetMapping("/tags/{id}/delete")
    public String deleteTag(@PathVariable Long id, RedirectAttributes attributes) {
        int t = tagService.delete(id);
        if (t == 0) {
            attributes.addFlashAttribute("message", "删除失败");
        } else {
            attributes.addFlashAttribute("message", "删除成功");
        }
        return "redirect:/admin/tags";
    }

    //    跳转到标签编辑页
    @GetMapping("/tags/{id}/edit")
    public String tagUpdate(@PathVariable Long id, Model model) {
        Tag tag = tagService.getTagById(id);
        model.addAttribute("tag", tag);
        return "admin/tags-input";
    }

    //    编辑标签
    @PostMapping("/tags/{id}/editSave")
    public String editPost(@Validated Tag tag, RedirectAttributes attributes) {
        int t = tagService.updateTag(tag);
        if (t == 0) {
            attributes.addFlashAttribute("message", "修改失败");
        } else {
            attributes.addFlashAttribute("message", "修改成功");
        }
        return "redirect:/admin/tags";
    }

    @GetMapping("/tags/saveTag")
    public String tagSave(Model model) {
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

//    添加标签
    @PostMapping("/tags/input")
    public String saveTag(@Validated Tag tag, RedirectAttributes attributes){
        String message = tagService.saveTag(tag);
        if(message .equals("标签已存在！")){
            attributes.addFlashAttribute("message",message);
            return "/admin/tags-input";
        }else {
            attributes.addFlashAttribute("message",message);
            return "redirect:/admin/tags";
        }
    }

}
