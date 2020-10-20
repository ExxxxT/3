package lab3;

abstract class Shape
{
   protected String color;
   protected Boolean filled;

    public Shape(String color, Boolean filled)
    {
        this.color = color;
        this.filled = filled;
    }

    public Shape() { }

    String getColor()
    {
        return color;
    }

    void setColor(String color)
    {
        this.color = color;
    }

    Boolean isFilled()
    {
        return filled;
    }

    void setFilled(Boolean isFilled)
    {
        filled = isFilled;
    }

    abstract double getArea();
    abstract double getPerimeter();
}

class Circle extends Shape
{
    protected double radius;

    public Circle() { }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    public Circle(double radius, String color, Boolean isFilled)
    {
        this.radius = radius;
        super.color = color;
        super.filled = isFilled;
    }

    @Override
    double getArea()
    {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter()
    {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString()
    {
        return String.format("Circle:\nS=%f\nP=%f\nColor=%s\nIsFilled?=%s",
                getArea(), getPerimeter(), getColor(), isFilled());
    }
}

class Rectangle extends Shape
{
    protected double width;
    protected double length;

    public Rectangle() { }

    public Rectangle(double width, double length)
    {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, Boolean isFilled)
    {
        this.width = width;
        this.length = length;
        super.color = color;
        super.filled = isFilled;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    double getArea() {
        return width * length;
    }

    @Override
    double getPerimeter() {
        return 2 * width + 2 * length;
    }

    @Override
    public String toString()
    {
        return String.format("Rectangle:\nS=%f\nP=%f\nColor=%s\nIsFilled?=%s",
                getArea(), getPerimeter(), getColor(), isFilled());
    }
}
class Square extends Rectangle
{
    double side;
    public Square () {}
    public Square (double side)
    {
        this.side = side;
    }
    public Square(double side, String color,Boolean isFilled){
        this.side = side;
        super.color = color;
        super.filled = isFilled;
    }
    public double getSide() {
        return side;
    }
    public void setSide(double side) {
        this.side = side;
    }
    @Override
    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    public void setLength(double length) {
        this.length = length;
    }
    @Override
    public String toString()
    {
        return String.format("Square:\nLength=%f\nSide=%f\nWidth=%s\nIsFilled?=%s",
                getLength(), getSide(), getWidth(), isFilled());
    }
}