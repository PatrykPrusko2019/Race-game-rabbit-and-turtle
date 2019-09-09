import java.util.Random;

public class Race {

    private String[][] tabRabbitAndTurtle;
    private int[] array_70_positions_players;
    private Random rand;
    int countMove = 0;
    private Rabbit rabbit;
    private Turtle turtle;

    public Race() {
        this.tabRabbitAndTurtle = new String[7][10];
        this.array_70_positions_players = new int[70];
        this.rand = new Random();
        this.rabbit = new Rabbit();
        this.turtle = new Turtle();
        playersStartingPosition();
    }



    public void playersStartingPosition() {

        for(int i = 0; i < array_70_positions_players.length; i++) {
            array_70_positions_players[i] = i + 1;
        }
        int counter = 0;
        for(int i  = 0; i < tabRabbitAndTurtle.length; i++) {
            for(int j = 0; j < tabRabbitAndTurtle[i].length; j++) {

                if(i == 0 && j == 0) {
                    tabRabbitAndTurtle[i][j] = turtle.getTurtle() + rabbit.getRabbit();
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

    public void startRace() {
        System.out.println("T -> turtle and R -> Rabbit race , F -> FINISH\nSTART : ");
        showArray();
        boolean finishRace = false;
        while(! finishRace) {

            turtle.checkMoveForTurtle(rand);
            rabbit.checkMoveForRabbit(rand);
            finishRace = checkifFinishRace();
            cleanOfArray();
            changeOfPositionOnArray(turtle.getActualPositionTurtle());
            changeOfPositionOnArray(rabbit.getActualPositionRabbit());

            checkThePosition(); //checks player positions as at the finish, it changes the value in the table

            showArray();
        }

        checkWhoWinner();

    }


    //if last position of array is player(rabbit or turtle -> change value in array !!!!
    private void checkThePosition() {
        if(turtle.getActualPositionTurtle() == 70) {
            tabRabbitAndTurtle[6][9] = turtle.getTurtle() + " ";
        } else if(rabbit.getActualPositionRabbit() == 70) {
            tabRabbitAndTurtle[6][9] = rabbit.getRabbit() + " ";
        } else if(turtle.getActualPositionTurtle() == 70 && rabbit.getActualPositionRabbit() == 70) {
            tabRabbitAndTurtle[6][9] = rabbit.getRabbit() + turtle.getTurtle();
        }
    }

    private void checkWhoWinner() {
        if(turtle.getActualPositionTurtle() == 70) {
            System.out.println("\nWINNER IS TURTLE !!!!\n");
        } else if (rabbit.getActualPositionRabbit() == 70) {
            System.out.println("\nWINNER IS RABBIT !!!!\n");
        } else  if(turtle.getActualPositionTurtle() == 70 && rabbit.getActualPositionRabbit() == 70){
            System.out.println("\nWINNER IS RABBIT AND TURTLE !!!!\n");
        }
    }

    private void cleanOfArray() {
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

    private void changeOfPositionOnArray(int player) { //player -> which rabbit or turtle
        int counter = 1;

        if( rabbit.getActualPositionRabbit() > 70 ) {
            rabbit.setActualPositionRabbit(70);
        }
        else if  (turtle.getActualPositionTurtle() > 70) {
            turtle.setActualPositionTurtle(70);
        }

        if(player == rabbit.getActualPositionRabbit()) { // turtle movement

            for(int i = 0; i < tabRabbitAndTurtle.length; i++) {
                for(int j = 0 ; j < tabRabbitAndTurtle[i].length; j++) {

                    if(counter == rabbit.getActualPositionRabbit()) {
                        if(tabRabbitAndTurtle[i][j] == turtle.getTurtle() + " ") {
                            tabRabbitAndTurtle[i][j] = turtle.getTurtle() + rabbit.getRabbit();
                        }else if(tabRabbitAndTurtle[i][j] == turtle.getTurtle() + rabbit.getRabbit()) {
                            tabRabbitAndTurtle[i][j] = rabbit.getRabbit() + " ";
                        }
                        else {
                            tabRabbitAndTurtle[i][j] = rabbit.getRabbit() + " ";
                        }
                    }

                    counter++;
                }
            }

        } else if( player == turtle.getActualPositionTurtle()) { //turtle movement
            for(int i = 0; i < tabRabbitAndTurtle.length; i++) {
                for(int j = 0 ; j < tabRabbitAndTurtle[i].length; j++) {

                    if(counter == turtle.getActualPositionTurtle()) {
                        if(tabRabbitAndTurtle[i][j] == rabbit.getRabbit() + " ") {
                            tabRabbitAndTurtle[i][j] = turtle.getTurtle() + rabbit.getRabbit();
                        } else if(tabRabbitAndTurtle[i][j] == turtle.getTurtle() + rabbit.getRabbit()) {
                            tabRabbitAndTurtle[i][j] = turtle.getTurtle() + " ";
                        }
                        else {
                            tabRabbitAndTurtle[i][j] = turtle.getTurtle() + " ";
                        }
                    }

                    counter++;
                }
            }
        }


    }

    private boolean checkifFinishRace() {
        if(turtle.getActualPositionTurtle() >= 70 || rabbit.getActualPositionRabbit() >= 70) {
            return true; //end of the race
        } else {
            return false;
        }
    }


    public void showArray() {

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


}
