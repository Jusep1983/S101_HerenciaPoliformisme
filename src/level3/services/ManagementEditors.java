package level3.services;

import java.util.ArrayList;

import level3.model.*;
import level3.util.KeyboardInputs;

import static level3.services.ManagementArticles.*;

public class ManagementEditors {
    public static ArrayList<Editor> editors = new ArrayList<>();

    public static int findDniEditor(String value) {
        int index = -1, i = 0;
        boolean found = false;
        while (i < editors.size() && !found) {
            if (editors.get(i).getDni().equalsIgnoreCase(value)) {
                index = i;
                found = true;
            }
            i++;
        }
        return index;
    }

    public static String createEditor() {
        String dniEditor = KeyboardInputs.readFormatDNI2("Introduce el DNI de redactor a crear: ");
        int indexEditor = findDniEditor(dniEditor);
        String answer;
        if (indexEditor == -1) {
            String nameEditor = KeyboardInputs.readANonEmptyString("Introduce el nombre de redactor a crear: ");
            answer = addEditor(nameEditor, dniEditor);
        } else {
            answer = "Ya existe un redactor con dni " + dniEditor;
        }
        return answer;
    }

    public static String addEditor(String name, String dni) {
        String answer;
        Editor editor = new Editor(name, dni);
        editors.add(editor);
        answer = "Redactor amb DNI " + dni + " creado con éxito";
        return answer;
    }

    public static void showAllEditors() {
        System.out.println("Lista de redactores: ");
        for (Editor editor : editors) {
            System.out.println("\t" + editor.getDni() + " " + editor.getName());
        }
    }

    public static String checkIfEditorExists() {
        String dniEditor = KeyboardInputs.readANonEmptyString("Introduce el DNI de redactor a eliminar: ");
        int indexEditor = findDniEditor(dniEditor);
        String answer;
        if (indexEditor != -1) {
            answer = removeEditor(indexEditor);
        } else {
            answer = "No existe ningún redactor con dni " + dniEditor;
        }
        return answer;
    }

    public static String removeEditor(int index) {
        String answer;
        answer = "Editor con DNI " + editors.get(index).getDni() + " eliminado con éxito";
        editors.remove(index);
        return answer;
    }

    public static String addArticleToEditor(int articleType) {
        String dniEditor, answer, headline, articleTypeStr = "";
        int indexArticle, indexEditor;
        headline = KeyboardInputs.readANonEmptyString("Introduce el titular de la noticia a asignar: ");
        indexArticle = findHeadlineByTypeArticle(headline, articleType);
        if (indexArticle != -1) {
            showAllEditors();
            dniEditor = KeyboardInputs.readANonEmptyString(
                    "Introduce el dni del redactor a asignarle la notícia: ");
            indexEditor = findDniEditor(dniEditor);
            if (indexEditor != -1) {
                editors.get(indexEditor).getArticles().add(articles.get(indexArticle));
                answer = "Al redactor con DNI " + editors.get(indexEditor).getDni()
                         + " se le ha asignado la noticia " + " \"" + headline + " \"";
            } else {
                answer = "No existe ningún redactor con DNI " + dniEditor;
            }
        } else {
            articleTypeStr = switch (articleType) {
                case 1 -> "de fútbol";
                case 2 -> "de básquet";
                case 3 -> "de tenis";
                case 4 -> "de fórmula 1";
                case 5 -> "de motociclismo";
                default -> articleTypeStr;
            };
            answer = "No existe ninguna noticia " + articleTypeStr + " con titular \"" + headline + "\"";
        }
        return answer;
    }

    public static int findHeadlineOnEditor(String headline, int indexEditor) {
        int indexHeadline = -1, i = 0;
        boolean found = false;
        while (i < editors.size() && !found) {
            if (editors.get(indexEditor).getArticles().get(i).getHeadline().equalsIgnoreCase(headline)) {
                indexHeadline = i;
                found = true;
            }
            i++;
        }
        return indexHeadline;
    }

    public static String removeArticleToEditor() {
        String answer;
        String dniEditor = KeyboardInputs.readANonEmptyString(
                "Introduce el DNI del redactor a eliminarle notícia: ");
        int indexEditor = findDniEditor(dniEditor);
        if (indexEditor != -1) {
            System.out.println("Lista de noticias del redactor " + dniEditor + " "
                               + editors.get(indexEditor).getName() + ":");
            for (int i = 0; i < editors.get(indexEditor).getArticles().size(); i++) {
                System.out.println("\t" + editors.get(indexEditor).getArticles().get(i).getHeadline());
            }
            String headline = KeyboardInputs.readANonEmptyString("Introduce el titular de la noticia a eliminar: ");
            int indexHeadline = findHeadlineOnEditor(headline, indexEditor);
            if (indexHeadline != -1) {
                answer = "Al redactor " + dniEditor + " " + editors.get(indexEditor).getName()
                         + " se le ha eliminado la noticia con titular " + "\"" + headline + "\"";
                editors.get(indexEditor).getArticles().remove(indexHeadline);
            } else {
                answer = "El redactor " + dniEditor + " " + editors.get(indexEditor).getName()
                         + " no tiene asignada ninguna noticia con titular " + "\"" + headline + "\"";
            }
        } else {
            answer = "No existe un redactor con dni " + dniEditor;
        }
        return answer;
    }

    public static void assignArticleToEditor() {
        String answerSubMenu = "";
        boolean subMenuExit = false;
        int articleType;
        do {
            switch (KeyboardInputs.subMenuAddArticle()) {
                case 1:
                    articleType = 1;
                    System.out.println(showAllArticlesByType(articleType));
                    answerSubMenu = addArticleToEditor(articleType);
                    break;
                case 2:
                    articleType = 2;
                    System.out.println(showAllArticlesByType(articleType));
                    answerSubMenu = addArticleToEditor(articleType);
                    break;
                case 3:
                    articleType = 3;
                    System.out.println(showAllArticlesByType(articleType));
                    answerSubMenu = addArticleToEditor(articleType);
                    break;
                case 4:
                    articleType = 4;
                    System.out.println(showAllArticlesByType(articleType));
                    answerSubMenu = addArticleToEditor(articleType);
                    break;
                case 5:
                    articleType = 5;
                    System.out.println(showAllArticlesByType(articleType));
                    answerSubMenu = addArticleToEditor(articleType);
                    break;
                case 0:
                    subMenuExit = true;
                    answerSubMenu = "Volviendo a menú principal...";
                    break;
            }
            System.out.println(answerSubMenu);
        } while (!subMenuExit);
    }

}
