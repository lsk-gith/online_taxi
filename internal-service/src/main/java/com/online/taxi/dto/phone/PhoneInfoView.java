package com.online.taxi.dto.phone;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Auther: lsk
 * @Date: 2022/7/17 - 07 - 17 - 14:19
 * @Description: com.online.taxi.dto.phone
 * @version: 1.0
 */
@Data
@Accessors(chain = true)
public class PhoneInfoView {
    private int id;
    private String phone;
    private String encrypt;
}
