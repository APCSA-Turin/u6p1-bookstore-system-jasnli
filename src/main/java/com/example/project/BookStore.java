package com.example.project;

public class BookStore{

    //requires at least 2 attributes Book[] books, User[] users (initialized to an empty array of 10 max users) 
    private Book[] books;
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
        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
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
            if (users[i].getId() == user.getId()) {
                users[i] = null;
            }
        }
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
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
            }
        }
    }
    // inserts a book at a certain index in the books list
    /**
     * 
     * @param book the book to be inserted
     * @param index the index at which it should be inserted at
     */
    public void insertBook(Book book, int index){
        if (books[index] != null) {
            Book[] newBooks = new Book[books.length + 1];
            for (int i = 0; i < books.length; i++) {
                if (i == index) {
                    newBooks[i + 1] = books[i];
                    newBooks[index] = book;
                } else {
                    newBooks[i] = books[i];
                }
            }
        } else {
            books[index] = book;
        }
        
    }
    // removes the a certain book from the books list
    public void removeBook(Book book){}
       
    public String bookStoreBookInfo(){} //you are not tested on this method but use it for debugging purposes

    public String bookStoreUserInfo(){} //you are not tested on this method but use it for debugging purposes

}