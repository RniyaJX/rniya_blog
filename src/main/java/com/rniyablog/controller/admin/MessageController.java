package com.rniyablog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rniyablog.entity.Message;
import com.rniyablog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年09月23日 12:01
 * @Description:
 */

@Controller
@RequestMapping("admin")
public class MessageController {

    @Autowired
    private MessageService messageService;

    //查询所有留言
    @GetMapping("/messages")
    public String findAll(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        String orderBy = "create_time";
        PageHelper.startPage(pageNum, 5, orderBy);
        List<Message> list = messageService.findAll();
        PageInfo<Message> pageInfo = new PageInfo<Message>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/message";
    }

    @GetMapping("/messages/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes attributes){
        int m = messageService.deleteMessageById(id);
        if (m == 0){
            attributes.addFlashAttribute("message","操作失败");
        }else {
            attributes.addFlashAttribute("message","操作成功");
        }
        return "redirect:/admin/messages";
    }

}
