package com.online.taxi.task;

import com.online.taxi.entity.Order;
import com.online.taxi.entity.OrderRulePrice;

import java.util.List;

/**
 * @Auther: lsk
 * @Date: 2022/7/22 - 07 - 22 - 22:44
 * @Description: com.online.taxi.task
 * @version: 1.0
 */
public interface ITask {
    public abstract int execute(long current);

    public abstract int getTaskId();

    public abstract boolean isTime();

    public abstract int getOrderType();

    public abstract boolean sendOrder(Order order, OrderRulePrice orderRulePrice, TaskCondition taskCondition, int round);

    public abstract void taskEnd(Order order, OrderRulePrice orderRulePrice);

    public abstract void setTaskConditions(List<TaskCondition> taskConditions);



}
