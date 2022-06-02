package com.example.demo.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import com.example.demo.dao.CommityDao;
import com.example.demo.dao.WholesaleDao;
import com.example.demo.entity.Commity;
import com.example.demo.entity.Wholesale;
import com.example.demo.entity.util.ServiceToControllerBody;
import com.example.demo.service.CommityService;

import org.springframework.stereotype.Service;

@Service("commityService")
public class CommityServiceImpl implements CommityService {
    @Resource
    private CommityDao commityDao;

    @Resource
    private WholesaleDao wholesaleDao;

    /**
     * 通过cId查询单条数据
     */
    @Override
    public ServiceToControllerBody<Commity> queryCommity(Integer cWid, Integer cId) {
        ServiceToControllerBody<Commity> Body = new ServiceToControllerBody<>();
        Wholesale wholesale = wholesaleDao.queryById(cWid);
        if (wholesale == null) {
            return Body.error("cWid", "该商户不存在", cWid);
        }
        Commity commity = commityDao.queryById(cId);
        if (commity == null) {
            return Body.error("cId", "该商品不存在", cId);
        }
        return Body.success(commity);
    }

    /**
     * 新增物品，
     * 如果该物品存在
     * 则把他们的数量相加
     */
    @Override
    public ServiceToControllerBody<Commity> addCommity(Integer cWid, Commity commity) {
        ServiceToControllerBody<Commity> Body = new ServiceToControllerBody<>();
        Wholesale wholesale = wholesaleDao.queryById(cWid);
        if (wholesale == null) {
            return Body.error("cWid", "商家不存在", cWid);
        }
        Commity commity1 = commityDao.queryByName(commity.getCName());
        if (commity1 == null) {
            commity.setCWid(cWid);
            commityDao.insert(commity);
            return Body.success(commity);
        } else {
            commity1.setCNumber(commity1.getCNumber() + commity.getCNumber());
            commityDao.update(commity1);
            return Body.success(commity1);
        }

    }

    /**
     * 修改商品数据
     */
    @Override
    public ServiceToControllerBody<Commity> updateCommity(Integer cWid, Integer cId, Commity commity) {
        ServiceToControllerBody<Commity> body = new ServiceToControllerBody<>();
        Wholesale wholesale = wholesaleDao.queryById(cWid);
        if (wholesale == null) {
            return body.error("cWid", "商家不存在", cWid);
        }
        Commity commity1 = commityDao.queryById(cId);
        if (commity1 == null) {
            return body.error("cId", "该商品不存在", cId);
        }
        commity.setCWid(cWid);
        if (commityDao.update(commity) == 1) {
            Commity commity2 = commityDao.queryById(commity.getCId());
            return body.success(commity2);
        }
        return body.error("cID", "修改失败", commity.getCId());
    }

    /**
     * 删除商品
     */
    @Override
    public ServiceToControllerBody<Commity> deleteCommity(Integer cWid, Integer cId) {
        ServiceToControllerBody<Commity> body = new ServiceToControllerBody<>();
        Wholesale wholesale = wholesaleDao.queryById(cWid);
        if (wholesale == null) {
            return body.error("cWid", "商家不存在", cWid);
        }
        Commity commity = commityDao.queryById(cId);
        if (commity == null) {
            return body.error("cID", "该物品不存在", cId);
        }
        if (commityDao.deleteByWidAndId(cWid, cId) == 1) {
            return body.success(commity);
        }
        return body.error("cID", "删除失败", cId);
    }

    /**
     * 根据cWid查询所有商品
     */
    @Override
    public ServiceToControllerBody<Map<String, Object>> queryCommities(Integer cWid) {
        ServiceToControllerBody<Map<String, Object>> body = new ServiceToControllerBody<>();
        Wholesale wholesale = wholesaleDao.queryById(cWid);
        if (wholesale == null) {
            return body.error("cWid", "商家不存在", cWid);
        }
        Map<String, Object> commities = new HashMap<>();
        commities.put("commities", commityDao.queryByWid(cWid));
        if (commities.get("commities") == null) {
            return body.error("cWid", "该商家还没有商品", cWid);
        }
        return body.success(commities);
    }

    /**
     * 根据商品大类型查询该类型所有商品
     */
    @Override
    public ServiceToControllerBody<Map<String, Object>> queryCommitiesByType(String cType) {
        ServiceToControllerBody<Map<String, Object>> body = new ServiceToControllerBody<>();
        Map<String, Object> commities = new HashMap<>();
        if (cType == null) {
            return body.error("cType", "cType传值错误", cType);
        } else if (cType.equals("全部")) {
            commities.put("commities", commityDao.queryAll());
        }
        commities.put("commities", commityDao.queryByType(cType));
        if (commities.get("commities") == null) {
            return body.error("cType", "该类型还没有商品", cType);
        }
        return body.success(commities);
    }
}
