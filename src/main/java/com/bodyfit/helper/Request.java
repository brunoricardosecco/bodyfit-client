package com.bodyfit.helper;

import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import java.net.URI;
import java.util.ArrayList;

public class Request {
    private static HttpClient httpClient;

    public static HttpResponse get(String url) throws Exception {
        httpClient = HttpClients.createDefault();

        URIBuilder builder = new URIBuilder(url);

        HttpGet request = new HttpGet(builder.build());
        return httpClient.execute(request);

    }

    public static HttpResponse get(String url, ArrayList<NameValuePair> params) throws Exception {
        httpClient = HttpClients.createDefault();

        URIBuilder builder = new URIBuilder(url);
        for (NameValuePair attr : params) {
            builder.addParameter(attr.getName(), attr.getValue());
        }

        HttpGet request = new HttpGet(builder.build());
        return httpClient.execute(request);

    }

    public static HttpResponse get(URI url, ArrayList<NameValuePair> params) throws Exception {
        httpClient = HttpClients.createDefault();

        URIBuilder builder = new URIBuilder(url);
        for (NameValuePair attr : params) {
            builder.addParameter(attr.getName(), attr.getValue());
        }

        HttpGet request = new HttpGet(builder.build());
        return httpClient.execute(request);
    }

    public static HttpResponse post(String url, JsonObject body) throws Exception {
        httpClient = HttpClients.createDefault();

        HttpPost request = new HttpPost(url);
        request.setEntity(new StringEntity(body.toString(), ContentType.APPLICATION_JSON));

        return httpClient.execute(request);
    }

    public static HttpResponse post(URI url, JsonObject body) throws Exception {
        httpClient = HttpClients.createDefault();

        HttpPost request = new HttpPost(url);
        request.setEntity(new StringEntity(body.toString(), ContentType.APPLICATION_JSON));

        return httpClient.execute(request);
    }
}
