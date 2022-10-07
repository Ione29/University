public class LineSub extends Point
{
    Point end;

    public LineSub(int beginX, int beginY, int endX, int endY)
    {
        super(beginX, beginY);
        this.end = new Point(endX, endY);
    }

    public LineSub(Point begin, Point end)
    {
        super(begin.getX(), begin.getY());
        this.end = end;
    }

    public String toString()
    {
        return "Line:\nBeginning " + super.toString() + "\nEnding " + end.toString();
    }

    public Point getBegin()
    {
        Point point = new Point (0, 0);
        point.setX(super.getX());
        point.setY(super.getY());
        return point;
    }

    public Point getEnd()
    {
        return this.end;
    }

    public void setBegin(Point p)
    {
        super.setXY(p.getX(), p.getY());
    }

    public void setEnd(Point p)
    {
        this.end.setXY(p.getX(), p.getY());
    }

    public int getBeginX()
    {
        return super.getX();
    }

    public int getBeginY()
    {
        return super.getY();
    }

    public int getEndX()
    {
        return this.end.getX();
    }

    public int getEndY()
    {
        return this.end.getY();
    }

    public void setBeginX(int x)
    {
        super.setX(x);
    }

    public void setBeginY(int y)
    {
        super.setY(y);
    }

    public void setBeginXY(int x, int y)
    {
        super.setXY(x, y);
    }

    public void setEndX(int x)
    {
        this.end.setX(x);
    }

    public void setEndY(int y)
    {
        this.end.setY(y);
    }

    public void setEndXY(int x, int y)
    {
        this.end.setXY(x, y);
    }

    public int getLengthSub()
    {
        return (int)Math.sqrt(Math.pow(getEndX() - super.getX(), 2) + Math.pow(getEndY() - super.getY() , 2));
    }

    public double getGradientSub()
    {
        return Math.atan2(getEndY() - super.getY(), getEndX() - super.getX());
    }
}
