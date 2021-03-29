package cn.codewang.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author wangxiao
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName(value = "demo")
public class Demo {

    /**
     * 此处要注意，数据库id若为自增长，要修改主键生成策略为type = IdType.AUTO
     */
    //@TableId(value = "id", type = IdType.AUTO)
    @TableId(value = "id")
    private Integer id;
    private String name;
    private int age;

    @TableField(value = "nick_name")
    private String nickName;

    /**
     * 逻辑删除
     *      value：未删除时的值
     *      delval：逻辑删除状态的值
     */
    @TableLogic(value = "1", delval = "0")
    private Integer enabled;

    /**
     * 添加数据时自动填充默认当前时间
     */
    @TableField(fill = FieldFill.INSERT, value = "created_date")
    private Date createdDate;

    @TableField(fill = FieldFill.INSERT_UPDATE, value = "modified_date")
    private Date modifiedDate;
}
