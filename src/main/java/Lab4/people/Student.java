package Lab4.people;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private int credits;
    private int student_id;
    private List<Integer> grades;

    public Student(String name, String adress, int age, String country, int student_id){
        super(name, adress, age, country);
        this.credits = 0;
        this.student_id = student_id;
        this.grades = new ArrayList<>();
    }

    public int getCredits() {
        return credits;
    }


    public void  study(){
    this.credits++;
    }


    public int credits(){
    return this.credits;
    }

    public int getStudent_id(){
        return student_id;
    }

    public void setStudent_id(int student_id){
        this.student_id = student_id;
    }

    public void addGrade(int grade){
        if(grade >= 0 && grade <= 100){
            grades.add(grade);
        }else {
            System.out.println("Invalid grade");
        }
    }

    public List<Integer> getGrades(){
        return grades;
    }

    @Override
    public String toString() {
        return super.toString()  + "\n" + this.student_id + "\n" + this.grades;
    }

    public static void main(String[] args) {
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki", 19, "South Korea", 1245);
        System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits "+ olli.credits());


        olli.addGrade(70);
        olli.addGrade(90);
        olli.addGrade(100);
        System.out.println("Updated Student Info: " + olli);
    }

}
