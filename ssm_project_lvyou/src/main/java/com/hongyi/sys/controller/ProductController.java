package com.hongyi.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hongyi.sys.entity.Product;
import com.hongyi.sys.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zhou
 * @since 2020-11-30
 */
@Controller
@RequestMapping("/sys/product")
public class ProductController {

    @Autowired
    public IProductService productService;

    @RequestMapping("/getById")
    public String getProductById(String id){
        Product product = productService.getById(id);
        System.out.println(product);
        return "success";
    }
    @RequestMapping("/getAll")
    public String getProductALL(Integer current, Integer size, String productName, Model model){
        Page<Product> pageInfo = new Page<>();
        if(current!=null && size!=null){
            pageInfo = new Page<>(current,size);
        }
        QueryWrapper<Product> wrapper  = new QueryWrapper<>();
        if(productName!=null && "".equals(productName)){
            wrapper.like("productname",productName);
        }
        productService.page(pageInfo,wrapper);
        model.addAttribute("pageInfo",pageInfo);
        model.addAttribute("pages",pageInfo.getPages());
        return "product-list";
    }

    @RequestMapping("/save")
    public String save(Product product){
        boolean save = productService.save(product);
        return "success";
    }

    @RequestMapping("/removeByIds")
    public String removeById(@RequestParam("ids") List<String> ids){
        System.out.println(ids);
        boolean save = productService.removeByIds(ids);
        return "success";
    }
    @RequestMapping("/updateStatus")
    public String UpdateStatus(@RequestParam("ids") List<String> ids){
        int i = productService.updateStatusByIds(ids);
        return "sucess";
    }
}
