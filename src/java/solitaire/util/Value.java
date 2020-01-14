package solitaire.util;

public enum Value
{
    EMPTY("0", 0), ACE("1", 1), TWO("2", 2), THREE("3",3), FOUR("4",4), FIVE("5",5), SIX("6",6), SEVEN("7",7), EIGHT("8",8), NINE("9",9), TEN("10",10), JACK("J",11), QUEEN("Q", 12), KING("K",13);

    public static Value getValue(int i)
    {
        switch(i)
        {
            case 1:
                return ACE;
            case 2:
                return TWO;
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
            case 6:
                return SIX;
            case 7:
                return SEVEN;
            case 8:
                return EIGHT;
            case 9:
                return NINE;
            case 10:
                return TEN;
            case 11:
                return JACK;
            case 12:
                return QUEEN;
            case 13:
                return KING;
        }
        return null;
    }

    String value;
    int num;

    Value(String value, int num)
    {
        this.value = value;
        this.num = num;
    }
}
