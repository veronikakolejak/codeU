package RearrangingCars;

public class Move {
  int carNumber;
  int origin;
  int destination;

  public Move(int car, int start, int end) {
    this.carNumber = car;
    this.origin = start;
    this.destination = end;
  }

  public void printMove() {
    System.out.println("Move car number " + carNumber + " at " + origin + " to position " + destination);
  }
}
