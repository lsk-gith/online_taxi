package com.lsk.serviceorder.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 21:43
 * @Description: com.lsk.serviceorder.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/grab")
public class GrabOrderController {

    public String grab(@PathVariable("orderId") int orderId, int driverId){


        return null;
    }


}
