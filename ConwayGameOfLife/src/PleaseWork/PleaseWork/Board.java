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

    public void updateBoard()
    {
        int[][] nextState = new int[boardWidth][boardHeight];
        for(int i= 0 ; i < boardWidth;i++)
        {
            for(int j= 0 ; j < boardHeight;j++)
            {
                nextState[i][j] = getNextState(i, j);
            }
        }
        for(int i= 0 ; i < boardWidth;i++)
        {
            for(int j= 0 ; j < boardHeight;j++)
            {
                setCell(i,j,nextState[i][j]);
            }
        }
    }

    public int getNextState(int x, int y)
    {
        //I Could use Bool but this makes it more expandable
        int neighbours = getNeighbours(x, y);
        int state = getCell(x, y).getState();

        if(state == 1)
        {
            if (neighbours < 2){return 0;}
            if (neighbours >= 2 && neighbours <=3){return 1;}
            else {return 0;}
        }
        else
        {
            if (neighbours == 3){return 1;}
            else {return 0;}
        }
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

    public void printBoard() 
    {
        for(int j = 0; j < boardHeight ;j++)
        {
            System.out.print("|");
            for(int i = 0; i < boardWidth ;i++)
            {
                if(getCell(i, j).getState()== 1){System.out.print("■");}
                if(getCell(i, j).getState()== 0){System.out.print(".");}
            }
            System.out.println("|");
        }
        System.out.println("");
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
