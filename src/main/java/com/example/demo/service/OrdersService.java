package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.Orders;
import com.example.demo.entity.util.ServiceToControllerBody;

public interface OrdersService {

    /**
     * 通过ID查询单条数据
     */
    ServiceToControllerBody<Orders> queryById(Integer oId);

    /**
     * 通过主键删除数据
     */
    ServiceToControllerBody<Orders> deleteById(Integer oId);

    /**
     * 创建订单详情
     */
    ServiceToControllerBody<Orders> CreateOrders(Integer rId, Integer cId, Integer wId, String oUnit, String oNum);

    /**
     * 查询零售商所有订单
     */
    ServiceToControllerBody<Map<String, Object>> queryAllOrders(Integer rId);

}
