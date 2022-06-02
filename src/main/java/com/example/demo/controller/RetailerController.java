package com.example.demo.controller;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.demo.entity.Account.Retailer;
import com.example.demo.entity.util.ResponseBody;
import com.example.demo.module.account.ForgetPassword;
import com.example.demo.module.account.changePassword;
import com.example.demo.service.RetailerService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("retailer")
public class RetailerController {

    @Resource
    private RetailerService retailerService;

    /**
     * 注册账号
     */
    @PostMapping("register")
    public ResponseEntity<ResponseBody<Retailer>> registerAccount(@Valid @RequestBody Retailer retailer) {
        return ResponseBody.handle(retailerService.registerRetailer(retailer));
    }

    /**
     * 注销账号
     * TODO: 待完成 :验证码
     */
    @DeleteMapping("{rId}")
    public ResponseEntity<ResponseBody<Retailer>> deleteAccount(@PathVariable("rId") @NotNull Integer rId) {
        return ResponseBody.handle(retailerService.deleteRetailer(rId));
    }

    /**
     * 登录账号
     * TODO: 待完成 :验证码
     */
    @PostMapping("login")
    public ResponseEntity<ResponseBody<Retailer>> loginAccount(@Valid @RequestBody Retailer retailer) {
        return ResponseBody.handle(retailerService.loginRetailer(retailer));
    }

    /**
     * 修改密码
     * TODO: 待完成 :验证码
     */
    @PutMapping("{rId}")
    public ResponseEntity<ResponseBody<Retailer>> changePassword(@Valid @PathVariable("rId") @NotNull Integer rId,
            @Valid @RequestBody changePassword changePassword) {
        return ResponseBody.handle(retailerService.changePassword(rId, changePassword));
    }

    /**
     * 遗忘密码
     */
    @PutMapping("forgetPassword")
    public ResponseEntity<ResponseBody<Retailer>> forgetPassword(@Valid @RequestBody ForgetPassword forgetPassword) {
        return ResponseBody.handle(retailerService.forgetPassword(forgetPassword));
    }
}

// TODO:查？
// @GetMapping("{rId}")
// public ResponseEntity<ResponseBody<Retailer>> queryById(@PathVariable("rId")
// Integer rId) {
// return ResponseBody.handle(this.retailerService.queryById(rId));
// }
