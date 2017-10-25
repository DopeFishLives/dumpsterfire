import java.util.concurrent.TimeUnit;
import java.io.Console;
//import java.util.Arrays;
import java.util.Random;
//import java.util.Arrays;

public class MemeGame 
{
	public static void main(String[] args)
    {
	    int width = 8, heigth = 8;
	    
		try
		{
			if(Integer.parseInt(args[0]) > 2 && Integer.parseInt(args[1]) > 2)
			{
			width = Integer.parseInt(args[0]);
			heigth = Integer.parseInt(args[1]);
			}
		}
		catch(Exception|Error e)
		{
			
		}
	    
	    
		String con1 = "" + width, con2 = "" + heigth;	    

		//if((width >= 30 && heigth >= 10) || (width >= 10 && heigth >= 30))
		//System.out.println("You have good memory, don't you?");
	    
	    if((width*heigth)%2 == 0)
		meme_start(width, heigth, (con1.length() + con2.length()));
	    else
	    System.out.println("Width and Heigth result in odd number");
	}

	public static void meme_start(int w, int h, int ll)
	{
		Console cokb = null;
		cokb = System.console();

		String[][] dta = new String[h][w];
		String[][] corl = new String[h][w];
		int guess=1, totalg=(w*h)/2;
		
		//dta = array_fill(w, h, 0, ll);
		//for(int i=0; i<1000; i++)
		//System.out.println("Hold on tight, generating game table.");
		
		corl = array_fill(w, h, 0, ll);
		dta = array_fill(w, h, 1, ll);
		//meme_sts_print(dta, w, h, ll, false);
		//meme_sts_print(corl, w, h, ll);
		
		boolean bound = true;
		
	    tom: while(cokb != null)
		{
			try
			{
			    jimmy: while(true)
			    {
				
				meme_sts_print(corl, w, h, ll, bound);
				//TimeUnit.SECONDS.sleep(2);
				bound = false;
				String in1 = cokb.readLine("First: ");

				String[] inf = in1.split(",");
				if(Integer.parseInt(inf[0]) > w || Integer.parseInt(inf[1]) > h)
				{
				    bound = true;
				    break jimmy;
				}
				String in2 = cokb.readLine("Second: ");

				String[] ins = in2.split(",");

				int[] ints = new int[4];
				ints[0] = Integer.parseInt(inf[0])-1; //WHY -1?!?!?!??!? Well, massives start from 0, so, if user picks 1,1 that refers to display name, actually it's 0,0 in massive terms
				ints[1] = Integer.parseInt(inf[1])-1;
				ints[2] = Integer.parseInt(ins[0])-1;
				ints[3] = Integer.parseInt(ins[1])-1;
				if(ints[2] > w || ints[3] > h || (ints[0] == ints[2] && ints[1] == ints[3])) //Big if(check if input is in bounds || (check if first w and second w are equal && repeat, just with h))
				{
				    bound = true;
				    break jimmy;
				}
				//Mostly used for dev 
				//System.out.println(Arrays.toString(inf) + Arrays.toString(ins));

				if(corl[ints[1]][ints[0]].contains("*") && corl[ints[3]][ints[2]].contains("*"))
				{
				    corl[ints[1]][ints[0]] = dta[ints[1]][ints[0]];
				    corl[ints[3]][ints[2]] = dta[ints[3]][ints[2]];
				    meme_sts_print(corl, w, h, ll, false);

				    
				    TimeUnit.SECONDS.sleep(3); //THE MOST INPORTANT TIMER EVER!!!!!!


				    if(corl[ints[1]][ints[0]].matches(corl[ints[3]][ints[2]]))
				    {
					guess++;
					if(guess>=totalg)
					{
					    meme_sts_print(dta, w, h, ll, false);
					    System.out.println("You win!");
					    break tom;
					}
					break jimmy;
				    }

				    corl[ints[1]][ints[0]] = "*";
                                    corl[ints[3]][ints[2]] = "*";

				}
				
			    }
			}
			catch(Exception|Error e)
			{
			    bound = true;
			    //System.out.println(e);
			}
		}
	}


	public static String[][] array_fill(int w, int h, int t, int lim)
	{
		String[][] outarr = new String[h][w];

		if(t==0)
		{
			for(int i=0; i<h; i++)
			{
				for(int v=0; v<w; v++)
					outarr[i][v] = new String("*");
			}
		}

		else
		if(t==1)
		{
			outarr = array_fill(w, h, 0, lim);
			Random rnd = new Random();
			int num_li = power(10, lim)-1;
			//int num_li = 19;
			int num = 0;
			
			for(int i=0; i<h; i++)
			{
				for(int v=0; v<w; v++)
				{
					num = rnd.nextInt(num_li);

					System.out.println(v + " " + i + " Hold on tight, generating game table.");
					
					boolean och = true;
					while(och)
					{
						och = false;
						tim: for(int p=0; p<h; p++)
						{
							for(int o=0; o<w; o++)
							{
								if(outarr[p][o].matches(Integer.toString(num)))
								{
									num = rnd.nextInt(num_li);
									och = true;
									break tim;
								}
							}
						}
					}




					if(outarr[i][v].contains("*"))
					{
						outarr[i][v] = Integer.toString(num);

						int c_w, c_h;

						jim: while(true)
						{
							c_w = rnd.nextInt(w);
							c_h = rnd.nextInt(h);

							if(outarr[c_h][c_w].contains("*"))
							{
								outarr[c_h][c_w] = Integer.toString(num);
								break jim;
							}
						}
					}
				}
			}
		}

		return outarr;
	}

	public static int power(int num, int power)
	{
		int pow=1;

		for(int i=0; i<power; i++)
		{
			pow = pow * num;
		}

		return pow;
	}

	public static void nl_prnt(int l, int t, int ll) // (Lines/Repeats, Type, Length)
	{
		if(t==0) //Simply new lines
		{
			for(int i=0; i<l; i++)
				System.out.println();
		}
		else
		if(t==1) //Decoration line
		{
			nl_prnt(0, 3, ll);
			for(int i=0; i<l; i++)
			{
				System.out.print("+");

				for(int v=0; v<ll; v++)
					System.out.print("-");
			}

			System.out.print("+");
			nl_prnt(1, 0, 0);
		}
		else
		if(t==2) //Spacer with decoration
		{
			for(int i=0; i<ll - l; i++)
				System.out.print(" ");
			System.out.print("|");
		}
		else
		if(t==3) //Spacer without decoration
		{
			for(int i=0; i<ll - l; i++)
				System.out.print(" ");
		}
		else
                if(t==4) //Decoration line                                                                                                                                      
                {		  
		        System.out.print("y\\");
                        nl_prnt(2, 3, ll);
                        for(int i=0; i<l; i++)
                        {
                                System.out.print("+");

                                for(int v=0; v<ll; v++)
                                        System.out.print("-");
                        }

                        System.out.print("+");
                        nl_prnt(1, 0, 0);
                }
	}

    public static void meme_sts_print(String[][] dta, int w, int h, int ll, boolean warn)
	{
	        nl_prnt(200*h, 0, 0);
		System.out.print("\\x");
		nl_prnt(2, 2, ll);

		for(int i=1; i<=w; i++)
		{
			System.out.print(i);

			String con = "" + i;
			nl_prnt(con.length(), 2, ll);
		}

		nl_prnt(1, 0, 0);

		//System.out.print("y\\");
		nl_prnt(w, 4, ll);

		for(int i=0; i<h; i++)
		{
			System.out.print((i+1));
			String con = "" + (1 + i);
			nl_prnt(con.length(), 2, ll);

			for(int v=0; v<w; v++)
			{
				System.out.print(dta[i][v]);
				nl_prnt(dta[i][v].length(), 2, ll);
			}

			nl_prnt(1, 0, 0);
			nl_prnt(w, 1, ll);
		}

		if(warn)
		    {
			System.out.println("Width(x) must be within: " + w + " And heigth(y) must be within: " + h);
			System.out.println("Usage: 'width,heigth' or 'x,y'");
		    }
	}
}
