# LAB 03: JUnit Intro

## 0. Open the starter code

1. Download the starter code of Lab 03 (`lab03.rar`) from the course website.
2. Unzip the file into your Eclipse workspace.
3. Open Eclipse and import your project using **Import an Existing Maven Project**.
4. Read the provided `Stack` class to get familiar with it. The objective is to write unit tests for it.

## 1. Create test cases for the `Stack` class

### a. Add a test class

In the `src/test/java` folder, create a new class named `StackTest` in a package with exactly the same name as the class to test.

### b. Import the JUnit classes/functions

```java
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
```

> **Note:** In Java, the `import static` statement is used to import static members (fields and methods) of a class so that you can access them without qualifying them with the class name. This is useful for `assertEquals`, for example.

### c. Test `push -> push -> pop`

Create a test case to verify that a sequence of `push -> push -> pop` correctly pops the latest pushed element.

```text
push("Z") -> push("A")
assertEquals("A", pop())
```

The popped element has to be equal to `A`; otherwise, there is a problem in the `Stack`.

### d. Run the Maven test

Right-click `pom.xml` and execute:

**Run As -> Maven test**

You should get a report showing that all tests passed.

### e. Force the test to fail

Modify the previous test to force it to fail:

```java
assertEquals("Z", pop());
```

### f. Add other test cases

#### i. Popping an empty stack should raise an exception

```java
@Test
public void pop_empty_stack() {
    NoSuchElementException thrown =
        assertThrows(
            NoSuchElementException.class,
            () -> stringStack.pop(),
            "Expected pop from empty Stack to throw, but it didn't"
        );

    assertTrue(thrown.getMessage().equals("Stack is empty,can’t pop"));
}
```

#### ii. Reverse order

Test that pushed elements are popped in reverse order.
