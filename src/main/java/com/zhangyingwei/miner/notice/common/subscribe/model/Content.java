package com.zhangyingwei.miner.notice.common.subscribe.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: zhangyw
 * @date: 2018/4/5
 * @time: 下午10:25
 * @desc:
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
}
