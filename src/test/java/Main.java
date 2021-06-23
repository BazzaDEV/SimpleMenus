import objects.Menu;
import objects.MenuOption;
import objects.MenuText;

public class Main {

    public static void main(String[] args) {

        Menu menu = Menu.create()
                .setTitle("Optimal Enchant Tool")
                .setText(
                    MenuText.create()
                            .newLine("Welcome!")
                            .spacer()
                            .newLine("Here's another line of text.")
                            .build())
                .addOption(
                    MenuOption.create()
                            .setKey('V').setText("View Enchantments")
                            .setAction(() -> System.out.println("Here are some enchantments!"))
                            .build())
                .addOption(
                        MenuOption.create()
                                .setKey('C').setText("Calculate")
                                .setAction(() -> System.out.println("Here are some calculations!"))
                                .build())
                .addOption(
                        MenuOption.create()
                                .setKey('Q').setText("Quit")
                                .setAction(() -> System.exit(1))
                                .build())
                .build();

        menu.runMenu();
    }
}
