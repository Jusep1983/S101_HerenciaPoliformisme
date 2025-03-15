package level3.model;

import java.util.ArrayList;

public class Editor {
    private String name;
    private final String dni;
    private static int salary = 1500;
    private ArrayList<Article> articles;

    public Editor(String name, String dni) {
        this.name = name;
        this.dni = dni;
        this.articles = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public String getDni() {
        return dni;
    }

    public static int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Redactor {" + "name: " + this.name + ", dni: " + this.dni + ", salary: " + getSalary()
               + ", Noticias asignadas: " + this.articles + "}\n";
    }
}
