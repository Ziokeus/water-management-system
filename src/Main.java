import com.watermanagement.WaterObject;

public class Main {
    public static void main(String[] args) {
        WaterObject station = new WaterObject(1,"Насосная станция Северная","насосная станция");

        System.out.println("Объект: " + station.getName());
        System.out.println("Тип: " + station.getType());
        System.out.println("ID: " + station.getId());
    }
}