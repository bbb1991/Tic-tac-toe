public class Check {

    public static char check() {
        char winner = Field.getDefaultSymbol();

        //Проверка победителя по строкам
        for(int i = 0; i < Field.getFieldSize(); i++) {
            if(Field.field[i][0] == Field.field[i][1]
                    && Field.field[i][1] == Field.field[i][2]
                    && Field.field[i][0] != Field.getDefaultSymbol()) {
                winner = Field.field[i][0];
                break;
            }
        }

        //Проверка победителя по столбцам
        for(int i = 0; i < Field.getFieldSize(); i++) {
            if(Field.field[0][i] == Field.field[1][i]
                    && Field.field[1][i] == Field.field[2][i]
                    && Field.field[0][i] != Field.getDefaultSymbol()) {
                winner = Field.field[0][i];
                break;
            }
        }

        //Проверка победителя по главной диагонали
        if(Field.field[0][0] == Field.field[1][1]
                && Field.field[1][1] == Field.field[2][2]) {
            winner = Field.field[0][0];
        }

        //Проверка победителя по дополнительной диагонали
        if(Field.field[0][2] == Field.field[1][1]
                && Field.field[1][1] == Field.field[2][0]) {
            winner = Field.field[0][2];
        }
        return winner;
    }

    //Проверка, есть ли возможность хода.
    public static boolean CanMove() {
        boolean canMove = false;
        for (int i = 0; i < Field.getFieldSize(); i++) {
            for (int j = 0; j < Field.getFieldSize(); j++) {
                if (Field.field[i][j] == Field.getDefaultSymbol()) {
                    canMove = true;
                }
            }
        }
        return canMove;
    }
}