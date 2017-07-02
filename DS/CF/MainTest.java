package CF;

import java.io.InputStreamReader;
import java.io.IOException;
import java.util.InputMismatchException;
import java.io.PrintStream;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 * @author Nipuna Samarasekara
 */
public class MainTest {
	public static void main(String[] args) {
		InputStream inputStream = System.in;
		OutputStream outputStream = System.out;
		FastScanner in = new FastScanner(inputStream);
		FastPrinter out = new FastPrinter(outputStream);
		TaskCTest solver = new TaskCTest();
		solver.solve(1, in, out);
		out.close();
	}
}

class TaskCTest {
    /////////////////////////////////////////////////////////////

    long[] level;
    long[] sum;
    static int[] A;
    int N;

    public void solve(int testNumber, FastScanner in, FastPrinter out) {
    level=new long[30];
    sum= new long[30];

   int n=in.nextInt();
   A=in.readIntArray((int)Math.pow(2,n));
    N=(int)Math.pow(2,n);

        for (int i = 1; i < 30; i++) {
            sum[i]= (long)(Math.pow(2,i)-1)*(long)(N/2);
        }
        for (int i = 29; i >0 ; i--) {
            sum[i]-=sum[i-1];
        }
     sort(0,N);



     int q=in.nextInt();
        for (int i = 0; i < q; i++) {
            int t=in.nextInt();

            for (int j = 1; j <= t ; j++) {
              level[j]=sum[j]-level[j];


            }
            long ans=0;
            for (int k = 1; k < 30; k++) {
                ans+=level[k];
            }
            out.println(ans);

        }


    }
    void sort(int low,int high){
        if(high-low==1)return;
        int len=(high-low)/2;
        sort(low,low+len);
        sort(low+len,high);
     //   System.out.println(low+" "+high+" ");
       int cc=high-low;
        int pos=0;
        while(cc>1){
            cc/=2;pos++;
        }
      int[] temp= new int[len*2];
       int ll=low,rr=low+len;
        while(ll<len+low&&rr<high){

            if(A[ll]<A[rr]){ll++;
            continue;
            }
            if(A[ll]>A[rr]){rr++;
                continue;
            }
            if(A[ll]==A[rr]){
                int val=A[ll];
                long c1=0,c2=0;
                while(ll<len+low&&A[ll]==val){ll++;c1++;}
                while(rr<high&&A[rr]==val){rr++;c2++;}
             //   System.out.println(A[ll]+" "+A[rr]+" "+c1+" "+c2);
             sum[pos]-=c1*c2;
            }

        }

        ll=low;rr=low+len;
        for (int i = 0; i < 2 * len; i++) {
            if(rr==high){
                temp[i]=A[ll];
                ll++;
                continue;
            }
            if(ll==low+len){
                temp[i]=A[rr];
                rr++;
                continue;
            }
            if(A[ll]<=A[rr]){
                temp[i]=A[ll];
                ll++;
            }
            else{
                temp[i]=A[rr];
                rr++;
                level[pos]+=low+len-ll;
            }
        }
        for (int i = 0; i < 2*len; i++) {
         A[low+i]=temp[i];
        }
    }
}

class FastScanner extends BufferedReader {

    public FastScanner(InputStream is) {
        super(new InputStreamReader(is));
    }

    public int read() {
        try {
            int ret = super.read();
//            if (isEOF && ret < 0) {
//                throw new InputMismatchException();
//            }
//            isEOF = ret == -1;
            return ret;
        } catch (IOException e) {
            throw new InputMismatchException();
        }
    }

    static boolean isWhiteSpace(int c) {
        return c >= 0 && c <= 32;
    }

    public int nextInt() {
        int c = read();
        while (isWhiteSpace(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int ret = 0;
        while (c >= 0 && !isWhiteSpace(c)) {
            if (c < '0' || c > '9') {
                throw new NumberFormatException("digit expected " + (char) c
                        + " found");
            }
            ret = ret * 10 + c - '0';
            c = read();
        }
        return ret * sgn;
    }

    public String readLine() {
        try {
            return super.readLine();
        } catch (IOException e) {
            return null;
        }
    }

    public int[] readIntArray(int n) {
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            ret[i] = nextInt();
        }
        return ret;
    }

}

class FastPrinter extends PrintWriter {

    public FastPrinter(OutputStream out) {
        super(out);
    }

    public FastPrinter(Writer out) {
        super(out);
    }


}