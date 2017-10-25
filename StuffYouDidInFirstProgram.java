import java.util.Arrays;

public class StuffYouDidInFirstProgram {
	public static void main(String[] args) 
	{
		int[] val = {99, 100, 40, 1, 20, 40, 50, 10, 50, 60};
		
		System.out.println("Small: " + Arrays.toString(val));
		
		swap_Thefucboys(val , 1, 0);
		System.out.println("Small: " + Arrays.toString(val));
		
		swap_Thefucboys(val, 7, 3);
		System.out.println("Small: " + Arrays.toString(val));
	}

	public static int small_cokb(int[] val)
	{
		int ret=val[0];
		for(int i=1; i<val.length; i++)
		{
			if(val[i]<ret)
				ret = val[i];
		}
		return ret;
	}
	
	public static int small_cokb_ind(int[] val)
	{
		int ret=val[0];
		for(int i=1; i<val.length; i++)
		{
			if(val[i]<ret)
				ret = i;
		}
		return ret;
	}
	
	public static int small_cokb_ind_fucboys(int[] val, int fuc)
	{
		int ret=val[fuc];
		for(int i=fuc; i<val.length; i++)
		{
			if(val[i]<ret)
				ret = i;
		}
		return ret;
	}
	
	public static void prnt(int val1, int val2)
	{
		System.out.println(val1);
		System.out.println(val2);
	}
	
	public static void swap_Thefucboys(int[] val, int dex1, int dex2)
	{
		//prnt(val[dex1], val[dex2]);
		int swp=val[dex1];
		val[dex1] = val[dex2];
		val[dex2] = swp;
	}
}
