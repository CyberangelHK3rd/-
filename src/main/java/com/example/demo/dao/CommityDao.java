package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Commity;

import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

public interface CommityDao {

    /**
     * 通过ID查询单条数据
     */
    Commity queryById(Integer cId);

    /**
     * 查询指定行数据
     */
    List<Commity> queryAllByLimit(Commity commity, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     */
    long count(Commity commity);

    /**
     * 新增数据
     */
    int insert(Commity commity);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     */
    int insertBatch(@Param("entities") List<Commity> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     */
    int insertOrUpdateBatch(@Param("entities") List<Commity> entities);

    /**
     * 修改数据
     */
    int update(Commity commity);

    /**
     * 根据wid和cid删除数据
     */
    int deleteByWidAndId(Integer cWid, Integer cId);

    /**
     * 根据姓名查询商品
     */
    Commity queryByName(String cName);

    /**
     * 根据wid查询商品
     */
    Commity queryByWid(Integer cWid);

    /**
     * 根据商品大类型查询该类型所有商品
     */
    Commity queryByType(String cType);

    /**
     * 查询所有商品,返回所有信息
     */
    Commity queryAll();

}
