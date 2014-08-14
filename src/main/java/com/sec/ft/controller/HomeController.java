package com.sec.ft.controller;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Locale;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sec.framework.controller.BaseController;
import com.sec.framework.util.FeatureTogglePropertyPlaceHolderConfigurer;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController extends BaseController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, HttpServletRequest request) {
		return "home";
	}

	@RequestMapping(value = "/featureA", method = RequestMethod.GET)
	public String featureA(HttpServletRequest request) {

		if (!isEnabledToggle("featureA")) {
			return "not_found";
		}

		return "featureA";
	}

	public boolean isEnabledToggle(String feature) {
		String value = (String) FeatureTogglePropertyPlaceHolderConfigurer
				.getContextProperty(feature);

		return value.equalsIgnoreCase("true");
	}

	public static String readValue(String filePath, String key) {
		Properties props = new Properties();
		try {
			InputStream in = new BufferedInputStream(new FileInputStream(
					filePath));
			props.load(in);
			String value = props.getProperty(key);
			System.out.println(key + value);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/featureB", method = RequestMethod.GET)
	public String featureB(HttpServletRequest request) {

		if (!isEnabledToggle("featureB")) {
			return "not_found";
		}

		return "featureB";
	}

}
