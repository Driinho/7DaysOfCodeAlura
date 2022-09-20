package models;

public class Filme {

    private String posRanking;
    private String titulo;
    private String url;
    private String nota;
    private String ano;

    public Filme(String posRanking, String titulo, String url, String nota, String ano) {
        this.posRanking = posRanking;
        this.titulo = titulo;
        this.url = url;
        this.nota = nota;
        this.ano = ano;
    }

    public String getPosRanking() {
        return posRanking;
    }

    public void setPosRanking(String posRanking) {
        this.posRanking = posRanking;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    @Override
    public String toString() {
        String str = "";
        str += "Ranking: " + posRanking;
        str += ", Título: " + titulo;
        str += ", Ano: " + ano;
        str += ", Nota: " + nota;

        return str;
    }
}
