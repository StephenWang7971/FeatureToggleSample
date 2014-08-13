package com.sec.ft.util.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.sec.framework.controller.FeatureToggle;
import com.sec.framework.util.FeatureTogglePropertyPlaceHolderConfigurer;

public class FeatureToggleInterceptor implements HandlerInterceptor {

	public boolean isEnabledToggle(String feature) {
		String value = (String) FeatureTogglePropertyPlaceHolderConfigurer
				.getContextProperty(feature);

		return value.equalsIgnoreCase("true");
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		if (!(handler instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod method = (HandlerMethod) handler;

		FeatureToggle featureToggle = method.getMethod().getDeclaringClass()
				.getAnnotation(FeatureToggle.class);

		if (featureToggle != null) {
			if (!isEnabledToggle(featureToggle.value())) {
				response.sendRedirect("/FTSample/not_found");
				return false;
			}
		}

		featureToggle = method.getMethodAnnotation(FeatureToggle.class);

		if (featureToggle != null) {
			if (!isEnabledToggle(featureToggle.value())) {
				response.sendRedirect("/FTSample/not_found");
				return false;
			}
		}

		return true;
	}
}
