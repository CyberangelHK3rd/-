package com.example.demo.service;

import com.example.demo.entity.Wholesale;
import com.example.demo.entity.util.ServiceToControllerBody;

public interface WholesaleService {

    /**
     * 通过ID查询零售商账户
     */
    ServiceToControllerBody<Wholesale> queryById(Integer wId);

    /**
     * 新增批发商账号
     */
    ServiceToControllerBody<Wholesale> addWholesale(Wholesale wholesale);

    /**
     * 修改零售商信息
     */
    ServiceToControllerBody<Wholesale> updateWholesaleById(Integer wId, Wholesale wholesale);

    /**
     * 通过主键删除数据
     *
     * @param wId 主键
     * @return 是否成功
     */
    ServiceToControllerBody<Wholesale> deleteWholesaleById(Integer wId);

}
