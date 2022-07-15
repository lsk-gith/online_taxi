package com.online.taxi.request;

import com.online.taxi.dto.phone.PhoneInfoView;
import lombok.Data;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 14:16
 * @Description: com.online.taxi.request
 * @version: 1.0
 */
@Data
public class PhoneRequest {
    private Integer idType;

    private List<PhoneInfoView> infoList;
}
