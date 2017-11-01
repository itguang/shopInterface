package cn.yearcon.shop.utils;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 分页工具类
 *
 * @author itguang
 * @create 2017-10-20 8:56
 **/
public class PageResult<T> implements Serializable{
    /**
     * 页数
     */
    private int pageCount = 1;
    /**
     * 数据总数
     */
    private int total = 1;
    /**
     * 当前页
     */
    private int currentPage = 1;
    /**
     * 页大小
     */
    private int pageSize = 10;
    /**
     * 数据
     */
    private List<T> data = new ArrayList<>();

    public List<T> getData() {
        return data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    public int getPageCount() {
        return pageCount;
    }
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }
    public int getCurrentPage() {
        return currentPage;
    }
    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return pageSize * (currentPage - 1);
    }

    public static <E>PageResult<E> create(int page, int count, List<E> data) {
        PageResult<E> pageResult = new PageResult<>();
        pageResult.setCurrentPage(page);
        pageResult.setTotal(count);
        pageResult.setData(data);
        return pageResult;
    }




}
