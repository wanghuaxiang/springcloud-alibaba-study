package com.wanghuaxiang.whxmall.payserver.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghuaxiang
 * @date 2020-10-22 14:56
 * @Description 支付管理
 */
@RestController
@RequestMapping("/pay")
public class PayController {


    @GetMapping("wxPay")
    public String wxPay(int money) {
        return "wx pay money num = " + money;
    }
}
