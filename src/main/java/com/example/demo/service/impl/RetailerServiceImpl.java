package com.example.demo.service.impl;

import java.util.Date;

import javax.annotation.Resource;

import com.example.demo.dao.RetailerDao;
import com.example.demo.entity.Account.Retailer;
import com.example.demo.entity.util.ServiceToControllerBody;
import com.example.demo.module.account.ForgetPassword;
import com.example.demo.module.account.changePassword;
import com.example.demo.service.RetailerService;

import org.springframework.stereotype.Service;

@Service("retailerService")
public class RetailerServiceImpl implements RetailerService {
    @Resource
    private RetailerDao retailerDao;

    /**
     * 注册账号
     * TODO: 待完成 ：验证码
     */
    @Override
    public ServiceToControllerBody<Retailer> registerRetailer(Retailer retailer) {
        ServiceToControllerBody<Retailer> body = new ServiceToControllerBody<>();
        Retailer retailer1 = retailerDao.queryByPhone(retailer.getPhone());
        if (retailer1 != null) {
            return body.error("phone", "该用户已存在", retailer.getPhone());
        }
        Date date = new Date();
        retailer.setTime(date).setStatus("1");
        if (retailerDao.registerRetailer(retailer) == 1) {
            return body.success(retailer);
        }
        return body.error("name", "注册失败", retailer.getName());
    }

    /**
     * 删除账号
     * TODO: 待完成 :验证码
     */
    @Override
    public ServiceToControllerBody<Retailer> deleteRetailer(Integer rId) {
        ServiceToControllerBody<Retailer> body = new ServiceToControllerBody<>();
        Retailer retailer = retailerDao.queryById(rId);
        if (retailer == null) {
            return body.error("rid", "该用户不存在", rId);
        }
        if (retailerDao.deleteRetailer(rId) == 1) {
            return body.success(retailer);
        }
        return body.error("rid", "删除失败", rId);
    }

    /**
     * 登录账号
     */
    @Override
    public ServiceToControllerBody<Retailer> loginRetailer(Retailer retailer) {
        ServiceToControllerBody<Retailer> body = new ServiceToControllerBody<>();
        Retailer retailer1 = retailerDao.queryByPhone(retailer.getPhone());
        if (retailer1 == null) {
            return body.error("phone", "该用户不存在", retailer.getPhone());
        }
        if (retailer.getPassword().equals(retailer1.getPassword())) {
            return body.success(retailer1);
        }
        return body.error("password", "密码错误", retailer.getPassword());
    }

    /**
     * 修改密码
     */
    @Override
    public ServiceToControllerBody<Retailer> changePassword(Integer rId,
            changePassword changePassword) {
        ServiceToControllerBody<Retailer> body = new ServiceToControllerBody<>();
        Retailer retailer = retailerDao.queryById(rId);
        if (retailer == null) {
            return body.error("rid", "该用户不存在", rId);
        }
        if (retailer.getPassword().equals(changePassword.getRPassword())) {
            if (retailerDao.changePassword(rId, changePassword.getNewPassword()) == 1) {
                return body.success(retailer);
            }
            return body.error("rid", "修改失败", rId);
        }
        return body.error("password", "密码错误", changePassword.getRPassword());
    }

    /**
     * 修改数据
     *
     * @param retailer 实例对象
     * @return 实例对象
     */
    @Override
    public Retailer update(Retailer retailer) {
        this.retailerDao.update(retailer);
        // return this.queryById(retailer.getRId());
        return null;
    }

    /**
     * 忘记密码
     */
    @Override
    public ServiceToControllerBody<Retailer> forgetPassword(ForgetPassword forgetPassword) {
        ServiceToControllerBody<Retailer> body = new ServiceToControllerBody<>();
        Retailer retailer = retailerDao.queryByPhone(forgetPassword.getRPhone());
        if (retailer == null) {
            return body.error("phone", "该用户不存在", forgetPassword.getRPhone());
        }
        if (retailer.getName().equals(forgetPassword.getRName())
                && retailer.getCodeid().equals(forgetPassword.getRCodeid())
                && retailer.getPhone().equals(forgetPassword.getRPhone())) {
            if (retailerDao.changePassword(retailer.getRId(), forgetPassword.getNewPassword()) == 1) {
                return body.success(retailer);
            }
            return body.error("phone", "修改失败", forgetPassword.getRPhone());
        }
        return body.error("rInformation", "用户校验不通过(信息不匹配)", forgetPassword);

    }

    // @Override
    // public ServiceToControllerBody<Retailer> queryById(Integer rId) {
    // ServiceToControllerBody<Retailer> body = new ServiceToControllerBody<>();
    // Retailer retailer = retailerDao.queryById(rId);
    // if (retailer == null) {
    // return body.error("rId", "该用户不存在", rId);
    // }
    // return body.success(retailer);
    // }
}
