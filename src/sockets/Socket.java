package sockets;

import homeAppliance.HomeAppliance;

public class Socket {
    private HomeAppliance applianceInSocket;
    private boolean isTurning;

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

    public boolean getIsTurning() {
        return isTurning;
    }

    public void setIsTurning(boolean isTurning) {
        this.isTurning = isTurning;
    }
}
