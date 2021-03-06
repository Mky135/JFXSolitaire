package solitaire.util;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Arrays;

class Column
{
    private int size;
    private Point2D point;
    ArrayList<Card> cards = new ArrayList<>();

    Column(int size, Point2D point,Card... cards)
    {
        this.size = size;
        this.point = point;
        if(cards != null)
        {
            this.cards.addAll(Arrays.asList(cards));
        }
    }

    Column(int size, int x, int y, Card... cards)
    {
        this(size, new Point2D(x,y), cards);
    }

    void add(double x, double y)
    {
        point = point.add(x, y);
    }

    Point2D getPoint()
    {
        return point;
    }

    double getY()
    {
        return point.getY();
    }

    double getX()
    {
        return point.getX();
    }

    void addToCards(Card card)
    {
        cards.add(card);
    }
}
