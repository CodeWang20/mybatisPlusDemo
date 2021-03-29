package cn.codewang.component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @Author wangxiao
 * @Date 2021/3/28 下午9:37
 */

@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("插入时：创建时间和修改时间....");
        //插入时：创建时间和修改时间
        this.setFieldValByName("createdDate", new Date(), metaObject);
        this.setFieldValByName("modifiedDate", new Date(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("插入时：创建时间和修改时间....");
        this.setFieldValByName("modifiedDate", new Date(), metaObject);
    }
}
