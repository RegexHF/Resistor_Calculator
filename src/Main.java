import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(System.in);
		File file = new File("Values.txt");
		if(!file.exists())file.createNewFile();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		
		/*
		 * Hardcoded 4 Band Resistor
		 */
		
		while(true)
		{
			try
			{
				System.out.println("Enter Band Number (4/5/DONE)");
				String bandStr = scan.nextLine();
				
				if(bandStr.equals("4"))
				{
					bands4(scan, bw);
				}
				
				if(bandStr.equals("5"))
				{
					bands5(scan, bw);
				}
				if(bandStr.equals("DONE"))
				{
					break;
				}
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		
		bw.close();
		System.out.println("THANKS FOR WATCHING!");
		System.exit(-1);
	}
	
	public static void bands4(Scanner scan, BufferedWriter bw) throws Exception
	{
		System.out.println("Enter First Band Color");
		String c1 = scan.nextLine();
		int c1Val = 0;
		
		System.out.println("Enter Second Band Color");
		String c2 = scan.nextLine();
		int c2Val = 0;
		
		System.out.println("Enter Multiplier Band Color");
		String mul = scan.nextLine();
		float mulVal = 0;
		
		System.out.println("Enter Tolerance Band Color");
		String tol = scan.nextLine();
		float tolVal = 0;
		
		/*
		 * Reads 2 Bands 1 Multiplier 1 Tolerance
		 * Checks if the string = the band name then sets the value to the band value
		 * 1 Array - Colors
		 * 1 Array - Multiplier
		 * 1 Array - Tolerance
		 */
		
		for(Band b : color)
		{
			if(b.getName().equals(c1))
			{
				c1Val = (int)b.getVaule();
				bw.write("Color: "  + b.getName() + "\n");
			}
		}
		
		for(Band b : color)
		{
			if(b.getName().equals(c2))
			{
				c2Val = (int)b.getVaule();
				bw.write("Color: "  + b.getName() + "\n");
			}
		}
		
		for(Band b : multiplier)
		{
			if(b.getName().equals(mul))
			{
				mulVal = b.getVaule();
				bw.write("Multiplier: "  + b.getName() + "\n");
			}
		}
		
		for(Band b : tolerance)
		{
			if(b.getName().equals(tol))
			{
				tolVal = b.getVaule();
				bw.write("Tolerance: "  + b.getName() + "\n");
			}
		}
		
		/*
		 * Too Lazy; Didn't Explain
		 * Really Simple Math
		 */
		
		String nomStr = c1Val + "" + c2Val;
		float nomialVal = Float.parseFloat(nomStr) * mulVal;
		bw.write("Nominal: " + nomialVal + "\n");
		
		float baseTol = nomialVal * tolVal;
		float a = nomialVal + baseTol;
		float b = nomialVal - baseTol;
		
		System.out.println("Higher: " + a);
		System.out.println("Lower: " + b);
		bw.write("Higher: " + a + "\n");
		bw.write("Lower: " + b + "\n");
		bw.write("\n");
	}
	
	public static void bands5(Scanner scan, BufferedWriter bw) throws Exception
	{
		System.out.println("Enter First Band Color");
		String c1 = scan.nextLine();
		int c1Val = 0;
		
		System.out.println("Enter Second Band Color");
		String c2 = scan.nextLine();
		int c2Val = 0;
		
		System.out.println("Enter Third Band Color");
		String c3 = scan.nextLine();
		int c3Val = 0;
		
		System.out.println("Enter Multiplier Band Color");
		String mul = scan.nextLine();
		float mulVal = 0;
		
		System.out.println("Enter Tolerance Band Color");
		String tol = scan.nextLine();
		float tolVal = 0;
		
		/*
		 * Reads 2 Bands 1 Multiplier 1 Tolerance
		 * Checks if the string = the band name then sets the value to the band value
		 * 1 Array - Colors
		 * 1 Array - Multiplier
		 * 1 Array - Tolerance
		 */
		
		for(Band b : color)
		{
			if(b.getName().equals(c1))
			{
				c1Val = (int)b.getVaule();
				bw.write("Color: "  + b.getName() + "\n");
			}
		}
		
		for(Band b : color)
		{
			if(b.getName().equals(c2))
			{
				c2Val = (int)b.getVaule();
				bw.write("Color: "  + b.getName() + "\n");
			}
		}
		
		for(Band b : color)
		{
			if(b.getName().equals(c3))
			{
				c3Val = (int)b.getVaule();
				bw.write("Color: "  + b.getName() + "\n");
			}
		}
		
		for(Band b : multiplier)
		{
			if(b.getName().equals(mul))
			{
				mulVal = b.getVaule();
				bw.write("Multiplier: "  + b.getName() + "\n");
			}
		}
		
		for(Band b : tolerance)
		{
			if(b.getName().equals(tol))
			{
				tolVal = b.getVaule();
				bw.write("Tolerance: "  + b.getName() + "\n");
			}
		}
		
		/*
		 * Too Lazy; Didn't Explain
		 * Really Simple Math
		 */
		
		String nomStr = c1Val + "" + c2Val + c3Val;
		float nomialVal = Float.parseFloat(nomStr) * mulVal;
		System.out.println("Nominal: " + nomialVal);
		bw.write("Nominal: " + nomialVal + "\n");
		
		float baseTol = nomialVal * tolVal;
		float a = nomialVal + baseTol;
		float b = nomialVal - baseTol;
		
		System.out.println("Higher: " + a);
		System.out.println("Lower: " + b);
		bw.write("Higher: " + a + "\n");
		bw.write("Lower: " + b + "\n");
		bw.write("\n");
	}
	
	/*
	 * The Original Function!
	 * It's What The Cool Kids Use
	 */
	
	public static void originalFunction(Scanner scan)
	{
		System.out.println("Enter Nomial Value");
		float ogVal = Float.parseFloat(scan.nextLine());
		System.out.println("Enter Multiplier Value");
		float multiplier = Float.parseFloat(scan.nextLine());
		float ogValMul = ogVal * multiplier;
		float a = ogVal + ogValMul;
		float b = ogVal - ogValMul;
		System.out.println("Higher: " + a);
		System.out.println("Lower: " + b);
	}
	
	/*
	 * The Various ArrayLists
	 */
	
	@SuppressWarnings("serial")
	public static ArrayList<Band> color = new ArrayList<Band>(){{
		add(new Band("BLACK", 	0));
		add(new Band("BROWN", 	1));
		add(new Band("RED", 	2));
		add(new Band("ORANGE", 	3));
		add(new Band("YELLOW", 	4));
		add(new Band("GREEN", 	5));
		add(new Band("BLUE", 	6));
		add(new Band("VIOLET", 	7));
		add(new Band("GRAY", 	8));
		add(new Band("WHITE", 	9));
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<Band> multiplier = new ArrayList<Band>(){{
		add(new Band("SILVER", 	0.01f));
		add(new Band("GOLD", 	0.1F));
		add(new Band("BLACK", 	1));
		add(new Band("BROWN", 	10));
		add(new Band("RED", 	100));
		add(new Band("ORANGE", 	1000));
		add(new Band("YELLOW", 	10000));
		add(new Band("GREEN", 	100000));
		add(new Band("BLUE", 	1000000));
		add(new Band("VIOLET", 	10000000));
		add(new Band("GRAY", 	100000000));
		add(new Band("WHITE", 	1000000000));
	}};
	
	@SuppressWarnings("serial")
	public static ArrayList<Band> tolerance = new ArrayList<Band>(){{
		add(new Band("NONE", 	0.2F));
		add(new Band("SILVER", 	0.1F));
		add(new Band("GOLD", 	0.05F));
	}};
	
}
