package cn.yearcon.shop.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页计算工具类
 *
 * @author itguang
 * @create 2017-10-21 15:44
 **/
public class Page  implements Serializable{

    /**
     *
     */
    private List records;
    /**
     *每页显示的记录条数
     */
    private int pagesize = 10;
    /**
     *用户要看的页码即当前页码
     */
    private int pagenum;
    /**
     *总页数
     */
    private int totalpage;
    /**
     *每页开始记录的索引
     */
    private int startIndex;

    /**
     *总记录条数
     */
    private int totalrecords;


    /**
     * 起始页
     */
    private int startPage;
    /**
     * 结束页
     */
    private int endPage;

    /**
     *
     * @param pagenum
     * @param totalrecords
     */
    public Page(int pagenum,int pagesize,int totalrecords){
        this.pagenum = pagenum;
        this.totalrecords = totalrecords;

        //计算每页开始记录的索引
        startIndex = (pagenum-1)*pagesize;
        //计算总页数
        totalpage = totalrecords%pagesize==0?totalrecords/pagesize:(totalrecords/pagesize+1);



    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getTotalpage() {
        return totalpage;
    }

    public void setTotalpage(int totalpage) {
        this.totalpage = totalpage;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTotalrecords() {
        return totalrecords;
    }

    public void setTotalrecords(int totalrecords) {
        this.totalrecords = totalrecords;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }
}
