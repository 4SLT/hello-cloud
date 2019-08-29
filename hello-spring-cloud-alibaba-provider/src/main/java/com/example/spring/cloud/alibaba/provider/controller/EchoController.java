package com.example.spring.cloud.alibaba.provider.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: EchoController
 * @date: 2019/8/29 13:41
 * @author: 林宗雄
 * @version: 1.0
 */
@RestController
public class EchoController {
    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable("string") String string) {
        return "Hello necos Procider" + string;
    }
}
