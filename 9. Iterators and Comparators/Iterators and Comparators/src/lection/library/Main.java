package lection.library;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("Clean Code", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("The Documents in the Case", 2002);

        Library<Book> library = new Library<>(bookOne, bookTwo, bookThree);

        library.forEach(book -> System.out.println(book.getTitle()));
    }

}
