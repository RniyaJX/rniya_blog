package com.rniyablog.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.rniyablog.entity.Blog;
import com.rniyablog.entity.Friendlink;
import com.rniyablog.service.FriendlinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年10月15日 16:44
 * @Description:
 */
@Controller
@RequestMapping("admin")
public class FriendlinkController {

    @Autowired
    private FriendlinkService friendlinkService;

    //跳转到友链管理页面
    @RequestMapping("/friendlink")
    public String friendlink(Model model, @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum,5);
        List<Friendlink> list = friendlinkService.getFriendlinkList();
        PageInfo<Friendlink> pageInfo = new PageInfo<Friendlink>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/friendlinks";
    }

    @RequestMapping("/friendlink/addFriendlink")
    public String addFriendlink(Model model){
        model.addAttribute("friendlink",new Friendlink());
        return "admin/friendlink-input";
    }

    @PostMapping("/friendlink/saveFriendlink")
    public String saveFriendlink(Friendlink friendlink, RedirectAttributes attributes){
        if (friendlinkService.saveFriendlink(friendlink) == 0) {
            attributes.addFlashAttribute("message","操作失败！");
        }else{
            attributes.addFlashAttribute("message","操作成功！");
        }
        return "redirect:/admin/friendlink";
    }

    @GetMapping("/friendlink/{id}")
    public String editFriendlink(@PathVariable Long id,Model model){
        Friendlink friendlink = friendlinkService.findFriendlinkById(id);
        model.addAttribute("friendlink",friendlink);
        return "admin/friendlink-input";
    }

    @PostMapping("/friendlink/{id}/edit")
    public String saveEditFriendlink(Friendlink friendlink,RedirectAttributes attributes){
        if (friendlinkService.editFriendlink(friendlink) == 0) {
            attributes.addFlashAttribute("message","操作失败！");
        }else{
            attributes.addFlashAttribute("message","操作成功！");
        }
        return "redirect:/admin/friendlink";
    }

    @GetMapping("/friendlink/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
       int f = friendlinkService.delete(id);
       if (f == 0){
           attributes.addFlashAttribute("message","操作失败！");
       }else{
           attributes.addFlashAttribute("message","操作成功！");
       }
        return "redirect:/admin/friendlink";
    }

}
