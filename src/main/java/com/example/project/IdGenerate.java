package com.example.project;

public class IdGenerate{ //This class contains statics variable and methods, you do not initalize an object to use it.
    
    // //requires 1 private attribute String currentId. You must initialize it to 99
    private static String currentID = "99";
    // //requires one empty constructor
    private IdGenerate(){}

    // RETURNS THE STATIC VARIABLE CURRENTID
    public static String getCurrentId() {return currentID;}
    //must reset the currentId back to 99
    public static void reset() {currentID = "99";}
    //generates a new id, when called it will increment the currentId by 1.. Hint pay attention to data type of currentId
    public static String generateID(){
        // TAKES THE VALUE OF THE STRING AS AN INTEGER AND ADDS 1
        currentID = Integer.toString(Integer.parseInt(currentID) + 1);
        return currentID;
    }
}