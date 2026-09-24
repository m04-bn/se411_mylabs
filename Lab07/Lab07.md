# Lab 07: Polymorphism in Java

**2 sessions to complete**

## Questions

1. **Create your project as a Maven project.**
2. **Create all the classes needed to support this system.**
3. **Use object-oriented principles accordingly: inheritance, polymorphism.**
4. **Maximize code reuse.**
5. **Create a main program in your main method to test your classes.**
6. **Integrate a file logger to log system start and stop events and raised exceptions when needed in the main calling program.**

---

## Scenario

A travel agency wants to build a system to manage **different types of transportation bookings** for its customers.

The agency offers three transportation modes:

- **Flights**
- **Train rides**
- **Car rentals**

All bookings share some common information:

- A **booking ID**
- The **customer’s full name**
- The **date of travel**
- The **destination city**

Each booking type has its own additional data and its own rules for computing the **total price**, which is why the agency wants to use **polymorphism**.

---

## Booking Types & Their Rules

### 1. FlightBooking

#### Stores

- Base ticket price — set when the booking is created
- Luggage weight — entered later by the customer

#### Price Calculation

```text
Total price = base price + (luggage weight × extra-luggage rate)
```

#### Business Rules

- Luggage weight must be between **0 and 40 kg**
- If luggage weight is not provided → throw `MissingInformationException`
- If weight is outside the allowed range → throw `InvalidArgumentException`
- The extra-luggage rate is defined in a **global configuration class**

---

### 2. TrainBooking

#### Stores

- Seat class:
  - `STANDARD`
  - `FIRST_CLASS`
- Distance in kilometers — entered later by the system

#### Price Calculation

```text
STANDARD:    price = distance × standard rate
FIRST_CLASS: price = distance × first-class rate
```

#### Business Rules

- Distance must be between **1 and 2000 km**
- If distance is not provided → throw `MissingInformationException`
- If distance is invalid → throw `InvalidArgumentException`
- Rates are defined in the **global configuration class**

---

### 3. CarRentalBooking

#### Stores

- Daily rental rate — set when the booking is created
- Number of rental days — entered later by the customer

#### Price Calculation

```text
Total price = daily rate × number of days
```

#### Business Rules

- Number of days must be between **1 and 30**
- If days are not provided → throw `MissingInformationException`
- If days are invalid → throw `InvalidArgumentException`

---

## Additional Requirements

### Global Configuration Class

Contains constants such as:

```text
EXTRA_LUGGAGE_RATE
TRAIN_STANDARD_RATE
TRAIN_FIRST_CLASS_RATE
MAX_LUGGAGE_WEIGHT
MAX_TRAIN_DISTANCE
MAX_RENTAL_DAYS
```

and other required configuration values.

### Custom Exceptions

```text
MissingInformationException
InvalidArgumentException
```

---

## Polymorphism Requirement

A method like:

```java
computeTotalPrice(Booking booking)
```

should work for **any booking type**.

---

# Annex

Run the Maven build using the goal:

```text
clean package exec:java
```

## 1. Configure the Exec Maven Plugin and SLF4J with Log4j12

Add the following configuration to `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-api</artifactId>
        <version>2.0.16</version>
    </dependency>

    <dependency>
        <groupId>org.slf4j</groupId>
        <artifactId>slf4j-log4j12</artifactId>
        <version>2.0.16</version>
    </dependency>
</dependencies>

<build>
    <plugins>
        <plugin>
            <groupId>org.codehaus.mojo</groupId>
            <artifactId>exec-maven-plugin</artifactId>
            <version>3.6.3</version>

            <configuration>
                <mainClass>edu.spu.se411.lab06_logging.App</mainClass>
            </configuration>
        </plugin>
    </plugins>
</build>
```

> **Note:** The annex provides `edu.spu.se411.lab06_logging.App` as the `mainClass`. If your Lab 07 package/class name is different, use your actual Lab 07 main class.

---

## 2. Configure Log4j12

Create the following file:

```text
src/main/resources/log4j.properties
```

Add:

```properties
log4j.rootLogger = INFO, LOG1
log4j.appender.LOG1=org.apache.log4j.FileAppender

log = ./logs/App/log4j
log4j.appender.LOG1.File=${log}/log.out

log4j.appender.LOG1.layout=org.apache.log4j.PatternLayout
log4j.appender.LOG1.layout.conversionPattern=%d %p [%t] %C - %m%n
```

---

## 3. Logging

Import `Logger`, then add logging instructions.

```java
static Logger logger = LoggerFactory.getLogger(App.class);
```

Example:

```java
logger.info("Application is starting...");
```

The application should log:

- System start events
- System stop events
- Raised exceptions when needed in the main calling program
