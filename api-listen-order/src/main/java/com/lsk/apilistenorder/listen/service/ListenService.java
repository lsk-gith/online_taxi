package com.lsk.apilistenorder.listen.service;

import com.lsk.apilistenorder.listen.response.PreGrabResponse;

/**
 * @Auther: lsk
 * @Date: 2022/7/13 - 07 - 13 - 22:07
 * @Description: com.lsk.apilistenorder.service
 * @version: 1.0
 */
public interface ListenService {
    /**
     *
     * @param driverId
     * @return
     */
    public abstract PreGrabResponse listen(int driverId);
}
