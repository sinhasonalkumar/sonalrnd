package com.sonal.springrestsecurity.config;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class RestInterceptorsConfig extends WebMvcConfigurerAdapter {

    private static Logger logger = LoggerFactory.getLogger(RestInterceptorsConfig.class);

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

	registry.addInterceptor(new HandlerInterceptor() {

	    @Override
	    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (StringUtils.isEmpty(MDC.get("requestId)"))) {
		    String requestId = UUID.randomUUID().toString();
		    MDC.put("requestId", requestId);
		    logger.info("preHandle");
		    logger.info("URI :: " + request.getRequestURI() + " :: Request ID Has been Generated !! :: " + requestId);
		}

		return true;
	    }

	    @Override
	    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		logger.info("postHandle");
	    }

	    @Override
	    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		logger.info("afterCompletion");
		MDC.clear();
	    }
	});
	// super.addInterceptors(registry);
    }

}
