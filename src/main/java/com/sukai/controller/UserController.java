package com.sukai.controller;

import com.sukai.dto.UserVo;
import com.sukai.entity.User;
import com.sukai.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chengsukai
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findByUserName")
    public User findByUserName(@RequestBody UserVo userVo, Model model) {
        User user = userService.findByUserName(userVo.getUsername());
        model.addAttribute("user", user);

        return user;
    }

    @RequestMapping(value = "/getAllUser",method = RequestMethod.GET)
    public ModelAndView getAllUser() {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findByUserName("admin");
        modelAndView.addObject("user", user);
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
