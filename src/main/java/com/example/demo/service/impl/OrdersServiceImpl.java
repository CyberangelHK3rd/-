package com.example.demo.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.example.demo.dao.CommityDao;
import com.example.demo.dao.OrdersDao;
import com.example.demo.dao.RetailerDao;
import com.example.demo.dao.WholesaleDao;
import com.example.demo.entity.Commity;
import com.example.demo.entity.Orders;
import com.example.demo.entity.Wholesale;
import com.example.demo.entity.Account.Retailer;
import com.example.demo.entity.util.ServiceToControllerBody;
import com.example.demo.service.OrdersService;

import org.springframework.stereotype.Service;

@Service("ordersService")
public class OrdersServiceImpl implements OrdersService {
    @Resource
    private OrdersDao ordersDao;

    @Resource
    private WholesaleDao wholesaleDao;

    @Resource
    private CommityDao commityDao;

    @Resource
    private RetailerDao retailerDao;

    /**
     * 通过ID查询单条数据
     */
    @Override
    public ServiceToControllerBody<Orders> queryById(Integer oId) {
        ServiceToControllerBody<Orders> body = new ServiceToControllerBody();
        Orders orders = ordersDao.queryById(oId);
        if (orders == null) {
            return body.error("oId", "该订单不存在", oId);
        }
        return body.success(orders);
    }

    /**
     * 修改数据
     */
    // @Override
    // public Orders update(Orders orders) {
    // this.ordersDao.update(orders);
    // return this.queryById(orders.getOId());
    // }

    /**
     * 通过主键删除数据
     * 改变状态值 隐藏该订单
     */
    @Override
    public ServiceToControllerBody<Orders> deleteById(Integer oId) {
        ServiceToControllerBody<Orders> body = new ServiceToControllerBody<>();
        Orders orders = ordersDao.queryById(oId);
        if (orders == null) {
            return body.error("oId", "该订单不存在", oId);
        }
        Orders orders1 = orders.setOState(0);
        if (ordersDao.update(orders) < 1) {
            return body.error("oId", "删除失败", oId);
        }
        return body.success(orders1);
    }

    /**
     * 创建订单详情
     */
    @Override
    public ServiceToControllerBody<Orders> CreateOrders(Integer rId, Integer cId, Integer wId, String oUnit,
            String oNum) {
        ServiceToControllerBody<Orders> body = new ServiceToControllerBody<>();
        Commity commity = this.commityDao.queryById(cId);
        Retailer retailer = this.retailerDao.queryById(rId);
        Wholesale wholesale = this.wholesaleDao.queryById(wId);
        Orders orders = new Orders();
        int num = Integer.parseInt(oNum);
        double price = Double.parseDouble(commity.getCPrice());
        String prices = String.valueOf(price);
        Date date = new Date();
        if (oUnit == null) {
            return body.error("oUnit", "请选择单位", oUnit);
        }
        if (num <= 0) {
            return body.error("oNum", "请输入数量", oNum);
        }
        orders.setOCid(cId).setORid(rId).setOWid(wId).setOCname(commity.getCName()).setORname(retailer.getName())
                .setOWname(wholesale.getWName()).setOUnit(oUnit).setONum(oNum).setOAmount(prices).setOState(1)
                .setOTime(date);
        if (ordersDao.insert(orders) > 0) {
            body.success(orders);
        }
        return body.error("orders", "订单创建失败", orders);
    }

    /**
     * 查询零售商所有订单
     */
    @Override
    public ServiceToControllerBody<Map<String, Object>> queryAllOrders(Integer rId) {
        ServiceToControllerBody<Map<String, Object>> body = new ServiceToControllerBody<>();
        Map<String, Object> order = new HashMap<>();
        Retailer retailer = this.retailerDao.queryById(rId);
        if (retailer == null) {
            return body.error("rId", "该零售商不存在", rId);
        }
        order.put("orders", this.ordersDao.queryAllOrders(rId));
        if (order.get("orders") == null) {
            return body.error("rId", "该零售商没有订单", rId);
        }
        return body.success(order);
    }
}
