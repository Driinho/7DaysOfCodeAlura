package models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {

    private String apiKey;
    private String apiImdb;

    public ImdbApiClient(String apiKey) {
        this.apiKey = apiKey;
        this.apiImdb = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
    }

    public String getBody() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiImdb))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getApiImdb() {
        return apiImdb;
    }

    public void setApiImdb(String apiImdb) {
        this.apiImdb = apiImdb;
    }
}
