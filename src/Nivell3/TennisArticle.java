package Nivell3;

public class TennisArticle extends Article {
    private String competition;
    private String tenista;

    public TennisArticle(String headline, String competition, String tenista) {
        super(headline);
        this.competition = competition;
        this.tenista = tenista;
        super.price = calculatePriceArticle();
        super.score = calculateScoreArticle();
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getTenista() {
        return tenista;
    }

    public void setTenista(String tenista) {
        this.tenista = tenista;
    }

    public int calculatePriceArticle() {
        int price = 150;
        if (this.tenista.equalsIgnoreCase("Federer") ||
                this.tenista.equalsIgnoreCase("Nadal") ||
                this.tenista.equalsIgnoreCase("Djokovic")) {
            price += 100;
        }
        return price;
    }

    public int calculateScoreArticle() {
        int score = 4;
        if (this.tenista.equalsIgnoreCase("Federer") ||
                this.tenista.equalsIgnoreCase("Nadal") ||
                this.tenista.equalsIgnoreCase("Djokovic")) {
            score += 3;
        }
        return score;
    }

    @Override
    public String toString() {
        return "\n\tTenis {" + super.toString()
                + ", Competición: " + this.competition + ", Tenista: " + this.tenista;
    }
}
