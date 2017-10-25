//System.out.println("");
public class Spacedout_ster_print
{
	public static void main(String[] args)
	{
		tree_print(6);
	}
	public static void tree_print(int n)
	{
		meat_print(n);
		for(int i=0; i<2; i++)
		{
				spacer_print((n)-2);
				ster_print(3);
		}
	}
	
	public static void meat_print(int n)
	{
		for(int i=1; i<=n; i++)
		{
			spacer_print(n-i);
			ster_print((i*2)-1);
		}
	}
	
	public static void rtri_print(int n)
	{
	        for(int i=1; i<=n; i++)
		{
         	       spacer_print(n-i);
         	       ster_print(i);
       		}
	}
	
	public static void spacer_print(int n)
	{
		for(int i=0; i<n; i++)
			System.out.print(" ");
	}
	
	public static void ster_print(int n)
	{
		for(int i=0; i<n; i++)
			System.out.print("*");
			
		System.out.println("");
	}
}
