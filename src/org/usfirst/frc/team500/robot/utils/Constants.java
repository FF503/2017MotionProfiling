package org.usfirst.frc.team500.robot.utils;

public class Constants {
	
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
