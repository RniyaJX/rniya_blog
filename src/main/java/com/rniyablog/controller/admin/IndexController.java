package com.rniyablog.controller.admin;

import com.rniyablog.entity.User;
import com.rniyablog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author: Rniya
 * @date: 2022年09月04日 16:09
 * @Description: 后台管理页面控制类
 */
@Controller
@RequestMapping("/admin")
public class IndexController {

    @Autowired
    private UserService userService;

    //跳转首页
    @GetMapping
    public String adminIndex() {
        return "admin/login";
    }

    @GetMapping("/index")
    public String acLogin(HttpSession session){
        if(session.getAttribute("user")!=null){
            return "admin/index";
        }else{
            return "redirect:/admin";
        }
    }

    //登录检测
    @PostMapping("/index")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes, Model model) {
        User user = userService.chickUser(username, password);

        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            session.setAttribute("username",username);
            session.setMaxInactiveInterval(-1);//Session永不过期
            return "admin/index";
        }else {
            attributes.addFlashAttribute("message","用户名和密码错误!");
            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.removeAttribute("user");
        return "redirect:/index";
    }

}
