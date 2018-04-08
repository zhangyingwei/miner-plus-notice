package com.zhangyingwei.miner.notice.common.sources.service;


import org.junit.Before;
import org.junit.Test;

/**
 * Created by zhangyw on 2018/4/8.
 */
public class ContentServiceTest {
    private ContentService contentService;

    @Before
    public void before(){
        this.contentService = new ContentService();
    }

    @Test
    public void listNoticeContents() throws Exception {
        System.out.println(this.contentService.listNoticeContents());
    }
}