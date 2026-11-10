# Practical Java

A collection of Java hands-on practices, experiments, and small console applications for building and strengthening core Java skills.

## What This Repository Covers

- Java syntax, variables, and data types
- User input with `Scanner`
- Conditional statements and grading logic
- Login and access-control checks
- Classes, objects, and basic object-oriented programming
- Collections such as `ArrayList` and `HashSet`
- Input validation and formatted console reports
- Student records, course scores, weighted averages, grades, and GPA calculations
- Maven project practice

## Repository Structure

```text
.
├── Conditionals/                  # Maven project for conditional-statement exercises
├── Data Structures Practicals/    # GPA and student-report practical
├── LOGIN ACCESS CHECK SYSTEM/     # Username and password validation exercise
├── Trials/                        # Additional Java experiments and practice programs
├── .gitignore
├── LICENSE
└── README.md
```

## Main Practical: GPAHub

`Data Structures Practicals/GPAHub.java` is a console-based student learning management system. It demonstrates:

- Student and course record modeling with nested classes
- `ArrayList` and `HashSet` collections
- Duplicate student-ID detection
- Validation for names, IDs, course details, credit hours, and scores
- Weighted averages and GPA calculations
- Letter grades, pass/fail status, and honors classification
- Formatted student reports

Run it from the repository root with:

```bash
javac "Data Structures Practicals/GPAHub.java"
java -cp "Data Structures Practicals" GPAHub
```

## Maven Project

The `Conditionals` directory contains a Maven project configured for the `Conditionals` main class.

```bash
cd Conditionals
mvn compile
mvn exec:java
```

The project currently contains conditional-statement and switch-statement practice. Some examples are still being developed and may require completion before the entire project compiles successfully.

## Standalone Exercises

The login exercise can be compiled and run from the repository root with:

```bash
javac "LOGIN ACCESS CHECK SYSTEM/LoginAccessCheck.java"
java -cp "LOGIN ACCESS CHECK SYSTEM" LoginAccessCheck
```

For other standalone files, compile the file and run its class from the relevant directory:

```bash
javac FileName.java
java FileName
```

Some exercises use packages, so run them from the appropriate source root or use your IDE's run configuration.

## Requirements

- A JDK compatible with the version configured in `Conditionals/pom.xml`
- Apache Maven for the Maven project
- A code editor or IDE such as IntelliJ IDEA, Eclipse, or VS Code

## Learning Approach

Each exercise is intentionally small and focused. The repository will grow over time as new Java concepts, examples, data-structure exercises, and practical challenges are added.

## Contributing

This is primarily a personal learning repository, but suggestions and improvements are welcome. Feel free to open an issue or submit a pull request.

## License

See the [LICENSE](LICENSE) file for details.
