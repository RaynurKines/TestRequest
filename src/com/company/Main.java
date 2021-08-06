package com.company;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://api.shoutcloud.io/V1/SHOUT");

        String inputJson = "{\"input\":\"Hello\"}";
        StringEntity stringEntity = new StringEntity(inputJson);
        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        HttpResponse response = httpclient.execute(httpPost);
        HttpEntity entity = response.getEntity();

        System.out.println(EntityUtils.toString(entity));
        System.out.println(response.getStatusLine());
    }
}
