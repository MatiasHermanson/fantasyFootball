package fantasy_football;

import java.util.Scanner;

public class FantasyFootball
{
	private int numberOfTeams; 
	private int numberOfWeeks; 
	private int[][] scores; 
	private double[] weekAverage; 
	private double[] teamAverage; 
	private String[] teamName; 
	
	Scanner keyboard = new Scanner(System.in);
	
 public void enterInData( )
 {
	 System.out.println("Enter number of teams:");
	 numberOfTeams = keyboard.nextInt( );
	 System.out.println("Enter number of weeks:");
	 numberOfWeeks = keyboard.nextInt( );
	 keyboard.nextLine();
	 scores = new int [numberOfTeams][numberOfWeeks];
	 weekAverage = new double [numberOfWeeks];
	 teamAverage = new double [numberOfTeams];
	 teamName = new String[numberOfTeams];
	 
	 for (int i = 0; i < numberOfTeams; i++)
	 {
		 System.out.println("Please enter a name for the team: ");
		 teamName [i] = keyboard.nextLine();
		 
		 for (int j = 0; j < numberOfWeeks; j++)
		 {
			 System.out.println("Please enter a score for week: " + (j+1));
			 scores [i] [j] = keyboard.nextInt();
			 keyboard.nextLine();
		 }
	 }
}

 	public void fillTeamAverage( )
 	{
 		int total;
 		
 		for (int i = 0; i < numberOfTeams; i++)
 		{
 			total = 0;
 			
 			for (int j = 0; j < numberOfWeeks; j++)
 			{
 				total += scores[i][j];
 			}
 			teamAverage[i] = total/numberOfWeeks;
 		}
 	}

 	public void fillWeekAverage( )
 	{
 		int total;
 		for (int i = 0; i < numberOfWeeks; i++)
 		{
 			total = 0;
 			for (int j = 0; j < numberOfTeams; j++)
 			{
 				total = total + scores [j][i];
 			}
 			weekAverage [i] = total/numberOfTeams;
 		}

 	}
 	public void display( )
 	{
 		System.out.printf("%15s", "team name:");
 		for (int i  = 0; i < numberOfWeeks; i++)
 		{
 			System.out.printf("%15s %d", "week", i +1);
 		}
 		System.out.println();
 		
 		for (int i = 0; i < numberOfTeams; i++)
 		{
 			System.out.printf("%15s", teamName [i]);
 			
 			for (int j = 0; j  < numberOfWeeks; j++)
 			{
 				System.out.printf("%15d", scores [i][j]);
 			}
 			System.out.printf("Average = %.2f", teamAverage[i]);
 			System.out.println();
 		}
 		System.out.printf("%15s", "weekAverage:");
 		for (int i = 0; i < numberOfWeeks; i++ )
 		{
 			System.out.printf("%15.2f", weekAverage[i]);
 		}
 	}

 	public static void main(String[] args)
 	{
 		FantasyFootball f= new FantasyFootball();
 		f.enterInData();
 		f.fillTeamAverage();
 		f.fillWeekAverage();

 		f.display();
 	}
}
