import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import models.Filme;
import models.ImdbApiClient;
import models.ParseJson;
import page.HTMLGenerator;

public class App {

    public static void main(String[] args) throws Exception {

        String apiKey = "k_5kqx9t0s";

        String json = new ImdbApiClient(apiKey).getBody();

        List<Filme> filmes = new ParseJson().parseJsonMovies(json);
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
}
