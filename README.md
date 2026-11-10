# Practical Java

A collection of Java hands-on practices, experiments, and small programs for building and strengthening core Java skills.

## What This Repository Covers

- Java syntax and fundamentals
- Variables, data types, and input handling
- Conditional statements and switch expressions
- Classes, objects, and basic object-oriented programming
- Small console-based applications and logic exercises
- Maven project practice

## Repository Structure

```text
.
├── Conditionals/              # Maven project for conditional-statement exercises
├── LOGIN ACCESS CHECK SYSTEM/ # Simple login-access practice program
├── Qbit/                      # Additional Java practice programs
├── .gitignore
├── LICENSE
└── README.md
```

## Requirements

- A JDK compatible with the version configured in `Conditionals/pom.xml`
- Apache Maven for building the Maven project
- A code editor or IDE such as IntelliJ IDEA, Eclipse, or VS Code

## Running the Maven Project

From the repository root:

```bash
cd Conditionals
mvn clean compile
mvn exec:java
```

You can also open the `Conditionals` directory in an IDE and run the configured main class.

## Running Standalone Programs

Compile and run a Java file from its directory with:

```bash
javac FileName.java
java FileName
```

Some exercises use packages, so run them from the appropriate source root or use your IDE's run configuration.

## Learning Approach

Each exercise is intentionally small and focused. The repository will grow over time as new Java concepts, examples, and practical challenges are added.

## Contributing

This is primarily a personal learning repository, but suggestions and improvements are welcome. Feel free to open an issue or submit a pull request.

## License

See the [LICENSE](LICENSE) file for details.
