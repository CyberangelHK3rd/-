package com.example.demo.service.impl;

import javax.annotation.Resource;

import com.example.demo.dao.WholesaleDao;
import com.example.demo.entity.Wholesale;
import com.example.demo.entity.util.ServiceToControllerBody;
import com.example.demo.service.WholesaleService;

import org.springframework.stereotype.Service;

@Service("wholesaleService")
public class WholesaleServiceImpl implements WholesaleService {
    @Resource
    private WholesaleDao wholesaleDao;

    /**
     * 通过ID查询零售商账号
     */
    @Override
    public ServiceToControllerBody<Wholesale> queryById(Integer wId) {
        ServiceToControllerBody<Wholesale> body = new ServiceToControllerBody<>();
        if (wholesaleDao.queryById(wId) != null) {
            return body.success(wholesaleDao.queryById(wId));
        }
        return body.error("wId", "该零售商不存在", wId);
    }

    /**
     * 增加一个零售商账户
     */
    @Override
    public ServiceToControllerBody<Wholesale> addWholesale(Wholesale wholesale) {
        ServiceToControllerBody<Wholesale> body = new ServiceToControllerBody<>();
        Wholesale w = wholesaleDao.queryByPhone(wholesale.getWPhone());
        if (w != null) {
            body.error("wId", "该手机号已经被注册", w.getWId());
        }
        if (wholesaleDao.insert(wholesale) == 1) {
            return body.success(wholesale);
        }
        return body.error("wholesale", "注册失败", wholesale);
    }

    /**
     * 修改零售商信息
     */
    @Override
    public ServiceToControllerBody<Wholesale> updateWholesaleById(Integer wId, Wholesale wholesale) {
        ServiceToControllerBody<Wholesale> body = new ServiceToControllerBody<>();
        Wholesale w = wholesaleDao.queryById(wId);
        if (w == null) {
            return body.error("wId", "该零售商不存在", wId);
        }
        wholesale.setWId(wId);
        if (wholesaleDao.update(wholesale) == 1) {
            Wholesale w1 = wholesaleDao.queryById(wId);
            return body.success(w1);
        }
        return body.error("wholesale", "修改失败", wholesale);
    }

    /**
     * 删除零售商账号
     */
    @Override
    public ServiceToControllerBody<Wholesale> deleteWholesaleById(Integer wId) {
        ServiceToControllerBody<Wholesale> body = new ServiceToControllerBody<>();
        Wholesale w = wholesaleDao.queryById(wId);
        if (w == null) {
            return body.error("wId", "该零售商不存在", wId);
        }
        if (wholesaleDao.deleteById(wId) == 1) {
            return body.success(w);
        }
        return body.error("wId", "删除失败", wId);
    }
}
