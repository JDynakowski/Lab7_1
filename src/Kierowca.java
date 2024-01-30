//zadanie 2 & Zadanie 5
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Kierowca
{
    private String pesel;
    protected String nazwisko;
    public String imie;
    public int wiek;

    public Kierowca(String imie, String nazwisko, int wiek, String pesel)
    {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
        this.pesel = pesel;
    }

    public void wypiszInformacje()
    {
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Wiek: " + wiek);
        System.out.println("PESEL: " + pesel);
    }
    public String getPesel()
    {
        return pesel;
    }
}

class Auto extends Kierowca
{
    private String vin;
    protected int rocznik;
    public String marka;
    public String model;

    public Auto(String imie, String nazwisko, int wiek, String pesel, String vin, int rocznik, String marka, String model) {
        super(imie, nazwisko, wiek, pesel);
        this.vin = vin;
        this.rocznik = rocznik;
        this.marka = marka;
        this.model = model;
    }

    public void wypiszAuto()
    {
        wypiszInformacje();
        System.out.println("VIN: " + vin);
        System.out.println("Rocznik: " + rocznik);
        System.out.println("Marka: " + marka);
        System.out.println("Model: " + model);
    }
    public void zapiszDoPliku(String sciezkaPliku)
    {
        try (PrintStream out = new PrintStream(new FileOutputStream(new File(sciezkaPliku))))
        {
            out.println("Imię: " + imie);
            out.println("Nazwisko: " + nazwisko);
            out.println("Wiek: " + wiek);
            out.println("PESEL: " + getPesel());
            out.println("VIN: " + vin);
            out.println("Rocznik: " + rocznik);
            out.println("Marka: " + marka);
            out.println("Model: " + model);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}

class Main
{
    public static void main(String[] args)
    {

        Auto auto = new Auto("Jan", "Kowalski", 30, "12345678901", "VIN123456789", 2020, "Toyota", "Corolla");
        auto.wypiszAuto();
        auto.zapiszDoPliku("C:/Users/jakub/OneDrive/Bureaublad/Informatyka/Studia/Rok 2/semestr I/Java/Zadania - Java/Zadanie 7/Lab7_Zadanie5.txt");
    }

}
