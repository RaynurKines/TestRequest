package com.company;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://api.shoutcloud.io/V1/SHOUT");

        String inputJson = "{" + " \"input\":\"Hello\"" + "}";
        StringEntity stringEntity = new StringEntity(inputJson, ContentType.APPLICATION_JSON);
        httpPost.setEntity(stringEntity);
        HttpResponse response = httpclient.execute(httpPost);
        System.out.println(response.getStatusLine());
        System.out.println(response.getEntity().getContent());
    }
}
