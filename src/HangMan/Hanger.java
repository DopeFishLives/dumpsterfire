import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.io.Console;
//System.out.println("");
public class Hanger
{
	public static void main(String[] args)
	{
		hanger_gamein();
	}

	public static void nl_prnt(int n, int d)
	{
		if(d == 0)
			for(int i=0; i<n; i++)
				System.out.println("");

		if(d == 1)
		{
			System.out.print("+");
			for(int i=0; i<n; i++)
				System.out.print("-");

			System.out.println("+");
		}
	}

	public static void menu_print()
	{
		System.out.println(" * menu *");
		System.out.println("quit - quits the game");
		System.out.println("a single letter uses the letter as a guess");
		System.out.println("an empty line prints this menu");
	}

	public static String get_word()
	{
		String word=null;
		int n=0;

		try
		{
			Scanner scam = new Scanner(new File("hgm_words.txt"));
			while(scam.hasNextLine())
			{
				String nil = scam.nextLine();
				//System.out.println(nil);
				n++;
			}
		}
		catch(Exception|Error e)
		{
			crash_msg();
                        System.out.println("Error: Missing or sometihng else did happen: " + e);
                        word = null;
		}

		Random rand = new Random();

		try
		{
			Scanner scam = new Scanner(new File("hgm_words.txt"));
			for(int i=0; i<=rand.nextInt(n); i++)
			{
				word = scam.nextLine();
				//System.out.println(word);
			}
		}
		catch(Exception|Error e)
		{
			crash_msg();
			System.out.println("Error: Missing or sometihng else did happen: " + e);
			word = null;
		}

		return word;
	}

	public static void hanger_gamein()
	{
		int stage=1, g=0, hits=0;
		boolean initialprint = true;
		String word =  get_word(), gl = "", cgl = "", valid_letters = "abcdefghijklmnoprsqtvuwyz";

		Console cokb = null;
		cokb = System.console();

		nl_prnt(200, 0);
		nl_prnt(11, 1);
		System.out.println("|  HANGMAN  |");
		nl_prnt(11, 1);
		menu_print();
		nl_prnt(11, 1);

		while(cokb != null || word != null)
		{
			try
			{
				hanger_print(stage, initialprint);
				initialprint=false;

				System.out.println("Guesses: " + g + " Correct: " + hits + " Misses: " + (stage-1));

				String st_cl = " ";

				jerry: for(int i=0; i<word.length(); i++)
				{
					boolean let=true;
					tim: for(int v=0; v<cgl.length(); v++)
					{

						if(word.regionMatches(true, i, cgl, v, 1))
						{
							st_cl = st_cl + cgl.substring(v, (v+1));
							let=false;
							break tim;
						}
					}
					if(let)
						st_cl = st_cl + "|";
				}

				System.out.println("Word:" + st_cl + " Used latters: " + gl); // Just prints things...

				if(word.length() == hits) // I was lazy and reused 'hits' that tracks successful guesses.
				{
					System.out.println("You win!         Now do something productive.");
					break;
				}

				if(stage>=9) // End the game when you used up all chances.
				{
					System.out.println("GAME OVER");
					break;
				}

				//Read the command line. No idea if this works on shitdows.
				String ca = cokb.readLine("Command: ");

				if(ca.matches("quit"))
				{
					System.out.println("Bye! Don't hit your ass with the door on the way out!");
					break;
				}
				else if(ca.matches("") || ca.matches(" "))
				{
					nl_prnt(200, 0);
					menu_print();
					initialprint=true;
				}

				else
				{
					boolean lc=true;
					for(int i=0; i<cgl.length(); i++)
					{
						if(cgl.regionMatches(true, i, ca, 0, 1))
							lc=false;
					}

					for(int v=0; v<gl.length(); v++)
					{
						if(gl.regionMatches(true, v, ca, 0, 1))
							lc=false;
					}
					for(int i=0; i<valid_letters.length(); i++)
					{
						if(valid_letters.regionMatches(true, i, ca, 0, 1))
						{
							lc=true;
							break;
						}
						else
							lc=false;
					}

					if(ca.length() == 1 && lc)
					{

						boolean allfails=true;
						for(int i=0; i<word.length(); i++)
						{
							if(word.regionMatches(true, i, ca, 0, ca.length()))
							{
								allfails=false;
								hits = hits + ca.length();
								cgl = cgl + ca;
							}
						}
						if(allfails)
						{
							gl = gl + ca;
							stage = stage + ca.length();
						}
						g++;
					}
				}
			}
			catch(Exception|Error e)
			{
				crash_msg();
				System.out.println(e);
				break;
			}
		}
	}

	public static void hanger_print(int stage, boolean clear_print)
	{
		if(!clear_print)
			nl_prnt(200,0);

		try
		{
			@SuppressWarnings("resource")
			Scanner scam = new Scanner(new File("hgn_man" + stage + ".txt"));
			while(scam.hasNextLine())
			{
				System.out.println(scam.nextLine());
			}
		}
		catch(Exception|Error e)
		{
			crash_msg();
			System.out.println("Error: " + e);
		}

	}

	public static void crash_msg()
	{
		Random rand = new Random();
		int string_mass = 15;
		String[] meme = new String[string_mass];

		meme[1]="I'm sorry D:";
		meme[2]="Free hug?";
		meme[3]=" 10/10 ";
		meme[4]="I'm awful at coding, what can you do?";
		meme[5]="It's not your fault :(";
		meme[6]="I have no cookies, they got stolen the cookie monster.";
		meme[7]="Gordon was here.";
		meme[8]="Nope, wrong game.";
		meme[9]="Don't cry );";
		meme[0]="Never divide by zero.";
		meme[10]="Cookie?";
		meme[11]="Don't eat in shady chinese inn.";
		meme[12]="Shinobu isn't here.";
		meme[13]="Behind you.";
		meme[14]="This statement is false.";

		System.out.println(meme[rand.nextInt(string_mass-1)]);

		System.out.println("");
	}
}
