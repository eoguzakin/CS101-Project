/**
 * @(#)Battle.java
 *
 *
 * @author Oguz Akýn
 * @version 1.00 2021/4/29
 */
 
/**In this class you can simulate a battle using the manpower and firepower features of two alliances,
 *calculate how many days or hours this battle will go on according to the battle ground
 *and calculate who the winner alliance is.
 *This class does not have setter methods as its variables are determined by the values passed as parameters.
 */
import java.util.ArrayList;
public class Battle {
	//Variables
	/**Manpower of each alliance 1*/
	private double manpower1;
	/**Manpower of each alliance 2*/
	private double manpower2;
	/**Firepower of alliance 1*/
	private double firepower1;
	/**Firepower of alliance 2*/
	private double firepower2;
	/**Choice of battle ground*/
	private int battleGround;
	/**Battle speed modifier*/
	private double battleSpeed = 1.0;
	/**Hour representation of battle duration*/
	private double battleHours = 0;
	/**Day representation of battle duration*/
	private int battleDays = 0;
	/**Indicator of the winner alliance*/
	private int winnerAlliance;
	
	/**Battle object with these features passed as parameters: Manpower1, Firepower1, Manpower2, Firepower2, BattleGround*/
    public Battle(double Manpower1, double Manpower2, double Firepower1, double Firepower2, int BattleGround){
    	manpower1 = Manpower1;
    	manpower2 = Manpower2;
    	firepower1 = Firepower1;
    	firepower2 = Firepower2;
    	battleGround = BattleGround;
    	//deciding the battle speed modifier using the battle ground
    	battleSpeedDecider();
    	//determining the winner and the tme passed
    	battleTimeAndWinnerCalculator();
    	//modifiying the time by multiplying it with the speed variable
    	battleHours = battleHours * battleSpeed;
    	//calculating how many days the battle lasted
    	calculateBattleDay();
    }
    /*Getters*/
    /**Gets winner by integer representation.*/
    public int getWinner(){
    	return winnerAlliance;
    }
    /**Gets duration of hours*/
    public double getBattleHours(){
    	return battleHours;
    }
    /**Gets the manpower of the first alliance.*/
    public double getManpower1(){
    	return manpower1;
    }
    /**Gets the manpower of the second alliance.*/
    public double getManpower2(){
    	return manpower2;
    }
    /**Gets battle speed modifier.*/
    public double getBattleSpeed(){
    	return battleSpeed;
    }
    /**Gets duration of days.*/
    public int getBattleDays(){
    	return battleDays;
    }
    /**Gets the firepower of the first alliance.*/
    public double getFirepower1(){
    	return firepower1;
    }
    /**Gets the firepower of the second alliance.*/
    public double getFirepower2(){
    	return firepower2;
    }
    /*Services*/
    /**Determines the battle speed modifier using the battle ground.
     *If it is Plains battleSpeed = 0.5. Because, in plains the battle goes faster. So, speed modifier makes the duration half as long.
     *If it is Marshlands battleSpeed = 2. Because, in marshlands the battle goes very slow as the soil is slippery. So, the modifier makes duration twice as long.
     *If it is Mountains battleSpeed = 1.5. Because, in mountains the battle goes slow as positions are strong to take. So, duration becomes 1.5 times longer.
     */
    public void battleSpeedDecider(){
    	//Plains
    	if(battleGround == 1){
    		battleSpeed = 0.5;
    	}
    	//Marshlands
    	else if(battleGround == 2){
    		battleSpeed = 2;
    	}
    	//Mountains
    	else if(battleGround == 3){
    		battleSpeed = 1.5;
    	}
    }
    /**Determines the winner and battle time.
     *Each period, each army suffers casualities by their manpower and other's firepower.
     *Each period is 10 hours. So, battle time increases 10 hours base each period.
     *If one alliance hits below %20 of its manpower it retreats and others win.
     *If they both hit below %20 at the same period they both retreat and there is no winner.
     */
    public void battleTimeAndWinnerCalculator(){
    	//creating backups of manpowers to use them elsewhere
    	double backupManpower1 = manpower1;
    	double backupManpower2 = manpower2;
    	//calculating the reserve manpower of each alliance which is %20
    	double reserve1 = manpower1 * 0.2;
    	double reserve2 = manpower2 * 0.2;
    	int i = 0;
    	//if one alliance hits below %20 of its manpower it retreats and others win
    	//if they both hit below %20 at the same period they both retreat and there is no winner
    	while(manpower1 > reserve1 && manpower2 > reserve2){
    		
    		battleHours = battleHours + 10;
    		manpower1 = manpower1 - (manpower1 * firepower2);
    		manpower2 = manpower2 - (manpower2 * firepower1);
    		i++;
    	}
    	//We check who wins
    	//if they have both retreated its a tie
    	if(manpower1 < reserve1 && manpower2 < reserve2){
    		winnerAlliance = 0;
    	}
    	//if the second has retreated, the first wins
    	else if(manpower1 > reserve1 && manpower2 < reserve2){
    		winnerAlliance = 1;
    	}
    	//if the first has retreated, the second wins
    	else if(manpower1 < reserve1 && manpower2 > reserve2){
    		winnerAlliance = 2;
    	}
    	manpower1 = backupManpower1;
    	manpower2 = backupManpower2;
    }
    /**Calculates battle duration of days by extraction 24 hours while battleHours is larger than 24 and incrementing battleDays.*/
    public void calculateBattleDay(){
    	//while hours is more than 24, days become incremented and hours decrease by 24
    	while(battleHours>=24){
    		battleDays++;
    		battleHours = battleHours - 24;
    	}
    }
    /**String representation of this battle.*/
    public String toString(ArrayList<Army> alliance1, ArrayList<Army> alliance2){
    	String s = "\n-Alliance1-\n";
    	for(int i = 0; i < alliance1.size(); i++){
        	s = s + alliance1.get(i).toString() + "\n";
        }
        s = s + "Total Manpower: " + manpower1 + " Cumulative Firepower: " + firepower1 + "\n";
        s = s + "\n-Alliance2-\n";
        for(int i = 0; i < alliance2.size(); i++){
        	s = s + alliance2.get(i).toString() + "\n";
        }
        s = s + "Total Manpower: " + manpower2 + " Cumulative Firepower: " + firepower2;
    	s = s + "\nWinner alliance is: Alliance" + winnerAlliance;
    	s = s + "\nThis battle has lasted " + battleDays + " days and " + battleHours + " hours.";
    	return s;
    }
}