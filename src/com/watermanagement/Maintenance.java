package com.watermanagement;

import java.time.LocalDate;

public class Maintenance {
    // ПОЛЯ
    private int id;
    private int equipmentId;        // ID оборудования
    private LocalDate date;         // дата проведения ТО
    private String description;     // описание работ
    private String technicianName;  // имя техника
    private double cost;            // стоимость работ

    // КОНСТРУКТОР
    public Maintenance(int id, int equipmentId, LocalDate date,
                       String description, String technicianName, double cost) {
        this.id = id;
        this.equipmentId = equipmentId;
        this.date = date;
        this.description = description;
        this.technicianName = technicianName;
        this.cost = cost;
    }

    // ГЕТТЕРЫ
    public int getId() { return id; }
    public int getEquipmentId() { return equipmentId; }
    public LocalDate getDate() { return date; }
    public String getDescription() { return description; }
    public String getTechnicianName() { return technicianName; }
    public double getCost() { return cost; }

    // СЕТТЕРЫ
    public void setDate(LocalDate date) { this.date = date; }
    public void setDescription(String description) { this.description = description; }
    public void setCost(double cost) { this.cost = cost; }

    // БИЗНЕС-МЕТОДЫ
    public boolean isOverdue() {
        // ТО считается просроченным, если было больше года назад
        return date.isBefore(LocalDate.now().minusYears(1));
    }

    public boolean isExpensive() {
        // ТО считается дорогим если стоимость > 50_000
        return cost > 50_000;
    }
}