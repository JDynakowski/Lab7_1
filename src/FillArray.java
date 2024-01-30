//zadanie 3
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/*
public class FillArray
{
    public static void main(String[] args)
    {
        int[] array = {1, 2, 3, 4, 5};
        String pathToFile = "C:/Users/jakub/OneDrive/Bureaublad/Informatyka/Studia/Rok 2/semestr I/Java/Zadania - Java/Zadanie 7/Lab7_Zadanie3.txt";

        try (PrintStream out = new PrintStream(new FileOutputStream(new File(pathToFile))))
        {
            for (int element : array)
            {
                out.println(element);
            }
            System.out.println("Tablica została zapisana do pliku.");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
*/

class ReadArrayFromFile
{

    public static void main(String[] args) {
        String pathToFile = "C:/Users/jakub/OneDrive/Bureaublad/Informatyka/Studia/Rok 2/semestr I/Java/Zadania - Java/Zadanie 7/Lab7_Zadanie3.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(pathToFile)))
        {
            List<Integer> list = new ArrayList<>();
            String line;

            while ((line = reader.readLine()) != null)
            {
                list.add(Integer.parseInt(line));
            }

            int[] array = list.stream().mapToInt(i -> i).toArray();
            System.out.println("Tablica odczytana z pliku:");
            for (int element : array)
            {
                System.out.print(element + " ");
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}