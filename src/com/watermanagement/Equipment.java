package com.watermanagement;

public class Equipment {
    //Поля характеристики оборудования
    private int id;
    private String name;
    private String type; // тип: насос, задвижка, фильтр, счетчик
    private String serialNumber; // серийный номер
    private int installationYear; // год установки
    private int waterObjectId; // ID объекта, где установлено

   // КОНСТРУКТОР
    public Equipment(int id, String name, String type,
                     String serialNumber, int installationYear, int waterObjectId) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.serialNumber = serialNumber;
        this.installationYear = installationYear;
        this.waterObjectId = waterObjectId;
    }
    // ГЕТТЕРЫ
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public String getSerialNumber() { return serialNumber; }
    public int getInstallationYear() { return installationYear; }
    public int getWaterObjectId() { return waterObjectId; }

    // СЕТТЕРЫ
    public void setName(String name) { this.name = name; }
    public void setType(String type) { this.type = type; }
    public void setWaterObjectId(int waterObjectId) { this.waterObjectId = waterObjectId; }

    // БИЗНЕС-МЕТОДЫ
    public int getAge() {
        return java.time.Year.now().getValue() - installationYear;
    }

    public boolean requiresInspection() {
        // Оборудование требует проверки если старше 5 лет
        return getAge() > 5;
    }

    public boolean isPump() {
        return "насос".equals(type);

    }
}