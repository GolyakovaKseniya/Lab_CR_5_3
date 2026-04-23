package ru.sivkova.main;
import ru.sivkova.cities.*;
import ru.sivkova.fractions.*;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
  // FIX_ME: Неправильное название параметров метода
  // public static double power(String strX, String strY) {
  public static double power(String stringX, String stringY) {
    int x = Integer.parseInt(stringX);
    int y = Integer.parseInt(stringY);
    return Math.pow(x,y);
  }
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    // FIX_ME: Неинформативное название переменной
    // int n;
    int numberTask;
    do {
      System.out.println("\n1. Работа с дробями (Fraction)");
      System.out.println("2. Карта дорог (Roads)");
      System.out.println("3. Поиск маршрута (Route)");
      System.out.println("4. Неизменяемые дроби (ForbiddenFraction)");
      System.out.println("5. Дроби с преобразованием типов (FractionIsNumber)");
      System.out.println("6. Сумма чисел разных типов (Addition)");
      System.out.println("7. Сравнение городов (ComparisonCities / TwoWayRoad / Roads)");
      System.out.println("8. Возведение в степень (power)");
      System.out.println("0. Выход из программы");
      System.out.print("Введите номер задачи (для завершения программы введите 0): ");

      // FIX_ME: Добавлена проверка на корректность ввода целых чисел
      try {
        numberTask = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Ошибка: нужно ввести число от 0 до 8");
        scanner.nextLine();
        break;
      }
      scanner.nextLine(); // Очистка буфера
      switch (numberTask) {
        case 0:
          System.out.println("Программа завершена.");
          break;
        case 1: {
          //1.4

          // FIX_ME: Неинформативное название переменной
          // f1, f2, f3, f4, f5, f6, f7, f8
          Fraction fractionOne = new Fraction();
          Fraction fractionTwo = new Fraction(-1, 4);
          Fraction fractionThree = new Fraction(3, -27);
          Fraction fractionFour = new Fraction(-2, -8);
          Fraction fractionFive = new Fraction(5, 10);

          System.out.println("f1 = " + fractionOne);
          System.out.println("f2 = " + fractionTwo);
          System.out.println("f3 = " + fractionThree);
          System.out.println("f4 = " + fractionFour);
          System.out.println("f5 = " + fractionFive);

          // Сложение дробей
          Fraction sumFraction = fractionOne.sum(fractionFive);
          System.out.println(fractionOne + " + " + fractionFive + " = " + sumFraction);

          // Сложение дроби и целого числа
          Fraction sumNumber = fractionFour.sum(2);
          System.out.println(fractionFour + " + 2 = " + sumNumber);

          // Вычитание дробей
          Fraction diffFraction = fractionThree.difference(fractionFour);
          System.out.println(fractionThree + " - " + fractionFour + " = " + diffFraction);

          // Вычитание дроби и целого числа
          Fraction diffNumber = fractionThree.difference(7);
          System.out.println(fractionThree + " - 7 = " + diffNumber);

          // Умножение дробей
          Fraction compFraction = fractionTwo.composition(fractionFive);
          System.out.println(fractionFive + " * " + fractionFive + " = " + compFraction);

          // Умножение дроби и целого числа
          Fraction compNumber = fractionFour.composition(16);
          System.out.println(fractionFour + " * 16 = " + compNumber);

          // Деление дробей
          Fraction divFraction = fractionFive.division(fractionOne);
          System.out.println(fractionFive + " / " + fractionOne + " = " + divFraction);

          // Деление дроби и целого числа
          Fraction divNumber = fractionThree.division(2);
          System.out.println(fractionThree + " / 2 = " + divNumber);

          try {
            Fraction fractionSix = new Fraction(1, 0); //знаменатель 0
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }

          try {
            Fraction fractionSeven = new Fraction(0, 1);
            fractionOne.division(fractionSeven); //деление на нулевую дробь
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }

          try {
            fractionTwo.division(0); //деление на 0
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }

          try {
            Fraction fractionEight = new Fraction(null); //передача дроби null в конструктор копирования
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }

          //f1.setNumerator(5); //нет сеттеров, нельзя менять дробь
          break;
        }

        case 2: {
          //1.10
          Roads cityA = new Roads();
          Roads cityB = new Roads("B");

          try {
            Roads cityC = new Roads(""); //пустое название города
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println();
          }

          Roads cityC = new Roads("C");

          cityA.addWay("B", 3);
          cityA.addWay("C", 12);
          cityC.addWay("A", 9);
          cityC.addWay("B", 2);

          Map<String, Integer> waysD = new HashMap<>();
          waysD.put("A", 5);
          waysD.put("C", 7);
          Roads cityD = new Roads("D", waysD);

          cityB.addWay("D", 6);

          System.out.println("Карта дорог: ");
          System.out.println(cityA);
          System.out.println(cityB);
          System.out.println(cityC);
          System.out.println(cityD);
          System.out.println();

          try {
            cityB.addWay("B", 4); //дорога в себя
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }

          try {
            cityD.addWay("A", 8); //дорога уже существует
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }

          cityA.removeWay("C");
          cityD.removeWay("A");

          try {
            cityB.removeWay("D"); //дороги не существует
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }

          try {
            cityB.addWay("D", -18); //некорректная стоимость
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
            System.out.println();
          }

          System.out.println("Изменённая карта дорог: ");
          System.out.println(cityA);
          System.out.println(cityB);
          System.out.println(cityC);
          System.out.println(cityD);
          System.out.println();

          try {
            Map<String, Integer> waysE = new HashMap<>();
            waysE.put("", 5); //в карте дорог путь с пустым названием города
            waysE.put("C", 7);
            Roads cityE = new Roads("E", waysE);
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }

          try {
            Map<String, Integer> waysE = new HashMap<>();
            waysE.put("A", 5);
            waysE.put("C", -7); //в карте дорог путь с некорректной стоимостью
            Roads cityE = new Roads("E", waysE);
          } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
          }
          break;
        }

        case 3: {
          //2.5
          CreateCities cityA = new CreateCities("A");
          CreateCities cityB = new CreateCities("B");
          CreateCities cityC = new CreateCities("C");
          CreateCities cityD = new CreateCities("D");
          CreateCities cityE = new CreateCities("E");
          CreateCities cityF = new CreateCities("F");

          cityA.addCreateWay("B", 5);
          cityA.addCreateWay("D", 6);
          cityA.addCreateWay("F", 1);

          cityB.addCreateWay("A", 5);
          cityB.addCreateWay("C", 3);

          cityC.addCreateWay("B", 3);
          cityC.addCreateWay("D", 4);

          cityD.addCreateWay("A", 6);
          cityD.addCreateWay("C", 4);
          cityD.addCreateWay("E", 2);

          cityE.addCreateWay("F", 2);

          cityF.addCreateWay("B", 1);
          cityF.addCreateWay("E", 2);

          Map<String, CreateCities> citiesMap = new HashMap<>();
          citiesMap.put("A", cityA);
          citiesMap.put("B", cityB);
          citiesMap.put("C", cityC);
          citiesMap.put("D", cityD);
          citiesMap.put("E", cityE);
          citiesMap.put("F", cityF);

          // FIX_ME: Неинформативное название переменной
          // route1, route2, route3
          Route routeOne = new Route(cityF, cityD, citiesMap);
          System.out.println(routeOne);
          Route routeTwo = new Route(cityA, cityC, citiesMap);
          System.out.println(routeTwo);
          Route routeThree = new Route(cityE, cityC, citiesMap);
          System.out.println(routeThree);
          break;
        }

        case 4: {
          //3.1

          // FIX_ME: Неинформативное название переменной
          // f1, f2, f3, f4, f5
          ForbiddenFraction fractionOne = ForbiddenFraction.create();
          ForbiddenFraction fractionTwo = ForbiddenFraction.create(-1, 4);
          ForbiddenFraction fractionThree = ForbiddenFraction.create(3, -27);
          ForbiddenFraction fractionFour = ForbiddenFraction.create(-2, -8);
          ForbiddenFraction fractionFive = ForbiddenFraction.create(5,10);

          //ForbiddenFraction f5 = new ForbiddenFraction.create(5,10); //использование new для статического метода
          //ForbiddenFraction f5 = new ForbiddenFraction(5,10); //конструкторы приватные

          System.out.println("f1 = " + fractionOne);
          System.out.println("f2 = " + fractionTwo);
          System.out.println("f3 = " + fractionThree);
          System.out.println("f4 = " + fractionFour);
          System.out.println("f5 = " + fractionFive);

          // Сложение дробей
          ForbiddenFraction sumFraction = fractionOne.sum(fractionFive);
          System.out.println(fractionOne + " + " + fractionFive + " = " + sumFraction);

          // Сложение дроби и целого числа
          ForbiddenFraction sumNumber = fractionFour.sum(2);
          System.out.println(fractionFour + " + 2 = " + sumNumber);

          // Вычитание дробей
          ForbiddenFraction diffFraction = fractionThree.difference(fractionFour);
          System.out.println(fractionThree + " - " + fractionFour + " = " + diffFraction);

          // Вычитание дроби и целого числа
          ForbiddenFraction diffNumber = fractionThree.difference(7);
          System.out.println(fractionThree + " - 7 = " + diffNumber);

          // Умножение дробей
          ForbiddenFraction compFraction = fractionTwo.composition(fractionFive);
          System.out.println(fractionFive + " * " + fractionFive + " = " + compFraction);

          // Умножение дроби и целого числа
          ForbiddenFraction compNumber = fractionFour.composition(16);
          System.out.println(fractionFour + " * 16 = " + compNumber);

          // Деление дробей
          ForbiddenFraction divFraction = fractionFive.division(fractionOne);
          System.out.println(fractionFive + " / " + fractionOne + " = " + divFraction);

          // Деление дроби и целого числа
          ForbiddenFraction divNumber = fractionThree.division(2);
          System.out.println(fractionThree + " / 2 = " + divNumber);


          //class Class extends ForbiddenFraction  //final запрещает
          //f1.setNumerator(5); //нет сеттеров, нельзя менять дробь
          break;
        }
        case 5: {
          //4.2
          // FIX_ME: Неинформативное название переменной
          // f1, f2, f3, f4, f5
          FractionIsNumber fractionOne = new FractionIsNumber();
          FractionIsNumber fractionTwo = new FractionIsNumber(-200, -102);
          FractionIsNumber fractionThree = new FractionIsNumber(-1, 4);
          FractionIsNumber fractionFour = new FractionIsNumber(60, 8);
          FractionIsNumber fractionFive = new FractionIsNumber(25, -10);

          System.out.println("f1 = " + fractionOne);
          System.out.println("f2 = " + fractionTwo);
          System.out.println("f3 = " + fractionThree);
          System.out.println("f4 = " + fractionFour);
          System.out.println("f5 = " + fractionFive);

          System.out.println("Преобразование типов:");
          System.out.println("f2: " + fractionTwo.doubleValue() + " (doubleValue())");
          System.out.println("f3: " + fractionThree.floatValue() + " (floatValue())");
          System.out.println("f4: " + fractionFour.longValue() + " (longValue())");
          System.out.println("f5: " + fractionFive.intValue() + " (intValue())");
          break;
        }

        case 6: {
          //5.1
          // FIX_ME: Неинформативное название переменной
          // sum1, sum2, sum3
          double sumOne = Addition.sum(
              Addition.createInteger(2),
              Addition.createFraction(3, 5),
              Addition.createDouble(2.3));
          double sumTwo = Addition.sum(
              Addition.createDouble(3.6),
              Addition.createFraction(49, 12),
              Addition.createInteger(3),
              Addition.createFraction(3, 2));
          double sumThree = Addition.sum(
              Addition.createFraction(1, 3),
              Addition.createInteger(1));

          System.out.println("2 + 3/5 + 2.3 = " + sumOne);
          System.out.println("3.6 + 49/12 + 3 + 3/2 = " + sumTwo);
          System.out.println("1/3 + 1 = " + sumThree);
          break;
        }

        case 7: {
          //6.5
          Map<String, Integer> ways = new HashMap<>();
          ways.put("B", 5);
          ways.put("C", 3);

          // FIX_ME: Неинформативное название переменной
          // A1, A2, A3
          ComparisonCities one = new ComparisonCities("A1", ways);
          TwoWayRoad two = new TwoWayRoad("A2", ways);
          Roads three = new Roads("A3", ways);

          System.out.println("A1 (ComparisonCities) equals A2 (TwoWayRoad): " + one.equals(two));
          System.out.println("A1 (ComparisonCities) equals A3 (Roads): " + one.equals(three));
          System.out.println("A1.hashCode(): " + one.hashCode());
          System.out.println("A2.hashCode(): " + two.hashCode());
          System.out.println("A3.hashCode(): " + three.hashCode());

          two.addTwoWayRoad(new TwoWayRoad("D"), 7);
          three.addWay("D", 7);

          System.out.println("A1 (ComparisonCities) equals A2 (TwoWayRoad): " + one.equals(two));
          System.out.println("A1 (ComparisonCities) equals A3 (Roads): " + one.equals(three));
          System.out.println("A1.hashCode(): " + one.hashCode());
          System.out.println("A2.hashCode(): " + two.hashCode());
          System.out.println("A3.hashCode(): " + three.hashCode());
          break;
        }

        case 8: {
          //7.3
          if (args.length >= 2) {
            // Есть параметры: args[0] и args[1]
            try {
              double result = power(args[0], args[1]);
              System.out.println(args[0] + " в степени " + args[1] + " = " + result);
            } catch (NumberFormatException e) {
              System.out.println("Ошибка: Неверный формат чисел.");
            }
          } else {
            // Параметров нет или только один
            System.out.println("Ошибка: Укажите два параметра.");
          }
          break;
        }

        default:
          System.out.println("Ошибка. Введён несуществующий номер задачи.");
          break;
      }
    } while (numberTask != 0);
  }
}