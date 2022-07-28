package com.online.taxi.task;

import com.online.taxi.cosntant.EnableDisableEnum;
import com.online.taxi.cosntant.OrderEnum;
import com.online.taxi.dto.BaseInfoDto;
import com.online.taxi.dto.ResponseResult;
import com.online.taxi.entity.CarLevel;
import com.online.taxi.entity.Channel;
import com.online.taxi.entity.City;
import com.online.taxi.entity.ServiceType;
import com.online.taxi.mapper.*;
import com.online.taxi.request.OrderDtoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Auther: lsk
 * @Date: 2022/7/28 - 07 - 28 - 22:30
 * @Description: com.online.taxi.task
 * @version: 1.0
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class OrderRequestTask {
    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private ServiceTypeMapper serviceTypeMapper;

    @Autowired
    private ChannelMapper channelMapper;

    @Autowired
    private CarLevelMapper carLevelMapper;

    @Autowired
    private OrderPointsMapper orderPointsMapper;

    @Autowired
    private OrderRuleMirrorMapper orderRuleMirrorMapper;

    @Autowired
    private OtherInterfaceTask otherInterfaceTask;

    /**
     * 校验基础信息
     * @param orderRequest
     * @return
     */
    public ResponseResult checkBaseInfo(OrderDtoRequest orderRequest){
        City city = cityMapper.selectByPrimaryKey(Integer.parseInt(orderRequest.getCityCode()));
        if(null == city){
            return ResponseResult.fail(OrderEnum.CITIES_DON_EXIST.getCode(),OrderEnum.CITIES_DON_EXIST.getValue());
        }else{
            if(StringUtils.isNotBlank(city.getCityStatus().toString()) && city.getCityStatus().equals(EnableDisableEnum.ENABLE.getCode())){
                return ResponseResult.fail(OrderEnum.CITIES_IS_NOT_ENABLED.getCode(),OrderEnum.CITIES_IS_NOT_ENABLED.getValue());
            }
        }

        ServiceType serviceType = serviceTypeMapper.selectByPrimaryKey(orderRequest.getServiceTypeId());
        if(null == serviceType){
            return ResponseResult.fail(OrderEnum.SERVICE_TYPE_IS_NO.getCode(),OrderEnum.SERVICE_TYPE_IS_NO.getValue());
        }else{
            if(StringUtils.isNotBlank(serviceType.getServiceTypeStatus().toString()) && serviceType.getServiceTypeStatus().equals(EnableDisableEnum.ENABLE.getCode())){
                return ResponseResult.fail(OrderEnum.SERVICE_TYPE_IS_NOT_ENABLED.getCode(),OrderEnum.SERVICE_TYPE_IS_NOT_ENABLED.getValue());
            }
        }
        Channel channel = channelMapper.selectByPrimaryKey(orderRequest.getChannelId());
        if(null == channel){
            return ResponseResult.fail(OrderEnum.CHANNEL_IS_NO.getCode(),OrderEnum.CHANNEL_IS_NO.getValue());
        }else{
            if(StringUtils.isNotBlank(channel.getChannelStatus().toString()) && channel.getChannelStatus().equals(EnableDisableEnum.ENABLE.getCode())){
                return ResponseResult.fail(OrderEnum.CHANNEL_IS_NOT_ENABLED.getCode(),OrderEnum.CHANNEL_IS_NOT_ENABLED.getValue());
            }
        }
        CarLevel carLevel = carLevelMapper.selectByPrimaryKey(orderRequest.getCarLevelId());
        if(null == carLevel){
            return ResponseResult.fail(OrderEnum.CAR_LEVEL_IS_NO.getCode(),OrderEnum.CAR_LEVEL_IS_NO.getValue());
        }else{
            if(StringUtils.isNotBlank(carLevel.getEnable().toString()) && carLevel.getEnable().equals(EnableDisableEnum.ENABLE.getCode())){
                return ResponseResult.fail(OrderEnum.CAR_LEVEL_IS_NOT_ENABLED.getCode(),OrderEnum.CAR_LEVEL_IS_NOT_ENABLED.getValue());
            }
        }

        BaseInfoDto baseInfoDto = new BaseInfoDto();
        baseInfoDto.setCityName(city.getCityName());
        baseInfoDto.setServiceTypeName(serviceType.getServiceTypeName());
        baseInfoDto.setChannelName(channel.getChannelName());
        baseInfoDto.setCarLevelName(carLevel.getLabel());
        return ResponseResult.success(baseInfoDto);

    }



}
