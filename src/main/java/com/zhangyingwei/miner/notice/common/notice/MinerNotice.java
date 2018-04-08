package com.zhangyingwei.miner.notice.common.notice;

import com.zhangyingwei.miner.notice.common.sources.action.ContentAction;
import com.zhangyingwei.miner.notice.common.sources.model.Content;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyw on 2018/4/8.
 */
@Log4j
public class MinerNotice {
    private ContentAction contentAction;
    private List<MinerSubsctibe> subsctibes;

    public MinerNotice() {
        this.contentAction = new ContentAction();
        this.subsctibes = new ArrayList<MinerSubsctibe>();
    }

    public void regist(MinerSubsctibe subsctibe) {
        this.subsctibes.add(subsctibe);
    }

    public void noticeAll() {
        List<Content> contents = this.contentAction.listNoticeContents();
        subsctibes.forEach(subsctibe -> {
            log.info("nocite " + subsctibe.getClass());
            subsctibe.notice(contents);
        });
    }


}
