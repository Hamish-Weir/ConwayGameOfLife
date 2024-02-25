package PleaseWork;

public class Board {
    int boardWidth = 0;
    int boardHeight = 0;
    Cell[][] board;

    public Board(int inputWidth, int inputHeight)
    {
        boardWidth = inputWidth;
        boardHeight = inputHeight; 
        board = new Cell[inputWidth][inputHeight];
        for(int i = 0;i<inputWidth; i++)
        {
            for(int j = 0; j<inputHeight; j++)
            {
                board[i][j] = new Cell();
            }
        } 
         
    }

    public Cell getCell(int x,int y)
    {
        return board[x][y];
    }

    public void setCell(int x,int y, int state)
    {
        //RULES GO HERE
        board[x][y].setState(state);
    }

    public int getNeighbours(int x, int y)
    {
        //TO UPDATE GAME, CHANGE THIS STATEMENT
        int NoNeighbours =                    0;
        boolean onLeft   =               (x==0);
        boolean onRight  =  (x==(boardWidth-1));
        boolean onTop    =               (y==0);
        boolean onBottom = (y==(boardHeight-1));

        if (!onTop && !onLeft)    {if(board[x-1][y-1].getState() == 1){NoNeighbours++;}}
        if (!onTop)                 {if(board[x][y-1].getState() == 1){NoNeighbours++;}}
        if (!onTop && !onRight)   {if(board[x+1][y-1].getState() == 1){NoNeighbours++;}}
        if (!onLeft)                {if(board[x-1][y].getState() == 1){NoNeighbours++;}}
        if (!onRight)               {if(board[x+1][y].getState() == 1){NoNeighbours++;}}
        if (!onBottom && !onLeft) {if(board[x-1][y+1].getState() == 1){NoNeighbours++;}}
        if (!onBottom)              {if(board[x][y+1].getState() == 1){NoNeighbours++;}}
        if (!onBottom && !onRight){if(board[x+1][y+1].getState() == 1){NoNeighbours++;}}

        return NoNeighbours;
    }


    public static void main(String[] args) {
        
        Board B = new Board(3, 3);

        B.setCell(0, 0, 1);
        B.setCell(1, 0, 1);
        B.setCell(2, 0, 1);
        B.setCell(0, 1, 1);
        B.setCell(1, 1, 1);
        B.setCell(2, 1, 1);
        B.setCell(0, 2, 1);
        B.setCell(1, 2, 1);
        B.setCell(2,2, 1);

        System.out.println(B.getNeighbours(1,1));

    }
}
