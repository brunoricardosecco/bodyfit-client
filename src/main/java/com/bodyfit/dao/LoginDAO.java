package com.bodyfit.dao;

import com.bodyfit.dto.LoginDto;
import com.bodyfit.helper.Request;
import com.bodyfit.model.Bodybuilder;
import com.bodyfit.model.Instructor;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javafx.scene.control.Alert;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

public class LoginDAO {

    public Bodybuilder login (String id) {
        JsonObject json = new JsonObject();
        json.addProperty("code", id);
        HttpResponse httpResponse = null;
        try {
            httpResponse = Request.post("https://app-bodyfit.herokuapp.com/bodybuilder/login", json);
        } catch (Exception err) {
            System.out.println("Erro");
        }

        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao logar");
            alert.setHeaderText("Ocorreu um erro ao tentar logar!");
            alert.setContentText("Verifique o código e tente novamente!");
            alert.showAndWait();

            return null;
        } else {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();

            String res = "";
            try {
                res = EntityUtils.toString(httpResponse.getEntity());
            } catch (Exception exception) {
                System.out.println("Erro na conversão de json");
            }

            LoginDto loginDto = gson.fromJson(res, LoginDto.class);
            return loginDto.getBodybuilder();
        }
    }
}
