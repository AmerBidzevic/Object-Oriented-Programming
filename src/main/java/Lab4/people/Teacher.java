package Lab4.people;

public class Teacher extends Person{
    private int salary;


    public Teacher(String name, String adress, int salary, int age, String country){
        super(name, adress, age, country);
        this.salary = salary;

    }

    public int getSalary(){
        return salary;
    }


    @Override
    public String toString() {
        return super.toString() + "\n  salary " + this.salary + " euros/month";
    }

    public static void main(String[] args) {
        Teacher pekka = new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200 , 24 ,"Russia");
        Teacher esko = new Teacher("Esko Ukkonen", "Mannerheimintie 15 Street 00100 Helsinki", 5400, 19 , "Japan");
        System.out.println( pekka );
        System.out.println( esko );




        Student olli = new Student("Olli", "Ida Albergintie 1 Street 00400 Helsinki", 19, "South Korea",3244);
        for ( int i=0; i < 25; i++ ) {
            olli.study();
        }
        System.out.println( olli );
    }

}
