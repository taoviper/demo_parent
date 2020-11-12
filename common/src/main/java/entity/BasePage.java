package entity;

/**
 * @author 9527
 * @version 1.0
 * @date 2020-11-3 9:35
 */
public class BasePage {

    /**
     * 每页展示数
     */
    private Integer  pageSize;

    /**
     * 当前页
     */
    private Integer  currentPage;

    /**
     * 查询总数
     */
    private Integer total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 偏移量
     */
    private Integer offset;

    public BasePage() {
    }

    public BasePage(Integer pageSize, Integer currentPage, Integer total) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        if (total/pageSize != 0){
            pages = total/pageSize + 1 ;
        }else {
            pages = total/pageSize;
        }
       // offset = (currentPage - 1) * pageSize;
    }

    public Integer getPages() {
        return pages;
    }

    public Integer getOffset() {
        return offset;
    }
}
