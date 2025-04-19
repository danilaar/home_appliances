package service;

import homeAppliance.HomeAppliance;
import org.w3c.dom.ls.LSOutput;
import sockets.Socket;
import java.util.Collections;
import java.util.Comparator;
import panel.ElectricPanel;

import java.util.ArrayList;
import java.util.List;

public class ApplianceService {
    int totalPower;

    public int calculateTotalPower (ArrayList<Socket> sockets, ElectricPanel panel) {

        while (sockets.get(0).getIsTurning()) {


            for (int i = 0; i < sockets.size(); i++) {
                totalPower += sockets.get(i).getAppliance().getPower();
            }
            //System.out.println("Total power: " + totalPower);
            return totalPower;
        }
        return 0;
    }

    public void sortPower(ArrayList<Socket> sockets) {
        while (sockets.get(0).getIsTurning()) {
            Collections.sort(sockets, Comparator.comparingInt(socket -> socket.getAppliance().getPower()));
            break;
        }
    }

    public List<HomeAppliance> findAppliance(ArrayList<Socket> sockets, String fuckRoom, int minPower, int maxPower) {

        List<HomeAppliance> findedAppliances = new ArrayList<>();
        while (sockets.get(0).getIsTurning()) {
            for (int i = 0; i < sockets.size(); i++) {
                if (sockets.get(i).getAppliance().getRoom().equals(fuckRoom)) {
                    if (sockets.get(i).getAppliance().getPower() >= minPower && sockets.get(i).getAppliance().getPower() <= maxPower) {
                        findedAppliances.add(sockets.get(i).getAppliance());
                    }
                }
            }
            return findedAppliances;
        }
        return findedAppliances;
    }
}
