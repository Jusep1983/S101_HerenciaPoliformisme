package level3.run;

import level3.menuTexts.MenusTexts;
import level3.sampleData.SampleData;
import level3.util.KeyboardInputs;

import static level3.services.ManagementArticles.*;
import static level3.services.ManagementEditors.*;

public class SportNewsRoom {
    public static void run() {
        String answer = "";
        boolean exit = false;
        SampleData.loadInfo();
        System.out.println(MenusTexts.APP_TITLE);
        do {
            switch (KeyboardInputs.menu()) {
                case 1:
                    answer = createEditor();
                    break;
                case 2:
                    showAllEditors();
                    answer = checkAndRemoveIfEditorExists();
                    break;
                case 3:
                    assignArticleToEditor();
                    break;
                case 4:
                    showAllEditors();
                    answer = removeArticleToEditor();
                    break;
                case 5:
                    showAllEditors();
                    answer = showAllArticlesByEditor();
                    break;
                case 6:
                    showAllHeadlines();
                    answer = calculatePointsByArticle();
                    break;
                case 7:
                    showAllHeadlines();
                    answer = calculatePriceOfArticle();
                    break;
                case 8:
                    printAllEditorsAndArticles();
                    break;
                case 0:
                    System.out.println("Grácias por utilitzar la aplicación, hasta pronto! ");
                    exit = true;
                    break;
            }
            System.out.println(answer);
            //resetting variables to avoid errors
            answer = "";
        } while (!exit);
    }
}
