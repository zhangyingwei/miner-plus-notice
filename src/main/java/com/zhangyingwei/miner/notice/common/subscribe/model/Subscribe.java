package com.zhangyingwei.miner.notice.common.subscribe.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author: zhangyw
 * @date: 2018/4/5
 * @time: 下午10:16
 * @desc:
 */
@Getter
@Setter
@ToString
public class Subscribe {
    private String id;
    private String email;
    private String topics;
    private Integer flag;
    private String subdate;
    private String dessubdate;
}
