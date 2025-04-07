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


}
