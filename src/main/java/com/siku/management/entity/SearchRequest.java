package com.siku.management.entity;

public class SearchRequest {
    private int pageIndex;
    private int pageSize;
    private int searchIndex;
    private String searchIndexValue;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSearchIndex() {
        return searchIndex;
    }

    public void setSearchIndex(int searchIndex) {
        this.searchIndex = searchIndex;
    }

    public String getSearchIndexValue() {
        return searchIndexValue;
    }

    public void setSearchIndexValue(String searchIndexValue) {
        this.searchIndexValue = searchIndexValue;
    }
}
