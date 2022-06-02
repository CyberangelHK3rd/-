package com.example.demo.module.account;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class ForgetPassword {

    /**
     * 零售商真名
     */
    private String rName;
    /**
     * 零售商身份证号
     */
    private String rCodeid;
    /**
     * 零售商电话
     */
    private String rPhone;
    /**
     * 新密码
     */
    private String newPassword;
}
