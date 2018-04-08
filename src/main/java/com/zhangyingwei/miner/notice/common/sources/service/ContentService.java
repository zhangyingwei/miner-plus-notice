package com.zhangyingwei.miner.notice.common.sources.service;

import com.zhangyingwei.miner.notice.common.sources.mapper.ContentMapper;
import com.zhangyingwei.miner.notice.common.sources.model.Content;
import com.zhangyingwei.miner.notice.common.utils.MybatisUtils;
import lombok.extern.log4j.Log4j;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyw on 2018/4/8.
 */
@Log4j
public class ContentService {
    private ContentMapper contentMapper;

    public ContentService() {
        this.contentMapper = MybatisUtils.getMapper(ContentMapper.class);
    }

    public List<Content> listNoticeContents() {
        try {
            String time = new DateTime().plusDays(0).toString("yyyy-MM-dd");
            System.out.println(time);
            return this.contentMapper.listNoticeContents(time);
        } catch (Exception e) {
            log.info(e.getLocalizedMessage());
        }
        return new ArrayList<Content>();
    }
}
