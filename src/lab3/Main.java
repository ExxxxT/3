package lab3;

class Main
{
    public static void main(String[] args)
    {
        var shapes = new Shape[10];

        for (int i = 0; i < 10; i++)
        {
            if (i % 2 == 0)
            {
                shapes[i] = new Circle(Math.random() * 100, "Black", i % 3 == 0);
            }
            else
            {
                shapes[i] = new Rectangle(Math.random() * 100, Math.random() * 100, "Black",  i % 3 == 0);
            }
        }

        for (var current : shapes)
        {
            System.out.println(current.toString());
            System.out.println();
        }
    }
}
