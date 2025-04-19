package panel;
import homeAppliance.HomeAppliance;
import sockets.Socket;

import java.util.ArrayList;

public class ElectricPanel {

    ArrayList<Socket> sockets;

    public ElectricPanel(ArrayList<Socket> sockets) {
        this.sockets = sockets;
    }

    public ElectricPanel() {}

    public void turnOn() {
        if (sockets.get(0).getIsTurning()) {
            System.out.println("The panel is already working!");
        }
        else {
            for (int i=0; i < sockets.size(); i++) {
                sockets.get(i).setIsTurning(true);
            }
        }
    }

    public void turnOff() {
        if (!sockets.get(0).getIsTurning()) {
            System.out.println("The panel is already killed!");
        } else {
            for (int i = 0; i < sockets.size(); i++) {
                sockets.get(i).setIsTurning(false);
            }
        }
    }
}
