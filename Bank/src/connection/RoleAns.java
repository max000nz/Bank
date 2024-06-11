package connection;
import enums.InputType;
import java.util.*;


public abstract class RoleAns {
  
  public static String passwordInput(String message, int minLenght, int maxLenght) throws Exception {

    if(maxLenght < minLenght) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if maxLenght is bigger than minLenght.

    String current;
    Scanner input = new Scanner(System.in);
    while(true){
      System.out.println(message + "with lenght between: " + minLenght + " and " + maxLenght);
      current = input.nextLine();
      if (operatorCheck(current, minLenght, maxLenght, InputType.PASSWORD)) {
        input.close();
        return current;
      }
    }
  }

  public static String messageInput(String message, int minLenght, int maxLenght) throws Exception {

    if(maxLenght < minLenght) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if maxLenght is bigger than minLenght.

    String current;
    Scanner input = new Scanner(System.in);
    while(true){
      System.out.println(message + "with lenght between: " + minLenght + " and " + maxLenght);
      current = input.nextLine();
      if (operatorCheck(current, minLenght, maxLenght, InputType.MESSAGE)) {
        input.close();
        return current;
      }
    }
  }

  public static String namesInput(String message, int minLenght, int maxLenght) throws Exception {

    if(maxLenght < minLenght) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if maxLenght is bigger than minLenght.
    
    String current;
    Scanner input = new Scanner(System.in);
    while(true){
      System.out.println(message + "with lenght between: " + minLenght + " and " + maxLenght);
      current = input.nextLine();
      if (operatorCheck(current, minLenght, maxLenght, InputType.NAMES)) {
        input.close();
        return current;
      }
    }
  }

  public static float cashInput(String message, float minValue, float maxValue) throws Exception {

    if(maxValue < minValue) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if maxLenght is bigger than minLenght.

    String current;
    float currFloat;
    Scanner input = new Scanner(System.in);
    while(true){
      System.out.println(message + "between " + minValue + " and " + maxValue);
      current = input.nextLine();
      if (operatorCheck(current, minValue, maxValue, InputType.CASH)) {
        currFloat = Float.parseFloat(current);
        input.close();
        return currFloat;
      }
    }
  }

  public static int idInput(String message, int minValue, int maxValue) throws Exception {

    if(maxValue < minValue) throw new Exception("maxValue has to be >= minValue"); // Throws an exception if maxValue is bigger than minValue.

    String current;
    int currInt = 0;
    Scanner input = new Scanner(System.in);
    while(true){
      System.out.println(message + "between " + minValue + " and " + maxValue);
      current = input.nextLine();
      if (operatorCheck(current, minValue, maxValue, InputType.ID)) { 
        currInt = Integer.parseInt(current);
        input.close();
        return currInt;
      }
    }
  }

  public static int choiceInput(String message, float minValue, float maxValue) throws Exception {

    if(maxValue < minValue) throw new Exception("maxValue has to be >= minValue"); // Throws an exception if maxValue is bigger than minValue.

    String current;
    int currInt;
    Scanner input = new Scanner(System.in);
    while(true){
      System.out.println(message + "between " + minValue + " and " + maxValue);
      current = input.nextLine();
      if (operatorCheck(current, minValue, maxValue, InputType.CHOICE)) {
        currInt = Integer.parseInt(current);
        input.close();
        return currInt;
      }
    }
  }

  private static boolean validationLength(String str, float min, float max, InputType input_type) throws Exception {

    if(max < min) throw new Exception("maxLength has to be >= minLength"); // Throws an exception if max is bigger than min.

    if(input_type == InputType.PASSWORD || input_type == InputType.MESSAGE || input_type == InputType.NAMES){

      if(str.length() > max || str.length() < min){
        return false;
      }
    }

    if(input_type == InputType.CASH  || input_type == InputType.ID || input_type == InputType.CHOICE){

      float num = Float.parseFloat(str);
      if(num > max || num < min) return false;
    }

    return true;
  }

  private static boolean operatorCheck(String str, float min, float max, InputType input_type)
  {
    String operators = "+-*/%^&|<>!=?:,.()_@#$\"'`~[]{}\\;";
    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    if(input_type == InputType.PASSWORD) return true;
    if(input_type == InputType.MESSAGE) return true;

    if(input_type == InputType.ID || input_type == InputType.CHOICE){

      for (char c : str.toCharArray()) {
      
        for(char o : operators.toCharArray()){
          if(c == o) return false;
        }

        c = Character.toLowerCase(c);
        for(char l : alphabet.toCharArray()){
          if(c == l) return false;
        }
      }
    }

    if(input_type == InputType.CASH){

      for (char c : str.toCharArray()) {
        for(char o : operators.toCharArray()){
          int counter = 0;
          if(c == o && c != '.') return false;
          else{
            counter++;
            if(counter >= 2) return false;
          }
          if(c == o) return false;
        }
      }

      for(char c : operators.toCharArray()){
        c = Character.toLowerCase(c);
        for(char l : alphabet.toCharArray()){
          if(c == l) return false;
        }
      }
    }

    if(input_type == InputType.NAMES){

      for (char c : str.toCharArray()) {
        for(char o : operators.toCharArray()){
          if(c == o && c != ' ') return false;
        }
      }
    }

    try {
      if(validationLength(str,min,max,input_type) == false) return false;
    } catch (Exception e) {
      System.err.println(e.getMessage());
      return false;
    }

    return true;
  }
}