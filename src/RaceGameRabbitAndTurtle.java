import java.util.Random;

/**
 *
 *turtle and rabbit game:
 *more specifically, a race showing how many moves a player has won
 * T -> turtle and R -> Rabbit race , F -> FINISH
 */

public class RaceGameRabbitAndTurtle {
    private static String[][] tabRabbitAndTurtle = new String[7][10];
    private static int[] array_70_positions_players = new int[70];
    private static int actualPositionTurtle = 1;
    private static int actualPositionRabbit = 1;
    private static Random rand = new Random();
    static String turtle = "T";
    static String rabbit = "R";
    static int countMove = 0;

    public static void main(String[] args) {

        playersStartingPosition();

        System.out.println("T -> turtle and R -> Rabbit race , F -> FINISH\nSTART : ");
        showArray();

        startRace();
    }

    private static void startRace() {
        boolean finishRace = false;
        while(! finishRace) {

            checkMoveForTurtle();
            checkMoveForRabbit();
            finishRace = checkifFinishRace();
            cleanOfArray();
            changeOfPositionOnArray(actualPositionTurtle);
            changeOfPositionOnArray(actualPositionRabbit);

            checkThePosition(); //checks player positions as at the finish, it changes the value in the table

            showArray();
        }

        checkWhoWinner();


    }

    //if last position of array is player(rabbit or turtle -> change value in array !!!!
    private static void checkThePosition() {
        if(actualPositionTurtle == 70) {
            tabRabbitAndTurtle[6][9] = turtle + " ";
        } else if(actualPositionRabbit == 70) {
            tabRabbitAndTurtle[6][9] = rabbit + " ";
        } else if(actualPositionTurtle == 70 && actualPositionRabbit == 70) {
            tabRabbitAndTurtle[6][9] = rabbit + turtle;
        }
    }

    private static void checkWhoWinner() {
        if(actualPositionTurtle == 70) {
            System.out.println("\nWINNER IS TURTLE !!!!\n");
        } else if (actualPositionRabbit == 70) {
            System.out.println("\nWINNER IS RABBIT !!!!\n");
        } else  if(actualPositionTurtle == 70 && actualPositionRabbit == 70){
            System.out.println("\nWINNER IS RABBIT AND TURTLE !!!!\n");
        }
    }

    private static void cleanOfArray() {
        int counter = 0;
        for(int i  = 0; i < tabRabbitAndTurtle.length; i++) {
            for(int j = 0; j < tabRabbitAndTurtle[i].length; j++) {
                if(i == tabRabbitAndTurtle.length-1 && j == tabRabbitAndTurtle[i].length-1) {
                    tabRabbitAndTurtle[i][j] = "F ";
                } else {
                    if(counter < 9) { //below range 0 - 9, add a blank String field
                        tabRabbitAndTurtle[i][j] = " " + array_70_positions_players[counter];
                    } else { // nie dodawaj
                        tabRabbitAndTurtle[i][j] = "" + array_70_positions_players[counter];
                    }
                }
                counter++;
            }
        }
    }

    private static void changeOfPositionOnArray(int player) { //player -> which rabbit or turtle
        int counter = 1;

        if(actualPositionRabbit > 70 ) {
            actualPositionRabbit = 70;
        }
        else if  (actualPositionTurtle > 70) {
            actualPositionTurtle = 70;
        }

        if(player == actualPositionRabbit) { // turtle movement

            for(int i = 0; i < tabRabbitAndTurtle.length; i++) {
                for(int j = 0 ; j < tabRabbitAndTurtle[i].length; j++) {

                    if(counter == actualPositionRabbit) {
                        if(tabRabbitAndTurtle[i][j] == turtle + " ") {
                            tabRabbitAndTurtle[i][j] = turtle + rabbit;
                        }else if(tabRabbitAndTurtle[i][j] == turtle + rabbit) {
                            tabRabbitAndTurtle[i][j] = rabbit + " ";
                        }
                        else {
                            tabRabbitAndTurtle[i][j] = rabbit + " ";
                        }
                    }

                    counter++;
                }
            }

        } else if( player == actualPositionTurtle) { //turtle movement
            for(int i = 0; i < tabRabbitAndTurtle.length; i++) {
                for(int j = 0 ; j < tabRabbitAndTurtle[i].length; j++) {

                    if(counter == actualPositionTurtle) {
                        if(tabRabbitAndTurtle[i][j] == rabbit + " ") {
                            tabRabbitAndTurtle[i][j] = turtle + rabbit;
                        } else if(tabRabbitAndTurtle[i][j] == turtle + rabbit) {
                            tabRabbitAndTurtle[i][j] = turtle + " ";
                        }
                        else {
                            tabRabbitAndTurtle[i][j] = turtle + " ";
                        }
                    }

                    counter++;
                }
            }
        }


    }

    private static boolean checkifFinishRace() {
        if(actualPositionTurtle >= 70 || actualPositionRabbit >= 70) {
            return true; //end of the race
        } else {
            return false;
        }
    }

    private static void checkMoveForRabbit() {
        int movePlayer;
        boolean exit;
        do {
            movePlayer = rand.nextInt(5) + 1;
            exit = foundNextMove(2, movePlayer); // if it finds the correct one, exit

        } while( ! exit);
    }

    private static void checkMoveForTurtle() {
        int movePlayer;
        boolean exit;
        do {
            movePlayer = rand.nextInt(3) + 1;
            exit = foundNextMove(1, movePlayer); // if it finds the correct one, exit

        } while( ! exit);
    }

    private static boolean foundNextMove(int numberPlayer, int movePlayer) {

        if(numberPlayer == 1) { //turtle

            switch (movePlayer) {
                case 1: { //fast walk
                    if(actualPositionTurtle + 3 >= 1) {
                        actualPositionTurtle = actualPositionTurtle + 3;
                        return true;
                    }
                    break;
                }
                case 2: { //slip
                    if(actualPositionTurtle - 3 >= 1) {
                        actualPositionTurtle = actualPositionTurtle - 3;
                        return true;
                    }
                    break;
                }
                case 3: { //slow walk
                    if(actualPositionTurtle + 1 >= 1) {
                        actualPositionTurtle = actualPositionTurtle + 1;
                        return true;
                    }
                    break;
                }
            }
            return false;

        } else if( numberPlayer == 2) { // rabbit

            switch (movePlayer) {
                case 1: { //dream
                    return true;
                }
                case 2: { //big jump
                    if(actualPositionRabbit + 9 >= 1) {
                        actualPositionRabbit = actualPositionRabbit + 9;
                        return true;
                    }
                    break;
                }
                case 3: { //big slip
                    if(actualPositionRabbit - 12 >= 1) {
                        actualPositionRabbit = actualPositionRabbit - 12;
                        return true;
                    }
                    break;
                }
                case 4: { //slow walk
                    if(actualPositionRabbit + 1 >= 1) {
                        actualPositionRabbit = actualPositionRabbit + 1;
                        return true;
                    }
                    break;
                }
                case 5: { //a little slip
                    if(actualPositionRabbit - 2 >= 1) {
                        actualPositionRabbit = actualPositionRabbit - 2;
                        return true;
                    }
                    break;
                }
            }
            return false;

        }

        return false;
    }

    private static void showArray() {

        System.out.println("*********************************************************************************`\n" + countMove + " MOVEMENT: \n");

        for(int i = 0; i < tabRabbitAndTurtle.length; i++) {
            for(int j = 0; j < tabRabbitAndTurtle[i].length; j++) {
                System.out.printf("|%s|\t" , tabRabbitAndTurtle[i][j]);
            }
            System.out.println();
        }
        //System.out.println("\n***********************************\n");
        countMove++;
    }

    private static void playersStartingPosition() {

        for(int i = 0; i < array_70_positions_players.length; i++) {
            array_70_positions_players[i] = i + 1;
        }
        int counter = 0;
        for(int i  = 0; i < tabRabbitAndTurtle.length; i++) {
            for(int j = 0; j < tabRabbitAndTurtle[i].length; j++) {

                if(i == 0 && j == 0) {
                    tabRabbitAndTurtle[i][j] = turtle + rabbit;
                } else if (i == tabRabbitAndTurtle.length-1 && j == tabRabbitAndTurtle[i].length-1 ) {
                    tabRabbitAndTurtle[i][j] = "F ";
                } else {
                    if(counter < 9) {
                        tabRabbitAndTurtle[i][j] = " " + array_70_positions_players[counter];
                    } else {
                        tabRabbitAndTurtle[i][j] = "" + array_70_positions_players[counter];
                    }
                }
                counter++;
            }
        }

    }



}
