import java.util.Random;

public class Turtle {

    private int actualPositionTurtle;
    private String turtle;

    Turtle() {
        this.actualPositionTurtle = 1;
        this.turtle = "T";
    }

    public int getActualPositionTurtle() {
        return actualPositionTurtle;
    }
    public void setActualPositionTurtle(int actualPositionTurtle) {
        this.actualPositionTurtle = actualPositionTurtle;
    }
    public String getTurtle() {
        return turtle;
    }
    public void setTurtle(String turtle) {
        this.turtle = turtle;
    }

    public void checkMoveForTurtle(Random rand) {
        int movePlayer;
        boolean exit;
        do {
            movePlayer = rand.nextInt(3) + 1;
            exit = foundNextMoveTurtle(movePlayer); // if it finds the correct one, exit

        } while( ! exit);
    }

    public boolean foundNextMoveTurtle(int movePlayer) {
        //turtle
        return moveTurtle(movePlayer);
    }

    public boolean moveTurtle(int movePlayer) {

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
    }

    //turtle movement
    public void changeOfPositionOnArrayTurtle(String[][] tabRabbitAndTurtle, Rabbit rabbit, Turtle turtle) {
        int counter = 1;

            for(int i = 0; i < tabRabbitAndTurtle.length; i++) {
                for(int j = 0 ; j < tabRabbitAndTurtle[i].length; j++) {

                    if(counter == turtle.getActualPositionTurtle()) {

                        if(turtle.getActualPositionTurtle() == rabbit.getActualPositionRabbit()) {
                            tabRabbitAndTurtle[i][j] = turtle.getTurtle() + rabbit.getRabbit();
                        } else {
                            tabRabbitAndTurtle[i][j] = turtle.getTurtle();
                        }

                    }

                    counter++;
                }
            }

    }
}
