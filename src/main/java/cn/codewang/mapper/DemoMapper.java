package cn.codewang.mapper;

import cn.codewang.entity.Demo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;


/**
 * @author wangxiao
 */


public interface DemoMapper extends BaseMapper<Demo> {
    /**
     * 自定义xml实现分页查询
     * @param page 参数1 分页参数
     * @param age 参数2 年龄
     * @return IPage 方便MP分页
     */
    IPage<Demo> selectByAge(IPage page, int age);
}
