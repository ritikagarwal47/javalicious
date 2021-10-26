package javalicious;
import java.util.*;
import java.io.*;
public class get_subsequence
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		ArrayList<String> ar = findSubsequence(s);
		System.out.println(ar);
	}
	public static ArrayList<String> findSubsequence(String s)
	{
		if(s.length()==0)
		{
			ArrayList<String> ot = new ArrayList<>();
			ot.add("");
			return ot;
		}
		String c = s.charAt(0)+"";
		String ros = s.substring(1);
		ArrayList<String> receive = findSubsequence(ros);
		ArrayList<String> store = new ArrayList<>();
		for(String rp : receive)
		{
			store.add(rp+"");
			store.add(rp+c);
		}
		return store;
	}
}