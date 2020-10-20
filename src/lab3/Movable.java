package lab3;
public interface Movable {

    public void moveUp();
    public void moveDown();
    public void moveLeft();
    public void moveRight();

}
class MovablePoint implements Movable {

    int x, y, xSpeed, ySpeed;     // package access

    public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    @Override
    public void moveUp() {
        y -= ySpeed;
    }

    @Override
    public void moveDown() {
        y += ySpeed;
    }

    @Override
    public void moveLeft() {
        x -= xSpeed;
    }

    @Override
    public void moveRight() {
        x += xSpeed;
    }

    @Override
    public String toString() {
        return String.format("MovablePoint (%1$d, %2$d) with xSpeed = %3$d and ySpeed = %4$d"
                , x, y, xSpeed, ySpeed);
    }
}
class MovableCircle implements Movable {

    private MovablePoint center;
    private int radius;

    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        center = new MovablePoint(x, y, xSpeed, ySpeed);
        this.radius = radius;
    }

    public void moveUp() {
        center.y -= center.ySpeed;
    }

    public void moveDown() {
        center.y += center.ySpeed;
    }

    public void moveLeft() {
        center.x -= center.xSpeed;
    }

    public void moveRight() {
        center.x += center.xSpeed;
    }

    public String toString() {
        return String.format("MovableCircle at point %1$s with radius = %2$d"
                , center.toString(), radius);
    }
}
class MovableRectangle implements Movable {

    private MovablePoint    topLeft;
    private MovablePoint    bottomRight;

    public MovableRectangle(int x1, int y1, int x2, int y2, int xSpeed, int ySpeed) {
        topLeft     = new MovablePoint(x1, y1, xSpeed, ySpeed);
        bottomRight = new MovablePoint(x2, y2, xSpeed, ySpeed);
    }

    @Override
    public void moveUp() {
        if ( ! hasPointsSameSpeed()) {
            return;
        }
        topLeft.y     -= topLeft.ySpeed;
        bottomRight.y -= bottomRight.ySpeed;
    }

    @Override
    public void moveDown() {
        if ( ! hasPointsSameSpeed()) {
            return;
        }
        topLeft.y     += topLeft.ySpeed;
        bottomRight.y += bottomRight.ySpeed;
    }

    @Override
    public void moveLeft() {
        if ( ! hasPointsSameSpeed()) {
            return;
        }
        topLeft.x     -= topLeft.xSpeed;
        bottomRight.x -= bottomRight.xSpeed;
    }

    @Override
    public void moveRight() {
        if ( ! hasPointsSameSpeed()) {
            return;
        }
        topLeft.x     += topLeft.xSpeed;
        bottomRight.x += bottomRight.xSpeed;
    }

    private boolean hasPointsSameSpeed() {
        return (topLeft.xSpeed == bottomRight.xSpeed)
                && (topLeft.ySpeed == bottomRight.ySpeed);
    }

    @Override
    public String toString() {
        return String.format("MovableRectangle with topLeft: %1$s and bottomRight: %2$s"
                , topLeft.toString(), bottomRight.toString());
    }
}