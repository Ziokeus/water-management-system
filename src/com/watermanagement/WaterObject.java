package com.watermanagement;

public class WaterObject {
    // ПОЛЯ (характеристики объекта)
    private int id;
    private String name;
    private String type;

    // КОНСТРУКТОР (способ создания объекта)
    public WaterObject(int id, String name, String type) {
        this.id=id;
        this.name=name;
        this.type=type;
    }
    // ГЕТТЕРЫ (способы получить значения)
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    // СЕТТЕРЫ (способы изменить значения)

    public void setName(String name) {
        this.name = name;
    }

    public void setType(String type) {
        this.type = type;
    }

    //Тест бизнес метода
    public boolean isPumpingStation(){
        return "насосная станция".equals(type);
    }
    //Тест бизнес метода2
    public boolean isReservoir(){
        return "резервуар".equals(type);
    }

}
