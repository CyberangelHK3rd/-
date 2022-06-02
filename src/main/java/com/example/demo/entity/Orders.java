package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (Orders)实体类
 *
 * @author makejava
 * @since 2022-05-12 09:34:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Orders implements Serializable {
    private static final long serialVersionUID = 590205578461368968L;
    /**
     * 订单编号
     */
    private Integer oId;
    /**
     * 购买商品编号
     */
    private Integer oCid;
    /**
     * 购买商品名
     */
    private String oCname;
    /**
     * 店家编号
     */
    private Integer oWid;
    /**
     * 店家名称
     */
    private String oWname;
    /**
     * 购买人编号
     */
    private Integer oRid;
    /**
     * 购买人名称
     */
    private String oRname;
    /**
     * 购买数量
     */
    private String oNum;
    /**
     * 购买单位
     */
    private String oUnit;
    /**
     * 购买金额
     */
    private String oAmount;
    /**
     * 购买时间
     */
    private Date oTime;
    /**
     * 订单状态
     */
    private Integer oState;
}
