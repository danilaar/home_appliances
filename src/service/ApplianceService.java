package service;

import homeAppliance.HomeAppliance;
import sockets.Socket;
import java.util.Collections;
import java.util.Comparator;

import java.util.ArrayList;
import java.util.List;

public class ApplianceService {
    int totalPower;

    public int calculateTotalPower (ArrayList<Socket> sockets) {

        for (int i = 0; i < sockets.size()  ; i++) {
            totalPower += sockets.get(i).getAppliance().getPower();
        }
        //System.out.println("Total power: " + totalPower);
        return totalPower;
    }

    public void sortPower(ArrayList<Socket> sockets) {
        Collections.sort(sockets, Comparator.comparingInt(socket -> socket.getAppliance().getPower()));
    }

    public List<HomeAppliance> findAppliance(ArrayList<Socket> sockets, String fuckRoom, int minPower, int maxPower) {
        List<HomeAppliance> findedAppliances = new ArrayList<>();
        for (int i = 0; i < sockets.size(); i++) {
            if (sockets.get(i).getAppliance().getRoom().equals(fuckRoom)) {
                if (sockets.get(i).getAppliance().getPower() >= minPower && sockets.get(i).getAppliance().getPower() <= maxPower ) {
                    findedAppliances.add(sockets.get(i).getAppliance());
                }
            }
        }
        return findedAppliances;
    }
}
