package ua.kpi.parsingText;

import ua.kpi.parsingText.controller.Controller;
import ua.kpi.parsingText.view.View;

import static ua.kpi.parsingText.view.View.print;

/**
 * Created by Evgeniy on 10.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller();
        System.out.println(controller.readFile(View.FILE_PATH));
        print();

        controller.processUser();
    }
}
