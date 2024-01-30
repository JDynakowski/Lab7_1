//zadanie 8
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public abstract class Book
{
    protected String title;
    protected String author;
    protected int year;

    public Book(String title, String author, int year)
    {
        this.title = title;
        this.author = author;
        this.year = year;
    }
    public abstract void displayInfo();
}

class FictionBook extends Book
{
    public FictionBook(String title, String author, int year)
    {
        super(title, author, year);
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Fiction Book: " + title + " by " + author + ", published in " + year);
    }
}

class NonFictionBook extends Book
{
    public NonFictionBook(String title, String author, int year)
    {
        super(title, author, year);
    }

    @Override
    public void displayInfo()
    {
        System.out.println("Non-Fiction Book: " + title + " by " + author + ", published in " + year);
    }
}

class BookManager
{
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book)
    {
        books.add(book);
    }

    public void displayBooks()
    {
        for (Book book : books)
        {
            book.displayInfo();
        }
    }

    public void saveBooksToFile(String filePath)
    {
        try (PrintStream out = new PrintStream(new FileOutputStream(new File(filePath))))
        {
            for (Book book : books)
            {
                out.println("\n" + book.title + ";" + book.author + ";" + book.year);
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    public void loadBooksFromFile(String filePath)
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)))
        {
            String line;
            while ((line = reader.readLine()) != null)
            {
                String[] data = line.split(";");
                addBook(new FictionBook(data[0], data[1], Integer.parseInt(data[2])));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Mainn
{
    public static void main(String[] args)
    {
        BookManager manager = new BookManager();

        manager.addBook(new FictionBook("1984", "George Orwell", 1949));
        manager.addBook(new FictionBook("To Kill a Mockingbird", "Harper Lee", 1960));
        manager.addBook(new NonFictionBook("Sapiens", "Yuval Noah Harari", 2015));
        manager.addBook(new NonFictionBook("A Brief History of Time", "Stephen Hawking", 1988));

        System.out.println("Displaying all books:\n");
        manager.displayBooks();

        String filePath = "C:/Users/jakub/OneDrive/Bureaublad/Informatyka/Studia/Rok 2/semestr I/Java/Zadania - Java/Zadanie 7/Lab7_Zadanie8.txt";
        manager.saveBooksToFile(filePath);
    }
}