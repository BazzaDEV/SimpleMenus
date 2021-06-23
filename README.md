# Simple Menus *for Java*
[![](https://jitpack.io/v/BazzaDEV/OptimalEnchantTool.svg)](https://jitpack.io/#BazzaDEV/OptimalEnchantTool)

## Table of Contents
- [Simple Menus *for Java*](#simple-menus-for-java)
  - [Table of Contents](#table-of-contents)
  - [💾 Installation](#-installation)
    - [**Local JAR**](#local-jar)
    - [**Maven**](#maven)
    - [**Gradle**](#gradle)
  - [🔎 Usage](#-usage)
  - [🚀 Examples](#-examples)

## 💾 Installation

### **Local JAR**
You can pull the JAR from the **Releases** tab on the right, and add it as a local dependency to your project.

### **Maven**
Alternatively, you can pull it from the JitPack repo using Maven.

First, add the JitPack repository:
```xml
<repository>
  <id>jitpack.io</id>
  <url>https://jitpack.io</url>
</repository>
```
Finally, add the SimpleMenus dependency:
```xml
<dependency>
  <groupId>com.github.BazzaDEV</groupId>
  <artifactId>SimpleMenus</artifactId>
  <version>1.2.1</version>
</dependency>
```

### **Gradle**
Add the JitPack repository to the root `build.gradle` at the end of repositories:
```gradle  
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```
Then add the dependency:
```gradle
dependencies {
  implementation 'com.github.BazzaDEV:OptimalEnchantTool:1.2.1'
}
```

## 🔎 Usage

*For now, the following usage guide will suffice. In the future, I will look to make a solid, in-depth guide hosted here or on another platform.*

The best way for you to see how this works is to follow along with me while I build a project.

Copy or download the following Java class from one of the links below:
- **Paste**: https://paste.lucko.me/1zSiSmROgy
- **Gist**: https://gist.github.com/BazzaDEV/5293820b8b183040f0b749f67ef6c2cf

You could build an entire menu in one chain of method calls by calling a `MenuFactory`. However, I won't be doing this here so you can follow along easily. We call a `MenuFactory` with `Menu.create()`:

```java
Menu.MenuFactory factory = Menu.create();
```

Okay, now we can starting building our menu. First, let's set the title for our menu:

```java
factory.setTitle("Some Short 'n Sweet Title Here");
```

We can also add some text which comes right after the title, but before the menu options. To do this, we need to instantiate a `MenuText` object. We do this with yet again another factory, `MenuTextFactory`, by calling `MenuText.create()`:

```java
MenuText.MenuTextFactory textFactory = MenuText.create();
```

Okay, let's add some text. We can write text on a fresh line using `newLine(String text)`, add a spacer (blank line) using `spacer()`, and build our `MenuText` item with `build()`:

```java
textFactory.newLine("Welcome!")
           .spacer()
           .newLine("Hopefully our program doesn't suck. It's designed to be good, but it could also be bad!")
           .spacer()
           .newLine("Well anyways, I've rambling on for some time now. Here are some things to do while you're in here:");

MenuText text = textFactory.build();
```

Alright, all that's left is to add it to our menu:

```java
factory.setText(text);
```

Okay, now time for the fun part - the options! The goal is to have 3 options for the user to choose from in the menu:

1. Enter `L` to view a list of animals;
2. `C` to run a method which takes in an animal name, then returns it in upper case only if that animal was part of our list (from the first option);
3. and finally, quit the application with `Q`.

If you haven't already copied the template class from the top of [this section](#-usage), now's a better time than ever for that!

We're going to walk you through creating one of the menu options, then show you how to make the rest in a faster way.

Let's try to create the menu option for #1 (*enter `L` to view a list of animals*). First, let's get an instance of `MenuOptionFactory` by calling `MenuOption.create()`:

```java
MenuOption.MenuOptionFactory optionOneFactory = MenuOption.create();
```

Okay, now we're going to build the individual components for our menu option. We need to decide on the following:

- What **key** will be bound to our menu option. *This is the character the user will enter to select this option.*
- What **text** will be shown to the user to identify the menu option. *This is a short name for the menu option.*
- What **action** will take place if this menu option is chosen. *This could include running a method, calling another menu, etc.*

Let's do it:

```java
optionOneFactory.setKey('L');

optionOneFactory.setText("View Animals List");

optionOneFactory.setAction(() -> {

  System.out.println("Here's the list of animals:\n");
  animalsList.forEach(System.out::println);

});
```

All that's left to do now is build the `MenuOption` object and add it to our `MenuFactory`:

```java
MenuOption optionOne = optionOneFactory.build();
factory.addOption(optionOne);
```

Now, we've actually been creating our menu the long way - we did it like this so that you can get the hang of what's going on, but now we're going to make the rest of the code for creating the options more concise. This shouldn't be too hard to get the hang of, check it out:

```java
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
```

Menu options complete! All that's left to do is build our `Menu` and run it:

```java
Menu menu = factory.build();
menu.runMenu();
```

Done!

You can clean up the earlier code we wrote using the principles from building the second and third menu options like this:

```java
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
```

## 🚀 Examples

Currently only my own project, [Optimal Enchant Tool](https://go.bazza.dev/OET) utilizes *Simple Menus*.

If you have used *Simple Menus* in your project and want to feature it here, shoot me a message on Discord!
