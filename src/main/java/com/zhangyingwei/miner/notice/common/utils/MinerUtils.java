package com.zhangyingwei.miner.notice.common.utils;

import com.zhangyingwei.miner.notice.common.sources.action.ContentAction;
import com.zhangyingwei.miner.notice.common.sources.model.Content;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

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

    public static String formateWeiBoContent(List<Content> contents) {
        StringBuilder result = new StringBuilder();
        Integer length = contents.size();
        for (int i = 0; i < contents.size(); i++) {
            String title = contents.get(i).getTitle();
            if (title.length() > 20) {
                title = title.substring(0, 20).concat("...");
            }
            contents.get(i).setTitle(title);
            result.append(contents.get(i).getTitle());
            result.append(new String(new byte[5]));
            if (result.length() > 100) {
                break;
            }else{
                length = i + 1;
            }
        }
        List<Content> resContents = contents.subList(0, length).stream().map(line -> {
            line.setTitle(line.getTitle().replaceAll("\\n",""));
            line.setUrl(URLEncoder.encode(line.getUrl())
                    .replaceAll("%3A",":")
                    .replaceAll("%2F","/")
            );
            return line;
        }).collect(Collectors.toList());
        String currentDate = getCurrentDate();
        return BeetlUtils.formateWeiBoTemplage(new HashMap(){
            {
                put("items", resContents);
                put("date", currentDate);
            }
        });
    }

    private static String getCurrentDate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date());
    }
}
