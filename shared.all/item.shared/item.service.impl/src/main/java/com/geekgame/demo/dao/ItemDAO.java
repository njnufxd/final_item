package com.geekgame.demo.dao;

import com.geekgame.demo.dataobject.ItemDO;
import com.geekgame.demo.param.BasePageParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface ItemDAO {
    int add(ItemDO itemDO);

    int delete(String id);

    int update(ItemDO itemDO);

    int selectCounts();

    ItemDO findById(String id);

    List<ItemDO> pageQuery(BasePageParam param);

    List<ItemDO> findByUserAndValue(@Param("userId") String userId, @Param("value") Double value);
}
