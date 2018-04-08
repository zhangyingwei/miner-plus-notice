package com.zhangyingwei.miner.notice.common.utils;

import com.zhangyingwei.miner.notice.common.sources.action.ContentAction;
import com.zhangyingwei.miner.notice.common.sources.model.Content;
import org.beetl.core.Configuration;
import org.beetl.core.GroupTemplate;
import org.beetl.core.Template;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.core.resource.FileResourceLoader;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangyw on 2017/8/24.
 */
public class BeetlUtils {
    private static final String TEMPLAGE = "/email.html";
//    private static ClasspathResourceLoader resourceLoader = new ClasspathResourceLoader("src/main/resources/template/");
//    static String root = System.getProperty("user.dir")+ File.separator+"src/main/resources/template";
    static String root = System.getProperty("user.dir")+ File.separator+"resources/template";
    static FileResourceLoader resourceLoader = new FileResourceLoader(root,"utf-8");
    private static Configuration cfg;
    static {
        try {
            cfg = Configuration.defaultConfiguration();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static GroupTemplate gt = new GroupTemplate(resourceLoader, cfg);

    public static String formateTemplage(Map<String,List<Content>> contents){
        Template t = gt.getTemplate(TEMPLAGE);
        t.binding(contents);
        return t.render();
    }

    public static void main(String[] args) {
        ContentAction contentAction = new ContentAction();
        List<Content> contents = contentAction.listNoticeContents();
        System.out.println(BeetlUtils.formateTemplage(new HashMap(){
            {
                put("items", contents);
            }
        }));
    }

}
