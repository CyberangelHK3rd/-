package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Orders;

import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

public interface OrdersDao {

    /**
     * 通过ID查询单条数据
     */
    Orders queryById(Integer oId);

    /**
     * 查询指定行数据
     *
     */
    List<Orders> queryAllByLimit(Orders orders, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     */
    long count(Orders orders);

    /**
     * 新增数据
     *
     */
    int insert(Orders orders);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     */
    int insertBatch(@Param("entities") List<Orders> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Orders> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Orders> entities);

    /**
     * 修改数据
     *
     * @param orders 实例对象
     * @return 影响行数
     */
    int update(Orders orders);

    /**
     * 通过主键删除数据
     *
     * @param oId 主键
     * @return 影响行数
     */
    int deleteById(Integer oId);

    /**
     * 通过rId查询数据
     */
    Orders queryAllOrders(Integer rId);

}
