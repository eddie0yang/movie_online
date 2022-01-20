package com.test.demo3_ribbon;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ribbonTest")
public class UserController {

    @GetMapping("/{id}")
    public String getUser(@PathVariable Long id) {
        System.out.println("测试连接成功！");
        return "测试连接成功"+id;
    }

    @GetMapping("/getUser2")
    public String getUser2(int id) {
        System.out.println("测试连接成功！");
        return "测试连接成功"+id;
    }
}