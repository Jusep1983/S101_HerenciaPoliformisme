package Nivell3;

import java.util.ArrayList;

public class Editor {
    private String name;
    private final String dni;
    private static int salary = 1500;
    private ArrayList<Article> articles;

    public Editor(String name, String dni) {
        this.name = name;
        this.dni = dni;
        this.articles = new ArrayList<Article>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Article> articles) {
        this.articles = articles;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDni() {
        return dni;
    }

    public static int getSalary() {
        return salary;
    }

    public static void setSalary(int salary) {
        Editor.salary = salary;
    }

    @Override
    public String toString() {
        return "Redactor {" + "name: " + this.name + ", dni: " + this.dni + ", salary: " + getSalary()
                + ", Noticias asignadas: " + this.articles + "}\n";
    }
}
