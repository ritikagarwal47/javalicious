import java.io.*;

public class kayo
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String p = br.readLine();
        StringBuilder sb = new StringBuilder("");
        int n = s.length();
        int m = p.length();
        for(int i=0;i<n;)
        {
            int j=i,c=0;
            boolean ok = true;
            for(;j<n && j<i+m;)
            {
                if(s.charAt(j)==p.charAt(c))
                {
                    ++j;++c;
                }
                else
                {
                    ok = false;
                    break;
                }
            }
            if(ok)
            {
                i=j;
                sb.append((i+1)+"");
            }
            else
            {
            	++i;
            }
        }
        String answer = sb.toString();
        System.out.println(answer);
    }
}
