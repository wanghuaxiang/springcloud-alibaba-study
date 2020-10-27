package com.wanghuaxiang.whxmall.userserver.feign;

import com.wanghuaxiang.whxmall.userserver.feign.fallbackfactory.PayServerFeignClientFallBackFactory;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wanghuaxiang
 * @date 2020-10-22 16:46
 * @Description TODO
 */

@FeignClient(name="pay-server",fallbackFactory = PayServerFeignClientFallBackFactory.class)
@RequestMapping("/needPay")
public interface PayFeignClient {

    /**
     * aaa
     * @param money
     * @return String
     */
    @GetMapping("/wxPay")
    String wxPay(@RequestParam("money") int money);
}
