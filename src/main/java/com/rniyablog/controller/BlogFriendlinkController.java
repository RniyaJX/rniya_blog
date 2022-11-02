package com.rniyablog.controller;

import com.rniyablog.entity.Friendlink;
import com.rniyablog.entity.Message;
import com.rniyablog.service.FriendlinkService;
import com.rniyablog.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author: Rniya
 * @date: 2022年10月09日 21:50
 * @Description:
 */
@Controller
public class BlogFriendlinkController {

    @Autowired
    private FriendlinkService friendlinkService;

    @Autowired
    private MessageService messageService;

    @RequestMapping("/friendlink")
    public String friendlink(Model model){
        List<Friendlink> friendlinkList = friendlinkService.getFriendlinkList();
        model.addAttribute("friendlinkList",friendlinkList);
        return "blog/friendlink";
    }

    @PostMapping("/friendlink/saveMessage")
    public String saveMessage(Message message, Model model){
        int m = messageService.saveMessage(message);
        String messageResult = "";
        if (m == 0){
            messageResult = "留言发送失败";
        }else{
            messageResult = "留言发送成功";
        }
        model.addAttribute("messageResult",messageResult);
        List<Friendlink> friendlinkList = friendlinkService.getFriendlinkList();
        model.addAttribute("friendlinkList",friendlinkList);
        return "blog/friendlink";
    }

}
