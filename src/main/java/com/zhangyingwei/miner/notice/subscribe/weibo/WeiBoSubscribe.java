package com.zhangyingwei.miner.notice.subscribe.weibo;

import com.zhangyingwei.miner.notice.common.notice.MinerSubsctibe;
import com.zhangyingwei.miner.notice.common.sources.model.Content;
import com.zhangyingwei.miner.notice.common.utils.MinerUtils;
import com.zhangyingwei.miner.notice.common.utils.PropertiesUtils;
import com.zhangyingwei.miner.notice.subscribe.email.Email;
import com.zhangyingwei.miner.notice.subscribe.email.EmailAction;
import com.zhangyingwei.smail.Smail;
import com.zhangyingwei.smail.config.SmailConfig;
import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by zhangyw on 2018/4/8.
 */
@Log4j
public class WeiBoSubscribe implements MinerSubsctibe {

    private WeiBoClient weiBoClient;

    public WeiBoSubscribe() throws IOException {
        this.weiBoClient = new WeiBoClient();
    }

    @Override
    public void notice(List<Content> contents) {
        try {
            String content = MinerUtils.formateWeiBoContent(contents);
            log.info(content);
            this.weiBoClient.send(content);
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
        }
    }
}