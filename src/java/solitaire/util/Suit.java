package solitaire.util;

public enum Suit
{
    CLUB("C"), HEART("H"), DIAMOND("D"), SPADE("S"), NONE("N");

    public static Suit getValue(int i)
    {
        switch(i)
        {
            case 0:
                return CLUB;
            case 1:
                return HEART;
            case 2:
                return DIAMOND;
            case 3:
                return SPADE;
        }
        return null;
    }

    String suit;

    Suit(String suit)
    {
        this.suit = suit;
    }
}
