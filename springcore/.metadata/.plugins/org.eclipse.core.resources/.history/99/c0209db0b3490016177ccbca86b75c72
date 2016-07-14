package co.uk.endava.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ModelAndView welcome(HttpServletRequest request) {
        //new ModelAndView("Test");
        //new ModelAndView("Test","modelName", "model value");
        //new ModelAndView("Test",new HashMap<String, Object>());
        return new ModelAndView("welcome","message","Good morning!");
    }
}
