package PleaseWork;
import java.awt.Frame;

public class GameUI {

    public class MyGUIProgram extends Frame {

        
    }




    public static void main(String[] args) {
    Board B = new Board(100, 10);

        B.setCell(0, 0, 0);
        B.setCell(1, 0, 0);
        B.setCell(2, 0, 0);

        B.setCell(0, 1, 1);
        B.setCell(1, 1, 0);
        B.setCell(2, 1, 1);

        B.setCell(0, 2, 0);
        B.setCell(1, 2, 1);
        B.setCell(2, 2, 1);

        B.setCell(0, 3, 0);
        B.setCell(1, 3, 1);
        B.setCell(2, 3, 0);

        do{
        B.printBoard();
        B.updateBoard();
        System.console().readLine();
        }
        while(true);
    }
}
