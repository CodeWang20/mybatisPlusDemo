package cn.codewang.service.impl;

import cn.codewang.entity.Demo;
import cn.codewang.mapper.DemoMapper;
import cn.codewang.service.DemoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @Author wangxiao
 * @Date 2021/3/28 下午2:46
 */


@Service
public class DemoServiceImpl extends ServiceImpl<DemoMapper, Demo> implements DemoService {
}
