package com.online.taxi.mapper;

import com.online.taxi.dto.valuation.charging.TagPrice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @Auther: lsk
 * @Date: 2022/7/26 - 07 - 26 - 21:47
 * @Description: com.online.taxi.mapper
 * @version: 1.0
 */
@Service
@Mapper
public interface TagRuleInfoMapper {
    /**
     * 查询标签
     * @param param
     * @return
     */
    List<TagPrice> selectByPrimaryKey(Map<String, Object> param);
}
