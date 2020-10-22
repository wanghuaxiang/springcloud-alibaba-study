package com.wanghuaxiang.whxmall.userserver;

import com.wanghuaxiang.whxmall.userserver.feign.PayFeignClient;
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

    @Autowired
    private PayFeignClient payFeignClient;

    @GetMapping("/getUserName")
    public String getUserName(int userid) {
        String payString = payFeignClient.wxPay(100);
        return "user name = zhangsan" + userid + " and " + payString;
    }
}
