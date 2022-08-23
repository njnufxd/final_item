package com.geekgame.demo.param;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 物品信息参数类
 */
@Data
public class ItemReceiveParam {
    private String id;

    private String name;

    private Double value;

    private String intro;

    private MultipartFile[] imgs;
}
