package homeAppliance;
public class HomeAppliance {
    private String name;
    private String room;
    private int power;

    public HomeAppliance(String name, String room, int power) {
        this.name = name;
        this.room = room;
        this.power = power;
    }

    public HomeAppliance() {}

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public int getPower() {
        return power;
    }

    public void doWork() {
        System.out.println("Бздыщь");
    }
}
