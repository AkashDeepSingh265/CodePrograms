import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


public class ReadDataURL {

	public static void test(){
		//String[] args = {"AKash","Deep","Singh"};
		//ReadDataURL.main(args);
	}
	public static String readData(String urlString){
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(urlString);
			InputStream in = url.openStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			int ch ;
			while((ch=br.read())!=-1){
				sb.append((char)ch);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sb.toString();
	}
	public static void main(String[] args){
		String url = "https://www.facebook.com/";
		System.out.println(ReadDataURL.readData(url));
		
	}
}
