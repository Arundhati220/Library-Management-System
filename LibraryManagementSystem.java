import java.util.ArrayList;
import java.util.Scanner;

// Model Class: Book

class Book {
    int id;
    String title;
    String author;
    boolean isIssued;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }
}

// Model Class: Member

class Member {
    int memberId;
    String name;

    Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}

// Main Library System

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice;

        while (true) {
            System.out.println("\n====== LIBRARY MANAGEMENT SYSTEM ======");
            System.out.println("1 Add Book");
            System.out.println("2 View All Books");
            System.out.println("3 Add Member");
            System.out.println("4 View All Members");
            System.out.println("5 Issue Book");
            System.out.println("6 Return Book");
            System.out.println("7 Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addBook(sc);
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    addMember(sc);
                    break;

                case 4:
                    viewMembers();
                    break;

                case 5:
                    issueBook(sc);
                    break;

                case 6:
                    returnBook(sc);
                    break;

                case 7:
                    System.out.println("Thank you! Exiting system...");
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // 1. Add Book
   
    public static void addBook(Scanner sc) {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Book Author: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));
        System.out.println("Book added successfully!");
    }

    // 2. View Books
   
    public static void viewBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found!");
            return;
        }

        System.out.println("\n BOOK LIST:");
        for (Book b : books) {
            System.out.println("ID: " + b.id + " | Title: " + b.title + " | Author: " + b.author + " | Status: " + (b.isIssued ? "Issued" : "Available"));
        }
    }

    // 3. Add Member
   
    public static void addMember(Scanner sc) {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        members.add(new Member(id, name));
        System.out.println("Member added successfully!");
    }

    // -----------------------------------------------------
    // 4. View Members
    // -----------------------------------------------------
    public static void viewMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found!");
            return;
        }

        System.out.println("\n MEMBER LIST:");
        for (Member m : members) {
            System.out.println("ID: " + m.memberId + " | Name: " + m.name);
        }
    }

    // -----------------------------------------------------
    // 5. Issue Book
    // -----------------------------------------------------
    public static void issueBook(Scanner sc) {
        System.out.print("Enter Book ID to issue: ");
        int bookId = sc.nextInt();

        for (Book b : books) {
            if (b.id == bookId) {
                if (b.isIssued) {
                    System.out.println("Book already issued!");
                } else {
                    b.isIssued = true;
                    System.out.println("Book issued successfully!");
                }
                return;
            }
        }

        System.out.println("Book not found!");
    }

    // 6. Return Book

    public static void returnBook(Scanner sc) {
        System.out.print("Enter Book ID to return: ");
        int bookId = sc.nextInt();

        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.isIssued) {
                    System.out.println("Book was not issued!");
                } else {
                    b.isIssued = false;
                    System.out.println("Book returned successfully!");
                }
                return;
            }
        }

        System.out.println("Book not found!");
    }
}
