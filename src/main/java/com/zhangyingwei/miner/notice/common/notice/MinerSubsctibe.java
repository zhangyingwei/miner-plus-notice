package com.zhangyingwei.miner.notice.common.notice;

import com.zhangyingwei.miner.notice.common.sources.action.ContentAction;
import com.zhangyingwei.miner.notice.common.sources.action.ContentAction.*;
import com.zhangyingwei.miner.notice.common.sources.model.Content;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2018/4/8.
 */
public interface MinerSubsctibe {
    void notice(List<Content> contents);
}