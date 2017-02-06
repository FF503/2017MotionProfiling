package org.usfirst.frc.team500.robot;

import com.ctre.CANTalon;



public class RobotHardwareProgrammingBot extends RobotHardware {
	private static CANTalon leftMaster;
	private static CANTalon leftSlave; 
	private static CANTalon rightMaster;
	private static CANTalon rightSlave;
	
	public final int leftMasterID = 2;  //front left
	public final int leftSlaveID = 1;	//back left
	public final int rightMasterID = 4;	//front right
	public final int rightSlaveID  = 3; //back right
	
	public final double WHEEL_DIAMETER = 8.0;
	public final double WHEEL_BASE = 27.0;
	public final double CYCLE_TIME = 0.01;
	public final int COUNTS_PER_REV = 360;
	
	public final double DRIVE_P = 0;
	public final double DRIVE_I = 0;
	public final double DRIVE_D = 0;//1.5;
	public final double LEFT_DRIVE_F = 1.50220264;
	public final double RIGHT_DRIVE_F = 1.51780415;
	
	public final boolean REVERSE_LEFT_SENSOR = false;
	public final boolean REVERSE_RIGHT_SENSOR = true;
	public final boolean REVERSE_LEFT_OUTPUT = false;
	public final boolean REVERSE_RIGHT_OUTPUT = true;
	
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
