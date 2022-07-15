package com.online.taxi.dao;

import com.online.taxi.entity.DriverLicenceInfo;
import com.online.taxi.mapper.DriverLicenceInfoMapper;
import com.sun.istack.internal.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 17:22
 * @Description: com.online.taxi.dao
 * @version: 1.0
 */
@Repository
@RequiredArgsConstructor
public class DriverLicenceInfoDao {
    @NotNull
    private DriverLicenceInfoMapper driverLicenceInfoMapper;
    public int deleteByPrimaryKey(Integer id) {
        return driverLicenceInfoMapper.deleteByPrimaryKey(id);
    }


    public int insert(DriverLicenceInfo record) {
        return driverLicenceInfoMapper.insert(record);
    }


    public int insertSelective(DriverLicenceInfo record) {
        return driverLicenceInfoMapper.insertSelective(record);
    }


    public DriverLicenceInfo selectByPrimaryKey(Integer id) {
        return driverLicenceInfoMapper.selectByPrimaryKey(id);
    }

    public DriverLicenceInfo selectByDriverId(Integer driverId) {
        return driverLicenceInfoMapper.selectByDriverId(driverId);
    }

    public int updateByPrimaryKeySelective(DriverLicenceInfo record) {
        return driverLicenceInfoMapper.updateByPrimaryKeySelective(record);
    }
    public int updateByDriverIdSelective(DriverLicenceInfo record) {
        return driverLicenceInfoMapper.updateByDriverIdSelective(record);
    }

    public int updateByPrimaryKey(DriverLicenceInfo record) {
        return driverLicenceInfoMapper.updateByPrimaryKey(record);
    }
}
