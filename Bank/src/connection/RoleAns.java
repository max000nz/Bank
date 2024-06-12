package connection;
import enums.InputType;
import java.util.Scanner;


public abstract class RoleAns {
  
  public static String passwordInput(String message, int minLenght, int maxLenght, Scanner input) throws Exception {
    try {
      if(maxLenght < minLenght) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if maxLenght is bigger than minLenght.
      String current;
      while(true){
        System.out.println(message + "with length between: " + minLenght + " and " + maxLenght);
        current = input.nextLine();
        if (operatorCheck(current, minLenght, maxLenght, InputType.PASSWORD)) {
          return current;
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return null;
    }
  }

  public static String messageInput(String message, int minLenght, int maxLenght, Scanner input) throws Exception {
    try {
      if(maxLenght < minLenght) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if maxLenght is bigger than minLenght.

      String current;
      while(true){
        System.out.println(message + "with length between: " + minLenght + " and " + maxLenght);
        current = input.nextLine();
        if (operatorCheck(current, minLenght, maxLenght, InputType.MESSAGE)) {
          return current;
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return null;
    }
  }

  public static String namesInput(String message, int minLenght, int maxLenght, Scanner input) throws Exception {
    try {
      if(maxLenght < minLenght) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if maxLenght is bigger than minLenght.
    
      String current;
      while(true){
        System.out.println(message + "with length between: " + minLenght + " and " + maxLenght);
        current = input.nextLine();
        if (operatorCheck(current, minLenght, maxLenght, InputType.NAMES)) {
          return current;
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return null;
    }
  }

  public static float cashInput(String message, float minValue, float maxValue, Scanner input) throws Exception {
    try {
      if(maxValue < minValue) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if maxLenght is bigger than minLenght.

      String current;
      float currFloat;
      while(true){
        System.out.println(message + "between " + minValue + " and " + maxValue);
        current = input.nextLine();
        if (operatorCheck(current, minValue, maxValue, InputType.CASH)) {
          currFloat = Float.parseFloat(current);
          return currFloat;
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return 0;
    }
  }

  public static int idInput(String message, int minValue, int maxValue, Scanner input) throws Exception {
    try {
      if(maxValue < minValue) throw new Exception("maxValue has to be >= minValue"); // Throws an exception if maxValue is bigger than minValue.
      String current;
      int currInt = 0;
      while(true){
        System.out.println(message + "between " + minValue + " and " + maxValue);
        current = input.nextLine();
        if (operatorCheck(current, minValue, maxValue, InputType.ID)) { 
          currInt = Integer.parseInt(current);
          return currInt;
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return 0;
    }
  }

  public static int choiceInput(String message, float minValue, float maxValue, Scanner input) throws Exception {
    try {
      if(maxValue < minValue) throw new Exception("maxValue has to be >= minValue"); // Throws an exception if maxValue is bigger than minValue.

      String current;
      int currInt;
      while(true){
        System.out.println(message + "between " + minValue + " and " + maxValue);
        current = input.nextLine();
        if (operatorCheck(current, minValue, maxValue, InputType.CHOICE)) {
          currInt = Integer.parseInt(current);
          return currInt;
        }
      }
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return -1;
    }
  }

  private static void validationLength(String str, float min, float max, InputType input_type) throws Exception {

    if(max < min) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if max is bigger than min.

    if(input_type == InputType.PASSWORD || input_type == InputType.MESSAGE || input_type == InputType.NAMES){

      if(str.length() > max || str.length() < min){
        throw new Exception("Input length is out of range");
      }
    }

    if(input_type == InputType.CASH  || input_type == InputType.ID || input_type == InputType.CHOICE){

      float num = Float.parseFloat(str);
      if(num > max || num < min) throw new Exception("Input length is out of range");
    }
  }

  private static boolean operatorCheck(String str, float min, float max, InputType input_type) throws Exception
  {
    String operators = "+-*/%^&|<>!=?:,.()_@#$\"'`~[]{}\\;";
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    if(input_type == InputType.PASSWORD) return true;
    if(input_type == InputType.MESSAGE) return true;

    if(input_type == InputType.ID || input_type == InputType.CHOICE){

      for (char c : str.toCharArray()) {
      
        for(char o : operators.toCharArray()){
          if(c == o) throw new Exception("Special letters are not allowed!");
        }

        c = Character.toLowerCase(c);
        for(char l : alphabet.toCharArray()){
          if(c == l) throw new Exception("Alphabet letters are not allowed!");
        }
      }
    }

    if(input_type == InputType.CASH){

      for (char c : str.toCharArray()) {
        for(char o : operators.toCharArray()){
          int counter = 0;
          if(c == o && c != '.') throw new Exception("Special letters are not allowed!"); // Dots are allowed
          else if (c == o && c == '.'){
            counter++;
            if(counter >= 2) throw new Exception("You have entered too many dots!"); // Only 1 dot is allowed
          }
        }
      }

      for(char c : operators.toCharArray()){
        c = Character.toLowerCase(c);
        for(char l : alphabet.toCharArray()){
          if(c == l) throw new Exception("Alphabet letters are not allowed!");
        }
      }
    }

    if(input_type == InputType.NAMES){

      for (char c : str.toCharArray()) {
        for(char o : operators.toCharArray()){
          if(c == o && c != ' ') throw new Exception("Special letters are not allowed!"); // Spaces are allowed
        }
      }
    }

    try {
      validationLength(str,min,max,input_type);
    } catch (Exception e) {
      throw new Exception(e.getMessage());
    }

    return true;
  }
}