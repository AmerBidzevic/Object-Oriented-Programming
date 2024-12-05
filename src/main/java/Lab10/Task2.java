package Lab10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

class Student {
    private String name;
    private String ID;
    private List<Integer> grades;

    public Student(String name, String ID, List<Integer> grades) {
        this.name = name;
        this.ID = ID;
        this.grades = grades;
    }

    public void printInfo() {
        System.out.println("Student Info:");
        System.out.println("ID: " + ID);
        System.out.println("Name: " + name);
        System.out.println("Grades: " + grades);
    }
}

class GradeAnalyzer {
    private List<Integer> grades;

    public GradeAnalyzer(List<Integer> grades) {
        this.grades = grades;
    }

    public double calculateAverage() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public void printSummary() {
        System.out.println("Grade Summary:");
        System.out.println("Grades: " + grades);
        System.out.println("Average: " + calculateAverage());
    }
}

class Start {
    public static void main(String[] args) {

        List<Integer> grades = Arrays.asList(85, 90, 78, 92);
        Student student = new Student("John Dirt", "SD123", grades);

        GradeAnalyzer gradeAnalyzer = new GradeAnalyzer(grades);

        analyzeClassWithReflection(student);
        analyzeClassWithReflection(gradeAnalyzer);
    }

    private static void analyzeClassWithReflection(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("\nAnalyzing class: " + clazz.getName());
        System.out.println("\nFields:");
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                System.out.println(field.getName() + " = " + field.get(obj));
            } catch (IllegalAccessException e) {
                System.out.println("Cannot access field: " + field.getName());
            }
        }

        System.out.println("\nMethods:");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.getName().startsWith("calculate") || method.getName().startsWith("print")) {
                System.out.println("Invoking method: " + method.getName());
                try {
                    if (method.getReturnType() != void.class) {
                        Object result = method.invoke(obj);
                        System.out.println("Result: " + result);
                    } else {
                        method.invoke(obj);
                        System.out.println("Method invoked successfully.");
                    }
                } catch (Exception e) {
                    System.out.println("Error invoking method: " + method.getName());
                }
            }
        }
    }
}