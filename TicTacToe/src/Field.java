
public class Field {
    private static int FIELD_SIZE = 3;
    private static final char DEFAULT_SYMBOL = ' ';
    private static final char PLAYER_SYMBOL = 'X';
    static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];

    public static int getFieldSize() {
        return FIELD_SIZE;
    }

    public static char getDefaultSymbol() {
        return DEFAULT_SYMBOL;
    }

    public static char getPlayerSymbol() {
        return PLAYER_SYMBOL;
    }

    public static char getComputerSymbol() {
        char COMPUTER_SYMBOL = '0';
        return COMPUTER_SYMBOL;
    }

    public static void printField() {
        for (char[] i : field) {
            for (char j : i) {
                System.out.print("[");
                System.out.print(j);
                System.out.print("]");
            }
            System.out.println();
        }
    }

    public static void clearField() {
        for(int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                field[i][j] = DEFAULT_SYMBOL;
            }
        }
    }
}
