package Nivell3;

public abstract class Article {
    protected String headline;
    protected String text;
    protected int score;
    protected int price;

    public Article(String headline) {
        this.headline = headline;
        this.text = "";
    }

    public String getHeadline() {
        return headline;
    }

    public String getText() {
        return text;
    }

    public int getScore() {
        return score;
    }

    public int getPrice() {
        return price;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setText(String text) {
        this.text = text;
    }

    public abstract int calculatePriceArticle();

    public abstract int calculateScoreArticle();

    @Override
    public String toString() {
        return "Titular: " + this.headline + ", Texto: " + this.text
                + ", Puntación: " + this.calculateScoreArticle() + ", Precio: " + this.calculatePriceArticle() + "€";
    }

}
