package com.wanghuaxiang.whxmall.userserver.loadbalance;

import org.springframework.cloud.netflix.ribbon.RibbonClients;
import org.springframework.context.annotation.Configuration;


/**
 * @author wanghuaxiang
 * 全局负载均衡策略配置
 */
@Configuration
@RibbonClients(defaultConfiguration = NacosWeightedRule.class)
public class UserCenterRibbonConfiguration {
}
