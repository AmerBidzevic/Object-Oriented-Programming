package Lab4.people;

public class Person {

    private String name;
    private String street;
    private int age;
    private String country;


    public Person(String name, String street, int age, String country) {
        this.name = name;
        this.street = street;
        this.age = age;
        this.country = country;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getCountry(){
        return country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    @Override
    public String toString() {
        return name + "\n " + street + "\n" + age + "\n" + country;
    }


    public static void main(String[] args) {
        Person pekka = new Person("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 24, "Russia");
        Person esko = new Person("Esko Ukkonen", "Mannerheimintie Street 15 00100 Helsinki", 21, "Japan");
        System.out.println(pekka);
        System.out.println(esko);
    }

}

