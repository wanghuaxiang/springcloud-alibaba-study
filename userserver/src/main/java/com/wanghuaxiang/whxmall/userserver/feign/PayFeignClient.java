package com.wanghuaxiang.whxmall.userserver.feign;

import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wanghuaxiang
 * @date 2020-10-22 16:46
 * @Description TODO
 */

@FeignClient(name="pay-server")
public interface PayFeignClient {

    /**
     * aaa
     * @param money
     * @return String
     */
    @GetMapping("/pay/wxPay")
    String wxPay(@RequestParam("money") int money);
}
