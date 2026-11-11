import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;

public class GPAHub {
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
    private static final String NAME_PATTERN =
            "[\\p{L}]+(?:['’-][\\p{L}]+)*(?:\\s+[\\p{L}]+(?:['’-][\\p{L}]+)*)*";
    private static final String STUDENT_ID_PATTERN =
            "[A-Za-z0-9]+(?:[/_-][A-Za-z0-9]+)*";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = new ArrayList<>();
        Set<String> studentIds = new HashSet<>();

        System.out.println("==============================================");
        System.out.println("       STUDENT LEARNING MANAGEMENT SYSTEM");
        System.out.println("==============================================");

        int studentCount = readPositiveInt(scanner, "Enter number of students: ");
        for (int i = 1; i <= studentCount; i++) {
            System.out.println("\n--- Enter details for student " + i + " ---");
            Student student = readStudent(scanner, studentIds);
            students.add(student);
        }

        printReport(students);
        scanner.close();
    }

    private static Student readStudent(Scanner scanner, Set<String> studentIds) {
        String name = readName(scanner);
        String id;
        do {
            id = readStudentId(scanner);
            if (studentIds.contains(id)) {
                System.out.println("That student ID already exists. Enter a unique ID.");
                id = "";
            }
        } while (id.isEmpty());
        studentIds.add(id);

        String level = readRequiredText(scanner, "Student level: ");
        String program = readRequiredText(scanner, "Student program: ");
        int courseCount = readPositiveInt(scanner, "Number of courses: ");
        List<CourseResult> courses = new <>();

        for (int i = 1; i <= courseCount; i++) {
            System.out.println("Course " + i);
            String courseCode = readRequiredText(scanner, "  Course code: ");
            String courseName = readRequiredText(scanner, "  Course name: ");
            int creditHours = readCreditHours(scanner, "  Credit hours: ");
            double score = readScore(scanner, "  Score (0-100): ");
            courses.add(new CourseResult(courseCode, courseName, creditHours, score));
        }

        return new Student(name, id, level, program, courses);
    }

    private static void printReport(List<Student> students) {
        System.out.println("\n\n==================== STUDENT REPORT ====================");
        for (Student student : students) {
            double total = 0;
            int totalCredits = 0;
            double highest = Double.NEGATIVE_INFINITY;
            double lowest = Double.MAX_VALUE;

            System.out.println("\nName: " + student.name);
            System.out.println("ID: " + student.id);
            System.out.println("Level: " + student.level);
            System.out.println("Program: " + student.program);
            System.out.println("---------------------------------------------------------");
            System.out.printf("%-15s %-28s %8s %8s %8s%n",
                    "Course code", "Course name", "Credit", "Score", "Grade");

            for (CourseResult course : student.courses) {
                total += course.score;
                totalCredits += course.creditHours;
                highest = Math.max(highest, course.score);
                lowest = Math.min(lowest, course.score);
                System.out.printf("%-15s %-28s %8d %8.2f %8s%n",
                        course.code, course.name, course.creditHours,
                        course.score, grade(course.score));
            }

            double average = weightedAverage(student.courses, totalCredits);
            double gpa = calculateGpa(student.courses);
            System.out.printf("---------------------------------------------------------%n");
            System.out.printf("Total score: %.2f | Total credits: %d | Average: %.2f%n",
                    total, totalCredits, average);
            System.out.printf("Highest: %.2f | Lowest: %.2f%n", highest, lowest);
            System.out.println("Overall grade: " + grade(average));
            System.out.printf("GPA: %.2f / 4.00%n", gpa);
            System.out.println("Class rank: " + classRank(gpa));
            System.out.println("Status: " + (average >= 50 ? "PASS" : "FAIL"));
        }
        System.out.println("\nRecords captured successfully: " + students.size());
    }

    private static double calculateGpa(List<CourseResult> courses) {
        double totalGradePoints = 0;
        int totalCredits = 0;
        for (CourseResult course : courses) {
            totalGradePoints += gradePoint(course.score) * course.creditHours;
            totalCredits += course.creditHours;
        }
        return totalGradePoints / totalCredits;
    }

    private static double weightedAverage(List<CourseResult> courses, int totalCredits) {
        double weightedScore = 0;
        for (CourseResult course : courses) {
            weightedScore += course.score * course.creditHours;
        }
        return weightedScore / totalCredits;
    }

    private static double gradePoint(double score) {
        if (score >= 80) return 4.0;
        if (score >= 70) return 3.0;
        if (score >= 60) return 2.0;
        if (score >= 50) return 1.0;
        return 0.0;
    }

    private static String classRank(double gpa) {
        if (gpa >= 3.90) return "Summa Cum Laude";
        if (gpa >= 3.70) return "Magna Cum Laude";
        if (gpa >= 3.50) return "Cum Laude";
        return "No honors";
    }

    private static String grade(double score) {
        if (score >= 80) return "A";
        if (score >= 70) return "B";
        if (score >= 60) return "C";
        if (score >= 50) return "D";
        return "F";
    }

    private static String readName(Scanner scanner) {
        while (true) {
            System.out.print("Student name: ");
            String name = scanner.nextLine().trim();
            if (name.matches(NAME_PATTERN)) {
                return name;
            }
            System.out.println(
                    "Enter a valid name using letters, spaces, hyphens, or apostrophes.");
        }
    }

    private static String readStudentId(Scanner scanner) {
        while (true) {
            System.out.print("Student ID: ");
            String id = scanner.nextLine().trim().toUpperCase(Locale.ROOT);
            if (id.matches(STUDENT_ID_PATTERN)) {
                return id;
            }
            System.out.println(
                    "Enter a valid ID using letters, numbers, and separators such as /, -, or _.");
        }
    }

    private static String readRequiredText(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String value = scanner.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("This field cannot be empty.");
        }
    }

    private static int readPositiveInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException ignored) {
                // The user receives a clear validation message below.
            }
            System.out.println("Enter a whole number greater than zero.");
        }
    }

    private static int readCreditHours(Scanner scanner, String prompt) {
        while (true) {
            int creditHours = readPositiveInt(scanner, prompt);
            if (creditHours <= 10) {
                return creditHours;
            }
            System.out.println("Credit hours must be between 1 and 10.");
        }
    }

    private static double readScore(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double score = Double.parseDouble(input);
                if (score >= MIN_SCORE && score <= MAX_SCORE) {
                    return score;
                }
            } catch (NumberFormatException ignored) {
                // The user receives a clear validation message below.
            }
            System.out.println("Enter a valid score from 0 to 100.");
        }
    }

    private static class Student {
        private final String name;
        private final String id;
        private final String level;
        private final String program;
        private final List<CourseResult> courses;

        private Student(String name, String id, String level, String program,
                        List<CourseResult> courses) {
            this.name = name;
            this.id = id;
            this.level = level;
            this.program = program;
            this.courses = courses;
        }
    }

    private static class CourseResult {
        private final String code;
        private final String name;
        private final int creditHours;
        private final double score;

        private CourseResult(String code, String name, int creditHours, double score) {
            this.code = code;
            this.name = name;
            this.creditHours = creditHours;
            this.score = score;
        }
    }
}
