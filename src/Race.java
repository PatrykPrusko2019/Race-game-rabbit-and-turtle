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


    //start players
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
                    tabRabbitAndTurtle[i][j] = "F";
                } else {
                        tabRabbitAndTurtle[i][j] = " " + array_70_positions_players[counter];
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
            checkPositionTwoPlayers();
            turtle.changeOfPositionOnArrayTurtle(tabRabbitAndTurtle, rabbit, turtle);
            rabbit.changeOfPositionOnArrayRabbit(tabRabbitAndTurtle, rabbit, turtle);

            checkThePosition(); //checks player positions as at the finish, it changes the value in the table

            showArray();
        }

        checkWhoWinner();

    }

    // we set positions on the finish line
    private void checkPositionTwoPlayers() {

        if (turtle.getActualPositionTurtle() > 70) {
            turtle.setActualPositionTurtle(70);
        }
        if(rabbit.getActualPositionRabbit() > 70) {
            turtle.setActualPositionTurtle(70);
        }
    }


    //if last position of array is player(rabbit or turtle -> change value in array !!!!
    private void checkThePosition() {
        if(turtle.getActualPositionTurtle() == 70 && rabbit.getActualPositionRabbit() == 70) {
            tabRabbitAndTurtle[6][9] = rabbit.getRabbit() + turtle.getTurtle();
        } else if(rabbit.getActualPositionRabbit() == 70) {
            tabRabbitAndTurtle[6][9] = rabbit.getRabbit();
        } else if(turtle.getActualPositionTurtle() == 70){
            tabRabbitAndTurtle[6][9] = turtle.getTurtle();
        }
    }

    private void checkWhoWinner() {

        if( tabRabbitAndTurtle[6][9] == rabbit.getRabbit() + turtle.getTurtle() ){
            System.out.println("\nWINNER IS RABBIT AND TURTLE !!!!\n");
        } else if(rabbit.getActualPositionRabbit() == 70) {
            System.out.println("\nWINNER IS RABBIT !!!!\n");
        } else if(turtle.getActualPositionTurtle() == 70) {
            System.out.println("\nWINNER IS TURTLE !!!!\n");
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
                if( (tabRabbitAndTurtle[i][j] == turtle.getTurtle()) || (tabRabbitAndTurtle[i][j] == rabbit.getRabbit()) ) {
                    System.out.printf("|%s |\t", tabRabbitAndTurtle[i][j]);
                } else {
                    System.out.printf("|%s|\t", tabRabbitAndTurtle[i][j]);
                }
            }
            System.out.println();
        }
        //System.out.println("\n***********************************\n");
        countMove++;
    }


}
