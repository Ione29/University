public class Elipse extends GeometricalForm{
    private int hRadius, vRadius;

    public Elipse(int x, int y, int hr, int vr){
        this.xCoord = x;
        this.yCoord = y;
        this.hRadius = hr;
        this.vRadius = vr;
    }

    public void enlarge(double ratio){
        this.hRadius *= ratio;
        this.vRadius *= ratio;
    }

    public void shrink(double ratio) {
        this.hRadius /= ratio;
        this.vRadius /= ratio;
    }

    public int getHorizRadius(){
        return hRadius;
    }

    public int getVertRadius(){
        return vRadius;
    }

    public String toString(){
        String text = "Elipse: x = " + this.xCoord + ", y = " + this.yCoord + ", Horizontal Radius = " + this.hRadius + ", Vertical Radius = " + this.vRadius;
        return text;
    }
}
