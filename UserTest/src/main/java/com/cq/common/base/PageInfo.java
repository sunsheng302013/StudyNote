/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.base;

/**
 * 分页信息类
 *
 * @since 2018年1月11日 下午3:47:01
 * @author CaiYH
 */
public class PageInfo {

    /** 每页长度默认50条记录 **/
    private static final int PAGESIZE = 50;

    /** 页码，默认0，显示第一页 **/
    private int pageIndex = 0;

    /** 分页偏移量 **/
    private int offset;

    /** 每页显示大小，默认50条记录 **/
    private int pageSize = PAGESIZE;

    /** 排序方式，默认升序 **/
    private String sortOrder = Sort.ASC.toString();

    /** 排序字段 **/
    private String sortField;

    /** 总条数 **/
    private Integer total;

    /** 排序 **/
    public enum Sort {
        /** 降序 **/
        DESC, ASC
    }

    /**
     * @return the pageIndex
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * @param pageIndex
     *            要设置的 pageIndex
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * @return the offset
     */
    public int getOffset() {
        this.offset = pageIndex * pageSize;
        return offset;
    }

    /**
     * @param offset
     *            要设置的 offset
     */
    public void setOffset(int offset) {
        this.offset = offset;
    }

    /**
     * @return the pageSize
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * @param pageSize
     *            要设置的 pageSize
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * @return the sortOrder
     */
    public String getSortOrder() {
        return sortOrder;
    }

    /**
     * @param sortOrder
     *            要设置的 sortOrder
     */
    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    /**
     * @return the sortField
     */
    public String getSortField() {
        return sortField;
    }

    /**
     * @param sortField
     *            要设置的 sortField
     */
    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total
     *            要设置的 total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }
}
