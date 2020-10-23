package com.wanghuaxiang.whxmall.payserver.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 *
 * @author wanghuaxiang
 * 统一限流降级异常处理
 */
@Component
public class MyUrlBlockHandler implements BlockExceptionHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException ex) throws IOException {
        ErrorMsg msg = null;
        if (ex instanceof FlowException) {
            msg = new ErrorMsg(100,"限流了");
        } else if (ex instanceof DegradeException) {
            msg = new ErrorMsg(101,"降级了");
        } else if (ex instanceof ParamFlowException) {
            msg = new ErrorMsg(102,"热点参数限流");
        } else if (ex instanceof SystemBlockException) {
            msg = new ErrorMsg(103,"系统规则（负载/...不满足要求）");
        } else if (ex instanceof AuthorityException) {
            msg = new ErrorMsg(104,"授权规则不通过");
        }
        // http状态码
        response.setStatus(200);
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "application/json;charset=utf-8");
        response.setContentType("application/json;charset=utf-8");
        // spring mvc自带的json操作工具，叫jackson
        new ObjectMapper()
            .writeValue(
                response.getWriter(),
                msg
            );
    }
}


class ErrorMsg implements Serializable {

    private Integer status;
    private String msg;

    public ErrorMsg(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
