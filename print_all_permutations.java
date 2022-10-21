import java.util.*;
public class print_all_permutations 
{
	public static void solution(String str)
	{
		int n = str.length();
		int fact = factorial(n);
		for(int i = 0 ; i < fact ; i++)
		{
			StringBuilder sb = new StringBuilder(str);
			int temp = i;
			for( int j = n ; j >= 1 ; j-- )
			{
				int q = temp / j ;
				int r = temp % j ;
				System.out.print(sb.charAt(r));
				sb.deleteCharAt(r);
				temp = q ;
				System.out.println("HI");
			}
			System.out.println();
		}
	}
	
	static int factorial(int n)
	{
		int pro = 1;
		for(int i = 1 ; i <= n ; i++)
		{
			pro *= i;
		}
		return pro;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		solution(str);
	}
}
