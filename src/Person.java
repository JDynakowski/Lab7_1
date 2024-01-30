//zadanie 4

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
//klasa person, tablica objektów
public class Person
{
    private String name;
    private int age;

    public Person(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString()
    {
        return name + ", " + age;
    }
    // Getters
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    // Setters
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
}
//Tablica objektów, które zostja zapisane w pliku tekstowym
/*
class SavePeople
{

    public static void main(String[] args)
    {
        Person[] people =
                {
                new Person("Jakub", 30),
                new Person("Agata", 25),
                new Person("Kola", 45)
                };

        String pathToFile = "C:/Users/jakub/OneDrive/Bureaublad/Informatyka/Studia/Rok 2/semestr I/Java/Zadania - Java/Zadanie 7/Lab7_Zadanie4.txt";

        try (PrintStream out = new PrintStream(new FileOutputStream(new File(pathToFile))))
        {
            for (Person person : people)
            {
                out.println(person);
            }
            System.out.println("Dane zostały zapisane do pliku.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

 */

//funkcja do odczytu pliku tekstowego
class LoadPeople
{

    public static void main(String[] args)
    {
        String pathToFile = "C:/Users/jakub/OneDrive/Bureaublad/Informatyka/Studia/Rok 2/semestr I/Java/Zadania - Java/Zadanie 7/Lab7_Zadanie4.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile)))
        {
            List<Person> people = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null)
            {
                String[] parts = line.split(", ");
                Person person = new Person(parts[0], Integer.parseInt(parts[1]));
                people.add(person);
            }

            for (Person person : people)
            {
                System.out.println(person);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
