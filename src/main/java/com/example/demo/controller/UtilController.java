package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;

import com.example.demo.entity.util.ResponseBody;
import com.example.demo.service.CommityService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 工具类
 */
@RestController
@RequestMapping("/util")
public class UtilController {

    @Resource
    private CommityService commityService;

    /**
     * 按照商品类型获取该大类型的所有商品
     */
    @GetMapping("CommityList/{cType}")
    public ResponseEntity<ResponseBody<Map<String, Object>>> queryCommitiesByType(
            @PathVariable("cType") @NotNull String cType) {
        return ResponseBody.handle(commityService.queryCommitiesByType(cType));
    }

    /**
     * 查所有
     */
}
