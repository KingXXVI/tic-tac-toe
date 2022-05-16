import java.util.Scanner;

public class Table {
    int[][] table = new int[3][3];
    Scanner s = new Scanner(System.in);
    
    //empties the board
    void emptyTable(){
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][j] = 0;
            }
        }
    }

    // gets the coordinates of the input
    int[] getCoords(int where){
        int y =(where-1)%3;
        int x = (where-y-1)/3;
        int[] ret ={x,y};
        return ret;
    }
    
    //gets the input as a number from 1 to 9 where
    //+---+---+---+
    //| 1 | 2 | 3 |
    //+---+---+---+
    //| 4 | 5 | 6 |
    //+---+---+---+
    //| 7 | 8 | 9 |
    //+---+---+---+
    int inputPlay(){
        int x;
        while (true) {
            System.out.print("Field to play: ");
            x = s.nextInt();
            if(x < 10 && x > 0 && isEmpty(x)) break;
            System.out.println("field is taken");
        }
        return x;
    }

    //checks it the field is empty
    boolean isEmpty(int where){
        int[] coords = getCoords(where);
        return this.table[coords[0]][coords[1]]==0;
    }

    //checks if the player has won on the current turn
    boolean checkWin(int who){
        int winSum = 3*who;
        if (table[0][0]+table[0][1]+table[0][2] ==winSum) return true;//123
        if (table[1][0]+table[1][1]+table[1][2] ==winSum) return true;//456
        if (table[2][0]+table[2][1]+table[2][2] ==winSum) return true;//789
        if (table[0][0]+table[1][0]+table[2][0] ==winSum) return true;//147
        if (table[0][1]+table[1][1]+table[2][1] ==winSum) return true;//258
        if (table[0][2]+table[1][2]+table[2][2] ==winSum) return true;//369
        if (table[0][0]+table[1][1]+table[2][2] ==winSum) return true;//159
        if (table[0][2]+table[1][1]+table[2][0] ==winSum) return true;//357
        return false;
    }

    //proceses the turn
    //puts the figure into the table
    void play(int who,int where){
        int[] coords = getCoords(where);
        this.table[coords[0]][coords[1]] = who;
        
    }

    //this ungodly mess prints the table into console
    void ptintTable(char p1, char p2){
        char outChar;
        System.out.println("+---+---+---+");
        for (int i = table.length-1; i >= 0; i--){
            System.out.print("| ");
            for (int j = 0; j < table[i].length; j++) {
                switch (table[i][j]) {
                    case 4: outChar=p1; break;
                    case 5: outChar=p2; break;
                    default: outChar=' '; break;
                }
                System.out.print(outChar + " | ");
            }
            System.out.println();
            System.out.println("+---+---+---+");
        }
    }
}
