# LAB 06: Logging with SLF4J

## 0. Open the starter code

1. Download the starter code of Lab 06 (`lab06.rar`) from the course website.
2. Unzip the file into your Eclipse workspace.
3. Open Eclipse and import your project using **Import an Existing Maven Project**.
4. Open the first package containing the main `App.java` file.

## 1. Add dependencies to SLF4J

Add the SLF4J dependency:

```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>2.0.16</version>
</dependency>
```

SLF4J is an abstraction to logging libraries. It does not have a concrete implementation of the logging functionality; it is a façade to other concrete libraries.

## 2. Test the logging functionality

### a. Create a Logger property

Create a static property for a `Logger` from `org.slf4j` in your main class.

You may need to right-click `pom.xml` and choose:

**Maven -> Update Project**

to force Maven to reload `pom.xml`.

```java
// Replace MainClassName by the name of your class
static Logger logger = LoggerFactory.getLogger(MainClassName.class);
```

### b. Log an information message

Log an information message that the application is starting where appropriate:

```java
logger.info("Application is starting...");
```

### c. Run the application

Run the application using the plugin declared in `pom.xml`:

```text
clean -> package -> exec:java
```

### d. Check the warning

A warning message should be displayed:

```text
No SLF4J providers were found.
```

> **Note:** We also have to add a dependency to a concrete logging library.

## 3. Add a dependency to the Logback library

### a. Add Logback

Open `pom.xml` and add a dependency to Logback using the user interface.

![Adding Logback dependency](Lab06-assets/image1.png)

### b. Run the application again

Re-run the application and check that you now have the correct logging message.

![Logging output](Lab06-assets/image2.png)

## 4. Use another library instead of Logback: Log4j12

### a. Remove Logback

Remove the previously added dependency to Logback.

### b. Add `log4j12`

Use:

| Property | Value |
|---|---|
| Group ID | `org.slf4j` |
| Artifact ID | `slf4j-log4j12` |
| Version | `2.0.16` |

### c. Create `log4j.properties`

Log4j needs a configuration file to work properly.

Add a new file under:

```text
src/main/resources
```

Name it:

```text
log4j.properties
```

### d. Configure the logger

Add the following configuration:

```properties
log4j.rootLogger = ERROR, LOG1
log4j.appender.LOG1=org.apache.log4j.FileAppender

log = ./logs/App/log4j
log4j.appender.LOG1.File=${log}/log.out

log4j.appender.LOG1.layout=org.apache.log4j.PatternLayout
log4j.appender.LOG1.layout.conversionPattern=%d %p [%t] %C - %m%n
```

Meaning:

- `log4j.rootLogger = ERROR, LOG1`
  - Configures the minimum displayed level.
  - Lower levels are ignored.
  - Creates a logger called `LOG1`.
- `log4j.appender.LOG1=org.apache.log4j.FileAppender`
  - Configures the logger to log to a file.
- `log4j.appender.LOG1.File=${log}/log.out`
  - Specifies the output file name.
- `log4j.appender.LOG1.layout=org.apache.log4j.PatternLayout`
  - Configures the log layout.
- `log4j.appender.LOG1.layout.conversionPattern=%d %p [%t] %C - %m%n`
  - `%d`: timestamp
  - `%p`: priority
  - `%t`: thread
  - `%C`: class
  - `%m`: message
  - `%n`: return character

### e. Re-execute the program

Re-execute the program. You should see no logged messages.

Change the minimum logged level to:

```text
INFO
```

Then re-execute. You should see the logged message in the correct format.

## 5. Add the following logging messages

| Event | Log Level |
|---|---|
| Application starts | `info` |
| Application ends | `info` |
| Wallet account created | `debug` |
| Deposit | `debug` |
| Withdraw | `debug` |
| `InsufficientFundsException` object created | `warn` |
| Thrown exception | `error` |

### Final tasks

1. Change the log level and re-execute your code to see what messages are logged.
2. Use AI to evaluate your logging strategy.
3. Apply AI recommendations to improve your logging strategy.

---

**END**
