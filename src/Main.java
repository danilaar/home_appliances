import HomeAppliance.*;
import Panel.ElectricPanel;
import Sockets.Socket;

public class Main {
    public static void main(String[] args) {

        HomeAppliance[] appliances = new HomeAppliance[5];

        appliances[0] = new Fridge("Холодильник", "Кухня",  500);
        appliances[1] = new Heater("Нагреватель", "Спальня", 2000);
        appliances[2] = new Laptop("Ноутбук", "Спальня", 80);
        appliances[3] = new Microwave("Микроволновка", "Кухня", 1000);
        appliances[4] = new WashingMachine("Стиральная машина", "WC", 2100);

        Socket[] sockets = new Socket[3];
        sockets[0] = new Socket();
        sockets[1] = new Socket();
        sockets[2] = new Socket();

        ElectricPanel panel = new ElectricPanel(sockets);

        sockets[0].TurnInSocket(appliances[0]);
        sockets[1].TurnInSocket(appliances[3]);
        sockets[2].TurnInSocket(appliances[2]);

        panel.calculateTotalPower();

        System.out.println(sockets[0].getAppliance());
        System.out.println(sockets[1].getAppliance());
        System.out.println(sockets[2].getAppliance());

        panel.sortPower();

        System.out.println("\n");
        System.out.println(sockets[0].getAppliance());
        System.out.println(sockets[1].getAppliance());
        System.out.println(sockets[2].getAppliance());
        System.out.println("\n");

        System.out.println(panel.findAppliance("Кухня", 100, 1050));

    }
}
