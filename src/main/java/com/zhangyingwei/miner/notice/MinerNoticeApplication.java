package com.zhangyingwei.miner.notice;

import com.zhangyingwei.miner.notice.common.notice.MinerNotice;
import com.zhangyingwei.miner.notice.common.sources.action.ContentAction;
import com.zhangyingwei.miner.notice.common.sources.model.Content;
import com.zhangyingwei.miner.notice.subscribe.email.EmailSubscribe;
import com.zhangyingwei.miner.notice.subscribe.weibo.WeiBoSubscribe;

import java.io.IOException;
import java.util.List;

/**
 * Created by zhangyw on 2018/4/8.
 */
public class MinerNoticeApplication {

    public static void main(String[] args) throws IOException {
        MinerNotice minerNotice = new MinerNotice();
        minerNotice.regist(new EmailSubscribe());
        minerNotice.regist(new WeiBoSubscribe());
        minerNotice.noticeAll();
    }
}
