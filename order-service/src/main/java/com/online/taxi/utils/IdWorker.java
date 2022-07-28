package com.online.taxi.utils;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Auther: lsk
 * @Date: 2022/7/25 - 07 - 25 - 22:50
 * @Description: com.online.taxi.utils
 * @version: 1.0
 */
@Component
public class IdWorker {
    private AtomicInteger sequence = new AtomicInteger();

    private String lastTimestamp = "";

    private Integer value =4;

    /**
     *
     * @return
     * @throws Exception
     * /如果上一个timestamp与新产生的相等，则sequence加一(0-4095循环)，下次再使用时sequence是新值
     */
    public String nextId(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String timeStamp = sdf.format(new Date());
        System.out.println(timeStamp);
        if(!this.lastTimestamp.equals(timeStamp)){
            sequence.set(0);
        }
        this.lastTimestamp = timeStamp;
        return timeStamp + fixedLenSeq();
    }

    private String fixedLenSeq() {
        String seq = "000" + sequence.incrementAndGet();
        if (seq.length() > value) {
            return seq.substring(seq.length() - 4, seq.length());
        }
        return seq;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++){
            System.out.println(new IdWorker().nextId());
        }
    }
}
