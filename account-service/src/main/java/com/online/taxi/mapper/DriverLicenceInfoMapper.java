package com.online.taxi.mapper;

import com.online.taxi.entity.DriverLicenceInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface DriverLicenceInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(DriverLicenceInfo record);

    int insertSelective(DriverLicenceInfo record);

    DriverLicenceInfo selectByDriverId(Integer driverId);

    DriverLicenceInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DriverLicenceInfo record);

    int updateByDriverIdSelective(DriverLicenceInfo record);

    int updateByPrimaryKey(DriverLicenceInfo record);
}