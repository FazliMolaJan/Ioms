package com.hy.ioms.model;

import java.util.List;

/**
 * page对象
 * Created by wsw on 2017/8/2.
 */

public class Page<T> {

    private int totalNumber;
    private int currentPage;
    private List<T> content;

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }


    public void synchronize(Page page) {
        this.totalNumber = page.getTotalNumber();
        this.currentPage = page.getCurrentPage();
    }
}
