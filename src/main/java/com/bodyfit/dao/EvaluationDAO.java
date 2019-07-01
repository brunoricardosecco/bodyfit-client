package com.bodyfit.dao;

import com.bodyfit.dto.LoginDto;
import com.bodyfit.helper.Request;
import com.bodyfit.model.Evaluation;
import com.bodyfit.model.Instructor;
import com.cedarsoftware.util.ArrayUtilities;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import javafx.scene.control.Alert;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

public class EvaluationDAO {
    public ArrayList getEvaluations() {
        JsonObject json = new JsonObject();
        HttpResponse httpResponse = null;
        try {
            httpResponse = Request.get("https://app-bodyfit.herokuapp.com/evaluation/getAll");
        } catch (Exception err) {
            System.out.println("Erro");
        }

        System.out.println(httpResponse);

        if (httpResponse.getStatusLine().getStatusCode() != HttpStatus.SC_OK) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Erro ao consultar avaliaçoes");
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

            JSONObject jsonObject = new JSONObject(res);

            JSONArray jsonArray = jsonObject.getJSONArray("evaluations");

            ArrayList<Evaluation> evaluations = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject o = jsonArray.getJSONObject(i);
                Integer id = o.getInt("id");
                String date_time = o.getString("date_time");
                Integer id_bodybuilder = o.getInt("id_bodybuilder");
                String name = o.getString("name");

                Evaluation e = new Evaluation(id, date_time, id_bodybuilder, name);
                evaluations.add(e);
            }

            return evaluations;
        }
    }
}
