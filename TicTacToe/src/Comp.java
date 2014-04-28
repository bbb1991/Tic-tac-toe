public class Comp {

    private static boolean moveComplete = false;

    public static void move() {

        switch(Game.getDifficulty()) {
            //Выбор случайной ячейки
            case 1:
                int rowNumber = 0;
                int colNumber = 0;

                while(Field.field[rowNumber][colNumber] != Field.getDefaultSymbol()) {
                    rowNumber = (int) Math.floor(Math.random() * Field.getFieldSize());
                    colNumber = (int) Math.floor(Math.random() * Field.getFieldSize());
                }
                Field.field[rowNumber][colNumber] = Field.getComputerSymbol();
                break;

            //Расчет полей и ячеек - "умный" соперник
            case 2:
                //Отработка и закрытие незаконченных комбинаций компьютера.
                //По строкам.
                if(!moveComplete) {
                    for (int i = 0; i < Field.getFieldSize(); i++) {
                        if(Field.field[i][0] == Field.getComputerSymbol()
                                && Field.field[i][1] == Field.getComputerSymbol()
                                && Field.field[i][2] == Field.getDefaultSymbol()) {
                            Field.field[i][2] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[i][1] == Field.getComputerSymbol()
                                && Field.field[i][2] == Field.getComputerSymbol()
                                && Field.field[i][0] == Field.getDefaultSymbol()) {
                            Field.field[i][0] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[i][0] == Field.getComputerSymbol()
                                && Field.field[i][2] == Field.getComputerSymbol()
                                && Field.field[i][1] == Field.getDefaultSymbol()) {
                            Field.field[i][1] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По столбцам.
                if(!moveComplete) {
                    for (int i = 0; i < Field.getFieldSize(); i++) {
                        if(Field.field[0][i] == Field.getComputerSymbol()
                                && Field.field[1][i] == Field.getComputerSymbol()
                                && Field.field[2][i] == Field.getDefaultSymbol()) {
                            Field.field[2][i] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[1][i] == Field.getComputerSymbol()
                                && Field.field[2][i] == Field.getComputerSymbol()
                                && Field.field[0][i] == Field.getDefaultSymbol()) {
                            Field.field[0][i] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][i] == Field.getComputerSymbol()
                                && Field.field[2][i] == Field.getComputerSymbol()
                                && Field.field[1][i] == Field.getDefaultSymbol()) {
                            Field.field[1][i] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По главной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Field.field[0][0] == Field.getComputerSymbol()
                                && Field.field[1][1] == Field.getComputerSymbol()
                                && Field.field[2][2] == Field.getDefaultSymbol()) {
                            Field.field[2][2] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][0] == Field.getComputerSymbol()
                                && Field.field[1][1] == Field.getDefaultSymbol()
                                && Field.field[2][2] == Field.getComputerSymbol()) {
                            Field.field[1][1] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][0] == Field.getDefaultSymbol()
                                && Field.field[1][1] == Field.getComputerSymbol()
                                && Field.field[2][2] == Field.getComputerSymbol()) {
                            Field.field[0][0] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        break;
                   }
                }
                //По дополнительной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Field.field[0][2] == Field.getComputerSymbol()
                                && Field.field[1][1] == Field.getComputerSymbol()
                                && Field.field[2][0] == Field.getDefaultSymbol()) {
                            Field.field[2][0] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][2] == Field.getComputerSymbol()
                                && Field.field[1][1] == Field.getDefaultSymbol()
                                && Field.field[2][0] == Field.getComputerSymbol()) {
                            Field.field[1][1] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][2] == Field.getDefaultSymbol()
                                && Field.field[1][1] == Field.getComputerSymbol()
                                && Field.field[2][0] == Field.getComputerSymbol()) {
                            Field.field[0][2] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                //Отработка и закрытие незаконченных комбинаций человека.
                //По строкам.
                if(!moveComplete) {
                    for (int i = 0; i < Field.getFieldSize(); i++) {
                        if(Field.field[i][0] == Field.getPlayerSymbol()
                                && Field.field[i][1] == Field.getPlayerSymbol()
                                && Field.field[i][2] == Field.getDefaultSymbol()) {
                            Field.field[i][2] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[i][1] == Field.getPlayerSymbol()
                                && Field.field[i][2] == Field.getPlayerSymbol()
                                && Field.field[i][0] == Field.getDefaultSymbol()) {
                            Field.field[i][0] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[i][0] == Field.getPlayerSymbol()
                                && Field.field[i][2] == Field.getPlayerSymbol()
                                && Field.field[i][1] == Field.getDefaultSymbol()) {
                            Field.field[i][1] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По столбцам.
                if(!moveComplete) {
                    for (int i = 0; i < Field.getFieldSize(); i++) {
                        if(Field.field[0][i] == Field.getPlayerSymbol()
                                && Field.field[1][i] == Field.getPlayerSymbol()
                                && Field.field[2][i] == Field.getDefaultSymbol()) {
                            Field.field[2][i] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[1][i] == Field.getPlayerSymbol()
                                && Field.field[2][i] == Field.getPlayerSymbol()
                                && Field.field[0][i] == Field.getDefaultSymbol()) {
                            Field.field[0][i] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][i] == Field.getPlayerSymbol()
                                && Field.field[2][i] == Field.getPlayerSymbol()
                                && Field.field[1][i] == Field.getDefaultSymbol()) {
                            Field.field[1][i] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                    }
                }
                //По главной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Field.field[0][0] == Field.getPlayerSymbol()
                                && Field.field[1][1] == Field.getPlayerSymbol()
                                && Field.field[2][2] == Field.getDefaultSymbol()) {
                            Field.field[2][2] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][0] == Field.getPlayerSymbol()
                                && Field.field[1][1] == Field.getDefaultSymbol()
                                && Field.field[2][2] == Field.getPlayerSymbol()) {
                            Field.field[1][1] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][0] == Field.getDefaultSymbol()
                                && Field.field[1][1] == Field.getPlayerSymbol()
                                && Field.field[2][2] == Field.getPlayerSymbol()) {
                            Field.field[0][0] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        break;
                    }
                }
                //По дополнительной диагонали
                if(!moveComplete) {
                    while(true) {
                        if(Field.field[0][2] == Field.getPlayerSymbol()
                                && Field.field[1][1] == Field.getPlayerSymbol()
                                && Field.field[2][0] == Field.getDefaultSymbol()) {
                            Field.field[2][0] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][2] == Field.getPlayerSymbol()
                                && Field.field[1][1] == Field.getDefaultSymbol()
                                && Field.field[2][0] == Field.getPlayerSymbol()) {
                            Field.field[1][1] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        if(Field.field[0][2] == Field.getDefaultSymbol()
                                && Field.field[1][1] == Field.getPlayerSymbol()
                                && Field.field[2][0] == Field.getPlayerSymbol()) {
                            Field.field[0][2] = Field.getComputerSymbol();
                            moveComplete = true;
                            break;
                        }
                        break;
                   }
                }
                if(!moveComplete) {
                    rowNumber = (int) Math.floor(Math.random() * Field.getFieldSize());
                    colNumber = (int) Math.floor(Math.random() * Field.getFieldSize());

                    while(Field.field[rowNumber][colNumber] != Field.getDefaultSymbol()) {
                        rowNumber = (int) Math.floor(Math.random() * Field.getFieldSize());
                        colNumber = (int) Math.floor(Math.random() * Field.getFieldSize());
                    }
                    Field.field[rowNumber][colNumber] = Field.getComputerSymbol();
                }
                break;
        }
        moveComplete = false;
    }
}