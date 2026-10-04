/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
class Book {
    int bookId;
    String title;
    String author;
    double price;

    static int totalBooks = 0;

    Book(int bookId, String title, String author, double price) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        totalBooks++;
    }

    void display() {
        System.out.println("Book ID : " + bookId);
        System.out.println("Title   : " + title);
        System.out.println("Author  : " + author);
        System.out.println("Price   : Rs. " + price);
        System.out.println("-------------------------");
    }

    void search(int id) {
        if (this.bookId == id) {
            System.out.println("Book found by ID:");
            display();
        } else {
            System.out.println("Book ID " + id + " does not match Book ID " + this.bookId + ".");
        }
    }

    void search(String title) {
        if (this.title.equalsIgnoreCase(title)) {
            System.out.println("Book found by Title:");
            display();
        } else {
            System.out.println("Title \"" + title + "\" does not match.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book(101, "Java Programming", "James Gosling", 450.00);
        Book b2 = new Book(102, "Clean Code", "Robert C. Martin", 650.50);

        System.out.println("Total Books Created: " + Book.totalBooks);
        System.out.println("-------------------------");

        b1.display();
        b2.display();

        System.out.println("=== Search Tests ===");
        b1.search(101);
        b1.search("Java Programming");
        b2.search("Python Essentials");
    }
}