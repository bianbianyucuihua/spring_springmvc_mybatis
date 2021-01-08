package com.hongyi.sys.service.impl;

import com.hongyi.sys.entity.Product;
import com.hongyi.sys.mapper.ProductMapper;
import com.hongyi.sys.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhou
 * @since 2020-11-30
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {
    @Autowired
    ProductMapper productMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean save(Product entity) {
        boolean save = super.save(entity);
        return save;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean removeById(Serializable id) {
        boolean b = super.removeById(id);
        return b;
    }

    @Override
    public int updateStatusByIds(Collection<String> ids) {
        int i = productMapper.updateStatusByIds(ids);
        return i;
    }
}
