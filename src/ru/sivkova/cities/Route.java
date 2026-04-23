package ru.sivkova.cities;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import ru.sivkova.validator.Validator;
public class Route {
  //Поля
  private CreateCities startCity;
  private CreateCities endCity;
  private Map<String, CreateCities> citiesMap;

  //Свойства
  public CreateCities getStartCity() {
    return startCity;
  }

  public CreateCities getEndCity() {
    return endCity;
  }

  public void setStartCity(CreateCities startCity) {
    Validator.validateCity(startCity);
    this.startCity = startCity;
  }

  public void setEndCity(CreateCities endCity) {
    Validator.validateCity(endCity);
    this.endCity = endCity;
  }

  //Конструкторы
  //С параметрами
  public Route(CreateCities startCity, CreateCities endCity, Map<String, CreateCities> citiesMap) {
    Validator.validateCity(startCity);
    Validator.validateCity(endCity);
    this.startCity = startCity;
    this.endCity = endCity;

    // FIX_ME: Две точки с запятой в конце строки
    this.citiesMap = new HashMap<>(citiesMap);
  }

  //Копирования
  public Route(Route route) {
    this.startCity = route.startCity;
    this.endCity = route.endCity;
    this.citiesMap = new HashMap<>(route.citiesMap);
  }

  //Получение массива
  public CreateCities[] getRoute() {
    List<CreateCities> way = new ArrayList<>();
    boolean wayFound = findWay(startCity, endCity.getCreateTitle(), way);
    // FIX_ME: Отсутствует пробел перед фигурной скобкой
    // FIX_ME: Отсутствует пробел после if
    if (wayFound) {
      return way.toArray(new CreateCities[0]);
    }
    return new CreateCities[0];
  }

  @Override
  public String toString() {
    CreateCities[] route = getRoute();

    // FIX_ME: Отсутствует пробел после if
    if (route.length == 0) {
      return "Маршрут между " + startCity.getCreateTitle() + " и " + endCity.getCreateTitle() + " не найден";
    }
    String result = "Маршрут: ";
    for (int i = 0; i < route.length; i++) {
      result += route[i].getCreateTitle();
      if (i < route.length -1) {
        result += " -> ";
      }
    }
    return result;
  }

  private boolean findWay(CreateCities current, String endCity, List<CreateCities> way) {
    for (CreateCities visit : way) {
      if (visit.getCreateTitle().equals((current.getCreateTitle()))) {
        return false; //Уже посещали текущий город
      }
    }
    way.add(current);
    if (current.getCreateTitle().equals(endCity)) {
      return true; //Достигли конечного города
    }
    Map<String, Integer> ways = current.getCreateWays(); //Получаем карту дорог из текущего города
    for (String neighborCity : ways.keySet()) {
      CreateCities neighbor = citiesMap.get(neighborCity);
      if (findWay(neighbor, endCity, way)) {
        return true;
      }
    }
    way.remove(way.size() - 1); //Путь не найден - удаляем текущий город из пути
    return false;
  }
}
