package solitaire.util;

import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collections;

public class Game
{
    private int gameBoardWidth;
    private int separatorWidth = 20;

    private Point2D column1 = new Point2D(0, 150);
    private Point2D column2 = new Point2D(0, 150);
    private Point2D column3 = new Point2D(0, 150);
    private Point2D column4 = new Point2D(0, 150);
    private Point2D column5 = new Point2D(0, 150);
    private Point2D column6 = new Point2D(0, 150);
    private Point2D column7 = new Point2D(0, 150);

    private ArrayList<Card> cards;
    public ArrayList<ImageView> onField = new ArrayList<>();
    public ArrayList<ImageView> drawPile = new ArrayList<>();

    public Game(int gameBoardWidth)
    {
        cards = new ArrayList<>();
        this.gameBoardWidth = gameBoardWidth;
        initCards();
        initPoints();
        init();
    }

    private ImageView setImageViewer(Card card, Point2D point)
    {
        ImageView imageView = new ImageView(card.getImage());
        imageView.setX(point.getX());
        imageView.setY(point.getY());
        return imageView;
    }

    private void initPoints()
    {
        int cardWidth = (int) cards.get(0).getImage().getWidth();
        separatorWidth = (gameBoardWidth - (cardWidth * 7)) / 8;
        column1 = column1.add(separatorWidth, 0);
        Point2D point2D = column1;
        for(int i = 2; i <= 7; i++)
        {
            switch(i)
            {
                case 2:
                    column2 = column2.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column2;
                    break;
                case 3:
                    column3 = column3.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column3;
                    break;
                case 4:
                    column4 = column4.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column4;
                    break;
                case 5:
                    column5 = column5.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column5;
                    break;
                case 6:
                    column6 = column6.add(point2D.getX() + separatorWidth + cardWidth, 0);
                    point2D = column6;
                    break;
                case 7:
                    column7 = column7.add(point2D.getX() + separatorWidth + cardWidth, 0);
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
                onField.add(setImageViewer(cards.get(i), column1));
            }
            else if(i < 3)
            {
                Point2D point = column2;
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 1 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                onField.add(imageView);
                if(i != 2)
                {
                    imageView.setDisable(true);
                }
            }
            else if(i < 6)
            {
                Point2D point = column3;
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 3 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                onField.add(imageView);
                if(i != 5)
                {
                    imageView.setDisable(true);
                }
            }
            else if(i < 10)
            {
                Point2D point = column4;
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 6 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                onField.add(imageView);
                if(i != 9)
                {
                    imageView.setDisable(true);
                }
            }
            else if(i < 15)
            {
                Point2D point = column5;
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 10 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                onField.add(imageView);
                if(i != 14)
                {
                    imageView.setDisable(true);
                }
            }
            else if(i < 21)
            {
                Point2D point = column6;
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 15 ? 0 : onField.get(i - 1).getY() - column1.getY() + separatorWidth));
                onField.add(imageView);
                if(i != 20)
                {
                    imageView.setDisable(true);
                }
            }
            else if(i < 28)
            {
                Point2D point = column7;
                ImageView imageView = setImageViewer(cards.get(i), point.add(0, i == 21 ? 0 : onField.get(i - 1).getY() - column1.getY() + 20));
                onField.add(imageView);
                if(i != 27)
                {
                    imageView.setDisable(true);
                }
            }
            else{
                drawPile.add(setImageViewer(cards.get(i), new Point2D(gameBoardWidth - separatorWidth - 68, 10)));
            }
        }
    }
}
