package level3.model;

public class BasketArticle extends Article {
    private String competition;
    private String club;

    public BasketArticle(String headline, String competition, String club) {
        super(headline);
        this.competition = competition;
        this.club = club;
        super.price = calculatePriceArticle();
        super.score = calculateScoreArticle();
    }

    public int calculatePriceArticle() {
        int price = 250;
        if (this.competition.equalsIgnoreCase("Eurolliga")) {
            price += 75;
        }
        if (this.club.equalsIgnoreCase("Barça") ||
                this.club.equalsIgnoreCase("Madrid")) {
            price += 75;
        }
        return price;
    }

    public int calculateScoreArticle() {
        int score = 4;
        if (this.competition.equalsIgnoreCase("Euroliga")) {
            score += 3;
        } else if (this.competition.equalsIgnoreCase("ACB")) {
            score += 2;
        }
        if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
            score += 1;
        }
        return score;
    }

    @Override
    public String toString() {

        return "\n\tBásquet {" + super.toString()
                + ", Competición: " + this.competition + ", Club: " + this.club +  "}";
    }
}
