package es.ernesto.easyGOband.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BaseController {

	private static final String VIEW_INDEX = "index.jsp";
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return VIEW_INDEX;

	}

}
