package com.online.taxi.service.impl;

import com.online.taxi.dto.OrderOtherPrice;
import com.online.taxi.dto.OrderPrice;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.OrderRulePrice;
import com.online.taxi.mapper.*;
import com.online.taxi.request.OrderDtoRequest;
import com.online.taxi.service.OrderService;
import com.online.taxi.task.OrderRequestTask;
import com.online.taxi.task.OtherInterfaceTask;
import com.online.taxi.utils.IdWorker;
import io.netty.util.internal.UnstableApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Auther: lsk
 * @Date: 2022/7/25 - 07 - 25 - 22:45
 * @Description: com.online.taxi.service.impl
 * @version: 1.0
 */
@Service
@Repository
public class OrderServiceImpl implements OrderService {
    private static final String PASSENGERS_IS_NULL = "乘客信息为空";
    private static final String VALUATION_RULES_CHANGE = "当前预估价格已变化";
    private boolean flag;
    private boolean sate;


    @Autowired
    private IdWorker idWorker;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PassengerInfoMapper passengerInfoMapper;

    @Autowired
    private OrderRulePriceMapper orderRulePriceMapper;

    @Autowired
    private OrderRuleMirrorMapper orderRuleMirrorMapper;

    @Autowired
    private DriverInfoMapper driverInfoMapper;

    @Autowired
    private CarInfoMapper carInfoMapper;

    @Autowired
    private OtherInterfaceTask otherInterfaceTask;

    @Autowired
    private OrderRequestTask orderRequestTask;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 订单预估
     *
     * @param orderDtoRequest
     * @return
     * @throws Exception
     */
    @Override
    public ResponseResult<OrderPrice> forecastOrderCreate(OrderDtoRequest orderDtoRequest) throws Exception {
        return null;
    }


    /**
     * 叫车
     *
     * @param orderDtoRequest
     * @return
     */
    @Override
    public ResponseResult callCar(OrderDtoRequest orderDtoRequest) throws Exception {
        return null;
    }


    /**
     * 订单修改
     *
     * @param orderDtoRequest
     * @return
     * @throws Exception
     */
    @Override
    public ResponseResult updateOrder(OrderDtoRequest orderDtoRequest, String driverLongitude, String driverLatitude) {
        return null;
    }



    /**
     * 订单其它费用结算
     *
     * @param orderDtoRequest
     * @return
     * @throws Exception
     */
    @Override
    public ResponseResult<OrderOtherPrice> otherPriceBalance(OrderDtoRequest orderDtoRequest) throws Exception {
        return null;
    }


    /**
     * 订单改派
     *
     * @param orderDtoRequest
     * @return
     */
    @Override
    public ResponseResult reassignmentOrder(OrderDtoRequest orderDtoRequest) throws Exception {
        return null;
    }




    /**
     * 批量修改
     *
     * @param request
     * @return
     * @throws Exception
     */
    @Override
    public ResponseResult batchUpdate(OrderDtoRequest request) throws Exception {
        return null;
    }
}
