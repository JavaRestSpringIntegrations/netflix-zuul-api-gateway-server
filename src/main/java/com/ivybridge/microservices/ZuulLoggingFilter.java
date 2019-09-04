package com.ivybridge.microservices;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ZuulLoggingFilter extends ZuulFilter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override // do you want after or before the request , or only error
    public String filterType() {

        HttpServletRequest request =
                RequestContext.getCurrentContext().getRequest();
        logger.info("Request is {}, request uri -> {}",request,request.getRequestURI());
        return "pre";
    }

    @Override // setting priority order
    public int filterOrder() {
        return 1;
    }

    @Override //should this filter executed or not
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        return null;
    }
}
