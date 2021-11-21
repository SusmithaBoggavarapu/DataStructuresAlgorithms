package CrackingCodingInterview.TreesAndGraphs;

public class NQueenSolver {
    private int[][] chessTable;
    private int noOfQueens;

    public NQueenSolver(int noOfQueens){
        this.noOfQueens = noOfQueens;
        this.chessTable = new int[noOfQueens][noOfQueens];
    }

    public void solve(){
        if(setQueens(0)){
            printQueens();
        }else{
            System.out.println("no solution exists..");
        }
    }

    private boolean setQueens(int colIndex){
        if(colIndex == noOfQueens){
            return true;
        }
        for (int rowIndex = 0; rowIndex < noOfQueens; rowIndex++) {
            if(isPlaceValid(rowIndex,colIndex)) {
                chessTable[rowIndex][colIndex] = 1;

                if (setQueens(colIndex + 1)) {
                    return true;
                }
                //back tracking
                chessTable[rowIndex][colIndex] = 0;
            }
        }
        return false;
    }

    private boolean isPlaceValid(int rowIndex, int colIndex){
        // row check
        for (int i = 0; i < colIndex; i++) {
            if(chessTable[rowIndex][i] == 1){
                return false;
            }

        }

        //diagonal check
        for(int i = rowIndex,j = colIndex; i >= 0 && j >=0 ; i--,j--){
            if(chessTable[i][j] == 1){
                return false;
            }
        }

        for (int i = rowIndex,j=colIndex; i < chessTable.length && j>=0 ; i++,j--) {
            if(chessTable[i][j] == 1){
                return false;
            }
        }
        return true;
    }

    private void printQueens(){
        for (int i = 0; i < noOfQueens; i++) {
            for (int j = 0; j < noOfQueens; j++) {
                if(chessTable[i][j] == 1){
                    System.out.print("Q");
                }else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }
}
