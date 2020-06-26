package shopify.rover;

class Boundary {
    int boundX, boundY;

    public Boundary(int boundX, int boundY) {
        this.boundX = boundX;
        this.boundY = boundY;
    }

    public boolean contains(Coordinates coordinates) {
        return coordinates.x >= 0 && coordinates.x <= boundX && coordinates.y >= 0 && coordinates.y <= boundY;
    }
}
