package com.zhangyingwei.miner.notice.common.subscribe.mapper;

import com.zhangyingwei.miner.notice.common.subscribe.model.Content;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: zhangyw
 * @date: 2018/4/5
 * @time: 下午10:27
 * @desc:
 */
public interface ContentMapper {

    @Select("select * from ")
    List<Content> listContentsByPushdate(String pushdate);
}
