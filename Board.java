package ConwayGameOfLife;

public class Board {
    int boardWidth = 0;
    int boardHeight = 0;
    Cell[][] board;

    public Board(int width, int height)
    {
        boardWidth = width;
        boardHeight = height;
        board = new Cell[width-1][height-1];
    }

    public Cell getCell(int x,int y)
    {
        return board[x][y];
    }

    public void setCell(int x,int y)
    {
        //RULES GO HERE
        board[x][y].setState();
    }

    public int getNeighbours(int x, int y)
    {
        //TO UPDATE GAME, CHANGE THIS STATEMENT
        int NoNeighbours = 0;

        if ((x > 0 && x < boardWidth-1)&&(y>0 && y< boardHeight-1))
        {
            if(board[x-1][y-1].setState() == 1){NoNeighbours++;}
            if(board[x][y-1].setState() == 1){NoNeighbours++;}
            if(board[x+1][y-1].setState() == 1){NoNeighbours++;}
            if(board[x-1][y].setState() == 1){NoNeighbours++;}
            if(board[x+1][y].setState() == 1){NoNeighbours++;}
            if(board[x-1][y+1].setState() == 1){NoNeighbours++;}
            if(board[x][y+1].setState() == 1){NoNeighbours++;}
            if(board[x+1][y+1].setState() == 1){NoNeighbours++;}
        }

        return NoNeighbours;
    }
}
