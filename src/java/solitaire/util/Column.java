package solitaire.util;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Arrays;

public class Column
{
    private int size;
    private Point2D point;
    ArrayList<Card> cards = new ArrayList<>();

    public Column(int size, Point2D point,Card... cards)
    {
        this.size = size;
        this.point = point;
        this.cards.addAll(Arrays.asList(cards));
    }

    public Column(int size, int x, int y, Card... cards)
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

    public void addToCards(Card card)
    {
        cards.add(card);
    }
}
