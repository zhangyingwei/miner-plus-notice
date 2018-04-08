package com.zhangyingwei.miner.notice.subscribe.email;

import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by zhangyw on 2018/4/8.
 */
public interface EmailMapper {

    @Select("select * from mp_subscribe where flag=2")
    List<Email> listSubscribes() throws Exception;
}
