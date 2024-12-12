package Lab11;

import java.util.*;
import java.io.*;

 class Student {
    private int id;
    private String name;
    private String university;
    private String department;
    private double GPA;

    public Student(int id, String name, String university, String department, double GPA) {
        this.id = id;
        this.name = name;
        this.university = university;
        this.department = department;
        this.GPA = GPA;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUniversity() {
        return university;
    }

    public String getDepartment() {
        return department;
    }

    public double getGPA() {
        return GPA;
    }

    @Override
    public String toString() {
        return name;
    }
}

class StudentNotFoundException extends Exception {
    public StudentNotFoundException(String message) {
        super(message);
    }
}

class EmptyStudentListException extends RuntimeException {
    public EmptyStudentListException(String message) {
        super(message);
    }
}

class InvalidStudentDataExceptions extends Exception {
    public InvalidStudentDataExceptions(String message) {
        super(message);
    }
}

class StudentSystem {
    private List<Student> students;

    public StudentSystem(List<Student> students) throws InvalidStudentDataExceptions {
        this.students = students;
        validateStudentData(students);
    }

    public StudentSystem(String filename) throws IOException, InvalidStudentDataExceptions {
        this.students = readStudents(filename);
        validateStudentData(students);
    }

    public List<Student> readStudents(String filename) throws IOException {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(" ");
                int id = Integer.parseInt(data[0]);
                String name = data[1];
                String university = data[2];
                String department = data[3];
                double gpa = Double.parseDouble(data[4]);
                studentList.add(new Student(id, name, university, department, gpa));
            }
        }
        return studentList;
    }

    private void validateStudentData(List<Student> students) throws InvalidStudentDataExceptions {
        for (Student student : students) {
            if (student.getGPA() < 6 || student.getGPA() > 10) {
                throw new InvalidStudentDataExceptions("Read data has invalid rows.");
            }
        }
    }

    public int noOfStudents() {
        return students.size();
    }

    public Optional<Student> getStudentById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return Optional.of(student);
            }
        }
        return Optional.empty();
    }

    public Student getHighestGPAStudent() {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }

        Student highestGPAStudent = students.get(0);

        for (Student student : students) {
            if (student.getGPA() > highestGPAStudent.getGPA()) {
                highestGPAStudent = student;
            }
        }
        return highestGPAStudent;
    }

    public Student getLongestNameStudent() {
        if (students.isEmpty()) {
            throw new EmptyStudentListException("List of students is empty.");
        }

        Student longestNameStudent = students.get(0);

        for (Student student : students) {
            if (student.getName() != null && student.getName().length() > longestNameStudent.getName().length()) {
                longestNameStudent = student;
            }
        }
        return longestNameStudent;
    }

    public static List<String> getNames(List<Student> students) {
        List<String> names = new ArrayList<>();
        for (Student student : students) {
            names.add(student.getName());
        }
        return names;
    }
}
