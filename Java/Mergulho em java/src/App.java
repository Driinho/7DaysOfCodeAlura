import java.io.File;
import java.io.PrintWriter;
import java.util.List;

import models.Filme;
import models.ImdbApiClient;
import models.ParseJson;
import page.HTMLGenerator;

public class App {

    public static void main(String[] args) throws Exception {

        String apiKeyImdb = "k_5kqx9t0s";
        String apiKeyMarvel = "4e37d9cbc7e9e317d5bfc25d030e3b6f";

        String json = new ImdbApiClient(apiKeyMarvel).getBody();

        System.out.println(json);
        // List<Filme> filmes = new ParseJson().parseJsonMovies(json);

        // File pagina = new File("src/page/Teste.html");
        // PrintWriter printWriter = new PrintWriter(pagina);
        // HTMLGenerator htmlGenerator = new HTMLGenerator(printWriter);

        // printWriter.println(htmlGenerator.headGenerator());
        // printWriter.println(htmlGenerator.navBarGenerator());
        // // printWriter.println(htmlGenerator.carrosselGenerator());

        // htmlGenerator.generator(filmes);

        // printWriter.close();
    }
}
