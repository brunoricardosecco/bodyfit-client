package com.bodyfit.dao;

import com.bodyfit.dto.BodyBuilderDTO;
import com.bodyfit.helper.Request;
import com.bodyfit.model.Bodybuilder;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javafx.scene.control.Alert;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;


public class BodybuilderDAO {

    public ArrayList<Bodybuilder> getAll() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = null;
        HttpGet request = null;
        try {
            request = new HttpGet("https://app-bodyfit.herokuapp.com/bodybuilder/getAll");
            response = client.execute(request);

        } catch (Exception ex) {
            System.out.println("Não deu");
        }

        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            System.out.println("Codigo != de 200");
            return null;
        } else {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            String res = "";
            System.out.println(res);
            try {
                res = EntityUtils.toString(response.getEntity());
            } catch (Exception ex) {
                System.out.println("Erro na conversão de json");
            }
            JSONObject jsonObject = new JSONObject(res);
            JSONArray jsonArray = jsonObject.getJSONArray("bodybuilders");

            ArrayList<Bodybuilder> arrayBodybuilder = new ArrayList<>();

            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);
                String code = obj.getString("code");
                String phone = obj.getString("phone");
                String birth_day = obj.getString("birth_date");
                String name = obj.getString("name");
                String cpf = obj.getString("cpf");
                Integer id = obj.getInt("id");
                String last_paid = "";
                try {
                    last_paid = obj.getString("last_paid");
                } catch (Exception ex) {
                }
                Boolean status = obj.getBoolean("status");

                Bodybuilder desgracado = new Bodybuilder(id, name, cpf, birth_day, status, last_paid, phone, code);
                arrayBodybuilder.add(desgracado);
            }
            return arrayBodybuilder;
        }
    }


    public String register(String name, String cpf, String birthday, String tel, Boolean status, String last_paid, Double value) {
        JsonObject json = new JsonObject();
        json.addProperty("name", name);
        json.addProperty("cpf", cpf);
        json.addProperty("birth_date", birthday);
        json.addProperty("phone", tel);
        json.addProperty("status", status);
        json.addProperty("last_paid", last_paid);
        json.addProperty("value", value);

        HttpResponse httpResponse = null;
        try {
            httpResponse = Request.post("https://app-bodyfit.herokuapp.com/bodybuilder/register", json);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        if(httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            try {
                String res = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("nao foi gravado" + res);
            } catch (Exception ex) {
                System.out.println("Erro na conversão para Json");
            }
            return null;

        } else {
            try {
                String res = EntityUtils.toString(httpResponse.getEntity());
                System.out.println("foi gravado" + res);
            } catch (Exception ex) {
                System.out.println("Erro na conversão para Json");
            }
            return "";
        }
    }
}
