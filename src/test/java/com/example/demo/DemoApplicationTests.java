package com.example.demo;

import com.example.demo.service.impl.RetailerServiceImpl;
import com.example.demo.service.impl.WholesaleServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private RetailerServiceImpl retailerService;

    @Autowired
    private WholesaleServiceImpl wholesaleService;

    // @Test
    // void contextLoads() {
    // Retailer retailer = new Retailer();
    // Date date = new Date();
    // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // System.out.println(simpleDateFormat.format(date));
    // retailer.setRUser("aaa").setpassword("123456").setRName("test").setRCodeid("123456789")
    // .setRPhone("12345678902").setRCompany("test").setRTime(date).setRStatus("正常");
    // System.out.println(retailerService.registerRetailer(retailer));

    // }

    // @Test
    // void contextLoads1() {
    // Wholesale wholesale = new Wholesale();
    // // SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    // Date date = new Date();
    // wholesale.setWUser("bbb").setWPassword("123456").setWName("test")
    // .setWPhone("12345678902").setWCompany("test").setWTime(date)
    // .setWStatus("正常").setWCodeid("123456789").setWCountry("中国");
    // // System.out.println(wholesaleService.addWholesale(wholesale));
    // System.out.println(wholesaleService.updateWholesaleById(2, wholesale));

    // }

}
