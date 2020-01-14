package solitaire.util;

import javafx.scene.image.Image;
import solitaire.Main;

class Card
{
    private Image image;
    private Value value;
    private Suit suit;
    private Color color;

    Card(Value value, Suit suit)
    {
        this.image = getImage(value, suit);
        this.value = value;
        this.suit = suit;
        this.color = Color.getValue(suit);
    }

    public Image getImage()
    {
        return image;
    }

    void setImage(Image image)
    {
        this.image = image;
    }

    Value getValue()
    {
        return value;
    }

    private void setValue(Value value)
    {
        this.value = value;
    }


    Suit getSuit()
    {
        return suit;
    }

    private void setSuit(Suit suit)
    {
        this.suit = suit;
    }


    private Color getColor()
    {
        return color;
    }

    private void setColor(Color color)
    {
        this.color = color;
    }

    private Image getImage(Value value, Suit suit)
    {
        String image = "";
        switch(suit.suit)
        {
            case "C":
                image = "clubs";
                break;
            case "D":
                image = "diamonds";
                break;
            case "S":
                image = "spades";
                break;
            case "H":
                image = "hearts";
                break;
        }
        image += "/" + value.value + suit.suit + ".png";
        return new Image(String.valueOf(Main.class.getResource(image)), 68, 104, true, true, false);
    }
}
