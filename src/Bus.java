class Bus {

    int busID;
    String busName;
    String destination;
    double fare;

    Bus left, right;

    public Bus(int busID, String busName, String destination, double fare) {

        this.busID = busID;
        this.busName = busName;
        this.destination = destination;
        this.fare = fare;

        left = null;
        right = null;
    }
}