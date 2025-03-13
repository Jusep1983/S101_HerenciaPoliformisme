package Nivell3;

public class MotorcycleArticle extends Article {
    private String team;

    public MotorcycleArticle(String headline, String team) {
        super(headline);
        this.team = team;
        super.price = calculatePriceArticle();
        super.score = calculateScoreArticle();
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int calculatePriceArticle() {
        int price = 100;
        if (this.team.equalsIgnoreCase("Honda") ||
                this.team.equalsIgnoreCase("Yamaha")) {
            price += 50;
        }
        return price;
    }

    public int calculateScoreArticle() {
        int score = 3;
        if (this.team.equalsIgnoreCase("Honda") ||
                this.team.equalsIgnoreCase("Yamaha")) {
            score += 3;
        }
        return score;
    }

    @Override
    public String toString() {
        return "\n\tMotociclismo {" + super.toString() + ", Equipo: " + this.team +"}";
    }
}
