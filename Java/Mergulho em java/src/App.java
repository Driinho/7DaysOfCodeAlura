import java.io.File;
import java.io.PrintWriter;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import models.Filme;
import page.HTMLGenerator;

public class App {

    public static void main(String[] args) throws Exception {

        String apiKey = "k_5kqx9t0s";
        String apiIMDB = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(apiIMDB))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        String[] moviesArray = parseJsonMovies(json);

        // List<String> titles = parseTitles(moviesArray);
        // titles.forEach(System.out::println);

        // List<String> urlImages = parseUrlImages(moviesArray);
        // urlImages.forEach(System.out::println);

        // List<String> notas = parseNotas(moviesArray);
        // notas.forEach(System.out::println);

        // List<String> anos = parseAnos(moviesArray);
        // anos.forEach(System.out::println);

        List<Filme> filmes = new ArrayList<Filme>();
        for (int i = 0; i < parseTitles(moviesArray).size(); i++) {
            filmes.add(new Filme(parseRanking(moviesArray).get(i), parseTitles(moviesArray).get(i),
                    parseUrlImages(moviesArray).get(i),
                    parseNotas(moviesArray).get(i), parseAnos(moviesArray).get(i)));
        }

        File pagina = new File("src/page/Teste.html");
        PrintWriter printWriter = new PrintWriter(pagina);
        HTMLGenerator htmlGenerator = new HTMLGenerator(printWriter);

        printWriter.println(htmlGenerator.headGenerator());
        printWriter.println(htmlGenerator.navBarGenerator());
        printWriter.println(htmlGenerator.carrosselGenerator());

        for (int i = 0; i < filmes.size(); i++) {
            htmlGenerator.generator(filmes.get(i));
        }

        printWriter.close();
    }

    private static String[] parseJsonMovies(String json) {
        Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("no match in " + json);
        }

        String[] moviesArray = matcher.group(1).split("\\},\\{");
        moviesArray[0] = moviesArray[0].substring(1);
        int last = moviesArray.length - 1;
        String lastString = moviesArray[last];
        moviesArray[last] = lastString.substring(0, lastString.length() - 1);
        return moviesArray;
    }

    private static List<String> parseRanking(String[] moviesArray) {
        return parseAttribute(moviesArray, 1);
    }

    private static List<String> parseTitles(String[] moviesArray) {
        return parseAttribute(moviesArray, 3);
    }

    private static List<String> parseUrlImages(String[] moviesArray) {
        return parseAttribute(moviesArray, 5);
    }

    private static List<String> parseNotas(String[] moviesArray) {
        return parseAttribute(moviesArray, 7);
    }

    private static List<String> parseAnos(String[] moviesArray) {
        return parseAttribute(moviesArray, 4);
    }

    private static List<String> parseAttribute(String[] moviesArray, int pos) {
        return Stream.of(moviesArray)
                .map(e -> e.split("\",\"")[pos])
                .map(e -> e.split(":\"")[1])
                .map(e -> e.replaceAll("\"", ""))
                .collect(Collectors.toList());
    }

}
