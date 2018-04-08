package com.zhangyingwei.miner.notice.subscribe.email;

import java.util.List;

/**
 * Created by zhangyw on 2018/4/8.
 */
public class EmailAction {
    private EmailService emailService;

    public EmailAction() {
        this.emailService = new EmailService();
    }

    public List<Email> listSubscribeEmails() {
        return this.emailService.listSubscribeEmails();
    }
}
