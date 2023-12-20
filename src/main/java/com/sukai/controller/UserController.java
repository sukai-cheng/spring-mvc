package com.sukai.controller;

import com.sukai.dto.UserVo;
import com.sukai.entity.User;
import com.sukai.service.UserService;
import com.sukai.utils.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author chengsukai
 */
@Controller
@RequestMapping
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/findByUserName")
    public User findByUserName(@RequestBody UserVo userVo, Model model) {
        User user = userService.findByUserName(userVo.getUsername());
        model.addAttribute("user", user);
        return user;
    }

    @RequestMapping("/user")
    public String user(Model model){
        User user = userService.findByUserName("chengsukai");
        model.addAttribute("user",user);
        return "user";
    }

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<List<User>> getAllUser() {
        List<User> userList = userService.findAllUsers();
        return new ResponseResult<>(200, "操作成功", userList);
    }
}
