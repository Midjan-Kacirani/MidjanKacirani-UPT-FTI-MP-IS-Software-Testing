package Ush9;

public class Rectangle {
    int width;
    int length;

    public Rectangle(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public int getArea(){
        return width * length;
    }

    public int getPerimeter(){
        return 2 * (width + length);
    }

}
