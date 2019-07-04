package com.bodyfit.dao;

import com.bodyfit.dto.WorkoutDTO;
import com.bodyfit.helper.Request;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;

public class DashboardDAO {

    public String getWorkout(Integer id) {
        JsonObject json = new JsonObject();
        json.addProperty("id_bodybuilder", id);

        HttpResponse httpResponse = null;

        try {
            httpResponse = Request.post("https://app-bodyfit.herokuapp.com/workout/get", json);
        } catch (Exception ex) {
            System.out.println("Erro na requisição: " + ex);
        }

        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            System.out.println("Erro ao recuperar workout");
            return null;
        } else {
            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create();
            String res = "";

            try {
                res = EntityUtils.toString(httpResponse.getEntity());
            } catch (Exception ex) {
                System.out.println("Erro na conversão para json");
            }
            WorkoutDTO workoutDTO = gson.fromJson(res, WorkoutDTO.class);

            System.out.println(res);
            System.out.println(workoutDTO);
            return null;
        }
    }
}
