package com.demo.vo;



/**
 * @author 9527
 * @version 1.0
 * @date 2020-11-2 16:11
 */
public class BasePage {

    private Integer currentPage;

    private Integer pageSize;

    private Integer offset;

    private Integer total;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public int getCurrentPage() {
        if (currentPage == null){
            return 1;
        }
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        if(pageSize == null){
            return 10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getOffset() {
        return offset= (currentPage-1)*pageSize;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }
}
