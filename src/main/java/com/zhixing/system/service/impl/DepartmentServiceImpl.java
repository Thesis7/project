package com.zhixing.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixing.system.mapper.DepartmentMapper;
import com.zhixing.system.pojo.Department;
import com.zhixing.system.service.IDepartmentService;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
}
