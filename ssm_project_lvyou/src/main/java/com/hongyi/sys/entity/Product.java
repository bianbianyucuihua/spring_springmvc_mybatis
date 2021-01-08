package com.hongyi.sys.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhou
 * @since 2020-11-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PRODUCT")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键UUID
     */
    @TableId("ID")
    private String id;

    /**
     * 产品编号，唯一，不为空
     */
    @TableField("PRODUCTNUM")
    private String productnum;

    /**
     * 产品名称（路线名称）
     */
    @TableField("PRODUCTNAME")
    private String productname;

    /**
     * 出发城市
     */
    @TableField("CITYNAME")
    private String cityname;

    /**
     * 出发时间
     */
    @TableField("DEPARTURETIME")
    private Date departuretime;

    /**
     * 产品价格
     */
    @TableField("PRODUCTPRICE")
    private Double productprice;

    /**
     * 产品描述
     */
    @TableField("PRODUCTDESC")
    private String productdesc;

    /**
     * 状态（0关闭，1开启）
     */
    @TableField("PRODUCTSTATUS")
    private Integer productstatus;


}
