# SimpleMenus
[![](https://jitpack.io/v/BazzaDEV/OptimalEnchantTool.svg)](https://jitpack.io/#BazzaDEV/OptimalEnchantTool)  

## Where can I get the latest release?

### Local JAR
You can pull the JAR from the **Releases** tab on the right, and add it as a local dependency to your project.

### Maven
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

### Gradle
Add the JitPack respository to the root `build.gradle` at the end of repositories:
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

## Usage

## Examples

Currently, only my own project, [Optimal Enchant Tool](https://go.bazza.dev/OET) utilizes *Simple Menus*.

If you have used *Simple Menus* in your own project and want to feature it here, shoot me a message on Discord (**Bazza#1111**).
