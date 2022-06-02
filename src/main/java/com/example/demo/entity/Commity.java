package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
/**
 * 商品表
 */
public class Commity implements Serializable {
    private static final long serialVersionUID = -79161712764790012L;
    /**
     * 商品编号
     */
    private Integer cId;
    /**
     * 商品名称
     */
    private String cName;
    /**
     * 商品小类
     */
    private String cKinds;
    /**
     * 商品大类
     */
    private String cType;
    /**
     * 商品产地
     */
    private String cOrigin;
    /**
     * 商品上传者
     */
    private Integer cWid;
    /**
     * 商品数量
     */
    private String cNumber;
    /**
     * 商品单位
     */
    private String cNunit;
    /**
     * 商品单价
     */
    private String cPrice;
    /**
     * 商品单价单位
     */
    private String cPunit;
    /**
     * 上架时间
     */
    private Date cTime;
    /**
     * 商品状态
     */
    private String cStatus;

}
