package com.zhangyingwei.miner.notice.subscribe.weibo;

import com.alibaba.fastjson.JSONObject;
import com.zhangyingwei.miner.notice.common.utils.PropertiesUtils;
import lombok.extern.log4j.Log4j;
import okhttp3.*;

import java.io.IOException;

/**
 * Created by zhangyw on 2018/4/9.
 */
@Log4j
public class WeiBoClient {
    private OkHttpClient client = new OkHttpClient();
    private String token;
    private String url;

    public WeiBoClient() throws IOException {
        this.token = PropertiesUtils.get("miner.weibo.token");
        this.url = PropertiesUtils.get("miner.weibo.url");
    }

    public void send(String content) throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        StringBuilder contentBuilder = new StringBuilder("access_token=");
        contentBuilder.append(token);
        contentBuilder.append("&status=");
        contentBuilder.append(content);
        RequestBody body = RequestBody.create(mediaType, contentBuilder.toString());
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("content-type", "application/x-www-form-urlencoded")
                .addHeader("cache-control", "no-cache")
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String result = response.body().string();
            log.info(result);
        } else {
            log.info("send weibo error");
            log.info(response.message());
            log.info(response.body().string());
            log.info("-----------------");
        }
    }

    public static void main(String[] args) throws IOException {
        new WeiBoClient().send("hello miner bot http://blog.zhangyingwei.com");
    }
}
