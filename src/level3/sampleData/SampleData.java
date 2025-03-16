package level3.sampleData;

import level3.model.*;
import level3.services.ManagementArticles;
import level3.services.ManagementEditors;

import static level3.services.ManagementArticles.*;

public class SampleData {

    public static void loadInfo() {
        Editor editor1 = new Editor("Jose", "11111111H");
        Editor editor2 = new Editor("Rakel", "22222222J");
        Editor editor3 = new Editor("Carlos", "33333333P");
        Editor editor4 = new Editor("Marta", "44444444A");
        FootballArticle footballArticle1 = new FootballArticle("Hat-trick de Benzema al Barça",
                "Champions League", "Madrid", "Benzema");
        FootballArticle footballArticle2 = new FootballArticle("Remontada histórica del Liverpool",
                "Premier League", "Liverpool", "Salah");
        FootballArticle footballArticle3 = new FootballArticle("Mbappé brilla en la final",
                "Champions League", "París", "Mbappé");
        BasketArticle basketArticle1 = new BasketArticle("Madrid arrasa!", "ACB", "Madrid");
        BasketArticle basketArticle2 = new BasketArticle("Golden State Warriors vuelven a ganar!",
                "NBA", "Golden State");
        BasketArticle basketArticle3 = new BasketArticle("Histórica derrota del Barça",
                "Euroliga", "Barça");
        TennisArticle tennisArticle1 = new TennisArticle("Nadal campeón Open USA",
                "Open USA", "Nadal");
        TennisArticle tennisArticle2 = new TennisArticle("Djokovic suma otro Grand Slam",
                "Roland Garros", "Djokovic");
        TennisArticle tennisArticle3 = new TennisArticle("Alcaraz hace história en Wimbledon",
                "Wimbledon", "Alcaraz");
        FOneArticle fOneArticle1 = new FOneArticle("Victoria Alonso!!!", "Aston Matrin");
        FOneArticle fOneArticle2 = new FOneArticle("Hamilton gana en Silverstone", "Mercedes");
        FOneArticle fOneArticle3 = new FOneArticle("Verstappen campeón del mundo!", "Red Bull");
        MotorcycleArticle motorcycleArticle1 = new MotorcycleArticle("GP Catalunya", "Honda");
        MotorcycleArticle motorcycleArticle2 = new MotorcycleArticle("Marquez domina en Jerez",
                "Honda");
        MotorcycleArticle motorcycleArticle3 = new MotorcycleArticle("Bagnaia campeón de  MotoGP",
                "Ducati");
        editor1.getArticles().add(footballArticle1);
        editor1.getArticles().add(basketArticle1);
        editor1.getArticles().add(tennisArticle1);
        editor1.getArticles().add(fOneArticle1);
        editor1.getArticles().add(motorcycleArticle1);
        editor2.getArticles().add(footballArticle2);
        editor2.getArticles().add(basketArticle2);
        editor2.getArticles().add(tennisArticle2);
        editor2.getArticles().add(fOneArticle2);
        editor2.getArticles().add(motorcycleArticle2);
        editor3.getArticles().add(footballArticle3);
        editor3.getArticles().add(basketArticle3);
        editor3.getArticles().add(tennisArticle3);
        editor3.getArticles().add(fOneArticle3);
        editor3.getArticles().add(motorcycleArticle3);
        editor4.getArticles().add(footballArticle1);
        editor4.getArticles().add(basketArticle1);
        editor4.getArticles().add(tennisArticle1);
        editor4.getArticles().add(footballArticle1);
        editor4.getArticles().add(motorcycleArticle1);
        ManagementEditors.editors.add(editor1);
        ManagementEditors.editors.add(editor2);
        ManagementEditors.editors.add(editor3);
        ManagementEditors.editors.add(editor4);
        ManagementArticles.articles.add(footballArticle1);
        articles.add(footballArticle2);
        articles.add(footballArticle3);
        articles.add(basketArticle1);
        articles.add(basketArticle2);
        articles.add(basketArticle3);
        articles.add(tennisArticle1);
        articles.add(tennisArticle2);
        articles.add(tennisArticle3);
        articles.add(fOneArticle1);
        articles.add(fOneArticle2);
        articles.add(fOneArticle3);
        articles.add(motorcycleArticle1);
        articles.add(motorcycleArticle2);
        articles.add(motorcycleArticle3);
    }
}
