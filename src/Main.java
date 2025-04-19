import homeAppliance.*;
import service.ApplianceService;
import service.LoggerEdit;
import sockets.Socket;
import panel.*;

import java.util.ArrayList;
import java.util.logging.*;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        LoggerEdit.LoggerRed(logger);

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

        panel.turnOn();

        sockets.get(0).turnInSocket(appliances.get(0));
        sockets.get(1).turnInSocket(appliances.get(3));
        sockets.get(2).turnInSocket(appliances.get(2));

        logger.info("TOTAL POWER: " + service.calculateTotalPower(sockets, panel));

        logger.info(sockets.get(0).getAppliance().toString());
        logger.info(sockets.get(1).getAppliance().toString());
        logger.info(sockets.get(2).getAppliance().toString());

        service.sortPower(sockets);

        logger.info("\n"+sockets.get(0).getAppliance());
        logger.info(sockets.get(1).getAppliance().toString());
        logger.info(sockets.get(2).getAppliance()+"\n");

        panel.turnOff();

        logger.info(service.findAppliance(sockets, "Кухня", 100, 1050).toString());

        sockets.get(0).getAppliance().doWork();


    }
}
