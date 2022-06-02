package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.demo.entity.Orders;
import com.example.demo.entity.util.ResponseBody;
import com.example.demo.service.OrdersService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单详情
 */
@RestController
@RequestMapping("orders")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    /**
     * 创建订单详情
     */
    @PostMapping("createOrders")
    public ResponseEntity<ResponseBody<Orders>> createOrders(@RequestParam("rId") @Valid Integer rId,
            @RequestParam("cId") @Valid Integer cId,
            @RequestParam("wId") @Valid Integer wId,
            @RequestParam("oNum") @Valid String oNum,
            @RequestParam("oUnit") @Valid String oUnit) {
        return ResponseBody.handle(ordersService.CreateOrders(rId, cId, wId, oUnit, oNum));
    }

    /**
     * 查询单个订单
     */
    @GetMapping("{oId}")
    public ResponseEntity<ResponseBody<Orders>> queryById(@PathVariable("oId") Integer oId) {
        return ResponseBody.handle(ordersService.queryById(oId));
    }

    /**
     * 删除订单详情
     */
    @DeleteMapping("{oId}")
    public ResponseEntity<ResponseBody<Orders>> deleteById(@PathVariable("oId") Integer oId) {
        return ResponseBody.handle(ordersService.deleteById(oId));
    }

    /**
     * 查询零售商所有订单
     */
    @GetMapping("queryAllOrders/{rId}")
    public ResponseEntity<ResponseBody<Map<String, Object>>> queryAllOrders(@PathVariable("rId") Integer rId) {
        return ResponseBody.handle(ordersService.queryAllOrders(rId));
    }
}
