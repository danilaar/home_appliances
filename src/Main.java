import homeAppliance.*;
import service.ApplianceService;
import sockets.Socket;
import panel.*;

import java.util.ArrayList;
import java.util.logging.Logger;
import java.util.logging.*;

public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {

        for (Handler handler : Logger.getLogger("").getHandlers()) {
            handler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record) {
                    return String.format("[%1$tT] [%2$s] %3$s%n",
                            record.getMillis(),
                            record.getLevel().getName(),
                            record.getMessage());
                }
            });
        }


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

        logger.info("TOTAL POWER: " + service.calculateTotalPower(sockets));

        logger.info(""+sockets.get(0).getAppliance());
        logger.info(""+sockets.get(1).getAppliance());
        logger.info(""+sockets.get(2).getAppliance());

        service.sortPower(sockets);

        logger.info("\n"+sockets.get(0).getAppliance());
        logger.info(""+sockets.get(1).getAppliance());
        logger.info(""+sockets.get(2).getAppliance()+"\n");

        logger.info(""+service.findAppliance(sockets, "Кухня", 100, 1050));
    }
}
