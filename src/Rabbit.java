import java.util.Random;

public class Rabbit {
    private int actualPositionRabbit;
    private String rabbit;

    public Rabbit() {
        this.actualPositionRabbit = 1;
        this.rabbit = "R";
    }
    public int getActualPositionRabbit() {
        return actualPositionRabbit;
    }
    public void setActualPositionRabbit(int actualPositionRabbit) {
        this.actualPositionRabbit = actualPositionRabbit;
    }
    public String getRabbit() {
        return rabbit;
    }
    public void setRabbit(String rabbit) {
        this.rabbit = rabbit;
    }


    public void checkMoveForRabbit(Random rand) {
        int movePlayer;
        boolean exit;
        do {
            movePlayer = rand.nextInt(5) + 1;
            exit = foundNextMoveTurtle(movePlayer); // if it finds the correct one, exit

        } while( ! exit);
    }

    public boolean foundNextMoveTurtle(int movePlayer) {
         //turtle
            return moveRabbit(movePlayer);
    }

    public boolean moveRabbit(int movePlayer) {

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

    //rabbit movement
    public void changeOfPositionOnArrayRabbit(String[][] tabRabbitAndTurtle, Rabbit rabbit, Turtle turtle) {
        int counter = 1;

        for(int i = 0; i < tabRabbitAndTurtle.length; i++) {
            for(int j = 0 ; j < tabRabbitAndTurtle[i].length; j++) {

                if(counter == rabbit.getActualPositionRabbit()) {

                    if(turtle.getActualPositionTurtle() == rabbit.getActualPositionRabbit()) {
                        tabRabbitAndTurtle[i][j] = turtle.getTurtle() + rabbit.getRabbit();
                    } else {
                        tabRabbitAndTurtle[i][j] = rabbit.getRabbit();
                    }

                }

                counter++;
            }
        }
    }
}
