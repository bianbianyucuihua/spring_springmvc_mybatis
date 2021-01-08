package com.hongyi.sys.service;

import com.hongyi.sys.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhou
 * @since 2020-11-30
 */
public interface IProductService extends IService<Product> {
    public int updateStatusByIds(Collection<String> ids);
}
