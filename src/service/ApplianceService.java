package service;

import homeAppliance.HomeAppliance;
import sockets.Socket;

import java.util.ArrayList;

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
        for(int i = 0; i < sockets.size()-1; i++) {
            int min = sockets.get(i).getAppliance().getPower();
            int pos = i;

            for (int j = i + 1; j < sockets.size(); j++)
                if (min > sockets.get(j).getAppliance().getPower()){
                    pos = j;
                    min = sockets.get(j).getAppliance().getPower();
                }
            Socket temp = sockets.get(i);
            sockets.set(i, sockets.get(pos));
            //sockets[i] = sockets[pos];
            sockets.set(pos, temp);
        }

    }

    public ArrayList<HomeAppliance> findAppliance(ArrayList<Socket> sockets, String fuckRoom, int minPower, int maxPower) {
        ArrayList<HomeAppliance> findedAppliances = new ArrayList<>();
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
