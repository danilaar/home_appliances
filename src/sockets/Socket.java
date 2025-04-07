package sockets;

import homeAppliance.HomeAppliance;

public class Socket {
    private HomeAppliance applianceInSocket;

    public Socket() {}

    public void turnInSocket (HomeAppliance appliance) {
        this.applianceInSocket = appliance;
    }

    public void turnOutSocket () {
        this.applianceInSocket = null;
    }

    public HomeAppliance getAppliance () {
        return applianceInSocket;
    }
}
