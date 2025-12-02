package com.watermanagement;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== СИСТЕМА УПРАВЛЕНИЯ ВОДОКАНАЛОМ ===\n");

        // 1. СОЗДАЁМ ОБЪЕКТЫ ВОДОКАНАЛА
        System.out.println("1. СОЗДАНИЕ ОБЪЕКТОВ:");
        WaterObject station = new WaterObject(1, "Насосная станция 'Северная'", "насосная станция");
        WaterObject reservoir = new WaterObject(2, "Резервуар чистой воды 'Западный'", "резервуар");

        System.out.println("   • " + station.getName() + " (ID: " + station.getId() + ")");
        System.out.println("   • " + reservoir.getName() + " (ID: " + reservoir.getId() + ")");

        // 2. СОЗДАЁМ ОБОРУДОВАНИЕ
        System.out.println("\n2. ДОБАВЛЕНИЕ ОБОРУДОВАНИЯ:");
        Equipment pump1 = new Equipment(101, "Насос Grundfos CR 45", "насос",
                "SN-2023-0456", 2023, 1); // установлен на station (id=1)
        Equipment pump2 = new Equipment(102, "Насос Wilo MVI 203", "насос",
                "SN-2020-0789", 2020, 1);
        Equipment valve1 = new Equipment(201, "Задвижка DN300", "задвижка",
                "SN-2019-1234", 2019, 2); // установлен на reservoir (id=2)

        System.out.println("   • " + pump1.getName() + " (возраст: " + pump1.getAge() + " лет)");
        System.out.println("   • " + pump2.getName() + " (возраст: " + pump2.getAge() + " лет)");
        System.out.println("   • " + valve1.getName() + " (возраст: " + valve1.getAge() + " лет)");

        // 3. СОЗДАЁМ ЗАПИСИ О ТЕХОБСЛУЖИВАНИИ
        System.out.println("\n3. РЕГИСТРАЦИЯ ТЕХОБСЛУЖИВАНИЯ:");
        Maintenance maintenance1 = new Maintenance(1001, 102, // ТО для pump2 (id=102)
                LocalDate.of(2023, 6, 15),
                "Замена сальников, смазка подшипников",
                "Иванов П.С.", 25_000);

        Maintenance maintenance2 = new Maintenance(1002, 201, // ТО для valve1 (id=201)
                LocalDate.of(2022, 9, 10),
                "Ревизия задвижки, замена уплотнений",
                "Петров А.В.", 18_000);

        System.out.println("   • ТО для " + pump2.getName() + " (" + maintenance1.getDate() + ")");
        System.out.println("   • ТО для " + valve1.getName() + " (" + maintenance2.getDate() + ")");

        // 4. БИЗНЕС-ЛОГИКА И АНАЛИЗ
        System.out.println("\n4. АНАЛИЗ И ПРОВЕРКИ:");

        // Проверяем тип объектов
        System.out.println("   • " + station.getName() + " - это насосная станция? " +
                (station.isPumpingStation() ? "Да" : "Нет"));
        System.out.println("   • " + reservoir.getName() + " - это резервуар? " +
                (reservoir.isReservoir() ? "Да" : "Нет"));

        // Проверяем состояние оборудования
        System.out.println("   • " + pump1.getName() + " требует проверки? " +
                (pump1.requiresInspection() ? "Да" : "Нет"));
        System.out.println("   • " + pump2.getName() + " требует проверки? " +
                (pump2.requiresInspection() ? "Да" : "Нет"));

        // Проверяем ТО
        System.out.println("   • ТО от " + maintenance1.getDate() + " просрочено? " +
                (maintenance1.isOverdue() ? "Да" : "Нет"));
        System.out.println("   • ТО от " + maintenance2.getDate() + " просрочено? " +
                (maintenance2.isOverdue() ? "Да" : "Нет"));

        // 5. ИТОГИ
        System.out.println("\n=== ИТОГОВАЯ ИНФОРМАЦИЯ ===");
        System.out.println("Объектов создано: 2");
        System.out.println("Единиц оборудования: 3");
        System.out.println("Записей ТО: 2");
        System.out.println("Общая стоимость ТО: " + (maintenance1.getCost() + maintenance2.getCost()) + " руб.");
    }
}