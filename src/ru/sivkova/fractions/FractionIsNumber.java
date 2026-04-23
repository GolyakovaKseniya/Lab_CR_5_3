package ru.sivkova.fractions;
import ru.sivkova.validator.Validator;

public class FractionIsNumber extends Number{
  //Поля
  private final int numerator;
  private final int denominator;

  //Свойства
  // FIX_ME: Лишние пустые строки внутри метода
  public int getNumerator() {
    return numerator;
  }

  public int getDenominator() {
    return denominator;
  }

  //Конструкторы
  //По умолчанию
  // FIX_ME: Отсутствует пробел перед фигурной скобкой
  public FractionIsNumber() {
    this.numerator = 2;
    this.denominator = 3;
  }

  //С параметрами
  public FractionIsNumber(int numerator, int denominator) {
    Validator.validateDenominator(denominator);
    if (denominator < 0) {
      numerator = -numerator;
      denominator = -denominator;
    }

    // FIX_ME: Неинформативное название переменной
    // int nod = gcd(numerator, denominator);
    int gcd = gcd(numerator, denominator);
    this.numerator = numerator / gcd;
    this.denominator = denominator / gcd;
  }

  //Копирования
  public FractionIsNumber(FractionIsNumber fraction) {
    Validator.validateFractionIsNumber(fraction);
    this.numerator = fraction.numerator;
    this.denominator = fraction.denominator;
  }

  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  @Override
  public int intValue() {
    Validator.validateDenominator(denominator);
    return numerator / denominator;
  }

  @Override
  public long longValue() {
    Validator.validateDenominator(denominator);
    return (long) numerator / (long) denominator;
  }

  @Override
  public double doubleValue() {
    Validator.validateDenominator(denominator);
    return (double) numerator / (double) denominator;
  }

  @Override
  public float floatValue() {
    Validator.validateDenominator(denominator);
    return (float) numerator / (float) denominator;
  }

  //Арифметические операции
  //Сумма дробей
  public FractionIsNumber sum(FractionIsNumber fraction) {
    int newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
    int newDenominator = this.denominator * fraction.denominator;
    return new FractionIsNumber(newNumerator, newDenominator);
  }

  //Сумма дроби и целого числа
  public FractionIsNumber sum(int number) {
    return sum(new FractionIsNumber(number, 1));
  }

  //Разность дробей
  public FractionIsNumber difference(FractionIsNumber fraction) {
    int newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
    int newDenominator = this.denominator * fraction.denominator;
    return new FractionIsNumber(newNumerator, newDenominator);
  }

  //Разность дроби и целого числа
  public FractionIsNumber difference(int number) {
    return difference(new FractionIsNumber(number, 1));
  }

  //Произведение дробей
  public FractionIsNumber composition(FractionIsNumber fraction) {
    int newNumerator = this.numerator * fraction.numerator;
    int newDenominator = this.denominator * fraction.denominator;
    return new FractionIsNumber(newNumerator, newDenominator);
  }

  //Произведение дроби и целого числа
  public FractionIsNumber composition(int number) {
    return composition(new FractionIsNumber(number, 1));
  }

  //Деление дробей
  public FractionIsNumber division(FractionIsNumber fraction) {
    Validator.validateFractionIsNumber(fraction);
    int newNumerator = this.numerator * fraction.denominator;
    int newDenominator = this.denominator * fraction.numerator;
    return new FractionIsNumber(newNumerator, newDenominator);
  }

  //Деление дроби и целого числа
  public FractionIsNumber division(int number) {
    Validator.validateNumber(number);
    return division(new FractionIsNumber(number, 1));
  }

  //НОД (метод Евклида)
  // FIX_ME: Неправильное название метода
  // private int NOD(int a, int b) {
  private int gcd(int a, int b) {
    a = Math.abs(a);
    b = Math.abs(b);
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }
}
