package org.cloud.sss.controller;

import org.cloud.sss.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    @RequestMapping("/restEmployee")
    public ModelAndView restEmployee() {
        return new ModelAndView("employee","command",new Employee());
    }
}
