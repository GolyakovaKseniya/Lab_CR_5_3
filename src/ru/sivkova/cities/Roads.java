package ru.sivkova.cities;
import ru.sivkova.validator.Validator;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Roads {
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
    if (ways.containsKey(this.title)) {
      throw new IllegalArgumentException("Нельзя создать дорогу в тот же город.");
    }
    if (ways.size() != new HashMap<>(ways).size()) {
      throw new IllegalArgumentException("Набор путей содержит дублирующиеся города.");
    }
    this.ways = ways;
  }

  //Конструкторы
  //По умолчанию
  // FIX_ME: Отсутствует пробел перед фигурной скобкой
  public Roads() {
    this.title = "A";
    this.ways = new HashMap<>();
  }

  //С параметрами
  //Создание города
  public Roads(String title) {
    Validator.validateTitle(title);
    this.title = title;
    this.ways = new HashMap<>();
  }

  //Создание города с готовыми путями
  public Roads(String title, Map<String, Integer> ways) {
    Validator.validateTitle(title);
    Validator.validateWays(ways);
    if (ways.containsKey(title)) {
      throw new IllegalArgumentException("Нельзя создать дорогу в тот же город.");
    }
    if (ways.size() != new HashMap<>(ways).size()) {
      throw new IllegalArgumentException("Набор путей содержит дублирующиеся города.");
    }
    this.title = title;
    this.ways = new HashMap<>(ways);
  }

  //Копирования
  public Roads(Roads roads) {
    this.title = roads.title;
    this.ways = new HashMap<>(roads.ways);
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

  // Определение хэш-кода для задачи 6.5
  @Override
  public int hashCode() {
    return Objects.hash(getWays());
  }
}
