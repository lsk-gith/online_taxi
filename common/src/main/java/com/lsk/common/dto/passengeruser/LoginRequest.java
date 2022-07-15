package com.lsk.common.dto.passengeruser;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * @Auther: lsk
 * @Date: 2022/7/15 - 07 - 15 - 23:17
 * @Description: com.lsk.common.dto.passengeruser
 * @version: 1.0
 */
@Data
public class LoginRequest {
    @NotBlank
    private String passengerPhone;

}
