package com.online.taxi.dao;

import com.online.taxi.mapper.PassengerWalletMapper;
import com.online.taxi.entity.PassengerWallet;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * @Auther: lsk
 * @Date: 2022/7/16 - 07 - 16 - 20:16
 * @Description: com.online.taxi.accountservice.dao
 * @version: 1.0
 */
@Repository
@RequiredArgsConstructor
public class PassengerWalletDao {
    @NonNull
    private PassengerWalletMapper passengerWalletMapper;
    public int insertSelective(PassengerWallet record){
        return passengerWalletMapper.insertSelective(record);
    }

}
