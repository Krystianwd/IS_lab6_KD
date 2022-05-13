package com.lg;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            //Test działania lokalnego REST API
            String temp_url = "http://localhost/IS_lab6_rest/cities/read";
            URL url = new URL(temp_url);
            System.out.println("Wysyłanie zapytania...");
            InputStream is = url.openStream();
            System.out.println("Pobieranie odpowiedzi...");
            String source = new BufferedReader(new
                    InputStreamReader(is))
                    .lines().collect(Collectors.joining("\n"));
            System.out.println("Przetwarzanie danych...");
            JSONObject json = new JSONObject(source);
            JSONArray recieveddata = (JSONArray)
                    json.get("cities");
            recieveddata.forEach(item -> {
                System.out.println("City name: " + ((JSONObject)item).get("Name") + " CountryCode: "
                + ((JSONObject)item).get("CountryCode") + " District: " + ((JSONObject)item).get("District")
                + " Population: " + ((JSONObject)item).get("District"));
            });


        } catch (Exception e) {
            System.err.println("Wystąpił nieoczekiwany błąd!!! ");
            e.printStackTrace(System.err);
        }
    }
}
