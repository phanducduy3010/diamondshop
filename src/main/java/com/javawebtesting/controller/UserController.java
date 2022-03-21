package com.javawebtesting.controller;

import com.javawebtesting.entity.User;
import com.javawebtesting.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController extends BaseController{

    @Autowired
    IUserService userService;

    @RequestMapping(value= "/dang-ky", method= RequestMethod.GET)
    public ModelAndView register() {
        _mvShare.setViewName("user/register");
        _mvShare.addObject("user", new User());
        return _mvShare;
    }

    @RequestMapping(value= "/dang-ky", method= RequestMethod.POST)
    public ModelAndView createAccount(@ModelAttribute("user") User user) {
        int count = userService.addAccount(user);
        if (count > 0) {
            _mvShare.addObject("status", "Dang ky tai khoan thanh cong");
        } else {
            _mvShare.addObject("status", "Dang ky tai khoan that bai");
        }
//        _mvShare.addObject("status", true);
        _mvShare.setViewName("user/register");
        return _mvShare;
    }

    @RequestMapping(value= "/dang-nhap", method= RequestMethod.POST)
    public ModelAndView login(HttpSession session, @ModelAttribute("user") User user) {
        user = userService.login(user);
        if(user != null) {
            _mvShare.setViewName("redirect:trang-chu");
            session.setAttribute("loginInfo", user);
        } else {
            _mvShare.addObject("statusLogin", "Dang ky tai khoan that bai");
        }
        return _mvShare;
    }

    @RequestMapping(value= "/dang-xuat", method= RequestMethod.GET)
    public String login(HttpSession session, HttpServletRequest request) {
        session.removeAttribute("loginInfo");
        return "redirect:" + request.getHeader("Referer");
    }
}
