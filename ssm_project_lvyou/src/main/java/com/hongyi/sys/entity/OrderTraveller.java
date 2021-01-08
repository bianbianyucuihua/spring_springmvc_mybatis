package com.hongyi.sys.entity;

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
@TableName("ORDER_TRAVELLER")
public class OrderTraveller implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("ORDERID")
    private String orderid;

    @TableField("TRAVELLERID")
    private String travellerid;

    public Traveller traveller;
}
