package com.geekgame.demo.service.impl;

import com.geekgame.demo.dao.ItemDAO;
import com.geekgame.demo.dataobject.ItemDO;
import com.geekgame.demo.model.Item;
import com.geekgame.demo.model.Paging;
import com.geekgame.demo.param.BasePageParam;
import com.geekgame.demo.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 服务实现类
 */
@Service
@DubboService
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public Item add(Item item) {
        if (item == null) {
            return null;
        }
        int add = itemDAO.add(new ItemDO(item));
        if (add == 1){
            return item;
        }
        return null;
    }

    @Override
    public boolean delete(String id) {
        if (StringUtils.isEmpty(id)) {
            return false;
        }
        int delete = itemDAO.delete(id);
        return delete == 1;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Item update(Item item) {
        if (item == null) {
            return null;
        }
        int update = itemDAO.update(new ItemDO(item));
        if (update == 1) {
            return item;
        }
        return null;
    }

    @Override
    public Item findById(String id) {
        if (StringUtils.isEmpty(id)) {
            return null;
        }
        ItemDO itemDO = itemDAO.findById(id);
        if (itemDO == null) {
            return null;
        }
        return itemDO.toModel();
    }

    @Override
    public Paging<Item> pageQuery(BasePageParam param) {
        Paging<Item> paging = new Paging<>();
        if (param == null) {
            return null;
        }
        List<ItemDO> itemDOS = itemDAO.pageQuery(param);
        if (itemDOS == null || itemDOS.isEmpty()) {
            return null;
        }
        List<Item> collect = itemDOS.stream().map(ItemDO::toModel).collect(Collectors.toList());
        Collections.shuffle(collect);
        int counts = itemDAO.selectCounts();
        paging.setPageNum(param.getPageNum());
        paging.setPageSize(param.getPageSize());
        paging.setTotalCount(counts);
        paging.setTotalPage((int) Math.ceil(counts * 1.0 / paging.getPageSize()));
        paging.setData(collect);
        return paging;
    }

    @Override
    public List<Item> findByUserAndValue(String userId, Double value) {
        if (userId == null && value == null) {
            return null;
        }
        List<ItemDO> itemDOS = itemDAO.findByUserAndValue(userId, value);
        if (itemDOS == null || itemDOS.isEmpty()) {
            return null;
        }
        List<Item> collect = itemDOS.stream().map(ItemDO::toModel).collect(Collectors.toList());
        return collect;
    }
}
