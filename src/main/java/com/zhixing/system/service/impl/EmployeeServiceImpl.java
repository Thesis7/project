package com.zhixing.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixing.system.mapper.EmployeeMapper;
import com.zhixing.system.pojo.Employee;
import com.zhixing.system.service.IEmployeeService;
import org.springframework.stereotype.Service;


@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {
}
