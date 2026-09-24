# LAB 05: Exception Handling

## Exercise 1: Create Custom Exceptions

### 1. Create a Maven project

Create a new Maven project and create a new class with a `main` method.

### 2. Create `InvalidAgeException`

Create a custom exception class called `InvalidAgeException` in a special package that will only contain exception classes.

### 3. Create `validateAge`

In your main class, create a method called `validateAge` that accepts an age and throws `InvalidAgeException` if the age is less than 18.

If the age is 18 or higher, the function prints:

```text
Age valid message.
```

### 4. Call `validateAge`

Call the `validateAge` method from the `main` method and run the new main method using Maven.

### 5. Add the Maven execution plugin

Add the following Maven plugin to `pom.xml`. This Maven plugin executes the Java program after it has been packaged.

```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>exec-maven-plugin</artifactId>
            <version>3.5.0</version>

            <configuration>
                <mainClass>edu.psu.se411.App</mainClass>
            </configuration>
        </plugin>
    </plugins>
</build>
```

To run the program:

```text
clean -> package -> exec:java
```

---

## Exercise 2: An Online Wallet

In the same Maven project, write a program that simulates an online wallet.

Create all classes that are needed, including a `Wallet` class.

The program should:

1. Allow users to withdraw money from their wallet to their bank account.
2. Handle `InsufficientFundsException` if the withdrawal amount exceeds the wallet account balance.
3. Use a custom exception for this scenario.
4. Use GitHub Copilot to review your code on exception-handling quality.

---

**END**
