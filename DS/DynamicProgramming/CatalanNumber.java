package DynamicProgramming;

//Catalan number : how many binary trees are there with n vertices
public class CatalanNumber{
	private int[] table;
	private int n;
	public CatalanNumber(int n){
		this.n=n;
		table = new int[n+1];
		table[0]=1;
		
	}
	
	private int getCatalanNumber(int n){
		if(table[n]!=0)return table[n];
		for(int i = 1;i<=n;i++){
			table[n] += getCatalanNumber(i-1)*getCatalanNumber(n-i); 
		}
		return table[n];
	}
	public int find(){
		return getCatalanNumber(n);
	}
	
	public static void main(String[] args){
		System.out.println(new CatalanNumber(9).find());
	}
}
