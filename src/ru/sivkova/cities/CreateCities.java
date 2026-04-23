package ru.sivkova.cities;
import ru.sivkova.validator.Validator;

import java.util.HashMap;
import java.util.Map;

public class CreateCities {
  //Поля
  private String createTitle;
  private Map<String, Integer> createWays;

  //Свойства
  public String getCreateTitle() {
    return createTitle;
  }

  public Map<String, Integer> getCreateWays() {
    return createWays;
  }

  public void setCreateTitle(String createTitle) {
    Validator.validateTitle(createTitle);
    this.createTitle = createTitle;
  }

  public void setCreateWays(Map<String, Integer> createWays) {
    this.createWays = createWays;
  }

  //Конструкторы
  //По умолчанию
  // FIX_ME: Отсутствует пробел перед фигурной скобкой
  public CreateCities() {
    this.createTitle = "Москва";
    this.createWays = new HashMap<>();
  }

  //С параметрами
  public CreateCities(String createTitle) {
    Validator.validateTitle(createTitle);
    this.createTitle = createTitle;
    this.createWays = new HashMap<>();
  }

  public CreateCities(String createTitle, Map<String, Integer> createWays) {
    Validator.validateTitle(createTitle);
    this.createTitle = createTitle;
    this.createWays = new HashMap<>(createWays);
  }

  //Добавление пути
  public void addCreateWay(String city, int cost) {
    Validator.validateTitle(city);
    Validator.validateCost(cost);
    this.createWays.put(city, cost);
  }

  //Копирования
  public CreateCities(CreateCities createCities) {
    this.createTitle = createCities.createTitle;
    this.createWays = new HashMap<>(createCities.createWays);
  }

  @Override
  public String toString() {
    String result = "";
    if (createWays.isEmpty()) {
      return "Из города " + createTitle + " нет путей.";
    }
    result = "Набор путей из города " + createTitle + " (название: стоимость).  ";
    for (Map.Entry<String, Integer> entry : createWays.entrySet()) {
      result += entry.getKey() + ": " + entry.getValue() + "; ";
    }
    return result;
  }
}