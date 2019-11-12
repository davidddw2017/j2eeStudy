package org.cloud.ssm.controller;

import org.cloud.ssm.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    
    @RequestMapping("/index")
    public String index(Model model) {
        return "index";
    }
    
    @RequestMapping("/employeeList")
    public ModelAndView employeeList() {
        return new ModelAndView("employeeList","command",new Employee());
    }
}
