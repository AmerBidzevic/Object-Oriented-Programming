package Lab6;

import Lab4.people.Person;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book>books;

    public Library() {
        books = new ArrayList<>();
    }



    public void addBook(Book newBook){
        books.add(newBook);
    }

    public void printBooks(){
        for(Book book : books){
            System.out.println(book);
        }
    }


    public ArrayList<Book> searchByTitle(String searchedTitle) {
        ArrayList<Book> found = new ArrayList<>();
        for (Book book : books) {
            if (StringUtils.included(book.title(), searchedTitle)) {
                found.add(book);
            }
        }
        return found;
    }

    public ArrayList<Book> searchByPublisher(String searchedPublisher) {
        ArrayList<Book> found = new ArrayList<>();
        for (Book book : books) {
            if (StringUtils.included(book.publisher(), searchedPublisher)) {
                found.add(book);
            }
        }
        return found;
    }


    public ArrayList<Book> searchByYear(int year) {
        ArrayList<Book> found = new ArrayList<>();
        for (Book book : books) {
            if (book.year() == year) {
                found.add(book);
            }
        }
        return found;
    }

    public class StringUtils {
        public static boolean included(String word, String searched) {
            if (word == null || searched == null) {
                return false;
            }
            word = word.trim().toUpperCase();
            searched = searched.trim().toUpperCase();
            return word.contains(searched);
        }
    }


    public static void main(String[] args) {
//        Library Library = new Library();
//        Book cheese = new Book("Cheese Problems Solved", "Woodhead Publishing", 2007);
//        Library.addBook(cheese);
//        Book nhl = new Book("NHL Hockey", "Stanley Kupp", 1952);
//        Library.addBook(nhl);
//        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));
//        Library.printBooks();

        Library Library = new Library();


        Library.addBook(new Book("Cheese Problems Solved", "Woodhead Publishing", 2007));
        Library.addBook(new Book("The Stinky Cheese Man and Other Fairly Stupid Tales", "Penguin Group", 1992));
        Library.addBook(new Book("NHL Hockey", "Stanley Kupp", 1952));
        Library.addBook(new Book("Battle Axes", "Tom A. Hawk", 1851));


        ArrayList<Book> result = Library.searchByTitle("Cheese");
        for (Book book: result) {
            System.out.println(book);
        }


        System.out.println("---");
        for (Book book: Library.searchByPublisher("Penguin Group  ")) {
            System.out.println(book);
        }


        System.out.println("---");
        for (Book book: Library.searchByYear(1851)) {
            System.out.println(book);
        }

    }
}
