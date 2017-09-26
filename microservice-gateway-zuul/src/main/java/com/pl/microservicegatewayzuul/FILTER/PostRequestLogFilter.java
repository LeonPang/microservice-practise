package com.pl.microservicegatewayzuul.FILTER;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by 庞亮 on 2017/9/20.
 */
public class PostRequestLogFilter extends ZuulFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostRequestLogFilter.class);
    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        PostRequestLogFilter.LOGGER.info(String.format("XXXX %s request to %s,,%s",request.getMethod(),request.getRequestURL().toString(),request.getRequestURI().toString()));
        return null;
    }
}
