package models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParseJson {

    public List<Filme> parseJsonMovies(String json) {
        Matcher matcher = Pattern.compile(".*\\[(.*)\\].*").matcher(json);

        if (!matcher.matches()) {
            throw new IllegalArgumentException("no match in " + json);
        }

        String[] moviesArray = matcher.group(1).split("\\},\\{");
        moviesArray[0] = moviesArray[0].substring(1);
        int last = moviesArray.length - 1;
        String lastString = moviesArray[last];
        moviesArray[last] = lastString.substring(0, lastString.length() - 1);

        List<Filme> filmes = new ArrayList<Filme>();
        for (int i = 0; i < parseTitles(moviesArray).size(); i++) {
            filmes.add(new Filme(parseRanking(moviesArray).get(i), parseTitles(moviesArray).get(i),
                    parseUrlImages(moviesArray).get(i),
                    parseNotas(moviesArray).get(i), parseAnos(moviesArray).get(i)));
        }

        return filmes;
    }

    private List<String> parseRanking(String[] moviesArray) {
        return parseAttribute(moviesArray, 1);
    }

    private List<String> parseTitles(String[] moviesArray) {
        return parseAttribute(moviesArray, 3);
    }

    private List<String> parseUrlImages(String[] moviesArray) {
        return parseAttribute(moviesArray, 5);
    }

    private List<String> parseNotas(String[] moviesArray) {
        return parseAttribute(moviesArray, 7);
    }

    private List<String> parseAnos(String[] moviesArray) {
        return parseAttribute(moviesArray, 4);
    }

    private List<String> parseAttribute(String[] moviesArray, int pos) {
        return Stream.of(moviesArray)
                .map(e -> e.split("\",\"")[pos])
                .map(e -> e.split(":\"")[1])
                .map(e -> e.replaceAll("\"", ""))
                .collect(Collectors.toList());
    }
}
