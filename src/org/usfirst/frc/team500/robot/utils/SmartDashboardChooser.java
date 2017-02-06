package org.usfirst.frc.team500.robot.utils;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



public class SmartDashboardChooser {
    public SendableChooser defenseChooser, shootChooser, allianceChooser, autonomousModeChooser, startPositionChooser, testChooser, modeChooser;

    private SmartDashboardChooser() {
		//create choosers
        startPositionChooser = new SendableChooser();
    	defenseChooser = new SendableChooser();
        shootChooser = new SendableChooser();
        allianceChooser = new SendableChooser();
        testChooser = new SendableChooser();        
        autonomousModeChooser = new SendableChooser();
        modeChooser = new SendableChooser();
        
        initChoosers();
	}
	
    private static SmartDashboardChooser chooser = new SmartDashboardChooser();
    
    public static SmartDashboardChooser getChooser(){
    	return chooser;
    }
    
	public void initChoosers() {

		if (defenseChooser == null) System.out.println("say error in initializing choosers");
       // defenseChooser.addObject("(0) Low Bar", defenseTypeOptions.LOW_BAR);
       // defenseChooser.addObject("(1) Portcullis", defenseTypeOptions.PORTCULLIS);
       // defenseChooser.addObject("(2) Chival de Frise", defenseTypeOptions.CHIVAL_DE_FRISE);
       // defenseChooser.addDefault("(3) Moat", defenseTypeOptions.MOAT);
       // defenseChooser.addObject("(4) Ramparts", defenseTypeOptions.RAMPARTS);
       // defenseChooser.addObject("(5) Drawbridge", defenseTypeOptions.DRAWBRIDGE);
       // defenseChooser.addObject("(6) Sallyport", defenseTypeOptions.SALLYPORT);
       // defenseChooser.addObject("(7) Rock Wall", defenseTypeOptions.ROCK_WALL);
       // defenseChooser.addObject("(8) Rough Terrain", defenseTypeOptions.ROUGH_TERRAIN);
       // defenseChooser.addObject("(-1) Do nothing in Auto.", defenseTypeOptions.NONE);
        SmartDashboard.putData("Defense to cross chooser", defenseChooser);

//        shootChooser.addDefault("Shoot High Left Goal", shootOptions.HIGH_LEFT);
//        shootChooser.addObject("Shoot High Center Goal", shootOptions.HIGH_CENTER);
//        shootChooser.addObject("Shoot High Right Goal", shootOptions.HIGH_RIGHT);
//        shootChooser.addObject("Shoot Low Left Goal", shootOptions.LOW_LEFT);
//        shootChooser.addObject("Shoot Low Right Goal", shootOptions.LOW_RIGHT);
//        shootChooser.addObject("Stay in place.", shootOptions.NONE);
        SmartDashboard.putData("Shoot chooser", shootChooser);

        allianceChooser.addDefault("Red", alliance.RED);
        allianceChooser.addObject("Blue", alliance.BLUE);
        SmartDashboard.putData("Alliance Chooser", allianceChooser);

        //autonomousModeChooser.addObject("Reach AND Cross Only", autonomousModeOptions.REACH_N_CROSS);
        //autonomousModeChooser.addDefault("Reach, Cross AND Shoot", autonomousModeOptions.REACH_N_CROSS_N_SHOOT);
        //autonomousModeChooser.addObject("Reach Only", autonomousModeOptions.REACH);
        //autonomousModeChooser.addObject("Not Moving in Autonomous", autonomousModeOptions.NONE);
        SmartDashboard.putData("Autonomous Mode Chooser", autonomousModeChooser);

        startPositionChooser.addDefault("Start Position 1 (Front of Low Bar)", startPositionOptions.FRONT_OF_DEFENSE_1_LOW_BAR);
        startPositionChooser.addObject("Start Position 2 (Front of 2nd Defense)", startPositionOptions.FRONT_OF_DEFENSE_2 );
        startPositionChooser.addObject("Start Position 3 (Front of 3rd Defense)", startPositionOptions.FRONT_OF_DEFENSE_3);
        startPositionChooser.addObject("Start Position 4 (Front of 4th Defense)", startPositionOptions.FRONT_OF_DEFENSE_4);
        startPositionChooser.addObject("Start Position 5 (Front of 5th Defense)", startPositionOptions.FRONT_OF_DEFENSE_5);
        SmartDashboard.putData("Start Position Chooser", startPositionChooser);

        modeChooser.addDefault("Teleop", teleopModes.TELEOP);
        modeChooser.addObject("Test Mode", teleopModes.TEST);
        SmartDashboard.putData("Teleop Mode Chooser", modeChooser);
               
 	}
	
	public void autoInitChoosers() {
        //Add other defense position text boxes
//        SmartDashboard.putNumber("Defense at Position 1", 0);
//        SmartDashboard.putNumber("Defense at Position 2", 3);
//        SmartDashboard.putNumber("Defense at Position 3", 4);
//        SmartDashboard.putNumber("Defense at Position 4", 7);
//        SmartDashboard.putNumber("Defense at Position 5", 8);
	}	

	public void teleopInitChoosers() {

	}	

	public void testInitChoosers() {
        testChooser.addObject("(0) Test Gyro", diagnosticPOSTOptions.TEST_GYRO);
        testChooser.addObject("(1) Test Ultrasonic", diagnosticPOSTOptions.TEST_ULTRASONIC);
        testChooser.addObject("(2) Test Infrared", diagnosticPOSTOptions.TEST_IR);
        testChooser.addObject("(3) Test Left Talon", diagnosticPOSTOptions.TEST_TALON_LEFT_MASTER);
        testChooser.addObject("(4) Test Right Talon", diagnosticPOSTOptions.TEST_TALON_RIGHT_MASTER);
        testChooser.addObject("(5) Test Drive", diagnosticPOSTOptions.TEST_CHASSIS_DRIVE);
        testChooser.addObject("(6) Test Shooter", diagnosticPOSTOptions.TEST_SHOOTER);
        testChooser.addObject("(7) Test Grappler", diagnosticPOSTOptions.TEST_GRAPPLER);
        testChooser.addObject("(8) Test Alignment", diagnosticPOSTOptions.TEST_ALIGN_TO_CASTLE);
        testChooser.addObject("(9) Test Lift", diagnosticPOSTOptions.TEST_LIFTER);
        testChooser.addObject("(10) Test Motion Profile", diagnosticPOSTOptions.TEST_MOTION_PROFILE);
        testChooser.addObject("(11) Test Global Positioning", diagnosticPOSTOptions.TEST_GLOBAL_POSITIONING);
        testChooser.addObject("(12) Test With Joystick", diagnosticPOSTOptions.TEST_JOYSTICK);
        testChooser.addDefault("(-1) Do Nothing", diagnosticPOSTOptions.TEST_NONE);
        testChooser.addObject("(0) Test Actuator", motorTests.TEST_ACTUATOR);
        testChooser.addObject("(1) Test Left Shooter", motorTests.TEST_LEFT_SHOOTER);
        testChooser.addObject("(2) Test Right Shooter", motorTests.TEST_RIGHT_SHOOTER);
        testChooser.addObject("(3) Test Drive Left Master", motorTests.TEST_DRIVE_LEFT_MASTER);
        testChooser.addObject("(4) Test Drive Right Master", motorTests.TEST_DRIVE_RIGHT_MASTER);
        testChooser.addObject("(5) Test Drive Left Slave", motorTests.TEST_DRIVE_LEFT_SLAVE);
        testChooser.addObject("(6) Test Drive Right Slave", motorTests.TEST_DRIVE_RIGHT_SLAVE);
        SmartDashboard.putData("Test Init Chooser", testChooser);
	}
	
	public enum startPositionOptions {
		FRONT_OF_DEFENSE_1_LOW_BAR,
		FRONT_OF_DEFENSE_2,
		FRONT_OF_DEFENSE_3,
		FRONT_OF_DEFENSE_4,
		FRONT_OF_DEFENSE_5,
		NONE
	}
	
	public enum diagnosticPOSTOptions {
		TEST_GYRO, 
		TEST_ULTRASONIC, 
		TEST_IR,
		TEST_TALON_LEFT_MASTER,
		TEST_TALON_RIGHT_MASTER,
		TEST_CHASSIS_DRIVE,
		TEST_SHOOTER,
		TEST_GRAPPLER,
		TEST_ALIGN_TO_CASTLE,
		TEST_LIFTER,
		TEST_MOTION_PROFILE, 
		TEST_GLOBAL_POSITIONING,
		TEST_JOYSTICK,
		TEST_NONE
	}

	public enum shootHeightOptions {
		HIGH,
		LOW,
		NONE
	}

	public enum shootOptions {
		HIGH_LEFT,
		HIGH_RIGHT,
		HIGH_CENTER,
		LOW_LEFT,
		LOW_RIGHT,
		NONE
	}
	
	public enum defenseTypeOptions {
		LOW_BAR,
		PORTCULLIS,
		CHIVAL_DE_FRISE,
		MOAT,
		RAMPARTS,
		DRAWBRIDGE,
		SALLYPORT,
		ROCK_WALL,
		ROUGH_TERRAIN,
		NONE
	}
	
	public enum endOptions {
		TELEOP_STARTING_POSITION,
		NONE
	}
	
	public enum Speed {
		SLOW, MEDIUM, FAST
	}

	public enum alliance {
		RED, BLUE
	}

	public enum autonomousModeOptions {
		REACH_N_CROSS,
		REACH_N_CROSS_N_SHOOT,
		REACH,
		NONE
	}

	public enum teleopModes {
		TELEOP,
		TEST;
	}

	public enum motorTests {
		TEST_ACTUATOR,
		TEST_LEFT_SHOOTER,
		TEST_RIGHT_SHOOTER,
		TEST_DRIVE_LEFT_MASTER,
		TEST_DRIVE_RIGHT_MASTER,
		TEST_DRIVE_LEFT_SLAVE,
		TEST_DRIVE_RIGHT_SLAVE,
		TEST_NONE;
	}
}
