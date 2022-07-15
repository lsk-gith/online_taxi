package com.lsk.apilistenorder.listen.controller;

import com.lsk.apilistenorder.listen.response.PreGrabResponse;
import com.lsk.apilistenorder.listen.service.ListenService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: lsk
 * @Date: 2022/7/13 - 07 - 13 - 22:21
 * @Description: com.lsk.apilistenorder.listen.controller
 * @version: 1.0
 */
@RestController
@RequestMapping("/listen")
public class ListenController {
    @Autowired
    private ListenService listenService;
    @RequestMapping(value = "/driver/{driverId}",produces = "text/event-stream;charset=utf-8")
    public String getData(@PathVariable("driverId") int driverId){
        System.out.println("方法进来了"+Math.random());
        PreGrabResponse preGrabResponse = listenService.listen(driverId);
        return "data:"+ JSONObject.fromObject(preGrabResponse)+"\n\n";
    }

}
