package main.java.DreamTeam.Exceptions;

public class CouldNotUpdateQuantityException extends Exception {
  public CouldNotUpdateQuantityException() {
      super("Could not update product quantity.");
  }

  public CouldNotUpdateQuantityException(String message) {
      super(message);
  }
}
