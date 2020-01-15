package solitaire.util;

import javafx.scene.image.Image;
import solitaire.Main;

class Card
{
    private Image image;
    private Image back;
    private Value value;
    private Suit suit;
    private Color color;
    private Column column;
    private boolean facing;
    private boolean inSlot;

    Card(Value value, Suit suit)
    {
        this.image = getImage(value, suit);
        this.value = value;
        this.suit = suit;
        this.color = Color.getValue(suit);
        this.back = new Image(String.valueOf(Main.class.getResource(Main.back)),68, 104, true, true, false);
        this.facing = false;
    }

    void setColumn(Column column)
    {
        this.column = column;
    }

    Column getColumn()
    {
        return column;
    }

    Image getImage()
    {
        if(!facing)
            return back;
        else
            return image;
    }

    void setInSlot(boolean inSlot)
    {
        this.inSlot = inSlot;
    }

    boolean inSlot()
    {
        return inSlot;
    }

    void setFacing(boolean facing)
    {
        this.facing = facing;
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

    @Override
    public String toString()
    {
        return value.num + suit.suit;
    }
}
