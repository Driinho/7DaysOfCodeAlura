package models;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ImdbApiClient {

    private String apiKey;
    private String apiImdb;
    private String apiMarvel;

    public ImdbApiClient(String apiKey) {
        this.apiKey = apiKey;
        // this.apiImdb = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
        this.apiMarvel = "https://gateway.marvel.com/v1/public/stories?ts=1663863768&apikey=4e37d9cbc7e9e317d5bfc25d030e3b6f&hash=317cd121a9fbf8fb33437d9481ad4455";
        // this.apiMarvel =
        // "http://gateway.marvel.com/v1/public/comics?ts=1&apikey=1234&hash=ffd275c5130566a2916217b101f26150";
    }

    public String getBody() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiMarvel))
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
