package level3.model;

public class FOneArticle extends Article {
    private String team;

    public FOneArticle(String headline, String team) {
        super(headline);
        this.team = team;
        super.price = calculatePriceArticle();
        super.score = calculateScoreArticle();
    }

    public int calculatePriceArticle() {
        int price = 100;
        if (this.team.equalsIgnoreCase("Ferrari") ||
            this.team.equalsIgnoreCase("Mercedes")) {
            price += 50;
        }
        return price;
    }

    public int calculateScoreArticle() {
        int score = 4;
        if (this.team.equalsIgnoreCase("Ferrari") ||
            this.team.equalsIgnoreCase("Mercedes")) {
            score += 2;
        }
        return score;
    }

    @Override
    public String toString() {
        return "\n\tFórmula 1 {" + super.toString() + ", Escudería: " + this.team + "}";
    }
}
