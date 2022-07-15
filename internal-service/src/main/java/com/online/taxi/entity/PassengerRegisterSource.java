package com.online.taxi.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * @author 
 * 
 */
@Data
public class PassengerRegisterSource implements Serializable {
    private Integer id;

    private Integer passengerInfoId;

    private String registerSource;

    private String marketChannel;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;
}