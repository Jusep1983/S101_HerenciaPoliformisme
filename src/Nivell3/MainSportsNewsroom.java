package Nivell3;

import java.util.ArrayList;

public class MainSportsNewsroom {
    static ArrayList<Editor> editors = new ArrayList<Editor>();
    static ArrayList<Article> articles = new ArrayList<Article>();
    private static final String APP_TITLE = "----------------------------------------------------\n"
            + "  BIENVENIDO A LA APLICACIÓN DE NOTICÍAS DEPORTIVAS  \n"
            + "----------------------------------------------------";
    private static final String MAIN_MENU = "\nMENÚ PRINCIPAL \n"
            + "1.- Introducir redactor \n"
            + "2.- Eliminar redactor \n"
            + "3.- Introducir notícia a un redactor \n"
            + "4.- Eliminar notícia \n"
            + "5.- Mostrar todas las notícias por redactor \n"
            + "6.- Calcular puntuación de una notícia \n"
            + "7.- Calcular precio de una notícia \n"
            + "8-. Ver lista completa de editores y noticias\n"
            + "0.- Sortir de l'aplicació \n"
            + "Introdueix un número d' opción entre 0 y 8: \n";
    private static final String SUBMENU_ADD_ARTICLE = "\nMENÚ INTRODUCIR NOTÍCIA \n"
            + "1.- Asignar redactor a una notícia de fútbol \n"
            + "2.- Asignar redactor a una notícia de básquet \n"
            + "3.- Asignar redactor a una notícia de tenis \n"
            + "4.- Asignar redactor a una notícia de fórmula 1 \n"
            + "5.- Asignar redactor a una notícia de motociclismo \n"
            + "0.- Volver atrás \n"
            + "Introdueix un número de opción entre 0 y 5: \n";

    public static void main(String[] args) {
        String awnser = "", dniEditor = "", nameEditor = "", headline = "", awnserSubmenu = "";
        int indexEditor = -1, indexHeadline = -1, articleType = 0;
        boolean exit = false, subMenuExit = false;

        loadInfo();

        System.out.println(APP_TITLE);
        do {
            switch (menu()) {
                case 1:
                    dniEditor = KeyboardInputs.readFormatDNI2("Introduce el DNI de redactor a crear: ");
                    indexEditor = findDniEditor(dniEditor);
                    if (indexEditor == -1) {
                        nameEditor = KeyboardInputs.readANonEmptyString("Introduce el nombre de redactor a crear: ");
                        awnser = createEditor(nameEditor, dniEditor);
                    } else {
                        awnser = "Ya existe un redactor con dni " + dniEditor;
                    }
                    break;
                case 2:
                    showAllEditors();
                    dniEditor = KeyboardInputs.readANonEmptyString("Introduce el DNI de redactor a eliminar: ");
                    indexEditor = findDniEditor(dniEditor);
                    if (indexEditor != -1) {
                        awnser = deleteEditor(indexEditor);
                    } else {
                        awnser = "No existe ningún redactor con dni " + dniEditor;
                    }
                    break;
                case 3:
                    do {
                        switch (subMenuAddArticle()) {
                            case 1:
                                articleType = 1;
                                System.out.println(showAllArticlesByType(articleType));
                                awnserSubmenu = assignArticleToEditor(articleType);
                                break;
                            case 2:
                                articleType = 2;
                                System.out.println(showAllArticlesByType(articleType));
                                awnserSubmenu = assignArticleToEditor(articleType);
                                break;
                            case 3:
                                articleType = 3;
                                System.out.println(showAllArticlesByType(articleType));
                                awnserSubmenu = assignArticleToEditor(articleType);
                                break;
                            case 4:
                                articleType = 4;
                                System.out.println(showAllArticlesByType(articleType));
                                awnserSubmenu = assignArticleToEditor(articleType);
                                break;
                            case 5:
                                articleType = 5;
                                System.out.println(showAllArticlesByType(articleType));
                                awnserSubmenu = assignArticleToEditor(articleType);
                                break;
                            case 0:
                                subMenuExit = true;
                                awnserSubmenu = "Volviendo a menú principal...";
                                break;
                        }
                        System.out.println(awnserSubmenu);
                    } while (!subMenuExit);
                    //resetting variables to avoid errors
                    awnserSubmenu = "";
                    break;
                case 4:
                    showAllEditors();
                    System.out.println("Lista de editores: ");
                    dniEditor = KeyboardInputs.readANonEmptyString(
                            "Introduce el DNI del redactor a eliminarle notícia: ");
                    indexEditor = findDniEditor(dniEditor);
                    if (indexEditor != -1) {
                        System.out.println("Lista de noticias del redactor " + dniEditor + " "
                                + editors.get(indexEditor).getName() + ":");
                        for (int i = 0; i < editors.get(indexEditor).getArticles().size(); i++) {
                            System.out.println("\t" + editors.get(indexEditor).getArticles().get(i).getHeadline());
                        }
                        headline = KeyboardInputs.readANonEmptyString("Introduce el titular de la noticia a eliminar: ");
                        indexHeadline = findHeadlineOnEditor(headline, indexEditor);
                        if (indexHeadline != -1) {
                            awnser = "El redactor " + dniEditor + " "
                                    + editors.get(indexEditor).getName()
                                    + " ya no tiene asignada la noticia con titular "
                                    + "\"" + headline + "\"";
                            editors.get(indexEditor).getArticles().remove(indexHeadline);
                        } else {
                            awnser = "El redactor " + dniEditor + " "
                                    + editors.get(indexEditor).getName()
                                    + " no tiene asignada ninguna noticia con titular "
                                    + "\"" + headline + "\"";
                        }
                    } else {
                        awnser = "No existe un redactor con dni " + dniEditor;
                    }
                    break;
                case 5:
                    showAllEditors();
                    dniEditor = KeyboardInputs.readANonEmptyString(
                            "Introduce el DNI del redactor a mostrar sus notícias: ");
                    indexEditor = findDniEditor(dniEditor);
                    if (indexEditor != -1) {
                        awnser = "Lista de noticias de redactor " + dniEditor + " " + editors.get(indexEditor).getName();
                        for (int i = 0; i < editors.get(indexEditor).getArticles().size(); i++) {
                            awnser += editors.get(indexEditor).getArticles().get(i);
                        }
                    } else {
                        awnser = "No existe un redactor con dni " + dniEditor;
                    }
                    break;
                case 6:
                    showAllHeadlines();
                    headline = KeyboardInputs.readANonEmptyString("Introduce el titular de la noticia: ");
                    indexHeadline = findArticleHeadline(headline);
                    if (indexHeadline != -1) {
                        awnser = "La puntuación de la noticia \"" + headline + "\" és de "
                                + articles.get(indexHeadline).getScore() + " puntos";
                    } else {
                        awnser = "No existe ninguna noticia con titular: \"" + headline + "\"";
                    }
                    break;
                case 7:
                    showAllHeadlines();
                    headline = KeyboardInputs.readANonEmptyString("Introduce el titular de la noticia: ");
                    indexHeadline = findArticleHeadline(headline);
                    if (indexHeadline != -1) {
                        awnser = "El precio de la noticia \"" + headline + "\" és de "
                                + articles.get(indexHeadline).getPrice() + "€";
                    } else {
                        awnser = "No existe ninguna noticia con titular: \"" + headline + "\"";
                    }
                    break;
                case 8:
                    printAllEditorsAndArticles();
                    break;
                case 0:
                    System.out.println("Grácias por utilitzar la aplicación, hasta pronto! ");
                    exit = true;
                    break;
            }
            System.out.println(awnser);
            //resetting variables to avoid errors
            awnser = "";
            subMenuExit = false;
        } while (!exit);

    }

    //---------------------------------------------------------------------------------------------------------------------
    public static byte menu() {
        byte option;
        option = KeyboardInputs.readByteRange(MAIN_MENU, (byte) 0, (byte) 8);
        return option;
    }

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

    public static String createEditor(String name, String dni) {
        String awnser = "";
        Editor editor = new Editor(name, dni);
        editors.add(editor);
        awnser = "Redactor amb DNI " + dni + " creado con éxito";
        return awnser;
    }

    public static String deleteEditor(int index) {
        String awnser = "";
        awnser = "Editor con DNI " + editors.get(index).getDni() + " eliminado con éxito";
        editors.remove(index);
        return awnser;
    }

    public static void showAllEditors() {
        System.out.println("Lista de redactores: ");
        for (int i = 0; i < editors.size(); i++) {
            System.out.println("\t" + editors.get(i).getDni() + " " + editors.get(i).getName());
        }
    }

    public static byte subMenuAddArticle() {
        byte option;
        option = KeyboardInputs.readByteRange(SUBMENU_ADD_ARTICLE, (byte) 0, (byte) 5);
        return option;
    }

    public static String showAllArticlesByType(int articleType) {
        String awnser = "";
        switch (articleType) {
            case 1:
                awnser = "Lista de noticias de fútbol: ";
                for (int i = 0; i < articles.size(); i++) {
                    if (articles.get(i) instanceof FootballArticle) {
                        awnser += "\n\t" + articles.get(i).getHeadline();
                    }
                }
                break;
            case 2:
                awnser = "Lista de noticias de básquet: ";
                for (int i = 0; i < articles.size(); i++) {
                    if (articles.get(i) instanceof BasketArticle) {
                        awnser += "\n\t" + articles.get(i).getHeadline();
                    }
                }
                break;
            case 3:
                awnser = "Lista de noticias de tenis: ";
                for (int i = 0; i < articles.size(); i++) {
                    if (articles.get(i) instanceof TennisArticle) {
                        awnser += "\n\t" + articles.get(i).getHeadline();
                    }
                }
                break;
            case 4:
                awnser = "Lista de noticias de fórmula 1: ";
                for (int i = 0; i < articles.size(); i++) {
                    if (articles.get(i) instanceof FOneArticle) {
                        awnser += "\n\t" + articles.get(i).getHeadline();
                    }
                }
                break;
            case 5:
                awnser = "Lista de noticias de motociclisme: ";
                for (int i = 0; i < articles.size(); i++) {
                    if (articles.get(i) instanceof MotorcycleArticle) {
                        awnser += "\n\t" + articles.get(i).getHeadline();
                    }
                }
                break;
        }
        return awnser;
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
        String awnser = "";
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

    public static String assignArticleToEditor(int articleType) {
        String dniEditor = "", awnser = "", headline = "", articleTypeStr = "";
        int indexArticle = -1, indexEditor = -1;
        headline = KeyboardInputs.readANonEmptyString("Introduce el titular de la noticia a asignar: ");
        indexArticle = findHeadlineByTypeArticle(headline, articleType);
        if (indexArticle != -1) {
            showAllEditors();
            dniEditor = KeyboardInputs.readANonEmptyString(
                    "Introduce el dni del redactor a asignarle la notícia: ");
            indexEditor = findDniEditor(dniEditor);
            if (indexEditor != -1) {
                editors.get(indexEditor).getArticles().add(articles.get(indexArticle));
                awnser = "Al redactor con DNI " + editors.get(indexEditor).getDni()
                        + " se le ha asignado la noticia " + " \"" + headline + " \"";
            } else {
                awnser = "No existe ningún redactor con DNI " + dniEditor;
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
            awnser = "No existe ninguna noticia " + articleTypeStr + " con titular \"" + headline + "\"";
        }
        return awnser;
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

    public static void showAllHeadlines() {
        System.out.println("Lista de noticias: ");
        for (int i = 0; i < articles.size(); i++) {
            System.out.println("\t" + articles.get(i).getHeadline());
        }
    }

    // Method that loads a sample of data
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
        editors.add(editor1);
        editors.add(editor2);
        editors.add(editor3);
        editors.add(editor4);
        articles.add(footballArticle1);
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

    public static void printAllEditorsAndArticles() {
        System.out.println("Redactores registrados: \n" + editors + "\n");
        System.out.println("Notícias registradas: \n" + articles + "\n");
    }

}
