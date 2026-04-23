package ru.sivkova.fractions;
import ru.sivkova.validator.Validator;

public class ForbiddenFraction extends Fraction{
  // Конструкторы
  //С параметрами
  // FIX_ME: Лишний пробел перед открывающей скобкой
  // FIX_ME: Отсутствует пробел перед фигурной скобкой
  private ForbiddenFraction(int numerator, int denominator) {
    // FIX_ME: Отсутствует пробел после запятой
    super(numerator,denominator);
  }

  //По умолчанию
  // FIX_ME: Отсутствует пробел перед фигурной скобкой
  private ForbiddenFraction() {
    super();
  }

  //Методы создания дроби
  public static ForbiddenFraction create(int numerator, int denominator) {
    return new ForbiddenFraction(numerator, denominator);
  }

  public static ForbiddenFraction create() {
    return new ForbiddenFraction();
  }

  public static ForbiddenFraction create(Fraction fraction) {
    Validator.validateFraction(fraction);
    return new ForbiddenFraction(fraction.getNumerator(), fraction.getDenominator());
  }

  @Override
  public final String toString() {
    return super.toString();
  }

  //Арифметические операции
  //Сумма дробей
  public final ForbiddenFraction sum(Fraction fraction) {
    Fraction result = super.sum(fraction);
    return create(result);
  }

  //Сумма дроби и целого числа
  public final ForbiddenFraction sum(int number) {
    Fraction result = super.sum(number);
    return create(result);
  }

  //Разность дробей
  public final ForbiddenFraction difference(Fraction fraction) {
    Fraction result = super.difference(fraction);
    return create(result);
  }

  //Разность дроби и целого числа
  public final ForbiddenFraction difference(int number) {
    Fraction result = super.difference(number);
    return create(result);
  }

  //Произведение дробей
  public final ForbiddenFraction composition(Fraction fraction) {
    Fraction result = super.composition(fraction);
    return create(result);
  }


  //Произведение дроби и целого числа
  public final ForbiddenFraction composition(int number) {
    Fraction result = super.composition(number);
    return create(result);
  }
  //Деление дробей
  public final ForbiddenFraction division(Fraction fraction) {
    Fraction result = super.division(fraction);
    return create(result);
  }

  //Деление дроби и целого числа
  public final ForbiddenFraction division(int number) {
    Fraction result = super.division(number);
    return create(result);
  }

}
