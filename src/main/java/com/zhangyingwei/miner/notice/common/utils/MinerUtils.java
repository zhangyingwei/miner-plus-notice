package com.zhangyingwei.miner.notice.common.utils;

import com.zhangyingwei.miner.notice.common.sources.action.ContentAction;
import com.zhangyingwei.miner.notice.common.sources.model.Content;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2018/4/8.
 */
public class MinerUtils {

    public static Map<ContentAction.Topic, List<ContentAction.Node>> converToMap(List<Content> contents) {
        Map<ContentAction.Topic, List<ContentAction.Node>> resultMap = new HashMap<ContentAction.Topic,List<ContentAction.Node>>();
        for (int i = 0; i < contents.size(); i++) {
            Content tmp = contents.get(i);
            ContentAction.Topic key = new ContentAction.Topic(tmp.getTopicid(),tmp.getTopic());
            List<ContentAction.Node> list = new ArrayList<ContentAction.Node>();
            if (resultMap.containsKey(key)) {
                list = resultMap.get(key);
            }
            list.add(new ContentAction.Node(tmp,key));
            resultMap.put(key, list);
        }
        return resultMap;
    }

    public static Map<String, List<Content>> converToSimpleMap(List<Content> contents) {
        Map<String, List<Content>> resultMap = new HashMap<String,List<Content>>();
        for (int i = 0; i < contents.size(); i++) {
            Content tmp = contents.get(i);
            String key = tmp.getTopicid();
            List<Content> list = new ArrayList<Content>();
            if (resultMap.containsKey(key)) {
                list = resultMap.get(key);
            }
            list.add(tmp);
            resultMap.put(key, list);
        }
        return resultMap;
    }

    public static String formateEmailContent(List<Content> pushContents) {
        return BeetlUtils.formateTemplage(new HashMap(){
            {
                put("items", pushContents);
            }
        });
    }
}
