package ru.sivkova.validator;
import ru.sivkova.fractions.Fraction;
import ru.sivkova.fractions.FractionIsNumber;
import ru.sivkova.cities.CreateCities;

import java.util.Map;

public class Validator {
  public static void validateDenominator(int denominator) {
    if (denominator == 0) {
      throw new IllegalArgumentException("Знаменатель не может быть равен нулю.");
    }
  }

  public static void validateFraction(Fraction fraction) {
    if (fraction == null) {
      throw new IllegalArgumentException("Дробь не может быть null");
    }
    if (fraction.getNumerator() == 0) {
      throw new ArithmeticException("Деление на нулевую дробь.");
    }
  }

  public static void validateNumber(int number) {
    if (number == 0) {
      throw new ArithmeticException("Деление на ноль.");
    }
  }

  // FIX_ME: Отсутствует пробел перед фигурной скобкой
  public static void validateTitle(String title) {
    if (title == null || title.length() == 0) {
      throw new IllegalArgumentException("Название города не может быть пустым.");
    }
  }

  public static void validateCost(int cost) {
    if (cost <= 0) {
      throw new IllegalArgumentException("Некорректное значение стоимости пути.");
    }
  }

  public static void validateWays(Map<String, Integer> ways) {
    for (Map.Entry<String, Integer> entry : ways.entrySet()) {
      validateTitle(entry.getKey());
      validateCost(entry.getValue());
    }
  }

  public static void validateCity(CreateCities city) {
    if (city == null) {
      throw new IllegalArgumentException("Город не может быть null");
    }
  }

  public static void validateFractionIsNumber(FractionIsNumber fraction) {
    if (fraction == null) {
      throw new IllegalArgumentException("Дробь не может быть null");
    }
    if (fraction.getNumerator() == 0) {
      throw new ArithmeticException("Деление на нулевую дробь.");
    }
  }
}
