public abstract class GeometricalForm implements FormOperations{
    protected int xCoord, yCoord;
    protected String iColor, fColor;

    public GeometricalForm(int x, int y){
        this.xCoord = x;
        this.yCoord = y;
    }

    public GeometricalForm(){}

    public int getXCoordinate() {
        return xCoord;
    }

    public int getYCoordinate() {
        return yCoord;
    }

    public String getFormColor() {
        return fColor;
    }

    public String getInnerColor() {
        return iColor;
    }

    public void move(int x, int y){
        this.xCoord = x;
        this.yCoord = y;
    }

    public void changeInnerColor(String color){
        this.iColor = color;
    }

    public void changeFormColor(String color){
        this.fColor = color;
    }

    public abstract void shrink(double ratio);

    public abstract void enlarge(double ratio);
}
