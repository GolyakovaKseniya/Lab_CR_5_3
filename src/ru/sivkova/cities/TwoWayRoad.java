package ru.sivkova.cities;
import java.util.Map;
import java.util.Objects;

public class TwoWayRoad extends Roads {
  // Конструкторы
  //По умолчанию
  public TwoWayRoad() {
    super();
  }

  //С параметрами
  //Создание города
  public TwoWayRoad(String title) {
    super(title);
  }

  //Создание города с готовыми путями
  public TwoWayRoad(String title, Map<String, Integer> ways) {
    super(title, ways);
  }

  //Копирования
  public TwoWayRoad(Roads roads) {
    super(roads);
  }

  //Добавление дороги в двух направлениях
  public void addTwoWayRoad(TwoWayRoad city, int cost) {
    super.addWay(city.getTitle(), cost);
    city.superAddWay(this.getTitle(), cost);
  }

  private void superAddWay(String city, int cost) {
    super.addWay(city, cost);
  }

  //Удаления дороги в обоих направлениях
  public void removeTwoWayRoad(TwoWayRoad otherCity) {
    super.removeWay(otherCity.getTitle());
    otherCity.superRemoveWay(this.getTitle());
  }

  private void superRemoveWay(String city) {
    super.removeWay(city);
  }

  @Override
  public int hashCode() {
    return Objects.hash(getWays());
  }
}
