package page;

import java.io.PrintWriter;
import java.util.List;

import models.Filme;

public class HTMLGenerator {

    private PrintWriter printWriter;

    public HTMLGenerator(PrintWriter printWriter) {
        this.printWriter = printWriter;
    }

    public String headGenerator() {
        String head = """
                <head>
                    <meta charset=\"utf-8\">
                    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                    <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\"
                        crossorigin=\"anonymous\">
                </head>
                """;
        // <script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\"
        // integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\"
        // crossorigin=\"anonymous\"
        // ></script>
        // <script
        // src=\"https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js\"
        // integrity=\"sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49\"
        // crossorigin=\"anonymous\"
        // ></script>
        // <script
        // src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js\"
        // integrity=\"sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy\"
        // crossorigin=\"anonymous\"
        // ></script>
        return head;
    }

    public String navBarGenerator() {
        String navbar = """
                  <nav class="navbar navbar-expand-lg navbar-light bg-light">
                  <a class="navbar-brand" href="#">Navbar</a>
                  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                  </button>

                  <div class="collapse navbar-collapse" id="navbarSupportedContent">
                      <ul class="navbar-nav mr-auto">
                      <li class="nav-item active">
                          <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link" href="#">Link</a>
                      </li>
                      <li class="nav-item dropdown">
                          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                          Dropdown
                          </a>
                          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                          <a class="dropdown-item" href="#">Action</a>
                          <a class="dropdown-item" href="#">Another action</a>
                          <div class="dropdown-divider"></div>
                          <a class="dropdown-item" href="#">Something else here</a>
                          </div>
                      </li>
                      <li class="nav-item">
                          <a class="nav-link disabled" href="#">Disabled</a>
                      </li>
                      </ul>
                      <form class="form-inline my-2 my-lg-0">
                      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
                      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                      </form>
                  </div>
                  </nav>
                """;
        return navbar;
    }

    // public String carrosselGenerator() {
    // String carrossel = """
    // <div id="carouselExampleControls" class="carousel slide w-50"
    // data-ride="carousel">
    // <div class="carousel-inner">
    // <div class="carousel-item active">
    // <img class="d-block w-100"
    // src=\"https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX128_CR0,12,128,176_AL_.jpg"
    // alt="First slide\">
    // </div>
    // <div class="carousel-item">
    // <img class="d-block w-100"
    // src=\"https://m.media-amazon.com/images/M/MV5BM2MyNjYxNmUtYTAwNi00MTYxLWJmNWYtYzZlODY3ZTk3OTFlXkEyXkFqcGdeQXVyNzkwMjQ5NzM@._V1_UX128_CR0,12,128,176_AL_.jpg"
    // alt="Second slide\">
    // </div>
    // <div class="carousel-item">
    // <img class="d-block w-100"
    // src=\"https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX128_CR0,12,128,176_AL_.jpg"
    // alt="Third slide\">
    // </div>
    // </div>
    // <a class="carousel-control-prev" href="#carouselExampleControls"
    // role="button" data-slide="prev">
    // <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    // <span class="sr-only">Previous</span>
    // </a>
    // <a class="carousel-control-next" href="#carouselExampleControls"
    // role="button" data-slide="next">
    // <span class="carousel-control-next-icon" aria-hidden="true"></span>
    // <span class="sr-only">Next</span>
    // </a>
    // </div>
    // """;
    // return carrossel;
    // }

    public String generator(List<Filme> filmes) {
        String divTemplate = "";
        for (int i = 0; i < filmes.size(); i++) {
            divTemplate = """
                    <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
                        <h4 class=\"card-header\">%s</h4>
                        <div class=\"card-body\">
                            <img class=\"card-img\" src=\"%s\" alt=\"%s\">
                            <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                        </div>
                    </div>
                    """;

            // usando o template com os dados do filme
            printWriter.println(
                    String.format(divTemplate, filmes.get(i).getTitulo(), filmes.get(i).getUrl(),
                            filmes.get(i).getTitulo(), filmes.get(i).getNota(),
                            filmes.get(i).getAno()));
        }

        return divTemplate;
    }

}
