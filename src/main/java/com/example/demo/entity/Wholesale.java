package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * (Wholesale)实体类
 *
 * @author makejava
 * @since 2022-05-12 09:34:30
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Wholesale implements Serializable {
    private static final long serialVersionUID = -92515323401242102L;
    /**
     * 批发商编号
     */
    private Integer wId;
    /**
     * 店铺名
     */
    private String wUser;
    /**
     * 登录密码
     */
    private String wPassword;
    /**
     * 联系人姓名
     */
    private String wName;
    /**
     * 联系人身份证号
     */
    private String wCodeid;
    /**
     * 公司名称
     */
    private String wCompany;
    /**
     * 联系人电话(登录账户)
     */
    private String wPhone;
    /**
     * 批发商国籍
     */
    private String wCountry;
    /**
     * 注册时间
     */
    private Date wTime;
    /**
     * 账号状态
     */
    private String wStatus;
}
