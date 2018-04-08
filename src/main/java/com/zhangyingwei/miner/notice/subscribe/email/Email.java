package com.zhangyingwei.miner.notice.subscribe.email;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangyw on 2018/4/8.
 */
@Getter
@Setter
@ToString
public class Email {
    private String id;
    private String email;
    private String topics;
    private String flag;

    public List<String> getTopices() {
        if (this.topics != null) {
            String[] topics = this.topics.split(",");
            return Arrays.asList(topics);
        } else {
            return new ArrayList<String>();
        }
    }
}
