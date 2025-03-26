package level3.services;

import java.util.ArrayList;

import level3.model.*;
import level3.util.KeyboardInputs;

import static level3.services.ManagementEditors.*;

public class ManagementArticles {

    public static ArrayList<Article> articles = new ArrayList<>();

    public static String showAllArticlesByType(int articleType) {
        String answer = switch (articleType) {
            case 1 -> showFootballArticlesByType();
            case 2 -> showBasketArticlesByType();
            case 3 -> showTennisArticlesByType();
            case 4 -> showF1ArticlesByType();
            case 5 -> showMotorcyclingByType();
            default -> "";
        };
        return answer;
    }

    private static String showFootballArticlesByType() {
        String answer = "Lista de noticias de fútbol: ";
        for (Article article : articles) {
            if (article instanceof FootballArticle) {
                answer += ("\n\t" + article.getHeadline());
            }
        }
        return answer;
    }

    private static String showBasketArticlesByType() {
        String answer = "Lista de noticias de básquet: ";
        for (Article article : articles) {
            if (article instanceof BasketArticle) {
                answer += "\n\t" + article.getHeadline();
            }
        }
        return answer;
    }

    private static String showTennisArticlesByType() {
        String answer = "Lista de noticias de tenis: ";
        for (Article article : articles) {
            if (article instanceof TennisArticle) {
                answer += "\n\t" + article.getHeadline();
            }
        }
        return answer;
    }

    private static String showF1ArticlesByType() {
        String answer = "Lista de noticias de fórmula 1: ";
        for (Article article : articles) {
            if (article instanceof FOneArticle) {
                answer += "\n\t" + article.getHeadline();
            }
        }
        return answer;
    }

    private static String showMotorcyclingByType() {
        String answer = "Lista de noticias de motociclisme: ";
        for (Article article : articles) {
            if (article instanceof MotorcycleArticle) {
                answer += "\n\t" + article.getHeadline();
            }
        }
        return answer;
    }

    public static String showAllArticlesByEditor() {
        String answer;
        String dniEditor = KeyboardInputs.readANonEmptyString(
                "Introduce el DNI del redactor a mostrar sus notícias: ");
        int indexEditor = findDniEditor(dniEditor);
        if (indexEditor == -1) {
            answer = "No existe un redactor con dni " + dniEditor;
        } else {
            answer = "Lista de noticias de redactor " + dniEditor + " " + editors.get(indexEditor).getName();
            for (int i = 0; i < editors.get(indexEditor).getArticles().size(); i++) {
                answer += editors.get(indexEditor).getArticles().get(i);
            }
        }
        return answer;
    }

    public static int findArticleHeadline(String value) {
        int index = -1, i = 0;
        boolean found = false;
        while (i < articles.size() && !found) {
            if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    public static int findHeadlineByTypeArticle(String value, int articleType) {
        int index = -1;
        index = switch (articleType) {
            case 1 -> findFootballHeadLine(value);
            case 2 -> findBasketHeadLine(value);
            case 3 -> findTennisHeadLine(value);
            case 4 -> findFOneHeadLine(value);
            case 5 -> findMotorcyclingHeadLine(value);
            default -> index;
        };
        return index;
    }

    private static int findFootballHeadLine(String value) {
        int index = -1, i = 0;
        boolean found = false;
        while (i < articles.size() && !found) {
            if (articles.get(i) instanceof FootballArticle) {
                if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                    index = i;
                    found = true;
                }
            }
            i++;
        }
        return index;
    }

    private static int findBasketHeadLine(String value) {
        int index = -1, i = 0;
        boolean found = false;
        while (i < articles.size() && !found) {
            if (articles.get(i) instanceof BasketArticle) {
                if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                    index = i;
                    found = true;
                }
            }
            i++;
        }
        return index;
    }

    private static int findTennisHeadLine(String value) {
        int index = -1, i = 0;
        boolean found = false;
        while (i < articles.size() && !found) {
            if (articles.get(i) instanceof TennisArticle) {
                if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                    index = i;
                    found = true;
                }
            }
            i++;
        }
        return index;
    }

    private static int findFOneHeadLine(String value) {
        int index = -1, i = 0;
        boolean found = false;
        while (i < articles.size() && !found) {
            if (articles.get(i) instanceof FOneArticle) {
                if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                    index = i;
                    found = true;
                }
            }
            i++;
        }
        return index;
    }

    private static int findMotorcyclingHeadLine(String value) {
        int index = -1, i = 0;
        boolean found = false;
        while (i < articles.size() && !found) {
            if (articles.get(i) instanceof MotorcycleArticle) {
                if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                    index = i;
                    found = true;
                }
            }
            i++;
        }
        return index;
    }

    public static void showAllHeadlines() {
        System.out.println("Lista de noticias: ");
        for (Article article : articles) {
            System.out.println("\t" + article.getHeadline());
        }
    }

    public static String calculatePointsByArticle() {
        String answer;
        String headline = KeyboardInputs.readANonEmptyString(
                "Introduce el titular de la noticia a la que calcular puntuación: "
        );
        int indexHeadline = findArticleHeadline(headline);
        if (indexHeadline == -1) {
            answer = "No existe ninguna noticia con titular: \"" + headline + "\"";
        } else {
            answer = "La puntuación de la noticia \"" + headline + "\" és de "
                     + articles.get(indexHeadline).getScore() + " puntos";
        }
        return answer;
    }

    public static String calculatePriceOfArticle() {
        String answer;
        String headline = KeyboardInputs.readANonEmptyString("Introduce el titular de la noticia: ");
        int indexHeadline = findArticleHeadline(headline);
        if (indexHeadline == -1) {
            answer = "No existe ninguna noticia con titular: \"" + headline + "\"";
        } else {
            answer = "El precio de la noticia \"" + headline + "\" és de "
                     + articles.get(indexHeadline).getPrice() + "€";
        }
        return answer;
    }

    public static void printAllEditorsAndArticles() {
        System.out.println("Redactores registrados: \n" + ManagementEditors.editors + "\n");
        System.out.println("Notícias registradas: \n" + articles + "\n");
    }

}
