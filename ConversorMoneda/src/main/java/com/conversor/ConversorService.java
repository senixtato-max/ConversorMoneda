package com.conversor;

import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorService {

    private static final String API_KEY = "19a7e866b5496e25c399d8a7";

    public double convertir(String base, String destino, double cantidad) throws Exception {
        String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + base;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        Gson gson = new Gson();
        ExchangeResponse data = gson.fromJson(response.body(), ExchangeResponse.class);

        double tasa = data.getConversion_rates().get(destino);
        return cantidad * tasa;
    }
}
