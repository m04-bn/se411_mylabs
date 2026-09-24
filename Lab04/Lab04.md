# LAB 04: Maven Intro

## Exercise 1: Maven Project Dependencies

For this exercise, you will prepare the Maven project for your course main project. You can work in groups using the same group as in the course main project.

### 1. Create a Maven project

Create a Maven project with the name of your course main project.

### 2. Create the main class

In the `src/main/java` folder, create a class with a `main` method.

Make sure you name your project using a namespace that reflects your team/company, for example:

```text
psu.se411.myprojectname
```

Example:

![Creating the Java class](Lab04-assets/image1.png)

### 3. Import JavaFX into the Maven project

Add a dependency and a plugin.

#### JavaFX dependency in `pom.xml`

Add a `dependencies` section inside the `project` element:

```xml
<project>
    ...
    <dependencies>
    </dependencies>
</project>
```

Add the JavaFX dependency inside the `dependencies` element:

```xml
<dependency>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-controls</artifactId>
    <version>23</version>
</dependency>
```

#### JavaFX plugin in `pom.xml`

Add a `build` section inside the `project` section:

```xml
<project>
    ...
    <dependencies>
    </dependencies>

    <build>
    </build>
</project>
```

Add a `plugins` section inside the `build` section:

```xml
<build>
    <plugins>
    </plugins>
</build>
```

Add the JavaFX plugin that has the `run` goal. Make sure you change the package name and main class name accordingly.

```xml
<plugin>
    <groupId>org.openjfx</groupId>
    <artifactId>javafx-maven-plugin</artifactId>
    <version>0.0.8</version>

    <configuration>
        <mainClass>packageName.MainClass</mainClass>
    </configuration>
</plugin>
```

### 4. Test the project with a basic JavaFX application

Make your main class inherit from the JavaFX `Application` class.

```java
public class MainClass extends Application {
    // ...
}
```

Implement the basic methods of a JavaFX application:

```java
public static void main(String[] args) {
    launch();
}

@Override
public void start(Stage primaryStage) {
    try {
        primaryStage.setTitle("My Project");
        primaryStage.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

Finally, execute the following Maven goals:

```text
clean
javafx:run
```

The window should show up.

---

## Exercise 2: Maven Site Plugin

Continue working on the same project.

You will add basic information to your project and generate a website as documentation.

### 1. Add project information to `pom.xml`

#### a. Project information

```xml
<name>MyProject Name</name>
<description>This project is……</description>
<url>https://yourProjectUrl.dom</url>
```

#### b. License information

```xml
<licenses>
    <license>
        <name>Apache License 2.0</name>
        <url>https://www.apache.org/licenses/LICENSE-2.0</url>
    </license>
</licenses>
```

#### c. Organization/team information

```xml
<organization>
    <name>SE411-Tech-Company</name>
    <url>https://mycompanyUrl.dom</url>
</organization>
```

#### d. Developer information

```xml
<developers>
    <developer>
        <name>Salah Ahmed</name>
        <email>salah.ahmed@domain.com</email>
    </developer>
</developers>
```

### 2. Generate the documentation website

Run the Maven Site plugin:

```text
clean site
```

### 3. Open the generated website

Inside the `target/site` folder, find:

```text
index.html
```

Right-click it and select:

**Open With -> System Editor**

### 4. Improve the generated site

Open a generative AI tool such as Copilot, ChatGPT, Gemini, or Claude and find how you can improve the generated site by including other useful information such as documentation content.

---

**END**
