package com.hongyi.sys.service.impl;

import com.hongyi.sys.entity.Member;
import com.hongyi.sys.mapper.MemberMapper;
import com.hongyi.sys.service.IMemberService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements IMemberService {

}
