package com.wanghuaxiang.whxmall.payserver.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author wanghuaxiang
 * @date 2020-10-23 15:41
 * @Description TODO
 */
public class SentinelBlockHandler {
    private final static Logger logger = LoggerFactory.getLogger(SentinelBlockHandler.class);

    /**
     * 处理限流或者降级
     *
     * @param a
     * @param e
     * @return
     */
    public static String block(int a, BlockException e) {
        logger.warn("限流，或者降级了 block:[{}]", a, e);
        return "限流，或者降级了 block:" + a;
    }
}
