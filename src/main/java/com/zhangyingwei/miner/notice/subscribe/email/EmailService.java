package com.zhangyingwei.miner.notice.subscribe.email;

import com.zhangyingwei.miner.notice.common.utils.MybatisUtils;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyw on 2018/4/8.
 */
@Log4j
public class EmailService {
    private EmailMapper emailMapper;

    public EmailService() {
        this.emailMapper = MybatisUtils.getMapper(EmailMapper.class);
    }

    public List<Email> listSubscribeEmails() {
        try {
            return this.emailMapper.listSubscribes();
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
        }
        return new ArrayList<Email>();
    }
}
