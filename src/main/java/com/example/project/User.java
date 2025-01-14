package com.example.project;

public class User{
    //requires 3 private attributes String name, String Id, Book book that is initialized to empty
    /**
     * the user's name
     */
    private String name;
    /**
     * the user Id
     */
    private String Id;
    /**
     * List of books, where the user can have a max of 5 books
     */
    private Book[] book = new Book[5];
    //requires 1 contructor with two parameters that will initialize the name and id
    /**
     * creates a user with name n and id i
     * @param n name of the user
     * @param i id of the user
     */
    public User(String n, String i) {
        name = n;
        Id = i;
    }
    public String getName() {return name;}
    public void setName(String n) {name = n;}
    public String getId() {return Id;}
    public void setId(String i) {Id = i;}
    public Book[] getBooks() {return book;}
    public void setBooks(Book[] bk) {book = bk;}

    //returns a booklist for the user, if empty, output "empty"
    // ITERATES THROUGH EVERY BOOK IN THE USERS BOOK LIST, BUT DOESN'T PRINT THE NULL ONES
    /**
     * returns a string with the info of every book in the users booklist and returns empty for ones that are empty
     * @return a string of info about the user's books
     */
    public String bookListInfo() {
        String str = "";
        for (int i = 0; i < book.length; i++) {
            if (book[i] != null) {
                str += book[i].bookInfo() + "\n";
            } else {
                str += "empty\n";
            }
        }
        return str;
    } 
    //returns  "Name: []\nID: []\nBooks:\n[]"
    /**
     * utilize
     * @return info about the user including booklist
     */
    public String userInfo(){
        String str = "";
        str += "Name: "+ name + "\nID: "+ Id +" \nBooks:\n"+ bookListInfo();
        return str;     
    } 

}