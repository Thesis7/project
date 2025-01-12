package com.zhixing.system.controller;


import com.zhixing.system.pojo.Employee;
import com.zhixing.system.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping("/empList")
    public String empList(Model model){
        model.addAttribute("emps", employeeService.list());
        return "emp/empList";
    }

    @RequestMapping("/toAddEmp")
    public String toAddEmp(){
        return "emp/empAdd";
    }

    @RequestMapping("/addEmp")
    public String addEmp(@RequestParam("name") String name,
                         @RequestParam("position") String position,
                         @RequestParam("phone") String phone,
                         @RequestParam("salary") double salary){
        Employee employee = new Employee();
        employee.setName(name).setPosition(position).setPhone(phone).setSalary(salary);
        employeeService.save(employee);
        return "redirect:/emp/empList";
    }

    @RequestMapping("/toUpdateEmp/{id}")
    public String toUpdateEmp(@PathVariable Integer id, Model model){
        model.addAttribute("emp", employeeService.getById(id));
        return "emp/empUpdate";
    }

    @RequestMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeService.updateById(employee);
        return "redirect:/emp/empList";
    }

    @RequestMapping("/deleteEmp/{id}")
    public String deleteEmp(@PathVariable Integer id){
        employeeService.removeById(id);
        return "redirect:/emp/empList";
    }
}
