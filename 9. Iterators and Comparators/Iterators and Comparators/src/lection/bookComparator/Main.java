package lection.bookComparator;

public class Main {
    public static void main(String[] args) {
        Book bookOne = new Book("Animal Farm", 2003, "George Orwell");
        Book bookTwo = new Book("The Documents in the Case", 1930, "Dorothy Sayers", "Robert Eustace");
        Book bookThree = new Book("Clean Code", 2002);

        BookComparator comparator = new BookComparator();

        int result =  comparator.compare(bookOne, bookTwo);

        if (result > 0) {
            System.out.printf("%s is before %s%n", bookOne, bookTwo);
        } else if (result < 0) {
            System.out.printf("%s is before %s%n", bookTwo, bookOne);
        } else {
            System.out.println("Book are equal");
        }
    }
}
