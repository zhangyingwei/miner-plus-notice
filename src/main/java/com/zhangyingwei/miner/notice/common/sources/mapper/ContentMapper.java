package com.zhangyingwei.miner.notice.common.sources.mapper;

import com.zhangyingwei.miner.notice.common.sources.model.Content;
import lombok.extern.log4j.Log4j;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * Created by zhangyw on 2018/4/8.
 */
public interface ContentMapper {
    @SelectProvider(type = ContentMapperProvider.class,method = "listNoticeContentsSql")
    List<Content> listNoticeContents(@Param("pushdate") String pushdate) throws Exception;

    @Log4j
    class ContentMapperProvider {
        public String listNoticeContentsSql(@Param("pushdate") String pushdate) {
            StringBuilder sql = new StringBuilder("select mc.*,mct.topicid,mt.topic from mp_content mc LEFT JOIN mp_content_topic mct on mc.id=mct.contentid LEFT JOIN mp_topics mt on mct.topicid=mt.id where state=4 and haspush = 0 and pushdate =#{pushdate}");
            log.info(sql.toString());
            return sql.toString();
        }
    }
}
