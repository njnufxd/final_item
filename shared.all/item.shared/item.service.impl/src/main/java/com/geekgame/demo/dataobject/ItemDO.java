package com.geekgame.demo.dataobject;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.geekgame.demo.model.Item;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.time.LocalDateTime;
@Data
public class ItemDO implements Serializable {

    private String id;

    private String name;

    private Double value;

    private String ownerId;

    private String ownerName;

    private String intro;

    private String imgs;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtCreated;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime gmtModified;

    public ItemDO() {
    }

    /**
     * Model 转 DO
     * @param item
     */
    public ItemDO(Item item){
        BeanUtils.copyProperties(item,this);
    }

    /**
     * DO 转 Model
     * @return Item
     */
    public Item toModel(){
        Item item = new Item();
        BeanUtils.copyProperties(this,item);
        return item;
    }



}
