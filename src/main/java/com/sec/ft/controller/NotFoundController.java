package com.sec.ft.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sec.framework.controller.BaseController;

@Controller
public class NotFoundController extends BaseController {
	private static final Logger logger = LoggerFactory
			.getLogger(NotFoundController.class);

	@RequestMapping(value = "/not_found", method = RequestMethod.GET)
	public String index(HttpServletRequest request) {

		return "not_found";
	}
}
