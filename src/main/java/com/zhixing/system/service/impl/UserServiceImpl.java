package com.zhixing.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixing.system.mapper.MallMapper;
import com.zhixing.system.mapper.UserMapper;
import com.zhixing.system.pojo.Mall;
import com.zhixing.system.pojo.User;
import com.zhixing.system.service.IMallService;
import com.zhixing.system.service.IUserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
}
