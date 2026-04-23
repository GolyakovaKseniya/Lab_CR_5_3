package ru.sivkova.fractions;
import ru.sivkova.validator.Validator;
public class Fraction {
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
  public Fraction() {
    this.numerator = 2;
    this.denominator = 3;
  }

  //С параметрами
  public Fraction(int numerator, int denominator) {
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
  public Fraction(Fraction fraction) {
    Validator.validateFraction(fraction);
    this.numerator = fraction.numerator;
    this.denominator = fraction.denominator;
  }

  @Override
  public String toString() {
    return numerator + "/" + denominator;
  }

  //Арифметические операции
  //Сумма дробей
  public Fraction sum(Fraction fraction) {
    int newNumerator = this.numerator * fraction.denominator + fraction.numerator * this.denominator;
    int newDenominator = this.denominator * fraction.denominator;
    return new Fraction(newNumerator, newDenominator);
  }

  //Сумма дроби и целого числа
  public Fraction sum(int number) {
    return sum(new Fraction(number, 1));
  }

  //Разность дробей
  public Fraction difference(Fraction fraction) {
    int newNumerator = this.numerator * fraction.denominator - fraction.numerator * this.denominator;
    int newDenominator = this.denominator * fraction.denominator;
    return new Fraction(newNumerator, newDenominator);
  }

  //Разность дроби и целого числа
  public Fraction difference(int number) {
    return difference(new Fraction(number, 1));
  }

  //Произведение дробей
  public Fraction composition(Fraction fraction) {
    int newNumerator = this.numerator * fraction.numerator;
    int newDenominator = this.denominator * fraction.denominator;
    return new Fraction(newNumerator, newDenominator);
  }

  //Произведение дроби и целого числа
  public Fraction composition(int number) {
    return composition(new Fraction(number, 1));
  }

  //Деление дробей
  public Fraction division(Fraction fraction) {
    Validator.validateFraction(fraction);
    int newNumerator = this.numerator * fraction.denominator;
    int newDenominator = this.denominator * fraction.numerator;
    return new Fraction(newNumerator, newDenominator);
  }

  //Деление дроби и целого числа
  public Fraction division(int number) {
    Validator.validateNumber(number);
    return division(new Fraction(number, 1));
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
