package com.online.taxi.context;

import com.online.taxi.task.ITask;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @Auther: lsk
 * @Date: 2022/7/22 - 07 - 22 - 22:38
 * @Description: com.online.taxi.context
 * @version: 1.0
 */
@Component
@Data
public class TaskStore {
    private static final Logger LOGGER = LoggerFactory.getLogger(TaskStore.class);
    private final ConcurrentHashMap<Integer, ITask> results = new ConcurrentHashMap();

    public void addTask(int taskId, ITask task){
        results.put(taskId, task);
    }

    public List<ITask> getNeedRetryTask(){
        synchronized (results){
            List<ITask> list = new ArrayList<>(results.values());
            results.clear();
            return list;
        }
    }
}
