package CF;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InfiniteMaze_196B {

	private int[][] maze;
	private int n;
	private int m;
	private int sx = -1;
	private int sy = -1;
	private int[] dx = {1,0,-1,0};
	private int[] dy = {0,-1,0,1};
	private Point[][] visited;
	public void addRowTOMatrix(String row,int rowIndex){
		for(int i=0;i<m;i++){
			switch(row.charAt(i)){
			case '#':
				maze[rowIndex][i] = -1;
				break;
			case '.':
				maze[rowIndex][i] = 1;
				break;
			case 'S':
				sx=rowIndex;
				sy=i;
				maze[rowIndex][i] = 1;
				break;
			}
			
		}
	}
	public void compute(){
		BufferedReader in = null;
		try{
			in = new BufferedReader(new InputStreamReader(System.in));
			String firstLine = in.readLine();
			n = Integer.parseInt(firstLine.split(" ")[0]);
			m = Integer.parseInt(firstLine.split(" ")[1]);
			maze = new int[n][m];
			visited = new Point[n][m];
			for(int i=0;i<n;i++){
				addRowTOMatrix(in.readLine(),i);
			}
			if(dfs(sx,sy,sx,sy)){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private boolean dfs(int x, int y,int mazeX,int mazeY) {
		Point cur =  new Point(x, y);
		if(visited[mazeX][mazeY]!=null){
			if(!visited[mazeX][mazeY].equals(cur)){
				return true;
			}else{
				return false;
			}
		}
		visited[mazeX][mazeY] = cur;
		int row;
		int col;
		int rowMaze = -1;
		int colMaze = -1;
		for(int i=0;i<4;i++){
			row = x + dx[i];
			col= y + dy[i];
			rowMaze=row;
			colMaze=col;
			if(row<0) rowMaze = row + n;
			if(row > n-1) rowMaze = row%n;
			if(col< 0) colMaze = col+ m;
			if(col> m-1 ) colMaze = col%m;
			if(maze[rowMaze][colMaze]==1){
				if(dfs(row,col,rowMaze,colMaze)){
					return true;
				}
			}
		}
		return false;
	}
	public static void main(String[] args){
		new InfiniteMaze_196B().compute();
		System.exit(0);
	}
	private class Point{
		private int x ; 
		private int y ;
		public Point(int px,int py){
			x=px;
			y=py;
		}
		public boolean equals(Point p){
			if(this.x==p.x&&this.y==p.y) return true;
			return false;
		}
	}
}
