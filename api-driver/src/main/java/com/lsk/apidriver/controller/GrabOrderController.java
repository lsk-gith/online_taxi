package com.lsk.apidriver.controller;

import com.lsk.apidriver.service.RestTemplateRequestService;
import com.lsk.common.dto.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/12 - 07 - 12 - 21:35
 * @Description: com.lsk.apidriver.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/grab")
public class GrabOrderController {

    @Autowired
    private RestTemplateRequestService restTemplateRequestService;
    @GetMapping("/do/{orderId}")
    public ResponseResult grab(@PathVariable("orderId") int orderId, int driverId){
        String grabOrder = restTemplateRequestService.grabOrder(orderId, driverId);
        return ResponseResult.success(grabOrder);

    }

}
