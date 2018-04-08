package com.zhangyingwei.miner.notice.subscribe.email;

import com.zhangyingwei.miner.notice.common.notice.MinerSubsctibe;
import com.zhangyingwei.miner.notice.common.sources.model.Content;
import com.zhangyingwei.miner.notice.common.utils.MinerUtils;
import com.zhangyingwei.miner.notice.common.utils.PropertiesUtils;
import com.zhangyingwei.smail.Smail;
import com.zhangyingwei.smail.config.SmailConfig;
import lombok.extern.log4j.Log4j;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Created by zhangyw on 2018/4/8.
 */
@Log4j
public class EmailSubscribe implements MinerSubsctibe {

    private EmailAction emailAction;

    public EmailSubscribe() {
        this.emailAction = new EmailAction();
    }

    @Override
    public void notice(List<Content> contents) {
        List<Email> emails = emailAction.listSubscribeEmails();
        Random random = new Random();
        emails.forEach(email -> {
            List<String> topics = email.getTopices();
            List<Content> pushContents = contents.stream().filter(content -> {
                return topics.contains(content.getTopicid());
            }).collect(Collectors.toList());
            if (pushContents.size() > 0) {
                try {
                    String username = PropertiesUtils.get("miner.mail.username");
                    String password = PropertiesUtils.get("miner.mail.password");
                    String title = PropertiesUtils.get("miner.mail.title");
                    log.info(username);
                    log.info(password);
                    log.info(title);
                    new Smail(new SmailConfig().setStarttls(true))
                            .auth(username, password)
                            .to(email.getEmail())
                            .send(title,MinerUtils.formateEmailContent(pushContents));
                    log.info("send mail to " + email.getEmail());
                    TimeUnit.SECONDS.sleep(random.nextInt(10));
                } catch (Exception e) {
                    log.info(e.getLocalizedMessage());
                }
            }
        });
    }
}
