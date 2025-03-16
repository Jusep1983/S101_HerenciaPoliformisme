package level3.services;

import java.util.ArrayList;

import level3.model.*;
import level3.util.KeyboardInputs;

import static level3.services.ManagementEditors.*;

public class ManagementArticles {

    public static ArrayList<Article> articles = new ArrayList<>();

    public static String showAllArticlesByType(int articleType) {
        String answer = "";
        switch (articleType) {
            case 1:
                answer = "Lista de noticias de fútbol: ";
                for (Article article : articles) {
                    if (article instanceof FootballArticle) {
                        answer += ("\n\t" + article.getHeadline());
                    }
                }
                break;
            case 2:
                answer = "Lista de noticias de básquet: ";
                for (Article article : articles) {
                    if (article instanceof BasketArticle) {
                        answer += "\n\t" + article.getHeadline();
                    }
                }
                break;
            case 3:
                answer = "Lista de noticias de tenis: ";
                for (Article article : articles) {
                    if (article instanceof TennisArticle) {
                        answer += "\n\t" + article.getHeadline();
                    }
                }
                break;
            case 4:
                answer = "Lista de noticias de fórmula 1: ";
                for (Article article : articles) {
                    if (article instanceof FOneArticle) {
                        answer += "\n\t" + article.getHeadline();
                    }
                }
                break;
            case 5:
                answer = "Lista de noticias de motociclisme: ";
                for (Article article : articles) {
                    if (article instanceof MotorcycleArticle) {
                        answer += "\n\t" + article.getHeadline();
                    }
                }
                break;
        }
        return answer;
    }

    public static String showAllArticlesByEditor() {
        String answer;
        String dniEditor = KeyboardInputs.readANonEmptyString(
                "Introduce el DNI del redactor a mostrar sus notícias: ");
        int indexEditor = findDniEditor(dniEditor);
        if (indexEditor != -1) {
            answer = "Lista de noticias de redactor " + dniEditor + " " + editors.get(indexEditor).getName();
            for (int i = 0; i < editors.get(indexEditor).getArticles().size(); i++) {
                answer += editors.get(indexEditor).getArticles().get(i);
            }
        } else {
            answer = "No existe un redactor con dni " + dniEditor;
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
        int index = -1, i = 0;
        boolean found = false;
        switch (articleType) {
            case 1:
                while (i < articles.size() && !found) {
                    if (articles.get(i) instanceof FootballArticle) {
                        if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                            index = i;
                            found = true;
                        }
                    }
                    i++;
                }
                break;
            case 2:
                while (i < articles.size() && !found) {
                    if (articles.get(i) instanceof BasketArticle) {
                        if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                            index = i;
                            found = true;
                        }
                    }
                    i++;
                }
                break;
            case 3:
                while (i < articles.size() && !found) {
                    if (articles.get(i) instanceof TennisArticle) {
                        if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                            index = i;
                            found = true;
                        }
                    }
                    i++;
                }
                break;
            case 4:
                while (i < articles.size() && !found) {
                    if (articles.get(i) instanceof FOneArticle) {
                        if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                            index = i;
                            found = true;
                        }
                    }
                    i++;
                }
                break;
            case 5:
                while (i < articles.size() && !found) {
                    if (articles.get(i) instanceof MotorcycleArticle) {
                        if (articles.get(i).getHeadline().equalsIgnoreCase(value)) {
                            index = i;
                            found = true;
                        }
                    }
                    i++;
                }
                break;
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
        if (indexHeadline != -1) {
            answer = "La puntuación de la noticia \"" + headline + "\" és de "
                     + articles.get(indexHeadline).getScore() + " puntos";
        } else {
            answer = "No existe ninguna noticia con titular: \"" + headline + "\"";
        }
        return answer;
    }

    public static String calculatePriceOfArticle() {
        String answer;
        String headline = KeyboardInputs.readANonEmptyString("Introduce el titular de la noticia: ");
        int indexHeadline = findArticleHeadline(headline);
        if (indexHeadline != -1) {
            answer = "El precio de la noticia \"" + headline + "\" és de "
                     + articles.get(indexHeadline).getPrice() + "€";
        } else {
            answer = "No existe ninguna noticia con titular: \"" + headline + "\"";
        }
        return answer;
    }

    public static void printAllEditorsAndArticles() {
        System.out.println("Redactores registrados: \n" + ManagementEditors.editors + "\n");
        System.out.println("Notícias registradas: \n" + articles + "\n");
    }

}
