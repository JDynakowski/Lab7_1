//zadanie 6 & 7
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Osoba
{
    private String imie;
    private String nazwisko;
    private int wiek;

    public Osoba(String imie, String nazwisko, int wiek)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }
    @Override
    public String toString()
    {
        return "\n" + imie + " " + nazwisko + ", wiek: " + wiek;
    }
}

class Samochod
{
    private String marka;
    private String model;

    public Samochod(String marka, String model)
    {
        this.marka = marka;
        this.model = model;
    }
    @Override
    public String toString() {
        return "Samochód: " + marka + " " + model;
    }
}

class Main1
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        //Pobieranie danych od użytkownika
        System.out.print("Podaj imię: ");
        String imie = scanner.nextLine();

        System.out.print("Podaj nazwisko: ");
        String nazwisko = scanner.nextLine();

        System.out.print("Podaj wiek: ");
        int wiek = scanner.nextInt();
        scanner.nextLine(); //Czyszczenie bufora

        System.out.print("Podaj markę samochodu: ");
        String marka = scanner.nextLine();

        System.out.print("Podaj model samochodu: ");
        String model = scanner.nextLine();

        //Tworzenie obiektów
        Osoba osoba = new Osoba(imie, nazwisko, wiek);
        Samochod samochod = new Samochod(marka, model);

        //Zapis do pliku
        String sciezkaPliku = "C:/Users/jakub/OneDrive/Bureaublad/Informatyka/Studia/Rok 2/semestr I/Java/Zadania - Java/Zadanie 7/Lab7_Zadanie6&7.txt";
        try (PrintStream out = new PrintStream(new FileOutputStream(new File(sciezkaPliku), true)))
        {
            out.println(osoba);
            out.println(samochod);
            System.out.println("Informacje zostały dopisane do pliku.");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }
}
