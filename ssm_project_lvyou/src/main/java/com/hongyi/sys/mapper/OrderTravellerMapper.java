package com.hongyi.sys.mapper;

import com.hongyi.sys.entity.OrderTraveller;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hongyi.sys.entity.Traveller;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhou
 * @since 2020-12-01
 */
public interface OrderTravellerMapper extends BaseMapper<OrderTraveller> {

    public OrderTraveller findTraveller(String orderid);
}
