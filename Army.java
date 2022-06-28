/**
 * @(#)Army.java
 *
 *
 * @author Oguz Akýn
 * @version 1.00 2021/4/29
 */
 /**In Army class, you create an army object taking the following features as parameters:
  *armyName, generalSkill, armyDrill, manpower, armyTradition, technology and firepower.
  */
public class Army {
	//Variables
	private String armyName;
	private double generalSkill;
	private double armyDrill;
	private long manpower;
	private double armyTradition;
	private double technology;
	private double firepower;
	/**
	 *Army object that takes these variables as parameters:
	 *ArmyName, GeneralSkill, ArmyDrill, Manpower, ArmyTradition, Technology.
	 */
    public Army(String ArmyName, double GeneralSkill, double ArmyDrill, long Manpower, double ArmyTradition, double Technology){
    	armyName = ArmyName;
    	//if the general skill is between 10 and 0, parameter is assigned as variable
    	if(GeneralSkill <= 10 && GeneralSkill >= 0){
    		generalSkill = GeneralSkill;
    	}
    	//else base value is set as variable
    	else{
    		generalSkill = 0;
    	}
    	//if armyDrill is between 0 and 5, parameter is assigned as variable
    	if(0 <= ArmyDrill && ArmyDrill <= 5){
    		armyDrill = ArmyDrill;
    	}
    	//else base value is set as variable
    	else{
    		armyDrill = 0;
    	}
    	//if manpower is bigger than 0, parameter is assigned as variable
    	if(0 < Manpower){
    		manpower = Manpower;
    	}
    	//else base value is set as variable
    	else{
    		manpower = 1;
    	}
    	//if ArmyTradition is between 0 and 100, parameter is assigned as variable
    	if(0 <= ArmyTradition && ArmyTradition <= 100){
    		armyTradition = ArmyTradition;
    	}
    	//else base value is set as variable
    	else{
    		armyTradition = 0.1;
    	}
    	//if technology is between 0 and 5, parameter is assigned as variable
    	if(0 <= Technology && Technology <= 5){
    		technology = Technology;
    	}
    	//else base value is set as variable
    	else{
    		technology = 0.25;
    	}
    	calculateFirepower();
    }
    //Getters
    /**
     *Gets army name.
     */
    public String getArmyName(){
    	return armyName;
    }
    /**
     *Gets general skill.
     */
    public double getGeneralSkill(){
    	return generalSkill;
    }
    /**
     *Gets army drill.
     */
    public double getArmyDrill(){
    	return armyDrill;
    }
    /**
     *Gets manpower.
     */
    public long getManpower(){
    	return manpower;
    }
    /**
     *Gets army tradition.
     */
    public double getArmyTradition(){
    	return armyTradition;
    }
    /**
     *Gets technology level.
     */
    public double getTechnology(){
    	return technology;
    }
    /**
     *Gets firepower.
     */
    public double getFirepower(){
    	return firepower;
    }
    //Setters
    /**
     *Sets army name.
     */
    public void setArmyName(String name){
    	armyName = name;
    }
    /**
     *Sets generalSkill if it is between 0 and 10, else, then base value, 0, is assigned.
     */
    public void setGeneralSkill(double skill){
    	if(0<= skill && skill <= 10){
    		generalSkill = skill;
    	}
    	else{
    		//base value
    		generalSkill = 0;
    	}
    }
    /**
     *Sets armyDrill if it is between 0 and 5, else, then base value, 0, is assigned.
     */
    public void setArmyDrill(double drill){
    	if(0<= drill && drill <= 5){
    		armyDrill = drill;
    	}
    	else{
    		//base value
    		armyDrill = 0;
    	}
    }
    /**
     *Sets manpower if it is larger than 0, if not then assigns the base value, 1.
     */
    public void setManpower(long man){
    	if(0 < man){
    		manpower  = man;
    	}
    	else{
    		//base value
    		manpower = 1;
    	}
    }
    /**
     *Sets armyTradition if it is between 0  and 100, if not then assigns the base value, 0.1.
     */
    public void setArmyTradition(double tradition){
    	if(0 < tradition && tradition <= 100){
    		armyTradition = tradition;
    	}
    	else{
    		//base value
    		armyTradition = 0.1;
    	}
    }
    /**
     *Sets technology level if it is between 0 and 5, if not assigns the base value, 0.25.
     */
    public void setTechnology(double tech){
    	if(0 < tech && tech <= 5){
    		technology = tech;
    	}
    	else{
    		technology = 0.25;
    	}
    }
    //Service Methods
    /**
     *Calculates the firepower of this army for each 10 hours which is the normal period to inflict firepower to the enemy.
     *Formula: (armyTradition + (armyDrill * technology * generalSkill)) / 1000
     */
    public void calculateFirepower(){
    	firepower = (armyTradition + (armyDrill * technology * generalSkill)) / 1000;
    }
    /**
     *Returns a string representation of an army using all its features.
     */
    public String toString(){
    	String s = "Army Name: " + armyName + " Manpower: " + manpower + " Firepower: " + firepower;
    	s = s + " Army Tradition: " + armyTradition + " General Skill: " + generalSkill + " Technology: " + technology + " Drill: " + armyDrill;
    	return s;
    }
}