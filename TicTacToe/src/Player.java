import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Player {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int colNumber;
    private static int rowNumber;

    private static void setDefaultValue() {
        int playerMove = -1;
        rowNumber = playerMove;
        colNumber = playerMove;
    }

    public static void move() throws NumberFormatException {
        setDefaultValue();

        while(colNumber < 0 || colNumber > 2 || rowNumber < 0 || rowNumber > 2
                || Field.field[rowNumber][colNumber] != Field.getDefaultSymbol()) {

            try {
                System.out.println("Введите номер строки (1.." + Field.getFieldSize() + "):");
                rowNumber = Integer.parseInt(reader.readLine()) - 1;
                checkCell(rowNumber);

                System.out.println("Введите номер столбца (1.." + Field.getFieldSize() + "):");
                colNumber = Integer.parseInt(reader.readLine()) - 1;
                checkCell(colNumber);

                if (Field.field[rowNumber][colNumber] != Field.getDefaultSymbol()) {
                    System.out.println("Эта ячейка занята.");
                    Field.printField();
                }

            } catch (IOException e) {
                System.out.println("Ошибка ввода. Введите только число.");
                setDefaultValue();
            } catch (ArrayIndexOutOfBoundsException | NumberFormatException e) {
                setDefaultValue();
            } catch (Exception e) {
                System.out.println("Sorry:(");
                e.printStackTrace();
            }
        }
        Field.field[rowNumber][colNumber] = Field.getPlayerSymbol();
    }

    private static void checkCell(int i) {
        if (i < 0 || i > 2) {
            System.out.println("Неправильный ввод. Введите число в диапазоне (1.." + Field.getFieldSize() + ")");
            Field.printField();
        }
    }
}