package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Wholesale;

import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

/**
 * (Wholesale)表数据库访问层
 *
 * @author makejava
 * @since 2022-05-12 09:34:30
 */
public interface WholesaleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param wId 主键
     * @return 实例对象
     */
    Wholesale queryById(Integer wId);

    /**
     * 查询指定行数据
     *
     * @param wholesale 查询条件
     * @param pageable  分页对象
     * @return 对象列表
     */
    List<Wholesale> queryAllByLimit(Wholesale wholesale, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param wholesale 查询条件
     * @return 总行数
     */
    long count(Wholesale wholesale);

    /**
     * 新增数据
     *
     * @param wholesale 实例对象
     * @return 影响行数
     */
    int insert(Wholesale wholesale);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Wholesale> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Wholesale> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Wholesale> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Wholesale> entities);

    /**
     * 修改数据
     *
     * @param wholesale 实例对象
     * @return 影响行数
     */
    int update(Wholesale wholesale);

    /**
     * 通过主键删除数据
     *
     * @param wId 主键
     * @return 影响行数
     */
    int deleteById(Integer wId);

    /**
     * 通过手机号查询
     */
    Wholesale queryByPhone(String wPhone);

}
