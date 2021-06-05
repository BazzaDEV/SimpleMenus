import org.apache.commons.lang3.StringUtils;
import utils.TextUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    //********************** Class Variables **********************//

    private final String title;
    private final MenuText text;
    private final List<MenuOption> options;

    //************************ Constructors ***********************//

    Menu(String title, MenuText text, List<MenuOption> options) {
        this.title = title;
        this.text = text;
        this.options = options;
    }

    public static MenuFactory create() {
        return new MenuFactory();
    }

    //************************** Methods **************************//

    public void runMenu() {
        while (true) {
            printMenu();

            MenuOption choice = null;
            while (choice == null) {
                choice = getInput();
            }

            choice.performAction();

            TextUtils.getInput("\n[Press any key to return to the main menu...]\n");
            TextUtils.printEmptyLines(20);
        }

    }

    private void printMenu() {
        printHeader();
        printText();
        printOptions();
    }

    private void printHeader() {
        System.out.println(TextUtils.HEADER_BRACKET_STARS);
        System.out.println(StringUtils.center(title, TextUtils.HEADER_BRACKET_STARS.length()));
        System.out.println(TextUtils.HEADER_BRACKET_STARS);
        System.out.println();

    }

    private void printText() {
        System.out.println(text.toString());
        System.out.println();
    }

    private void printOptions() {
        for (MenuOption option : options) {
            System.out.println(option.toString());
        }
    }

    private MenuOption getInput() {
        System.out.print(">> ");

        String input = TextUtils.getInput();

        if (input.length() == 1) {
            char c = input.charAt(0);
            for (MenuOption option : options) {
                if (option.getKey() == c)
                    return option;
            }
        }

        return null;

    }


/*************************************************************************************************************/


    static class MenuFactory {

        //********************** Class Variables **********************//

        private String title;
        private MenuText text;
        private final List<MenuOption> options;

        //************************ Constructors ***********************//

        private MenuFactory() {
            options = new ArrayList<>();
        }

        //************************** Methods **************************//

        public MenuFactory setTitle(String title) {
            this.title = title;

            return this;
        }

        public MenuFactory setText(MenuText text) {
            this.text = text;

            return this;
        }

        public MenuFactory addOption(MenuOption option) {
            options.add(option);

            return this;
        }

        public Menu build() {
            return new Menu(title, text, options);
        }

    }
}
