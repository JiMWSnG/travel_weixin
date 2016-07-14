package com.travel.web;

import com.travel.util.Page;

/**
 * Created by Administrator on 2016/7/13.
 */
public class PageResponse extends Response {
    private Page page;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
