package com.zhangyingwei.miner.notice.common.subscribe.mapper;

import com.zhangyingwei.miner.notice.common.subscribe.model.Subscribe;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author: zhangyw
 * @date: 2018/4/5
 * @time: 下午10:15
 * @desc:
 */
public interface SubscribeMapper {

    @SelectProvider(type = SubscribeMapperProvider.class, method = "listAllSubscribeByParamSql")
    List<Subscribe> listAllSubscribeByParam(@Param("sub") Subscribe subscribe);

    class SubscribeMapperProvider {
        public String listAllSubscribeByParamSql(@Param("sub") Subscribe subscribe) {
            StringBuffer sql = new StringBuffer("select * from mp_subscribe where 1=1 and");
            if (null != subscribe.getFlag()) {
                sql.append(" flag=#{sub.flag} and");
            }
            if (StringUtils.isNotEmpty(subscribe.getSubdate())) {
                sql.append(" subdate=#{sub.subdate} and");
            }
            sql.delete(sql.length() - 4, sql.length());
            sql.append(" order by id desc");
            return sql.toString();
        }
    }
}
