package com.online.taxi.schedule;

import com.online.taxi.context.TaskStore;
import com.online.taxi.service.ConfigService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: lsk
 * @Date: 2022/7/22 - 07 - 22 - 22:30
 * @Description: com.online.taxi.schedule
 * @version: 1.0
 */
@Service
@Slf4j
public class TaskManager {
    private static final String ORDER_ID_IS_NULL = "订单ID为空";
    private static final String ORDER_START_TIME_IS_NULL = "订单开始时间为空";
    private static final String TASK_CONDITIONS_IS_NULL = "任务为空";

    @Autowired
    private TaskStore taskStore;

    @Autowired
    private ConfigService configService;

}
