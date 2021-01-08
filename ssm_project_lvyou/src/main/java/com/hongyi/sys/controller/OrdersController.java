package com.hongyi.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongyi.sys.entity.Member;
import com.hongyi.sys.entity.OrderTraveller;
import com.hongyi.sys.entity.Orders;
import com.hongyi.sys.entity.Product;
import com.hongyi.sys.service.IMemberService;
import com.hongyi.sys.service.IOrderTravellerService;
import com.hongyi.sys.service.IOrdersService;
import com.hongyi.sys.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2020-12-01
 */
@Controller
@RequestMapping("/sys/orders")
public class OrdersController {
    @Autowired
    public IOrdersService ordersService;
    @Autowired
    public IProductService productService;
    @Autowired
    public IOrderTravellerService orderTravellerService;
    @Autowired
    public IMemberService memberService;

    @RequestMapping("/orderslist")
    public String ordersList(Integer current, Integer size, Model  model){
        Page<Orders> pageInfo = new Page<>();
        if(current!=null && size!=null){
            pageInfo = new Page<>(current,size);
        }
        ordersService.page(pageInfo);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pageInfo.getPages());
        System.out.println(pageInfo.getRecords());
        System.out.println(pageInfo.getPages());
        return "product-list";
    }

    @RequestMapping("/byId")
    public String byId(String id,Model model){
        Orders order = ordersService.getById(id);
        if(order==null){
            return "error";
        }
        Product product = productService.getById(order.getProductid());
        OrderTraveller traveller = orderTravellerService.findTraveller(id);
        System.out.println(traveller);
        Member member = memberService.getById(order.getMemberid());
        System.out.println(member);
        System.out.println(product);
        model.addAttribute("product",product);
        model.addAttribute("order",order);

        return "product-list";
    }
}
