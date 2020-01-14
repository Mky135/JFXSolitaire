package solitaire.util;

import javafx.geometry.Point2D;

public class Slot
{
    private Value value = Value.EMPTY;
    private Suit suit;
    private Point2D point;

    private Slot(Suit suit, Point2D point2D)
    {
        this.suit = suit;
        this.point = point2D;
    }

    Slot(Suit suit, int x, int y)
    {
        this(suit, new Point2D(x, y));
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
