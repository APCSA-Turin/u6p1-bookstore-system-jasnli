package com.example.project;

public class Book{
    //requires 5 attributes String title, String author, int yearPublished, String isbn, int quantity
    /** 
     * the title of the book
     * the author of the book
     * the year published
     * the international standard book number
     * the quantity
     */
    private String title;
    private String author;
    private int yearPublished;
    private String isbn;
    private int quantity;
    //requires 1 constructor with 5 arguments that intitialize the attribtues of the class.
    /**
     * 
     * @param t the title of the book
     * @param a the author of the book
     * @param yP the year the book was published
     * @param isbn the international standard book number
     * @param q the quantity of the book
     */
    public Book(String t, String a, int yP, String isbn, int q){ 
        title = t;
        author = a;
        yearPublished = yP;
        this.isbn = isbn;
        quantity = q;
    }
    /**
     * 
     * @return the title of the book
     */
    public String getTitle() {
        return title;
    }
    /**
     * 
     * @param nt the new title
     */
    public void setTitle(String nt) {
        title = nt;
    }
    /**
     * 
     * @return the author
     */
    public String getAuthor() {return author;}
    /**
     * 
     * @param a the new author
     */
    public void setAuthor(String a) {author = a;}
    /**
     * 
     * @return the year published
     */
    public int getYearPublished() {return yearPublished;}
    /**
     * 
     * @param yp the new year published
     */
    public void setYearPublished(int yp) {yearPublished = yp;}
    /**
     * 
     * @return the international standard book number
     */
    public String getIsbn() {return isbn;}
    /**
     * 
     * @param newbn the new bn
     */
    public void setIsbn(String newbn) {isbn = newbn;}
    /**
     * 
     * @return the quantity of the book
     */
    public int getQuantity() {return quantity;}
    /**
     * 
     * @param nq the new quantity
     */
    public void setQuantity(int nq) {quantity = nq;}
    /**
     * Generates the attributes of the books
     * @return the info of the book
     */
    public String bookInfo() {
        return "Title: " + title + ", Author: "+ author + ", Year: "+ yearPublished +", ISBN: "+ isbn+ ", Quantity: " + quantity;
    }
       
}