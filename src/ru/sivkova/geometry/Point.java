package ru.sivkova.geometry;
import java.util.Objects;
public class Point {
  private double x;
  private double y;

  public double getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  public void setX(double x) {
    this.x = x;
  }

  public void setY(double y) {
    this.y = y;
  }

  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  // FIX_ME: Отсутствует модификатор доступа (package-private)
  // Point(Point point) {
  public Point(Point point) {
    this.x = point.x;
    this.y = point.y;
  }

  @Override
  public String toString() {
    return "{" + x + ";" + y + "}";
  }

  @Override
  public boolean equals(Object object) {
    // FIX_ME: Лишний пробел перед открывающей скобкой
    if(this == object) {
      return true;
    }
    if(object == null) {
      return false;
    }
    if(!(object instanceof Point)) {
      return false;
    }
    Point point = (Point) object;

    // FIX_ME: Отсутствуют фигурные скобки для if (Google Style требует скобки всегда)
    if(this.x == point.x && this.y == point.y) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(x, y);
  }

  @Override
  protected Point clone() {
    return new Point(this);
  }
}
