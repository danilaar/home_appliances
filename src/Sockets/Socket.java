package Sockets;

import HomeAppliance.HomeAppliance;

public class Socket {
    private HomeAppliance applianceInSocket;

    public Socket() {}

    public void TurnInSocket (HomeAppliance appliance) {
        this.applianceInSocket = appliance;
    }

    public void TurnOutSocket () {
        this.applianceInSocket = null;
    }

    public HomeAppliance getAppliance () {
        return applianceInSocket;
    }
}
