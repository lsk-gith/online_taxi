package com.online.taxi.service.impl;

import com.online.taxi.entity.DriverInfo;
import com.online.taxi.mapper.DriverInfoMapper;
import com.online.taxi.service.DriverService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/25 - 07 - 25 - 22:17
 * @Description: com.online.taxi.service.impl
 * @version: 1.0
 */
@Service
public class DriverServiceImpl implements DriverService {
    @Autowired
    private DriverInfoMapper driverInfoMapper;


    @Override
    public List<DriverInfo> selectDriverList() {

        return driverInfoMapper.selectDriverInfoList();
    }
}
