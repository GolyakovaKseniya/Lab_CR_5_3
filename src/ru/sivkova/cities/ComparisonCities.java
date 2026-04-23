package ru.sivkova.cities;
import ru.sivkova.validator.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ComparisonCities {
  //Поля
  private String title;
  private Map<String, Integer> ways;

  //Свойства
  public String getTitle() {
    return title;
  }

  public Map<String, Integer> getWays() {
    return new HashMap<>(ways);
  }

  public void setTitle(String title) {
    Validator.validateTitle(title);
    this.title = title;
  }

  public void setWays(Map<String, Integer> ways) {
    Validator.validateWays(ways);
    this.ways = ways;
  }

  //Конструкторы
  //По умолчанию
  // FIX_ME: Отсутствует пробел перед фигурной скобкой
  public ComparisonCities() {
    this.title = "A";
    this.ways = new HashMap<>();
  }

  //С параметрами
  //Создание города
  public ComparisonCities(String title) {
    Validator.validateTitle(title);
    this.title = title;
    this.ways = new HashMap<>();
  }

  //Создание города с готовыми путями
  public ComparisonCities(String title, Map<String, Integer> ways) {
    Validator.validateTitle(title);
    Validator.validateWays(ways);
    if (ways.containsKey(title)) {
      throw new IllegalArgumentException("Нельзя создать дорогу в тот же город.");
    }
    this.title = title;
    this.ways = new HashMap<>(ways);
  }

  //Копирования
  public ComparisonCities(ComparisonCities city) {
    this.title = city.title;
    this.ways = new HashMap<>(city.ways);
  }

  //Добавление пути
  public void addWay(String city, int cost) {
    Validator.validateTitle(city);
    Validator.validateCost(cost);
    if (ways.containsKey(city)) {
      throw new IllegalStateException("Дорога в город " + city + " уже существует.");
    }
    if (this.title.equals(city)) {
      throw new IllegalStateException("Нельзя создать дорогу в тот же город.");
    }
    this.ways.put(city, cost);
  }

  //Удаление пути
  public void removeWay(String city) {
    if (!ways.containsKey(city)) {
      throw new IllegalStateException("Дороги в город " + city + " не существует.");
    }
    ways.remove(city);
  }

  @Override
  public String toString() {
    String result = "";
    if (ways.isEmpty()) {
      return "Из города " + title + " нет путей.";
    }
    result = "Набор путей из города " + title + " (название: стоимость).";
    for (Map.Entry<String, Integer> city : ways.entrySet()) {
      result += city.getKey() + ": " + city.getValue() + ";";
    }
    return result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    Map<String, Integer> newWays;
    if (object instanceof ComparisonCities) {
      newWays = ((ComparisonCities) object).ways;
    } else if (object instanceof TwoWayRoad) {
      newWays = ((TwoWayRoad) object).getWays();
    } else if (object instanceof Roads) {
      newWays = ((Roads) object).getWays();
    } else {
      return false;
    }
    return Objects.equals(this.ways, newWays);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ways);
  }
}