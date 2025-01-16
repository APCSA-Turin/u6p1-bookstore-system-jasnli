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
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null && !isFilled) {
                users[i] = user;
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
            if (users[i] != null && users[i].getId().equals(user.getId())) {
                users[i] = null;
            }
        }
        consolidateUsers();
    }
    /**
     * Shifts all the users so that all the users fill up the first few spots of the users list
     */
    public void consolidateUsers(){
        for (int i = 0; i < users.length; i++) {
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
        Book[] newBooks = new Book[books.length + 1];
        for (int i = 0; i < books.length; i++) {
            newBooks[i] = books[i];
        }
        newBooks[books.length] = book;
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
        for (int i = 0; i < index; i++) {
            newBook[i] = books[i];
        }
        newBook[index] = book;
        for (int i = index + 1; i < newBook.length; i++) {
            newBook[i] = books[i - 1];
        }
        books = newBook;
    }
    // removes the a certain book from the books list
    public void removeBook(Book book){ 
        for (int i = 0; i < books.length; i++) {
            if (books[i].getIsbn().equals(book.getIsbn())) {
                books[i].setQuantity(books[i].getQuantity() - 1);
                if (books[i].getQuantity() == 0){ 
                    Book[] newBooks = new Book[books.length - 1];
                    int indexNew = 0;
                    for (int j = 0; j < books.length; j++) {
                        if (books[j].getQuantity() != 0) {
                            newBooks[indexNew] = books[j];
                            indexNew ++;
                        }
                    }
                    books = newBooks;
                }
            }
        }
    }

       
    public String bookStoreBookInfo(){
        String str = "";
        for (int i = 0; i < books.length ; i ++) {
            if (books[i] == null) {
                str += "empty \n";
            } else {
                str += books[i].bookInfo() + "\n";  
            }
            
        }
        return str;
    } //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo(){
        String str = "";
        for (int i = 0; i < users.length; i ++) {
            if (users[i] == null) {
                str += "null \n";
            } else {
                str += users[i].userInfo() + "\n";
            }
        }
        return str;
    } //you are not tested on this method but use it for debugging purposes

}