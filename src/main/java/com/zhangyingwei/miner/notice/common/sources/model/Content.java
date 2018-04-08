package com.zhangyingwei.miner.notice.common.sources.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by zhangyw on 2018/4/8.
 */
@Getter
@Setter
@ToString
public class Content {
    private String id;
    private String author;
    private String sitename;
    private String site;
    private String url;
    private String title;
    private String description;
    private String comment;
    private String pubdate;
    private String getdate;
    private String pushdate;
    private String state;
    private String hashpush;
    private String topicid;
    private String topic;
}
