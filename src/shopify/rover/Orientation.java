package shopify.rover;

enum Orientation {
    N(0, 1) {
        @Override
        public Orientation onLeft() {
            return W;
        }

        @Override
        public Orientation onRight() {
            return E;
        }
    }, S(0, -1) {
        @Override
        public Orientation onLeft() {
            return E;
        }

        @Override
        public Orientation onRight() {
            return W;
        }
    }, W(-1, 0) {
        @Override
        public Orientation onLeft() {
            return S;
        }

        @Override
        public Orientation onRight() {
            return N;
        }
    }, E(1, 0) {
        @Override
        public Orientation onLeft() {
            return N;
        }

        @Override
        public Orientation onRight() {
            return S;
        }
    };

    int deltaX;
    int deltaY;

    Orientation(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    public abstract Orientation onLeft();

    public abstract Orientation onRight();

    public Coordinates onMove(Coordinates coordinates) {
        return new Coordinates(coordinates.x + deltaX, coordinates.y + deltaY);
    }
}
