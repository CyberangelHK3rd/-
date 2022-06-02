package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.Commity;
import com.example.demo.entity.util.ServiceToControllerBody;

public interface CommityService {

    /**
     * 通过ID查询单条数据
     */
    ServiceToControllerBody<Commity> queryCommity(Integer cWid, Integer cId);

    /**
     * 新增商品
     */
    ServiceToControllerBody<Commity> addCommity(Integer cWid, Commity commity);

    /**
     * 修改商品信息
     */
    ServiceToControllerBody<Commity> updateCommity(Integer cWid, Integer cId, Commity commity);

    /**
     * 删除商品
     */
    ServiceToControllerBody<Commity> deleteCommity(Integer cWid, Integer cId);

    /**
     * 根据wId查询该商户的所有商品
     */
    ServiceToControllerBody<Map<String, Object>> queryCommities(Integer cWid);

    /**
     * 根据商品大类型查询该商户的所有商品
     */
    ServiceToControllerBody<Map<String, Object>> queryCommitiesByType(String cType);

}
