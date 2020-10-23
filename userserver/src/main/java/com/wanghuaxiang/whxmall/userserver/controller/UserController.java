package com.wanghuaxiang.whxmall.userserver.controller;

import com.wanghuaxiang.whxmall.userserver.feign.PayFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghuaxiang
 * @date 2020-10-22 16:01
 * @Description 用户管理
 */
@RestController
@RequestMapping("/user")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PayFeignClient payFeignClient;

    @GetMapping("/getUserName")
    public String getUserName(int userid) {
        logger.info("getUserName is request");
        String payString = payFeignClient.wxPay(userid);
        return "user name = zhangsan" + userid + " and " + payString;
    }
}
