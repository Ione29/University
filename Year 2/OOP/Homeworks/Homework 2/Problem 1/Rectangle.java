public class Rectangle extends GeometricalForm{
    private int width, height;

    public Rectangle(int x, int y, int width, int height){
        this.xCoord = x;
        this.yCoord = y;
        this.width = width;
        this.height = height;
    }

    public void enlarge(double ratio){
        this.width *= ratio;
        this.height *= ratio;
    }

    public void shrink(double ratio){
        this.width /= ratio;
        this.height /= ratio;
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }

    public String toString(){
        String text = "Rectangle: x = " + this.xCoord + ", y = " + this.yCoord + ", Width = " + this.width + ", Height = " + this.height;
        return text;
    }
}
