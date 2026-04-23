package ru.sivkova.main;
import ru.sivkova.fractions.Fraction;

public class Addition {
  // FIX_ME: Неинформативное название интерфейса
  // interface SummVal {
  interface Summable {
    double toDouble();
  }

  // FIX_ME: Класс должен быть static, чтобы не зависеть от экземпляра Addition
  // FIX_ME: Неинформативное название класса
  // public class FractionVal implements Summable {
  public static class FractionValue implements Summable {
    private Fraction value;

    public FractionValue(int numerator, int denominator) {
      this.value = new Fraction(numerator, denominator);
    }

    @Override
    public double toDouble() {
      return (double) value.getNumerator() / value.getDenominator();
    }

    @Override
    public String toString() {
      return value.toString();
    }
  }

  // FIX_ME: Класс должен быть static, чтобы не зависеть от экземпляра Addition
  // FIX_ME: Неинформативное название класса
  // class IntegerVal implements Summable {
  public static class IntegerValue implements Summable {
    private int value;

    public IntegerValue(int value) {
      this.value = value;
    }

    @Override
    public double toDouble() {
      return (double) value;
    }

    @Override
    public String toString() {
      return Integer.toString(value);
    }
  }

  // FIX_ME: Класс должен быть static, чтобы не зависеть от экземпляра Addition
  // FIX_ME: Неинформативное название класса
  // class DoubleVal implements Summable {
  public static class DoubleValue implements Summable {
    private double value;

    public DoubleValue(double value) {
      this.value = value;
    }

    @Override
    public double toDouble() {
      return value;
    }

    @Override
    public String toString() {
      return Double.toString(value);
    }
  }

  // FIX_ME: Создаёт экземпляр Addition, хотя методы статические — неэффективно
  public static Summable createFraction(int numerator, int denominator) {
    Addition addition = new Addition();

    // return addition.new FractionValue(numerator, denominator);
    return new FractionValue(numerator, denominator);
  }

  public static Summable createInteger(int value) {
    Addition addition = new Addition();
    return new IntegerValue(value);
  }

  public static Summable createDouble(double value) {
    Addition addition = new Addition();
    return new DoubleValue(value);
  }

  public static double sum(Summable... values) {
    double result = 0;

    // FIX_ME: Неинформативное название переменной
    // for (Summable val : values) {
    for (Summable value : values) {
      result += value.toDouble();
    }
    return result;
  }
}
