import java.util.Scanner;

public class Player {
    Scanner s = new Scanner(System.in);
    String name;
    char charFigure;
    int intFigure;
    int score;

    //constructor
    public Player(int intFigure,char charFigure){
        this.intFigure=intFigure;
        this.charFigure=charFigure;
    }


    //resests the players score
    void resetScore(){
        this.score=0;
    }

    // increments score when the character wins
    void win(){
        this.score++;
    }
    //swaps the player fiures
    //unused
    //and probbably in the wrong place
    void swapFigure(){
        if(this.charFigure == 'X'){
            this.charFigure = 'O';
        }
        else{
            this.charFigure = 'X';
        }
    }

    //sets the player name
    void setName(int x){
        this.resetScore();
        System.out.print("Enter player " + x + " name : ");
        this.name=s.next();
    }

}
