package com.zhixing.system.controller;


import com.zhixing.system.pojo.Mall;
import com.zhixing.system.service.IMallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mall")
public class MallController {

    @Autowired
    private IMallService mallService;


    //查询
    @RequestMapping("/mallList")
    public String mallList(Model model){
        model.addAttribute("malls", mallService.list());
        return "mall/mallList";
    }


    //添加
    @RequestMapping("/toAddMall")
    public String toAddMall(){
        return "mall/mallAdd";
    }

    @RequestMapping("/addMall")
    public String addMall(@RequestParam("name") String name,
                          @RequestParam("address") String address,
                          @RequestParam("phone") String phone){
        Mall mall = new Mall().setName(name).setAddress(address).setPhone(phone);
        mallService.save(mall);
        return "redirect:/mall/mallList";
    }


    //修改
    @RequestMapping("/toUpdateMall/{id}")
    public String toUpdateMall(@PathVariable Integer id, Model model){
        Mall mall = mallService.getById(id);
        model.addAttribute("mall", mall);
        return "mall/mallUpdate";
    }

    @RequestMapping("/updateMall")
    public String updateMall(Mall mall){
        mallService.updateById(mall);
        return "redirect:/mall/mallList";
    }

    //删除
    @RequestMapping("/deleteMall/{id}")
    public String deleteMall(@PathVariable Integer id){
        mallService.removeById(id);
        return "redirect:/mall/mallList";
    }


}
