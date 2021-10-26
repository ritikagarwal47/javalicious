package javalicious;
import java.util.*;
import java.io.*;
public class GetKPC
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		ArrayList<String> ar = getKPC(s);
		System.out.println(ar);
	}
	static String[] refer = {".;","abc","def","ghi","jkl","mno","pqrs","tu","vwx","yz"};
	public static ArrayList<String> getKPC(String s)
	{
		if(s.length()==0)
		{
			ArrayList<String> ar = new ArrayList<>();
			ar.add("");
			return ar;
		}
		char c = s.charAt(0);
		String rest = s.substring(1);
		ArrayList<String> recur = getKPC(rest);
		ArrayList<String> store = new ArrayList<>();
		String it = refer[c-'0'];
		for(int i=0;i<it.length();i++)
		{
			char chco = it.charAt(i);
			for(String l : recur)
			{
				store.add(chco+l);
			}
		}
		return store;
	}
}
