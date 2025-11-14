import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class ExchangeRateClient {

    // API KEY real
    private static final String API_KEY = "5c1557b42f2c24a0e163499e";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private final HttpClient client = HttpClient.newHttpClient();

    public double getRate(String from, String to) {
        String url = BASE_URL + API_KEY + "/latest/" + from;

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .GET()
                .build();

        try {
            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() != 200) {
                throw new RuntimeException("Error HTTP: " + response.statusCode());
            }

            JsonObject root = JsonParser
                    .parseString(response.body())
                    .getAsJsonObject();

            JsonObject rates = root.getAsJsonObject("conversion_rates");

            if (!rates.has(to)) {
                throw new RuntimeException("No encuentro la moneda destino: " + to);
            }

            return rates.get(to).getAsDouble();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Error consultando la API", e);
        }
    }
}
