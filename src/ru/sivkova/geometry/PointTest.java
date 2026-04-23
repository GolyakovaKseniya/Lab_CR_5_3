package ru.sivkova.geometry;

public class PointTest {
  public static void main(String[] args) {
    // FIX_ME: неправильное название объекта класса
    // point1, point2
    Point pointOne = new Point(-8.1, 3.0);
    Point clone = pointOne.clone();
    Point pointTwo = new Point(2, 9);

    System.out.println("Объект point1: " + pointOne);
    System.out.println("Объект clone: " + clone);
    System.out.println("Объект point2: " + pointTwo);

    System.out.println("point1 equals clone: " + pointOne.equals(clone));
    System.out.println("point2 equals clone: " + pointTwo.equals(clone));

    System.out.println("Хэш-код point1: " + pointOne.hashCode());
    System.out.println("Хэш-код clone: " + clone.hashCode());
    System.out.println("Хэш-код point2: " + pointTwo.hashCode());
  }
}
