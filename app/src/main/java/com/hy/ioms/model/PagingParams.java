package com.hy.ioms.model;

import java.io.Serializable;

import javax.inject.Inject;

import static com.hy.ioms.Config.DEFAULT_ITEMS_PER_PAGE;
import static com.hy.ioms.Config.DEFAULT_PAGE;
import static com.hy.ioms.Config.DEFAULT_QUERY_PAGE;
import static com.hy.ioms.Config.DEFAULT_TOTAL_COUNT;

/**
 * Created by wsw on 2017/4/14.
 */

public class PagingParams implements Serializable {

    @Inject
    public PagingParams() {
        init();
    }

    public int currentPage;
    public int itemsPerPage;
    public int totalCount;
    public String sort;
    public int queryPage;

    public void init() {
        currentPage = DEFAULT_PAGE;
        queryPage = DEFAULT_QUERY_PAGE;
        itemsPerPage = DEFAULT_ITEMS_PER_PAGE;
        totalCount = DEFAULT_TOTAL_COUNT;
        sort = "id,desc";
    }
}
