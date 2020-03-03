package com.clf.meetingfilm.backendgwzuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author: clf
 * @Date: 2020-03-02
 * @Description: 自定义Filter
 */
@Slf4j
public class MyFilter extends ZuulFilter {

    /**
     * 类型
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * Filter的执行顺序 0是最高级
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否要拦截
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 具体的业务逻辑
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            log.info("headerName: {}, headerValue: {}", headerName, request.getHeader(headerName));
        }
        return null;
    }
}
