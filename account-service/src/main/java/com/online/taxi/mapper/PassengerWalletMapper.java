package com.online.taxi.mapper;

import com.online.taxi.entity.PassengerWallet;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Mapper
@Repository
public interface PassengerWalletMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PassengerWallet record);

    int insertSelective(PassengerWallet record);

    PassengerWallet selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PassengerWallet record);

    int updateByPrimaryKey(PassengerWallet record);
}