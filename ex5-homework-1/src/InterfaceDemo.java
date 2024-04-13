interface Vehicle{
    void start(String name);
    void stop(String name);
}

class Bike implements Vehicle{
    public void start(String name) {
        System.out.println("Bike named " + name + " starts");
    }
    public void stop(String name) {
        System.out.println("Bike named " + name + " stops");
    }
}

class Bus implements Vehicle{
    public void start(String name) {
        System.out.println("Bus named " + name + " starts");
    }
    public void stop(String name) {
        System.out.println("Bus named " + name + " stops");
    }
}

public class InterfaceDemo {
    public static void main(String[] args) throws Exception {
        Bike bike = new Bike();
        Bus bus = new Bus();
        bike.start("bike");
        bike.stop("bike");
        bus.start("bus");
        bus.stop("bus");
    }
}
