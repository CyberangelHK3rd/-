package com.example.demo.entity.Account;

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
public class Retailer implements Serializable {
    private static final long serialVersionUID = 191699191891212101L;
    /**
     * 零售商编号
     */
    private Integer rId;
    /**
     * 零售商会员名
     */
    private String user;
    /**
     * 零售商登录密码
     */
    private String password;
    /**
     * 零售商真名
     */
    private String name;
    /**
     * 零售商身份证号
     */
    private String codeid;
    /**
     * 零售商公司
     */
    private String company;
    /**
     * 零售商电话
     */
    private String phone;
    /**
     * 零售商注册时间
     */
    private Date time;
    /**
     * 零售商状态
     */
    private String status;
}
