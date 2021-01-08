package com.hongyi.sys.service;

import com.hongyi.sys.entity.OrderTraveller;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhou
 * @since 2020-12-01
 */
public interface IOrderTravellerService extends IService<OrderTraveller> {
    public OrderTraveller findTraveller(String orderid);
}
