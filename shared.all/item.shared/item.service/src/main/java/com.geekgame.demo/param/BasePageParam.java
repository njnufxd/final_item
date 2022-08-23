package com.geekgame.demo.param;

/**
 * 分页参数类
 */
public class BasePageParam  {

    /**
     * 页数
     */
    private int pageNum = 1;

    /**
     * 每页数量
     */
    private int pageSize = 15;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

}
