package Panel;
import HomeAppliance.HomeAppliance;
import Sockets.Socket;

import java.util.ArrayList;
import java.util.Scanner;

public class ElectricPanel {

    int totalPower;
    Socket[] sockets;

    public ElectricPanel(Socket[] sockets) {
        this.sockets = sockets;
    }

    public ElectricPanel() {}

    public void calculateTotalPower () {
        for (int i = 0; i < sockets.length; i++) {
            totalPower += sockets[i].getAppliance().getPower();
        }
        System.out.println("Total power: " + totalPower);
    }

    public void sortPower() {
        for(int i = 0; i < sockets.length-1; i++) {
            int min = sockets[i].getAppliance().getPower();
            int pos = i;

            for (int j = i + 1; j < sockets.length; j++)
                if (min > sockets[j].getAppliance().getPower()){
                    pos = j;
                    min = sockets[j].getAppliance().getPower();
                }
            Socket temp = sockets[i];
            sockets[i] = sockets[pos];
            sockets[pos] = temp;
        }

    }

    public ArrayList<HomeAppliance> findAppliance(String fRoom, int minPower, int maxPower) {
        ArrayList<HomeAppliance> findedAppliances = new ArrayList<>();
        for (int i = 0; i < sockets.length; i++) {
            if (sockets[i].getAppliance().getRoom().equals(fRoom)) {
                if (sockets[i].getAppliance().getPower() >= minPower && sockets[i].getAppliance().getPower() <= maxPower ) {
                    findedAppliances.add(sockets[i].getAppliance());
                }
            }
        }
        return findedAppliances;
    }
}
