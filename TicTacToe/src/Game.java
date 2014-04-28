import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Game {
    private static int difficulty = 0;
    private static boolean isPlayerMove;

    public void startGame() throws IOException {

        int gameCount = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Выбор сложности уровня
        do {
            System.out.println("Выберите сложность соперника:\n" +
                    "1. Random-bot.\n" +
                    "2. Умный соперник.");
            try {
                difficulty = Integer.parseInt(reader.readLine());
            } catch (Exception NumberFormatException) {
                System.out.println("Неправильный ввод. Введите только номера.");
                continue;
            }
            switch (difficulty) {
                case 1:
                    System.out.println("Вы выбрали: \"Random-bot\".");
                    break;
                case 2:
                    System.out.println("Вы выбрали: \"Умный соперник\".");
                    break;
                default:
                    System.out.println("Неправильный ввод. Попробуйте еще раз.");
            }
        } while(difficulty < 1 || difficulty > 2);

        do {
            gameCount++;
            Field.clearField();
            System.out.println("Игра №" + gameCount + " началась!");

            checkWhoMove();

            while(Check.check() == Field.getDefaultSymbol() && Check.CanMove()) {
                doMove();
            }

            Field.printField();
            if (!Check.CanMove()) {
                System.out.println("Поле заполнена.");
            }

            if (Check.check() == Field.getPlayerSymbol()) {
                System.out.println("Поздравляю! Вы выиграли!");
            }

            if (Check.check() == Field.getComputerSymbol()) {
                System.out.println("Вы проиграли.");
            }

            System.out.println("\n~~~~~~~~\nЗаново? y 1- Да");
        } while(reader.readLine().equals("y"));

        System.out.println("Спасибо за игру!");
        System.out.print("Создатель: Багдат Бимаганбетов. 2014");
    }


    public static int getDifficulty() {
        return difficulty;
    }

    private static void doMove(){
        if (isPlayerMove) {
            Field.printField();
            Player.move();
        } else {
            Comp.move();
        }
        isPlayerMove = !isPlayerMove;
    }

    private static void checkWhoMove() {
        float gamer = (float) Math.random();
        if (gamer <= 0.5) {
            isPlayerMove = false;
            System.out.println("Компьютер ходит первым.");
        } else {
            isPlayerMove = true;
            System.out.println("Вы ходите первым.");
        }
    }
}