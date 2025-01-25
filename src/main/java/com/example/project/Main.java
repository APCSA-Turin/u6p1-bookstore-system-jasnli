package com.example.project;
import java.util.Scanner;

public class Main {
    private static int printLayout() {
        Scanner s = new Scanner(System.in);
        System.out.println("𖦹------------Select One of the Following-------------𖦹");
        System.out.println("0️⃣  Exit Application ☹️");
        System.out.println("1️⃣  Add a New Book to the Jamazon Library 📖");
        System.out.println("2️⃣  Upgrade Quantity of a Book 📈");
        System.out.println("3️⃣  Search for a Book 🔍");
        System.out.println("4️⃣  Show All Books 👁️");
        System.out.println("5️⃣  Register A Student 👨‍🎓");
        System.out.println("6️⃣  Remove/Show Registered Students 📃");
        System.out.println("7️⃣  Check Out Book 📩");
        System.out.println("8️⃣  Remove Book 🛫");
        System.out.println("𖦹----------------------------------------------------𖦹");
        System.out.println("Choose An Option: ");
        return s.nextInt();
    }

    public static void main(String[] args) {
        BookStore jamazon = new BookStore();
        Scanner s = new Scanner(System.in);
        System.out.println("------⭐ - • Welcome to Jamazon Library • - ⭐------");
        System.out.println("                       Welcome!");
        System.out.println("--------------------= - • ✅ • - =--------------------");
        int choice = Integer.MIN_VALUE;
        boolean done = true;
        while(choice != 0) {
            // PRINT LAYOUT IF ACTION IS FINISHED
            if (done) {
                choice = printLayout();
                done = false;
            }
            // REPEAT ASKING IF THE CHOICES ARE NOT A CHOICE AVAILABLE
            if (choice > 8 || choice < 0) {
                done = true;
            }
            // ADD A NEW BOOK TO THE LIBRARY
            if (choice == 1) {
                String sn;
                String bookName;
                String author;
                int yearP;
                int quant;
                System.out.println("▮▮▮ |] ACTION: ADDING BOOK ---------------- [|");
                // ASKING FOR ALL THE BOOK INFO TO ADD
                System.out.print("Enter the Serial Number of the Book: ");
                sn = s.nextLine();
                System.out.print("Enter the Book Title: ");
                bookName = s.nextLine();
                System.out.print("Enter the Book Author: ");
                author = s.nextLine();
                System.out.print("Enter the Year the Book was Published: ");
                yearP = s.nextInt();
                s.nextLine();
                System.out.print("Quantity of Books Added: ");
                quant = s.nextInt();
                s.nextLine();
                // MAKING A NEW BOOK OBJECT TO ADD TO THE LIST'S END
                jamazon.addBook(new Book(bookName, author, yearP, sn, quant));
                System.out.println("✅ BOOK ADDED ✅");
                // ACTION FINISHED
                done = true;
            }
            // UPGRADING THE QUANTITY OF A BOOK 
            if (choice == 2) {
                System.out.println("▮▮▮ |] ACTION: UPGRADING QUANTITY ---------------- [|");
                System.out.println(jamazon.bookStoreBookInfo());
                System.out.println("• Select A Book (NUMBER) •");
                // FOR THE INDEX OF THE LIST IN THE BOOKSTORE
                int selection = s.nextInt() - 1;
                s.nextLine();
                if (selection < jamazon.getBooks().length) {
                    // TO SELECT NEW QUANTITY
                    System.out.print("New Quantity for " + jamazon.getBooks()[selection].getTitle() + ": ");
                    jamazon.getBooks()[selection].setQuantity(s.nextInt());
                    s.nextLine();
                    System.out.println("! QUANTITY UPDATED !");
                    // IF CHOICE IS INVALID (SUCH AS CHOOSING A BOOK THAT DOESN'T EXIST)
                } while (!(selection < jamazon.getBooks().length)) {
                    System.out.print("| - ⚠️ Invalid Entry, Try Again ⚠️ - |");
                    selection = s.nextInt() - 1;
                }
                // ACTION DONE
                done = true;
            }  
            // SEARCH FOR A BOOK
            if (choice == 3){
                System.out.println("▮▮▮ |] ACTION: SEARCH FOR A BOOK ---------------- [|");
                System.out.println("Choose a Search Method");
                // TWO METHODS, TITLE AND SERIAL NUMBER
                System.out.println("1. Title");
                System.out.println("2. Serial Number");
                // SELECTS THE METHOD BY NUMBER 1 = TITLE , 2 = SN
                int method = s.nextInt();
                s.nextLine();
                // REPEATS IF THE ENTRY IS NOT 1 OR 2
                while (method <= 0 || method > 2) {
                    System.out.println("⚠️ Invalid Option, Try Again ⚠️");
                    method = s.nextInt();
                    s.nextLine();
                }
                // BY TITLE SEARCH
                if (method == 1) {
                    System.out.print("Enter Book Title: ");
                    String enteredTitle = s.nextLine();
                    boolean foundBook = false;
                    // CHECKS THROUGH THE LIST FOR A BOOK WITH THE SAME TITLE AND THEN ENDS THE LOOP WHEN IT FINDS IT WITH THE FOUNDBOOK BOOLEAN VARIABLE
                    for (int i = 0; i < jamazon.getBooks().length; i++) {
                        if (jamazon.getBooks()[i].getTitle().equals(enteredTitle)) {
                            System.out.println(jamazon.getBooks()[i].bookInfo());
                            foundBook = true;
                        }
                        // IF IT DOESNT FIND THE BOOK, REPORT BOOK NOT FOUND
                    } if (!foundBook) {
                        System.out.println("⚠️ BOOK NOT FOUND ⚠️");
                    }
                    // BY THE SERIAL NUMBER
                } if (method == 2) {
                    System.out.print("Enter Book Serial Number: ");
                    String enteredSN = s.nextLine();
                    boolean foundBook = false;
                    // SAME AS ABOVE, BUT FOR SERIAL NUMBER INSTEAD
                    for (int i = 0; i < jamazon.getBooks().length; i++) {
                        if (jamazon.getBooks()[i].getIsbn().equals(enteredSN)) {
                            System.out.println(jamazon.getBooks()[i].bookInfo());
                            foundBook = true;
                        }
                    } if (!foundBook) {
                        System.out.println("⚠️ BOOK NOT FOUND ⚠️");
                    }
                }
                // ACTION COMPLETED
                done = true;
            }
            // SHOW ALL BOOKS
            if (choice == 4) {
                System.out.println("▮▮▮ |] ACTION: SHOW ALL BOOKS ---------------- [|");
                System.out.println(jamazon.bookStoreBookInfo());
                // FOR INSERTING A BOOK, Y FOR YES, N FOR NO
                System.out.println("Would you like to insert a book? (y/n)");
                String option = s.nextLine();
                // IF IT IS YES (Y)
                if (option.toLowerCase().equals("y")) {
                    // PRECONDITION: POSITION MUST BE IN THE LIST ALREADY (CANNOT BE GREATER THAN LIST LENGTH)
                    System.out.println("- Enter Position to Insert -");
                    int position = s.nextInt() - 1;
                    s.nextLine();
                    System.out.println("- Enter Book Info to Insert -");
                    System.out.print("Title: ");
                    String insTitle = s.nextLine();
                    System.out.print("Author: ");
                    String insAuthor = s.nextLine();
                    System.out.print("Serial Number: ");
                    String insBN = s.nextLine();
                    System.out.print("Year Published: ");
                    int insYP = s.nextInt();
                    s.nextLine();
                    System.out.print("Quantity: ");
                    int insQU = s.nextInt();
                    s.nextLine();
                    // INSERTS THE BOOK WITH THE GIVEN DATA
                    jamazon.insertBook(new Book(insTitle, insAuthor, insYP, insBN, insQU), position);
                }
                // ACTION DONE
                done = true;
            }
            // REGISTER A STUDENT
            if (choice == 5) {
                System.out.println("▮▮▮ |] ACTION: REGISTERING A STUDENT ---------------- [|");
                System.out.println("- Add A New Student -");
                System.out.print("👨‍🎓 ");
                // ADDS A NEW USER AS A STUDENT
                jamazon.addUser(new User(s.nextLine(), IdGenerate.generateID()));
                // ACTION COMPLETE
                done = true;
            }
            // SHOW/REMOVE REGISTERED STUDENTS
            if (choice == 6) {
                // SHOWS THE STUDENTS FIRST
                System.out.println("▮▮▮ |] ACTION: SHOW OR EDIT REGISTERED STUDENTS ---------------- [|");
                System.out.println(jamazon.bookStoreUserInfo());
                // ASK FOR REMOVE (Y FOR YES, ANYTHING ELSE FOR NO)
                System.out.print("Would you like to remove a student? ");
                String selection = s.nextLine();
                // IF WE WANNA REMOVE
                if (selection.toLowerCase().equals("y")) {
                    System.out.println("Select ID of Student To Remove");
                    // SELECT THE STUDENT'S ID
                    String studentID = s.nextLine();
                    for (int i = 0; i < jamazon.getUsers().length; i++) {
                        // IF THE ID IS A STUDENT'S ID FROM THE STORE, REMOVE THAT STUDENT
                        if (studentID.equals(jamazon.getUsers()[i].getId())) {
                            User student = jamazon.getUsers()[i];
                            jamazon.removeUser(student);
                            i = jamazon.getUsers().length + 1;
                        }
                    } 
                }

                // ACTION COMPLETE
                done = true;
            }
            // CHECK OUT BOOK
            if (choice == 7) {
                System.out.println("▮▮▮ |] ACTION: CHECK OUT A BOOK FOR A STUDENT ---------------- [|");
                System.out.println(jamazon.bookStoreUserInfo());
                System.out.println("Select ID of Student");
                // PRECONDITION: MUST BE VALID ID
                String studentId = s.nextLine();
                System.out.println(jamazon.bookStoreBookInfo());
                System.out.println("Select Book to Check Out (List Number)");
                // PRECONDITION: MUST BE VALID NUMBER FROM THE LIST
                int bookFromList = s.nextInt() - 1;
                s.nextLine();
                // CHECKS THROUGH EVERY USER
                for (int i = 0; i < jamazon.getUsers().length; i++) {
                    boolean end = false;
                    // IF THE IDS MATCH
                    if (studentId.equals(jamazon.getUsers()[i].getId())) {
                        // MAKE A COPY OF THE BOOK LIST THAT USER HAS THAT HAS THE MATCHING ID
                        Book[] userBookList = new Book[5];
                        for (int k = 0; k < 5; k++) {
                            userBookList[k] = jamazon.getUsers()[i].getBooks()[k];
                        }
                        // CHECKS THROUGH EVERY INDEX IN THAT BOOKLIST
                        // IF ONE OF THEM IS EMPTY, AND THE ACTION HASNT ENDED YET
                        // PUT A NEW BOOK THERE
                        for (int j = 0; j < 5; j++) {
                            if (userBookList[j] == null && !end) {
                                Book book = jamazon.getBooks()[bookFromList];
                                userBookList[j] = new Book(book.getTitle(), book.getAuthor(), book.getYearPublished(), book.getIsbn(), 1);
                                end = true;
                                // IF THE BOOK IS ALREADY THERE JUST ADD TO THE QUANTITY
                            } else if (!end && userBookList[j].getIsbn().equals(jamazon.getBooks()[bookFromList].getIsbn())) {
                                userBookList[j].setQuantity(userBookList[j].getQuantity() + 1);
                                end = true;
                            }
                            // END THE ACTION AFTERWARDS
                        }

                        // REMOVES THE BOOK FROM JAMAZON
                        jamazon.removeBook(jamazon.getBooks()[bookFromList]);
                        jamazon.getUsers()[i].setBooks(userBookList);
                        // ENDS LOOP
                        i = jamazon.getUsers().length + 1;
                    }
                }
                // ACTION COMPLETE
                done = true;
            }
            // REMOVE BOOK
            if (choice == 8) {
                System.out.println("▮▮▮ |] ACTION: CHECK OUT A BOOK FOR A STUDENT ---------------- [|");
                System.out.println(jamazon.bookStoreBookInfo());
                // SELECT A BOOK THEN REMOVE IT
                System.out.println("List Number of Book to Remove");
                int indexNum = s.nextInt() - 1;
                s.nextLine();
                jamazon.removeBook(jamazon.getBooks()[indexNum]);
                // ACTION COMPLETE
                done = true;
            }
        }
    }
}