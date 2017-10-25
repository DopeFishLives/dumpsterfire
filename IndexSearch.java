
public class IndexSearch {
	public static void main(String[] args) 
	{
		int[] arr = {20, 11, 18, 14, 15, 9, 32, 5, 26};
		
		if(binLookUp(arr, 404))
			System.out.println("FOUND IT!");
		else
			System.out.println("didn't find it D:");
		
		if(binLookUp(arr, 404, 1, 5))
			System.out.println("FOUND IT!");
		else
			System.out.println("didn't find it D:");
	}

	public static boolean binLookUp (int[] array, int key)
	{
		for(int i=0; i<array.length;i++)
		{
			if(array[i]==key)
				return true;
		}
		return false;
	}
	
	public static boolean binLookUp (int[] array, int key, int fromInd, int toInd)
	{
		if(toInd>array.length)
			toInd = array.length;
		
		for(int i=fromInd; i<toInd;i++)
		{
			if(array[i]==key)
				return true;
		}
		return false;
	}
	
	public static void draft(int[] array)
	{
		{
			int piv = array[array.length/2];
			array[array.length/2] = array[array.length-1];
			array[array.length-1] = piv;
		}
		
		for(int i=0;;i++)
		{
			
		}
	}
}
