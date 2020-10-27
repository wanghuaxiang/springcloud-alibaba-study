package com.wanghuaxiang.whxmall.payserver.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.wanghuaxiang.whxmall.payserver.handler.SentinelBlockHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wanghuaxiang
 * @date 2020-10-22 14:56
 * @Description 支付管理
 */
@RestController
@RequestMapping("/needPay")
public class PayController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("wxPay")
//    @SentinelResource(
//            value = "wxPay",
//            blockHandler = "block",
//            fallback = "block",
//            blockHandlerClass = SentinelBlockHandler.class
//    )
    public String wxPay(int money) {
        logger.info("wxPay is request");
        int a = 100 / money;
        return "wx pay money num = " + money;
    }
}
