package solitaire.util;

public enum Color
{
    RED, BLACK;

    public static Color getValue(Suit suit)
    {
        switch(suit)
        {
            case CLUB:
                return BLACK;
            case HEART:
                return RED;
            case SPADE:
                return BLACK;
            case DIAMOND:
                return RED;
        }
        return null;
    }
}
