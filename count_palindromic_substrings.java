 import java.util.*;
import java.io.*;
public class count_palindromic_substrings
{
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		boolean dp[][] = new boolean[s.length()][s.length()];
		for(int g=0;g<s.length();g++)
		{
			for(int i=0,j=g;j<dp.length;i++,j++)
			{
				if(i==j)
				{
					dp[i][j]=true;
				}
				else if(g==1)
				{
					if((s.charAt(i)+"").equals(s.charAt(j)+""))
					{
						dp[i][j]=true;
					}
					else
					{
						dp[i][j]=false;
					}
				}
				else
				{
					if(((s.charAt(i)+"").equals(s.charAt(j)+"")) && dp[i+1][j-1]==true)
					{
						dp[i][j]=true;
					}
					else
					{
						dp[i][j]=false;
					}
				}
			}
		}
		int count = 0;
		ArrayList<String> ar = new ArrayList<>();
		for(int i=0;i<s.length();i++)
		{
			for(int j=0;j<dp.length;j++)
			{
				if(dp[i][j]==true)
				{
					count++;
					ar.add(s.substring(i, j+1));
				}
			}
		}
		System.out.println("Total Number of Palindromic Substrings:-"+count);
		System.out.println(ar);
	}
}
