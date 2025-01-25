package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books = new Book[0];
    private User[] users = new User[10];
    //requires 1 empty constructor
    public BookStore() {}
    public User[] getUsers(){return users;}
    public void setUsers(User[] u){users = u;}
    public Book[] getBooks(){return books;}
    // Adds a user to the first empty spot of the users list
    /**
     * 
     * @param user the user to be added
     */
    public void addUser(User user){
        boolean isFilled = false;
        // checks every index and if the index is empty and we haven't already filled an index yet, add that user to the index
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null && !isFilled) {
                users[i] = user;
                // isFilled to true to prevent that user from being added to every index
                isFilled = true;
            }
        }
    } 
    // Removes a user from the bookstore list
    /**
     * 
     * @param user the user to be removed
     */
    public void removeUser(User user){
        for (int i = 0; i < users.length; i++) {
            // if that user in the bookstore's matches the id of the user we want to remove, replace it with null
            if (users[i] != null && users[i].getId().equals(user.getId())) {
                users[i] = null;
            }
        }
        // shifts the list over
        consolidateUsers();
    }
    /**
     * Shifts all the users so that all the users fill up the first few spots of the users list
     */
    public void consolidateUsers(){
        for (int i = 0; i < users.length; i++) {
            // if there is a null spot, search the rest of the list for an index that isn't null and pull that user to the current null spot
            // then replace that users old spot with a null, this way only the first instances of nulls will be replaced and all the
            // nulls will be on the right in the end
            if (users[i] == null) {
                for (int j = i; j < users.length; j++) {
                    if (users[j] != null) {
                        users[i] = users[j];
                        users[j] = null;
                        j = users.length;
                    }
                }
            }
        }

    }
    /**
     * adds a book to the book list
     * @param book
     */
    public void addBook(Book book){
        // makes a new list with the length but one more spot for the new book
        Book[] newBooks = new Book[books.length + 1];
        // copies the list without making it a reference to the memory address
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        // adds that book to the very end
        newBooks[books.length] = book;
        // assigns the copy to the original
        books = newBooks;
    }
    // inserts a book at a certain index in the books list
    /**
     * 
     * @param book the book to be inserted
     * @param index the index at which it should be inserted at
     */
    public void insertBook(Book book, int index){
        // if the index has a book already
        Book[] newBook = new Book[books.length + 1];
        // make a copy with one more spot for the new book
        for (int i = 0; i < index; i++) {
            // copies until the index we want, keeping the same as the original
            newBook[i] = books[i];
        }
        // puts the book at that index
        newBook[index] = book;
        // shifts the rest of the books over by 1 spot
        for (int i = index + 1; i < newBook.length; i++) {
            newBook[i] = books[i - 1];
        }
        // sets the original to the copy to avoid memory address referencing
        books = newBook;
    }

    // removes the a certain book from the books list
    /**
     * 
     * @param book the book to be removed
     */
    public void removeBook(Book book){ 
        // iterate through the book list
        for (int i = 0; i < books.length; i++) {
            // check if the isbn is equal
            if (books[i].getIsbn().equals(book.getIsbn())) {
                // takes the quantity and takes one away
                books[i].setQuantity(books[i].getQuantity() - 1);
                if (books[i].getQuantity() == 0){ 
                    // creates a copy with one less for the shortened list
                    Book[] newBooks = new Book[books.length - 1];
                    // if there is no more of that book, remove it entirely from the list
                    int indexNew = 0;
                    for (int j = 0; j < books.length; j++) {
                        if (books[j].getQuantity() != 0) {
                            newBooks[indexNew] = books[j];
                            // adds an index so we can shift it over by 1 when we hit that book
                            indexNew ++;
                        }
                    }
                    // assigns it back
                    books = newBooks;
                }
            }
        }
    }

       /**
        * 
        * @return a string of the bookstore's book info
        */
    public String bookStoreBookInfo(){
        String str = "";
        for (int i = 0; i < books.length ; i ++) {
            str += i + 1 + ". ";
            if (books[i] == null) {
                str += "Empty \n";
            } else {
                str += books[i].bookInfo() + "\n";  
            }
            
        }
        return str;
    } //you are not tested on this method but use it for debugging purposes

    /**
     * 
     * @return a string of the user and their infos
     */
    public String bookStoreUserInfo(){
        String str = "";
        for (int i = 0; i < users.length; i ++) {
            if (users[i] == null) {
                str += "EMPTY SPOT \n";
            } else {
                str += users[i].userInfo() + "\n";
            }
        }
        return str;
    } //you are not tested on this method but use it for debugging purposes

}