package com.Arrays;


public class GameOfLife {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] board={{1,0,0},{0,1,1},{0,0,0}};
		gameOfLife(board);
		//System.out.println(2>>1);
	}

/* Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
 * using the following four rules (taken from the above Wikipedia article):
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 
 * Write a function to compute the next state (after one update) of the board given 
 * its current state. */	
	
	public static void gameOfLife(int[][] board) 
	{ 
        int m = board.length;  
        int n = board[0].length;  
        for (int i = 0; i < m; i++) 
        {  
            for (int j = 0; j < n; j++) 
            {  
                int status = getStatus(board, m, n, i, j);  
                System.out.println("status"+status);
                if ((board[i][j] == 1 || board[i][j] == 3)  && (status == 2 || status == 3)) 
                {  
                    board[i][j] = 3;  
                } 
                else 
                {  
                    board[i][j] = status == 3 ? 2 : board[i][j];  
                }  
            }  
        }  
        
        
      
        for (int i = 0; i < m; i++) 
        {  
            for (int j = 0; j < n; j++) 
            {  
                board[i][j] >>= 1;  
            }  
        }  
    
        for(int i=0;i<board.length;i++)
      		{
      			for(int j=0;j<board[0].length;j++)
      			{
      				System.out.println("i-"+i+" j-"+j+" "+board[i][j]);
      			}
      		}
	}
	
    
	
	public static int getStatus(int[][] board, int m, int n, int x, int y)
	{  
        int live = 0;  
        for (int i = -1; i < 2; i++) 
        {  
            for (int j = -1; j < 2; j++) 
            {  
                int newX = x + i;  
                int newY = y + j;  
                if (newX == x && newY == y) 
                {  
                    continue;  
                }  
                if (newX >= 0 && newY >= 0 && newX < m && newY < n) 
                {  
                    if (board[newX][newY] == 1 || board[newX][newY] == 3) 
                    {  
                        live++;  
                    }  
                }  
            }  
        }  
        return live;  
    }  
	
	
	
	public static void  gameOfLife1(int[][] board) {
	    if(board==null || board.length==0||board[0].length==0)
	        return;
	 
	    int m=board.length;
	    int n=board[0].length;
	 
	    int[] x = {-1, -1, 0, 1, 1, 1, 0, -1};
	    int[] y = {0, 1, 1, 1, 0, -1, -1, -1};
	 
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            int count=0;
	            for(int k=0; k<8; k++){
	                int nx=i+x[k];
	                int ny=j+y[k];
	                if(nx>=0&&nx<m&&ny>=0&&ny<n&&(board[nx][ny]&1)==1){
	                    count++;
	                }
	            }
	 
	            //<2 die
	            if(count<2){
	                board[i][j] &= 1;
	            }
	 
	            //same state
	            if(count==2||count==3){
	                board[i][j] |=  board[i][j]<<1;
	            }
	 
	            //go live
	            if(count==3){
	                board[i][j] |=2;
	            }
	 
	            //>3 die
	            if(count>3){
	                board[i][j] &=1;
	            }
	        }
	    }
	 
	    for(int i=0; i<m; i++){
	        for(int j=0; j<n; j++){
	            board[i][j] = board[i][j]>>1;
	 
	        }
	    }
	    
	    
	    
	    for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				System.out.println("i-"+i+" j-"+j+" "+board[i][j]);
			}
		}
	    
	    
	}
	
}
