package com.sec.ft.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sec.framework.controller.BaseController;
import com.sec.framework.controller.FeatureToggle;

@FeatureToggle("featureC")
@Controller
public class FeatureCController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(FeatureCController.class);

	@RequestMapping(value = "/featureC", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {

		return "featureC";
	}
}
