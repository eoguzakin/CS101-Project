/**
 * @(#)BattleProject.java
 *
 *
 * @author Oguz Akýn
 * @version 1.00 2021/4/29
 */
 
import java.util.ArrayList;
import java.util.Scanner;
public class BattleApp {
	/**Scanner object*/
	public static Scanner input = new Scanner(System.in);
	/**Fills the alliance array by using user inputs for every army feature.*/
	public static ArrayList<Army> allianceFiller(ArrayList<Army> alliance){
		int i = 0;
		//while there are more armies to take, user inputs army features and they are added to alliance array list
		while(i < 3){
        	System.out.println("");
        	//taking the name
        	System.out.print("What is the name of this army: ");
        	String name = input.next();
        	//taking manpower
        	System.out.print("Manpower: ");
        	long manpower = input.nextInt();
        	//taking technology
        	System.out.print("Technology(x/5): ");
        	double technology = input.nextDouble();
        	//taking army tradition
        	System.out.print("Army Tradition(x/100): ");
        	double tradition = input.nextDouble();
        	//taking general skill
        	System.out.print("General Skill(x/10): ");
        	double skill = input.nextDouble();
        	//taking army drill
        	System.out.print("Army Drill(x/5): ");
        	double drill = input.nextDouble();
        	//constructing a new army object with input features
        	Army army = new Army(name, skill, drill, manpower, tradition, technology);
        	//adding it to the alliance
        	alliance.add(i,army);
        	i++;
        	System.out.println("");
        }
        return alliance;
	}
	/**Gets the total manpower for a particular alliance by getting all armies' manpowers one by one and summing them.*/
	public static long getTotalManpower(ArrayList<Army> armies){
    	long total = 0;
    	for(int i = 0; i < armies.size(); i++){
    		total = total + armies.get(i).getManpower();
    	}
    	return total;
    }
	/**Calculates the cumulative firepower of the allied armies for each 10 hours,
	 *calculation formula: cumulativeFirepower = ((firepower1*manpower1+firepower2*manpower2+firepower3*manpower3+...)/totalManpower).
	 */
    public static double calculateCumulativeFirepower(ArrayList<Army> armies){
    	//strength means the multiplication of manpower and firepower for that specific army
    	double strength = 0;
    	long totalManpower = 0;
    	for(int i = 0; i < armies.size(); i++){
    		strength = strength + (armies.get(i).getFirepower() * armies.get(i).getManpower());
    		totalManpower = totalManpower + armies.get(i).getManpower();
    	}
    	return (strength / totalManpower);
    }
    /**This is the main method of BattleApp.
	  *In here Army objects and two alliance ArrayLists are created with user inputs,
	  *total manpowers of alliances and their cumulative firepowers are calculated and the battle is presented.
	  */
    public static void main(String[] args) {
    	//two alliance array lists
        ArrayList<Army> alliance1 = new ArrayList<Army>();
        ArrayList<Army> alliance2 = new ArrayList<Army>();
        //filling the first alliance with inputs
        System.out.println("-Alliance1-");
        alliance1 = allianceFiller(alliance1);
        //filling the second alliance with inputs
        System.out.println("-Alliance2-");
        alliance2 = allianceFiller(alliance2);
        //inputting battle ground choice
        System.out.println("Select the battle ground: 1)Plains, 2)Marshlands or 3)Mountains ?");
        int battleGround = input.nextInt();
        //creating the battle
        Battle battle = new Battle(getTotalManpower(alliance1),getTotalManpower(alliance2),calculateCumulativeFirepower(alliance1),calculateCumulativeFirepower(alliance2),battleGround); 
        //printing the results
        System.out.println(battle.toString(alliance1,alliance2));
    }
}
