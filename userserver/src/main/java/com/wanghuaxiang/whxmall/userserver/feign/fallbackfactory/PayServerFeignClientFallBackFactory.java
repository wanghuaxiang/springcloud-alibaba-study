package com.wanghuaxiang.whxmall.userserver.feign.fallbackfactory;

import com.wanghuaxiang.whxmall.userserver.feign.PayFeignClient;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author wanghuaxiang
 * @date 2020-10-22 17:38
 * @Description feign调用失败处理
 */
@Component
public class PayServerFeignClientFallBackFactory implements FallbackFactory<PayFeignClient> {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public PayFeignClient create(Throwable throwable) {
        return new PayFeignClient() {
            @Override
            public String wxPay(int money) {
                logger.error("远程调用失败", throwable);
                return "pay error";
            }
        };
    }
}
