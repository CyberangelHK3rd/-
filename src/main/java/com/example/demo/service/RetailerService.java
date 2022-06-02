package com.example.demo.service;

import com.example.demo.entity.Account.Retailer;
import com.example.demo.entity.util.ServiceToControllerBody;
import com.example.demo.module.account.ForgetPassword;
import com.example.demo.module.account.changePassword;

public interface RetailerService {

    /**
     * 通过ID查询单条数据
     * TODO: 查？
     */
    // ServiceToControllerBody<Retailer> queryById(Integer rId);

    /**
     * 修改数据
     *
     * @param retailer 实例对象
     * @return 实例对象
     */
    Retailer update(Retailer retailer);

    /**
     * 注册账号
     */
    ServiceToControllerBody<Retailer> registerRetailer(Retailer retailer);

    /**
     * 删除账号
     */
    ServiceToControllerBody<Retailer> deleteRetailer(Integer rId);

    /**
     * 登录账号
     */
    ServiceToControllerBody<Retailer> loginRetailer(Retailer retailer);

    /**
     * 修改密码
     */
    ServiceToControllerBody<Retailer> changePassword(Integer rId, changePassword changePassword);

    /**
     * 忘记密码
     */
    ServiceToControllerBody<Retailer> forgetPassword(ForgetPassword forgetPassword);

}
