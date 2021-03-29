package cn.codewang;

import cn.codewang.entity.Demo;
import cn.codewang.mapper.DemoMapper;
import cn.codewang.service.DemoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private DemoService demoService;

    @Test
    void contextLoads() {
        System.out.println(demoMapper.selectById(1));
    }

//    @Test
//    void add(){
//        Demo demo = new Demo(null, "小明", 22, "顶级大牛", null);
//        demoMapper.insert(demo);
//    }
//
//    @Test
//    void update(){
//        Demo demo = new Demo(4, "李四", 18, "资深选手", null);
//        demoMapper.updateById(demo);
//    }

    @Test
    void delete(){
        demoMapper.deleteById(5);
    }

    @Test
    void selectByMap(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("age", 18);
        System.out.println(demoMapper.selectByMap(map));
    }


    /**
     * 以下是 使用service层的
     */

    @Test
    void query(){
        System.out.println(demoService.getById(1));
    }

    /**
     * 分页   需要先配置一个分页插件
     */
    @Test
    void queryByPage(){
        IPage<Demo> demoIPage = new Page<>(1, 1);
        IPage<Demo> page = demoService.page(demoIPage);
        List<Demo> records = page.getRecords();
        System.out.println(records);
        System.out.println(page.getPages());
    }

    /**
     * 自定义XML的分页查询
     */
    @Test
    void customizeByPage(){
        IPage<Demo> demoPage = new Page<>(1, 2);
        List<Demo> records = demoMapper.selectByAge(demoPage, 18).getRecords();
        System.out.println(records);
    }


    /**
     * QueryWrapper条件构造器
     */
    @Test
    void customWrapper1(){
        QueryWrapper<Demo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name", "age", "nick_name")
                .eq("age", 20);
        List<Demo> list = demoService.list(queryWrapper);
        System.out.println(list);
    }

    @Test
    void customWrapper2(){
        QueryWrapper<Demo> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 19);
        List<Demo> list = demoService.list(queryWrapper);
        System.out.println(list);
    }

    /**
     * UpdateWrapper条件构造器
     */
    @Test
    void customWrapper3(){
        UpdateWrapper<Demo> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id", 1)
                .set("age", 20);
        demoService.update(updateWrapper);
    }

    /**
     * AbstractWrapper条件构造器
     *      区别于QueryWrapper硬编码的方式，动态条件
     *      只需要维护好实体类即可
     */
    @Test
    void AbstractWrapper1(){
        QueryWrapper<Demo> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .select(Demo::getName, Demo::getAge, Demo::getNickName)
                .between(Demo::getAge, 15, 20);
        System.out.println(demoService.list(wrapper));
    }

    /**
     * 逻辑删除（注解方式）
     *      1、实体类中添加逻辑删除的字段
     *      2、局部单表逻辑删除，在对应实体类中加@TableLogic
     *  （全局yml见配置文件）
     */
    @Test
    void logicDel(){
        demoService.removeById(1);
    }

    /**
     * 数据自动填充，例如：
     *      1、id
     *      2、create（创建时间）
     *      3、modified（修改时间）
     */
    @Test
    void autoFill(){
        Demo demo = new Demo();
        demo.setId(9);
        demo.setName("小明");
        demo.setAge(20);
        demo.setNickName("顶级大牛");
        demoService.saveOrUpdate(demo);
    }
}
