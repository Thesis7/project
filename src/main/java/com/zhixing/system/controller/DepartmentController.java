package com.zhixing.system.controller;


import com.zhixing.system.pojo.Department;
import com.zhixing.system.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dep")
public class DepartmentController {

    @Autowired
    private IDepartmentService departmentService;

    @RequestMapping("/depList")
    public String depList(Model model){
        List<Department> departments = departmentService.list();
        model.addAttribute("deps", departments);
        return "dep/depList";
    }

    @RequestMapping("/toAddDep")
    public String toAddDep(){
        return "dep/depAdd";
    }

    @RequestMapping("/addDep")
    public String addDep(@RequestParam("name") String name,
                         @RequestParam("address") String address,
                         @RequestParam("phone") String phone){
        Department department = new Department();
        department.setName(name).setAddress(address).setPhone(phone);
        departmentService.save(department);
        return "redirect:/dep/depList";
    }

    @RequestMapping("/toUpdateDep/{id}")
    public String toUpdateDep(@PathVariable Integer id, Model model){
        model.addAttribute("dep", departmentService.getById(id));
        return "dep/depUpdate";
    }

    @RequestMapping("/updateDep")
    public String updateDep(Department department){
        departmentService.updateById(department);
        return "redirect:/dep/depList";
    }

    @RequestMapping("/deleteDep/{id}")
    public String deleteDep(@PathVariable Integer id){
        departmentService.removeById(id);
        return "redirect:/dep/depList";
    }




}
