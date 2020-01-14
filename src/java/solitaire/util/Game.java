package solitaire.util;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Game
{
    private int gameBoardWidth;
    private int separatorWidth = 20;

    private Column column1;
    private Column column2;
    private Column column3;
    private Column column4;
    private Column column5;
    private Column column6;
    private Column column7;
    private Slot heartsSlot = new Slot(Suit.HEART, 20, 10);
    private Slot diamondsSlot = new Slot(Suit.DIAMOND, 108,10);
    private Slot clubsSlot = new Slot(Suit.CLUB,196,10);
    private Slot spadesSlot = new Slot(Suit.SPADE,284,10);

    private ArrayList<Card> cards;
    public ArrayList<ImageView> onField = new ArrayList<>();
    private HashMap<Card, ImageView> cardImageViewHashMap = new HashMap<>();
    public ArrayList<ImageView> drawPile = new ArrayList<>();

    public Game(int gameBoardWidth)
    {
        cards = new ArrayList<>();
        this.gameBoardWidth = gameBoardWidth;
        column1 = new Column(1, 0, 150, (Card) null);
        column2 = new Column(2, 0, 150, (Card) null);
        column3 = new Column(3, 0, 150, (Card) null);
        column4 = new Column(4, 0, 150, (Card) null);
        column5 = new Column(5, 0, 150, (Card) null);
        column6 = new Column(6, 0, 150, (Card) null);
        column7 = new Column(7, 0, 150, (Card) null);
        initCards();
        initPoints();
        init();
    }

    private ImageView setImageViewer(Card card, Point2D point)
    {
        ImageView imageView = new ImageView(card.getImage());
        imageView.setOnMouseClicked(event -> {
            switch(card.getSuit())
            {
                case HEART:
                    if(heartsSlot.updateValue(card))
                    {
                        imageView.setX(heartsSlot.getX());
                        imageView.setY(heartsSlot.getY());
                        turnUnderneath(card);
                    }
                    break;
                case SPADE:
                    if(spadesSlot.updateValue(card))
                    {
                        imageView.setX(spadesSlot.getX());
                        imageView.setY(spadesSlot.getY());
                        turnUnderneath(card);
                    }
                    break;
                case DIAMOND:
                    if(diamondsSlot.updateValue(card))
                    {
                        imageView.setX(diamondsSlot.getX());
                        imageView.setY(diamondsSlot.getY());
                        turnUnderneath(card);
                    }
                    break;
                case CLUB:
                    if(clubsSlot.updateValue(card))
                    {
                        imageView.setX(clubsSlot.getX());
                        imageView.setY(clubsSlot.getY());
                        turnUnderneath(card);
                    }
                    break;
            }
        });
        imageView.setX(point.getX());
        imageView.setY(point.getY());
        return imageView;
    }

    private void turnUnderneath(Card card)
    {
       if(card.getColumn().equals(column1))
       {
           column1.cards.remove(card);
       }
       else if(card.getColumn().equals(column2))
       {
           removeCardFromColumn(card, column2);
       }
       else if(card.getColumn().equals(column3))
       {
           removeCardFromColumn(card, column3);
       }
       else if(card.getColumn().equals(column4))
       {
           removeCardFromColumn(card, column4);
       }
       else if(card.getColumn().equals(column5))
       {
           removeCardFromColumn(card, column5);
       }
       else if(card.getColumn().equals(column6))
       {
           removeCardFromColumn(card, column6);
       }
       else if(card.getColumn().equals(column7))
       {
           removeCardFromColumn(card, column7);
       }
    }

    private void removeCardFromColumn(Card card, Column column)
    {
        column.cards.remove(card);
        column.cards.get(column.cards.size()-1).setFacing(true);
        cardImageViewHashMap.get(column.cards.get(column.cards.size()-1)).setImage(column.cards.get(column.cards.size()-1).getImage());
    }

    private void initPoints()
    {
        int cardWidth = (int) cards.get(0).getImage().getWidth();
        separatorWidth = (gameBoardWidth - (cardWidth * 7)) / 8;
        column1.add(separatorWidth, 0);
        Point2D point2D = column1.getPoint();
        for(int i = 2; i <= 7; i++)
        {
            switch(i)
            {
                case 2:
                    column2.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column2.getPoint();
                    break;
                case 3:
                    column3.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column3.getPoint();
                    break;
                case 4:
                    column4.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column4.getPoint();
                    break;
                case 5:
                    column5.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column5.getPoint();
                    break;
                case 6:
                    column6.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column6.getPoint();
                    break;
                case 7:
                    column7.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    break;
            }
        }
    }

    private void initCards()
    {
        for(int j = 0; j < 4; j++)
        {
            for(int i = 1; i <= 13; i++)
            {
                Suit suit = Suit.getValue(j);
                assert suit != null;
                cards.add(new Card(Value.getValue(i), suit));
            }
        }
    }

    private void init()
    {
        Collections.shuffle(cards);

        for(int i = 0; i < cards.size(); i++)
        {
            if(i < 1)
            {
                cards.get(i).setFacing(true);
                column1.addToCards(cards.get(i));
                cards.get(i).setColumn(column1);
                onField.add(setImageViewer(cards.get(i), column1.getPoint()));
            }
            else if(i < 3)
            {
                if(i == 2)
                {
                    cards.get(i).setFacing(true);
                }
                Point2D point = column2.getPoint();
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 1 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                addCardToField(i, imageView, column2);
            }
            else if(i < 6)
            {
                if(i == 5)
                {
                    cards.get(i).setFacing(true);
                }
                Point2D point = column3.getPoint();
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 3 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                addCardToField(i, imageView, column3);
            }
            else if(i < 10)
            {
                if(i == 9)
                {
                    cards.get(i).setFacing(true);
                }
                Point2D point = column4.getPoint();
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 6 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                addCardToField(i, imageView, column4);
            }
            else if(i < 15)
            {
                if(i == 14)
                {
                    cards.get(i).setFacing(true);
                }
                Point2D point = column5.getPoint();
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 10 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                addCardToField(i, imageView, column5);
            }
            else if(i < 21)
            {
                if(i == 20)
                {
                    cards.get(i).setFacing(true);
                }
                Point2D point = column6.getPoint();
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 15 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                addCardToField(i, imageView, column6);
            }
            else if(i < 28)
            {
                if(i == 27)
                {
                    cards.get(i).setFacing(true);
                }
                Point2D point = column7.getPoint();
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 21 ? 0 : onField.get(i - 1).getY() - column1.getY() + 20));
                addCardToField(i, imageView, column7);
            }
            else{
                drawPile.add(setImageViewer(cards.get(i), new Point2D(gameBoardWidth - separatorWidth - 68, 10)));
            }
        }
    }

    private void addCardToField(int i, ImageView imageView, Column column)
    {
        column.addToCards(cards.get(i));
        cards.get(i).setColumn(column);
        onField.add(imageView);
        cardImageViewHashMap.put(cards.get(i), imageView);
    }
}
