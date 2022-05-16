
public class Main {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        
        game.clearScreen();

        //the intro message
        String intro="""
            This is a game of tic tac toe.
            you know how to play tic tac toe.
            you dont need me to explain the rules.
            controls are as follows
                +---+---+---+
                | 7 | 8 | 9 |
                +---+---+---+
                | 4 | 5 | 6 |
                +---+---+---+
                | 1 | 2 | 3 |
                +---+---+---+
                """;
        System.out.println(intro);
        game.newGame();
    }
}
