package org.usfirst.frc.team500.robot;

import com.ctre.CANTalon;



public class RobotHardwarePracticeBot extends RobotHardware {
	private static CANTalon leftMaster;
	private static CANTalon leftSlave; 
	private static CANTalon rightMaster;
	private static CANTalon rightSlave;
	
	public final int leftMasterID = 3;
	public final int leftSlaveID = 1;
	public final int rightMasterID = 4;
	public final int rightSlaveID  = 2;
	
	public final double WHEEL_DIAMETER = 4.0;
	public final double WHEEL_BASE = 32.5;
	public final double  LOOP_TIME = 0.1;
	
	public final int COUNTS_PER_REV = 512;
	public final double DRIVE_P = 0;
	public final double DRIVE_I = 0;
	public final double DRIVE_D = 0;
	public final double LEFT_DRIVE_F = 0;
	public final double RIGHT_DRIVE_F = 0;
	
	public final boolean REVERSE_LEFT_SENSOR = true;
	public final boolean REVERSE_RIGHT_SENSOR = false;
	public final boolean REVERSE_LEFT_OUTPUT = true;
	public final boolean REVERSE_RIGHT_OUTPUT = false;
	
	@Override
	public void initialize(){
		leftMaster = new CANTalon(leftMasterID);
		leftSlave = new CANTalon(leftSlaveID);
		rightMaster = new CANTalon(rightMasterID);
		rightSlave = new CANTalon(rightSlaveID);
	}
	
	@Override
	public CANTalon getCANTalonObj(int CANTalonID){
		if(CANTalonID == 0){
			return leftMaster;
		}
		else if(CANTalonID == 1){
			return leftSlave;
		}
		else if(CANTalonID == 2){
			return rightMaster;
		}
		else if(CANTalonID == 3){
			return rightSlave;
		}
		else{
			return null;
		}
	}	
	
	@Override
	public String getName(){
		return "ProgrammingBot";
	}
}