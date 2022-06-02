package com.example.demo.controller;

import javax.annotation.Resource;
import javax.validation.Valid;

import com.example.demo.entity.Wholesale;
import com.example.demo.entity.util.ResponseBody;
import com.example.demo.service.WholesaleService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("wholesale")
/**
 * 批发商信息
 */
public class WholesaleController {

    @Resource
    private WholesaleService wholesaleService;

    /**
     * 新增批发商账号
     */
    @PostMapping("")
    public ResponseEntity<ResponseBody<Wholesale>> addWholesale(@Valid @RequestBody Wholesale wholesale) {
        return ResponseBody.handle(wholesaleService.addWholesale(wholesale));
    }

    /**
     * 查询批发商账号
     */
    @GetMapping("{wId}")
    public ResponseEntity<ResponseBody<Wholesale>> queryWholesaleById(@PathVariable("wId") Integer wId) {
        return ResponseBody.handle(wholesaleService.queryById(wId));
    }

    /**
     * 修改批发商信息
     */
    @PutMapping
    public ResponseEntity<ResponseBody<Wholesale>> updateWholesaleById(@PathVariable("wId") Integer wId,
            @Valid @RequestBody Wholesale wholesale) {
        return ResponseBody.handle(wholesaleService.updateWholesaleById(wId, wholesale));
    }

    /**
     * 删除批发商信息
     */
    @DeleteMapping("{wId}")
    public ResponseEntity<ResponseBody<Wholesale>> deleteWholesaleById(@Valid @PathVariable("wId") Integer wId) {
        return ResponseBody.handle(wholesaleService.deleteWholesaleById(wId));
    }

}
