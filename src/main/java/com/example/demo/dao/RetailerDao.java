package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import com.example.demo.entity.Account.Retailer;

public interface RetailerDao {

    /**
     * 查询指定行数据
     *
     * @param retailer 查询条件
     * @param pageable 分页对象
     * @return 对象列表
     */
    List<Retailer> queryAllByLimit(Retailer retailer, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param retailer 查询条件
     * @return 总行数
     */
    long count(Retailer retailer);

    /**
     * 新增数据
     *
     * @param retailer 实例对象
     * @return 影响行数
     */
    int registerRetailer(Retailer retailer);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Retailer> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Retailer> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Retailer> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Retailer> entities);

    /**
     * 修改数据
     */
    int update(Retailer retailer);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 影响行数
     */
    int deleteRetailer(Integer rId);

    /**
     * 通过id查询用户
     */
    Retailer queryById(Integer rId);

    /**
     * 通过电话号码查询账户
     */
    Retailer queryByPhone(String rPhone);

    /**
     * 修改密码
     */
    int changePassword(@Param("rId") Integer rId, @Param("newPassword") String newPassword);

}
