import homeAppliance.*;
import service.ApplianceService;
import sockets.Socket;
import panel.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<HomeAppliance> appliances = new ArrayList<>();

        appliances.add(new Fridge("Холодильник", "Кухня", 500));
        appliances.add(new Heater("Нагреватель", "Спальня", 2000));
        appliances.add(new Laptop("Ноутбук", "Спальня", 80));
        appliances.add(new Microwave("Микроволновка", "Кухня", 1000));
        appliances.add(new WashingMachine("Стиральная машина", "WC", 2100));

        ArrayList<Socket> sockets = new ArrayList<>();

        sockets.add(new Socket());
        sockets.add(new Socket());
        sockets.add(new Socket());

        ElectricPanel panel = new ElectricPanel(sockets);
        ApplianceService service = new ApplianceService();

        sockets.get(0).turnInSocket(appliances.get(0));
        sockets.get(1).turnInSocket(appliances.get(3));
        sockets.get(2).turnInSocket(appliances.get(2));

        System.out.println("Total power: " + service.calculateTotalPower(sockets));

        System.out.println(sockets.get(0).getAppliance());
        System.out.println(sockets.get(1).getAppliance());
        System.out.println(sockets.get(2).getAppliance());

        service.sortPower(sockets);

        System.out.println("\n");
        System.out.println(sockets.get(0).getAppliance());
        System.out.println(sockets.get(1).getAppliance());
        System.out.println(sockets.get(2).getAppliance());
        System.out.println("\n");

        System.out.println(service.findAppliance(sockets, "Кухня", 100, 1050));
    }
}
