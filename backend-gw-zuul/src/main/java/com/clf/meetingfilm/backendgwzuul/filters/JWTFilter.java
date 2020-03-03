package com.clf.meetingfilm.backendgwzuul.filters;

import com.alibaba.fastjson.JSONObject;
import com.clf.meetingfilm.backendutils.properties.JwtProperties;
import com.clf.meetingfilm.backendutils.util.JwtTokenUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @Author: clf
 * @Date: 2020-03-02
 * @Description: 自定义Filter
 */
@Slf4j
public class JWTFilter extends ZuulFilter {

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
        JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        JwtProperties jwtProperties = JwtProperties.getJwtProperties();

        // ThreadLocal
        RequestContext ctx = RequestContext.getCurrentContext();
        // 获取当前请求和返回值
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();

        // 提前设置请求继续，如果失败则修改此内容
        ctx.setSendZuulResponse(true);
        ctx.setResponseStatusCode(200);

        // 判断是否是登陆，如果是登陆则不验证JWT
        if (request.getServletPath().endsWith("/" + jwtProperties.getAuthPath())) {
            return null;
        }

        //1. 验证token有效性 --> 用户是否登录过

        //2. 解析出JWT中的 payload --> userId - randomKey

        //3. 是否需要验签

        //4. 判断用userId是否有效
        return null;
    }

    /**
     * 渲染json对象
     */
    public static void renderJson(RequestContext ctx, HttpServletResponse response, Object jsonObject) {
        // 设置终止请求
        response.setHeader("Content-Type", "application/json;charset=UTF-8");
        ctx.setSendZuulResponse(false);
        ctx.setResponseBody(JSONObject.toJSONString(jsonObject));
    }
}
