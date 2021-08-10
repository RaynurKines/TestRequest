package com.company;

import com.company.Objects.Category;
import com.company.Objects.Pet;
import com.company.Objects.Status;
import com.company.Objects.Tag;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();

        Status status = null;
        //Creating the dog
        Pet pet = createPet();

        ObjectMapper mapper = new ObjectMapper();

        //POST creating the dog
        HttpPost postCreate = new HttpPost("https://petstore.swagger.io/v2/pet");

        StringEntity stringEntity = new StringEntity(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(pet));
        postCreate.setEntity(stringEntity);
        postCreate.setHeader("Accept", "application/json");
        postCreate.setHeader("Content-type", "application/json");
        HttpResponse response = httpClient.execute(postCreate);
        HttpEntity entity = response.getEntity();

        System.out.println(EntityUtils.toString(entity));
        System.out.println(response.getStatusLine());

        httpClient.close();

        CloseableHttpClient httpСlient2 = HttpClients.createDefault();
        //POST changing dog's name & status
        HttpPost postChangeName = new HttpPost("https://petstore.swagger.io/v2/pet/" + pet.getId());

        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("name", "Sharick"));
        nvps.add(new BasicNameValuePair("status", Status.sold.name()));
        postChangeName.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
        HttpResponse response2 = httpСlient2.execute(postChangeName);
        HttpEntity entity2 = response2.getEntity();

        System.out.println(EntityUtils.toString(entity2));
        System.out.println(response2.getStatusLine());
        httpСlient2.close();

        CloseableHttpClient httpСlient3 = HttpClients.createDefault();
        //Get finding the dog
        HttpGet getPet = new HttpGet("https://petstore.swagger.io/v2/pet/" + pet.getId());
        CloseableHttpResponse response3 = httpСlient3.execute(getPet);
        HttpEntity entity3 = response3.getEntity();
        System.out.println(EntityUtils.toString(entity3));

    }

    private static Pet createPet() {

        int id = 121;
        Category category = null;
        Pet pet = new Pet();

        pet.setId(id);
        pet.setCategory(category);
        pet.setName("Bobick");
        pet.setPhotoUrls(new String[]{"https://proprikol.ru/wp-content/uploads/2021/01/sobachki-krasivye-kartinki-1-650x406.jpg", "https://proprikol.ru/wp-content/uploads/2021/01/sobachki-krasivye-kartinki-3-650x455.jpg"});
        pet.setTags(new Tag[]{});
        pet.setStatus(Status.available);

        return pet;

    }

    private static void changePetsName() {


    }

    public void GET() {


    }

}
