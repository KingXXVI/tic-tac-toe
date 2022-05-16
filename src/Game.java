import java.util.Scanner;

public class Game {
    Scanner s =new Scanner(System.in);
    Table t = new Table();
    Player p1 = new Player(4,'X');
    Player p2 = new Player(5,'O');

    //starts a new game
    void newGame(){
        if(getBinChoice("Start New Game?")){
            clearScreen();
            t.emptyTable();
            p1.setName(1);
            p2.setName(2);
            gameLoop();
            t.emptyTable();
        }
        //exits the game
        clearScreen();
        System.exit(0);
    }
    
    //starts a new round
    void newRound(){
        if (!getBinChoice("Start new round?")) {
            newGame();
        }
        System.out.print("\033[H\033[2J");  
        System.out.flush();
        t.emptyTable();
        gameLoop();
    }
    
    // game logic
    void gameLoop(){
        int turn = 0;
         do{
            refreshScreen();
            //draw condition 
            //if 9 turns have been played without a wind then the round finishes with a draw
            if (turn >8) {
                System.out.println("draw");
                newRound();
            }
            if(turn % 2 == 0){
                System.out.println(p1.name+"'s turn");
                t.play(p1.intFigure, t.inputPlay());
                if (t.checkWin(p1.intFigure)) {//player 1 win condition
                    p1=win(p1);
                    newRound();
                }
            }
            else{
                System.out.println(p2.name+"'s turn");
                t.play(p2.intFigure, t.inputPlay());
                if (t.checkWin(p2.intFigure)) {//player 2 win condition
                    p2=win(p2);
                    newRound();
                }
            }

            turn++;
         }while(true);
    }

    //proceses a win condition
    Player win(Player p){
        p.win();
        refreshScreen();
        System.out.println(p.name+" won");
        return p;
    }

    //refreshes the screen
    void refreshScreen(){
        clearScreen();
        t.ptintTable(p1.charFigure,p2.charFigure);
        printScore();
    }

    //this clears the screen somehow
    //i have no idea how
    void clearScreen(){
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }
    
    //get binary choice
    boolean getBinChoice(String msg){
       while (true) {
        System.out.print(msg+" [Y/N]: ");
        String x = s.next();
        x = x.toLowerCase();
        if(x.equals("yes")||x.equals("y"))return true;
        if(x.equals("no")||x.equals("n"))return false;
       }
    }

    //prints score
    void printScore(){
        String score =p1.name+" : "+p1.score+"\n"
                 +p2.name+" : "+p2.score;
        System.out.println(score);
    }
}
