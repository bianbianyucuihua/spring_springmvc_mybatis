package com.hongyi.sys.service.impl;

import com.hongyi.sys.entity.OrderTraveller;
import com.hongyi.sys.mapper.OrderTravellerMapper;
import com.hongyi.sys.service.IOrderTravellerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhou
 * @since 2020-12-01
 */
@Service
public class OrderTravellerServiceImpl extends ServiceImpl<OrderTravellerMapper, OrderTraveller> implements IOrderTravellerService {

    @Autowired
    public OrderTravellerMapper orderTravellerMapper;

    @Override
    public OrderTraveller findTraveller(String orderid) {
        OrderTraveller traveller = orderTravellerMapper.findTraveller(orderid);
        return traveller;
    }
}
