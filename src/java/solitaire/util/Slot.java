package solitaire.util;

import javafx.geometry.Point2D;

class Slot
{
    private Value value = Value.EMPTY;
    private Point2D point;

    private Slot(Point2D point2D)
    {
        this.point = point2D;
    }

    Slot(int x, int y)
    {
        this(new Point2D(x, y));
    }

    private Point2D getPoint()
    {
        return point;
    }

    double getX()
    {
        return getPoint().getX();
    }

    double getY()
    {
        return getPoint().getY();
    }

    boolean updateValue(Card card)
    {
        if(value.num+1 == card.getValue().num)
        {
            value = card.getValue();
            return true;
        }
        return false;
    }
}
