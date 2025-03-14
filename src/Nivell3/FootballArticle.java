package Nivell3;

//import java.util.ArrayList;

public class FootballArticle extends Article {
    private String competition = "";
    private String club;
    private String player;

    public FootballArticle(String headline, String competition, String club, String player) {
        super(headline);
        this.competition = competition;
        this.club = club;
        this.player = player;
        super.price = calculatePriceArticle();
        super.score = calculateScoreArticle();
    }

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int calculatePriceArticle() {
        int price = 300;
        if (this.competition.equalsIgnoreCase("Champions league")) {
            price += 100;
        }
        if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
            price += 100;
        }
        if (this.player.equalsIgnoreCase("Ferran Torres") ||
                this.player.equalsIgnoreCase("Benzema")) {
            price += 50;
        }
        return price;
    }

    public int calculateScoreArticle() {
        int score = 5;
        if (this.competition.equalsIgnoreCase("Lliga de Campions")) {
            score += 3;
        } else if (this.competition.equalsIgnoreCase("Lliga")) {
            score += 2;
        }
        if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
            score += 1;
        }
        if (this.player.equalsIgnoreCase("Ferran Torres") ||
                this.player.equalsIgnoreCase("Benzema")) {
            score += 1;
        }
        return score;
    }

    @Override
    public String toString() {
        return "\n\tFútbol {" + super.toString()
                + ", Competición: " + this.competition + ", Club: " + this.club + ", Jugador: "
                + this.player + "}";
    }
}

