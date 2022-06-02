package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.example.demo.entity.Commity;
import com.example.demo.entity.util.ResponseBody;
import com.example.demo.service.CommityService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 商品详情
 */
@RestController
@RequestMapping("Wholesale/{cWid}/commity")
public class CommityController {

    @Resource
    private CommityService commityService;

    /**
     * 新增商品
     */
    @PostMapping("register")
    public ResponseEntity<ResponseBody<Commity>> addCommity(
            @PathVariable("cWid") @NotNull Integer cWid, @Valid @RequestBody Commity commity) {
        return ResponseBody.handle(commityService.addCommity(cWid, commity));
    }

    /**
     * 修改商品数据
     */
    @PutMapping("cId")
    public ResponseEntity<ResponseBody<Commity>> updateCommity(
            @PathVariable("cWid") @NotNull Integer cWid,
            @PathVariable("cId") Integer cId, @Valid @RequestBody Commity commity) {
        return ResponseBody.handle(commityService.updateCommity(cWid, cId, commity));
    }

    /**
     * 删除商品
     */
    @DeleteMapping("cId")
    public ResponseEntity<ResponseBody<Commity>> deleteCommity(
            @PathVariable("cWid") @NotNull Integer cWid, @PathVariable("cId") @NotNull Integer cId) {
        return ResponseBody.handle(commityService.deleteCommity(cWid, cId));
    }

    /**
     * 查询数据
     */

    @GetMapping("{cId}")
    public ResponseEntity<ResponseBody<Commity>> queryCommity(
            @PathVariable("cWid") @NotNull Integer cWid, @PathVariable("cId") @NotNull Integer cId) {
        return ResponseBody.handle(commityService.queryCommity(cWid, cId));
    }

    /**
     * 根据wid查询所有商品
     */
    @GetMapping("CommityList")
    public ResponseEntity<ResponseBody<Map<String, Object>>> queryCommities(
            @PathVariable("cWid") @NotNull Integer cWid) {
        return ResponseBody.handle(commityService.queryCommities(cWid));
    }
}
