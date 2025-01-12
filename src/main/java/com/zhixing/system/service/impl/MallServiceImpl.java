package com.zhixing.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhixing.system.mapper.MallMapper;
import com.zhixing.system.pojo.Mall;
import com.zhixing.system.service.IMallService;
import org.springframework.stereotype.Service;

@Service
public class MallServiceImpl extends ServiceImpl<MallMapper, Mall> implements IMallService {
}
