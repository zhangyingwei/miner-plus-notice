package com.zhangyingwei.miner.notice.common.sources.action;

import com.zhangyingwei.miner.notice.common.sources.model.Content;
import com.zhangyingwei.miner.notice.common.sources.service.ContentService;
import lombok.*;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by zhangyw on 2018/4/8.
 */
@Log4j
public class ContentAction {

    private ContentService contentService;

    public ContentAction() {
        this.contentService = new ContentService();
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Node {
        private Content content;
        private Topic topic;
    }

    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Topic {
        private String id;
        private String topic;
    }

    public List<Content> listNoticeContents() {
        return this.contentService.listNoticeContents().stream().sorted((n1,n2) -> {
            return n1.getTopicid().compareTo(n2.getTopicid());
        }).collect(Collectors.toList());
    }
}
