public enum TypeOfRoom {
    STANDART(100),
    SUPERIOR(200),

    SUTE(300);

    private final double price;

    TypeOfRoom(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
