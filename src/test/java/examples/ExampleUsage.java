package examples;

import dev.bazza.simplemenus.objects.Menu;
import dev.bazza.simplemenus.objects.MenuOption;
import dev.bazza.simplemenus.objects.MenuText;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExampleUsage {

    List<String> animalsList = Arrays.asList("Cow", "Pig", "Sheep", "Dog", "Cat", "Fish");

    public static void main(String[] args) {
        new ExampleUsage().buildAndRunMenu();
    }

    private void buildAndRunMenu() {

        Menu.MenuFactory factory = Menu.create();

        factory.setTitle("Some Short 'n Sweet Title Here");

        MenuText.MenuTextFactory textFactory = MenuText.create();

        textFactory.newLine("Welcome!")
                .spacer()
                .newLine("Hopefully our program doesn't suck. It's designed to be good, but it could also be bad!")
                .spacer()
                .newLine("Well anyways, I've rambling on for some time now. Here are some things to do while you're in here:");

        MenuText text = textFactory.build();
        factory.setText(text);

        MenuOption.MenuOptionFactory optionOneFactory = MenuOption.create();

        optionOneFactory.setKey('L');
        optionOneFactory.setText("View Animals List");
        optionOneFactory.setAction(() -> {

            System.out.println("Here's the list of animals:\n");
            animalsList.forEach(System.out::println);

        });

        MenuOption optionOne = optionOneFactory.build();
        factory.addOption(optionOne);

        factory.addOption(
                    MenuOption.create()
                        .setKey('C').setText("Run Complex Calculations")
                        .setAction(this::calculate)
                        .build())
                .addOption(
                    MenuOption.create()
                        .setKey('Q').setText("Quit")
                        .setAction(() -> {
                            System.out.println("\nThanks for trying out my application! Peace.");
                            System.exit(1);
                        })
                        .build());

        Menu menu = factory.build();
        menu.runMenu();

    }

    private void buildAndRunMenuConcise() {

        Menu menu = Menu.create()
                .setTitle("Some Short 'n Sweet Title Here")

                .setText(
                        MenuText.create()
                                .newLine("Welcome!")
                                .spacer()
                                .newLine("Hopefully our program doesn't suck. It's designed to be good, but it could also be bad!")
                                .spacer()
                                .newLine("Well anyways, I've rambling on for some time now. Here are some things to do while you're in here:")
                        .build())

                .addOption(
                        MenuOption.create()
                                .setKey('L').setText("View Animals List")
                                .setAction(() -> {
                                    System.out.println("Here's the list of animals:\n");
                                    animalsList.forEach(System.out::println);
                                })
                                .build())

                .addOption(
                        MenuOption.create()
                                .setKey('C').setText("Run Complex Calculations")
                                .setAction(this::calculate)
                                .build())

                .addOption(
                        MenuOption.create()
                                .setKey('Q').setText("Quit")
                                .setAction(() -> {
                                    System.out.println("\nThanks for trying out my application! Peace.");
                                    System.exit(1);
                                })
                                .build())

                .build();

        menu.runMenu();


    }

    private void calculate() {
        System.out.print("Enter the name of a valid animal to see it in uppercase: ");

        Scanner sc = new Scanner(System.in);
        String input = null;

        boolean FLAG = false;
        while(!FLAG) {
            input = sc.nextLine().trim();
            if (animalsList.stream().anyMatch(input::equalsIgnoreCase)) {
                FLAG = true;
            } else {
                System.out.println("This is not a valid animal name - try again.");
            }
        }

        System.out.println("\nThat's a valid animal name! Here it is in all caps: " + input.toUpperCase());








    }



}
