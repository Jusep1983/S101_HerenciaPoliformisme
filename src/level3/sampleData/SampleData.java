package level3.sampleData;

import level3.model.*;
import level3.services.ManagementArticles;
import level3.services.ManagementEditors;

import java.util.Arrays;
import java.util.List;

public class SampleData {

    public static void loadInfo() {

        List<Editor> editors = Arrays.asList(
                new Editor("Jose", "11111111H"),
                new Editor("Rakel", "22222222J"),
                new Editor("Carlos", "33333333P"),
                new Editor("Marta", "44444444A")
        );

        List<FootballArticle> footballArticles = Arrays.asList(
                new FootballArticle("Hat-trick de Benzema al Barça", "Champions League", "Madrid", "Benzema"),
                new FootballArticle("Remontada histórica del Liverpool", "Premier League", "Liverpool", "Salah"),
                new FootballArticle("Mbappé brilla en la final", "Champions League", "París", "Mbappé")
        );

        List<BasketArticle> basketArticles = Arrays.asList(
                new BasketArticle("Madrid arrasa!", "ACB", "Madrid"),
                new BasketArticle("Golden State Warriors vuelven a ganar!", "NBA", "Golden State"),
                new BasketArticle("Histórica derrota del Barça", "Euroliga", "Barça")
        );

        List<TennisArticle> tennisArticles = Arrays.asList(
                new TennisArticle("Nadal campeón Open USA", "Open USA", "Nadal"),
                new TennisArticle("Djokovic suma otro Grand Slam", "Roland Garros", "Djokovic"),
                new TennisArticle("Alcaraz hace historia en Wimbledon", "Wimbledon", "Alcaraz")
        );

        List<FOneArticle> fOneArticles = Arrays.asList(
                new FOneArticle("Victoria Alonso!!!", "Aston Martin"),
                new FOneArticle("Hamilton gana en Silverstone", "Mercedes"),
                new FOneArticle("Verstappen campeón del mundo!", "Red Bull")
        );

        List<MotorcycleArticle> motorcycleArticles = Arrays.asList(
                new MotorcycleArticle("GP Catalunya", "Honda"),
                new MotorcycleArticle("Marquez domina en Jerez", "Honda"),
                new MotorcycleArticle("Bagnaia campeón de MotoGP", "Ducati")
        );

        // Assign articles to editors
        editors.get(0).getArticles().addAll(Arrays.asList(
                footballArticles.get(0), basketArticles.get(0), tennisArticles.get(0),
                fOneArticles.get(0), motorcycleArticles.get(0)
        ));

        editors.get(1).getArticles().addAll(Arrays.asList(
                footballArticles.get(1), basketArticles.get(1), tennisArticles.get(1),
                fOneArticles.get(1), motorcycleArticles.get(1)
        ));

        editors.get(2).getArticles().addAll(Arrays.asList(
                footballArticles.get(2), basketArticles.get(2), tennisArticles.get(2),
                fOneArticles.get(2), motorcycleArticles.get(2)
        ));

        editors.get(3).getArticles().addAll(Arrays.asList(
                footballArticles.get(0), basketArticles.get(0), tennisArticles.get(0),
                footballArticles.get(0), motorcycleArticles.get(0)
        ));

        // Add editors and articles to management lists
        ManagementEditors.editors.addAll(editors);
        ManagementArticles.articles.addAll(footballArticles);
        ManagementArticles.articles.addAll(basketArticles);
        ManagementArticles.articles.addAll(tennisArticles);
        ManagementArticles.articles.addAll(fOneArticles);
        ManagementArticles.articles.addAll(motorcycleArticles);
    }
}
