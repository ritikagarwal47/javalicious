import java.util.*;
import java.util.List;
import java.io.*;
class Point
{	//initiating variables
	int first, second;

	public Point(int first, int second)
	{
		this.first = first;
		this.second = second;
	}
}
class Main
{
	public static int[][] preprocess(int[][] mat, int M, int N)
	{
		int[][] sum = new int[mat.length][mat[0].length];
		sum[0][0] = mat[0][0];
		for (int j = 1; j < mat[0].length; j++) {
			sum[0][j] = mat[0][j] + sum[0][j - 1];
		}
		for (int i = 1; i < mat.length; i++) {
			sum[i][0] = mat[i][0] + sum[i - 1][0];
		}
		for (int i = 1; i < mat.length; i++)
		{
			for (int j = 1; j < mat[0].length; j++)
			{
				sum[i][j] = mat[i][j] + sum[i - 1][j] + sum[i][j - 1]
						- sum[i - 1][j - 1];
			}
		}
		return sum;
	}
	public static void findMaxSumSubMatrix(int[][] mat, int k)
	{
		if (mat == null || mat.length == 0) {
			return;
		}
		int M = mat.length;
		int N = mat[0].length;
		int[][] sum = preprocess(mat, M, N);
		int total, max = Integer.MIN_VALUE;
		Point p = null;
		for (int i = k - 1; i < M; i++)
		{
			for (int j = k - 1; j < N; j++)
			{
				total = sum[i][j];
				if (i - k >= 0) {
					total = total - sum[i - k][j];
				}

				if (j - k >= 0) {
					total = total - sum[i][j - k];
				}

				if (i - k >= 0 && j - k >= 0) {
					total = total + sum[i - k][j - k];
				}

				if (total > max)
				{
					max = total;
					p = new Point(i, j);
				}
			}
		}
		int SUM=0;
		for (int i = 0; i < k; i++)
		{
			for (int j = 0; j < k; j++) {
				if(i==1 && j==1)
				{
					continue;
				}
				int r = i + p.first - k + 1;
				int c = j + p.second - k + 1;
				SUM+=mat[r][c];
			}
		}
		System.out.println(SUM);
	}
	public static void main(String[] args)throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int m = Integer.parseInt(s[0]);
		int n = Integer.parseInt(s[1]);
		int[][] mat = new int[m][n];
		for(int i=0;i<m;i++)
		{
			String ar[]= br.readLine().split(" ");
			for(int j=0;j<n;j++)
			{
				mat[i][j]=Integer.parseInt(ar[j]);
			}
		}
		int k = 3;
		findMaxSumSubMatrix(mat, k);
	}
}
