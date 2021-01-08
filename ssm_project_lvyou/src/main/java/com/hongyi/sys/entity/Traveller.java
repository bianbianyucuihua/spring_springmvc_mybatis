package com.hongyi.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhou
 * @since 2020-12-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("TRAVELLER")
public class Traveller implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ID")
    private String id;

    @TableField("NAME")
    private String name;

    @TableField("SEX")
    private String sex;

    @TableField("PHONENUM")
    private String phonenum;

    @TableField("CREDENTIALSTYPE")
    private BigDecimal credentialstype;

    @TableField("CREDENTIALSNUM")
    private String credentialsnum;

    @TableField("TRAVELLERTYPE")
    private BigDecimal travellertype;


}
