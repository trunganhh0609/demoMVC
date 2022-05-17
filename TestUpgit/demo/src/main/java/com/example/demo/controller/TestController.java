package com.example.demo.controller;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/test")
public class TestController {
    @Autowired
    EmployeeService employeeService;


    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String index(ModelMap modelMap){
        return "index";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(ModelMap modelMap){
        modelMap.addAttribute("employee", new Employee());
        return "insert";
    }
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(ModelMap modelMap,@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "insert";
        }else {
            employeeService.insert(employee);
            return "redirect:/test/getAllEmployee";
        }

    }
    @RequestMapping(value = "/getAllEmployee",method = RequestMethod.GET)
    public String getAllEmployee(ModelMap modelMap){
        List<Employee> employeeList = employeeService.employeeList();
        modelMap.addAttribute("list", employeeList);
        System.out.println(employeeList);
        return "allemployee";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public String updatePage(ModelMap modelMap, @PathVariable long id){
        Employee employee = employeeService.findById(id);
        modelMap.addAttribute("employee" ,employee);
        return "update";
    }
    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateEmployee(ModelMap modelMap, @Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult){
        employee.getId();
        if(bindingResult.hasErrors()){
            return "update";
        }else {
            employeeService.updateEmployee(employee);
            return "redirect:/test/getAllEmployee";
        }


    }
    @RequestMapping(value = "/delete/{id}", method=RequestMethod.POST)
    public String deleteEmployee(ModelMap modelMap, @PathVariable long id){
        if(employeeService.findById(id)!=null){
            employeeService.delete(id);
            return "redirect:/test/getAllEmployee";
        }
        return "redirect:/test/getAllEmployee";
    }

}
