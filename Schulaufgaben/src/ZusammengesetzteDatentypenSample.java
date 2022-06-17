
import java.util.ArrayList;
import java.util.HashMap;


public class ZusammengesetzteDatentypenSample {
    
    public static void main(String[] args)
    {
        Adresse lennartsAdresse = new Adresse("Im Brook","12a", "26127","Oldenburg","GER");

        Person VerasOma = new Person("Erika", 77,lennartsAdresse);
        Person VerasOpa = new Person("Karl-Gustav", 80,lennartsAdresse);
        Person KlausOpa = new Person("Heinz", 80,lennartsAdresse);
        Person KlausOma = new Person("Heide", 80,lennartsAdresse);
        Person lennartMother = new Person("Vera", 44, lennartsAdresse,VerasOma,VerasOpa);
        Person lennartFather = new Person("Klaus", 46,lennartsAdresse,KlausOma,KlausOpa);
        Person lennart = new Person("Lennart",21,lennartsAdresse,lennartMother,lennartFather);

        MakeStammbaum(lennart);
    }

    public static void MakeStammbaum(Person person){
        System.out.println("Name:" + person.name);
        if(person.Mother != null)
            System.out.println(person.name + "'s Mutter:" + person.Mother.name);
        if(person.Father != null)
            System.out.println(person.name + "'s Vater:" + person.Father.name);
        System.out.println();
        if(person.Mother.Mother != null || person.Mother.Father != null){
            MakeStammbaum(person.Mother);
        }
        if(person.Father.Father != null || person.Father.Mother != null){
            MakeStammbaum(person.Father);
        }
    }

}

class Person {
   String name;
   int alter;
   Adresse wohntIn;
   ArrayList<Haustier> haustiere = new ArrayList<>();

   Person Mother;
   Person Father;
   Person Child;
    public Person(String name, int alter, Adresse wohntIn) {
        this.name = name;
        this.alter = alter;
        this.wohntIn = wohntIn;
    }

    public Person(String name, int alter, Adresse wohntIn, Person mother, Person father) {
        this.name = name;
        this.alter = alter;
        this.wohntIn = wohntIn;
        setMother(mother);
        setFather(father);
    }

    public void setMother(Person mother) {
        Mother = mother;
        mother.setChild(this);
    }

    public void setFather(Person father) {
        Father = father;
        father.setChild(this);
    }

    public void setChild(Person child) {
        Child = child;
    }
}

class Adresse {

    String street;
    String hausnummer;
    String plz;
    String ort;
    String land;

    public Adresse(String street, String hausnummer, String plz, String ort, String land) {
        this.street = street;
        this.hausnummer = hausnummer;
        this.plz = plz;
        this.ort = ort;
        this.land = land;
    }
}

class Haustier{
    String name;
    Person besitzer;

    public void setBesitzer(Person besitzer) {
        this.besitzer = besitzer;
        besitzer.haustiere.add(this);
    }

    public Haustier(String name, Person besitzer) {
        this.name = name;
        this.besitzer = besitzer;
        besitzer.haustiere.add(this);
    }

    public Haustier(String name) {
        this.name = name;
    }
}

enum Relation{
    FATHER,
    MOTHER,
    CHILD
}