package com.hongyi.sys.mapper;

import com.hongyi.sys.entity.Product;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;
import java.util.Collections;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhou
 * @since 2020-11-30
 */
public interface ProductMapper extends BaseMapper<Product> {

    public int updateStatusByIds(Collection<String> ids);
}
