package org.usfirst.frc.team500.robot.subsystems;

import org.usfirst.frc.team500.robot.Robot;
import org.usfirst.frc.team500.robot.motionProfile.TrapezoidThread;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DrivetrainSubsystem extends Subsystem {

   // Put methods for controlling this subsystem
   // here. Call these from Commands.
	
	private CANTalon leftMaster, leftSlave, rightMaster, rightSlave;
	private double talonLeftPos, talonRightPos, talonLeftRPM, talonRightRPM, rightSpeed, leftSpeed;
	private double curTime, difTime, lastTime;         
	private TrapezoidThread trapThread;
	private static int currentProfileID;
	public boolean profileHasFinished = false;
	private boolean firstLogFileRun = true;
  
   public DrivetrainSubsystem() {
	   
	   	System.out.println("constructing drive train");
	   	leftMaster = Robot.bot.getCANTalonObj(0);
		leftSlave = Robot.bot.getCANTalonObj(1);
		rightMaster = Robot.bot.getCANTalonObj(2);
		rightSlave = Robot.bot.getCANTalonObj(3);
		
		
		leftMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		rightMaster.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
		leftMaster.configEncoderCodesPerRev(Robot.bot.COUNTS_PER_REV);
		rightMaster.configEncoderCodesPerRev(Robot.bot.COUNTS_PER_REV);
		
		setDrivePID(Robot.bot.DRIVE_P, Robot.bot.DRIVE_I, Robot.bot.DRIVE_D);
		
		leftMaster.setF(Robot.bot.LEFT_DRIVE_F);
		rightMaster.setF(Robot.bot.RIGHT_DRIVE_F);
		
		leftSlave.changeControlMode(TalonControlMode.Follower);
	   	rightSlave.changeControlMode(TalonControlMode.Follower);
	   	leftSlave.set(Robot.bot.leftMasterID);
	   	rightSlave.set(Robot.bot.rightMasterID);
		
	   	setDriveDirectionForward();
	   	setBrakeMode(true);
	   	
	   	    	
	   	trapThread = new TrapezoidThread(leftMaster, rightMaster);	
   }
   
   public void setBrakeMode(boolean value){
	   rightMaster.enableBrakeMode(value);
	   leftMaster.enableBrakeMode(value);	
	   rightSlave.enableBrakeMode(value);
	   leftSlave.enableBrakeMode(value);
   }
   
   public void setDrivePID(double p, double i, double d){
		leftMaster.setPID(p, i, d);
		rightMaster.setPID(p, i, d);
   }
   
   private void waitForTrapezoidalFinish() {
		while(true){
			if(getTrapStatus().equals("finished") && (getTrapID() == currentProfileID)){
				profileHasFinished = true;
				break;
			}
		}
		
	}
   
   public CANTalon getLeftMaster(){
	   return leftMaster;
   }
   
   public CANTalon getRightMaster(){
	   return rightMaster;
   }
   
   public void runProfileLeftRight(double[][] leftPoints, double[][] rightPoints){
	   leftMaster.enableBrakeMode(true);
	   rightMaster.enableBrakeMode(true);
   		System.out.println("runProfileLeftRight");
   		profileHasFinished = false;
		currentProfileID++;
		startTrapezoidControl(leftPoints, rightPoints, currentProfileID);
		waitForTrapezoidalFinish();
		System.out.println("Time: " + Timer.getFPGATimestamp());		
	}
   
	public void startTrapezoidControl(double[][] leftPoints, double[][] rightPoints,int trapID) {	
		System.out.println("startTrapezoidControl");
		trapThread.activateTrap(leftPoints, rightPoints, trapID);
	}
	
	public void stopTrapezoidControl() {
		System.out.println("stopTrapezoidControl");
		trapThread.resetTrapezoid();
	}
	
	public synchronized int getTrapID(){
		return trapThread.getID();
	}

	public synchronized String getTrapStatus(){
		return trapThread.getStatus();
	}
   
   public void percentVoltageMode(){
	   leftMaster.changeControlMode(TalonControlMode.PercentVbus);
	   rightMaster.changeControlMode(TalonControlMode.PercentVbus);
   }
   
   public void initDefaultCommand() {
       // Set the default command for a subsystem here.
       //setDefaultCommand(new MySpecialCommand());
   }
    
    public void resetEncoders(){
   	 	System.out.println("reset encoders");
   	 	leftMaster.setEncPosition(0);
		rightMaster.setEncPosition(0);
	}
    
	private static DrivetrainSubsystem instance = new DrivetrainSubsystem();
	
	public static DrivetrainSubsystem getInstance(){
		return instance;
	}
	
	private void setMotorOutputs(double leftSpeed, double rightSpeed, boolean sensitivity){
		if(sensitivity){
			//leftSpeed = setDriveSensitivity(leftSpeed);
			//rightSpeed = setDriveSensitivity(rightSpeed);
		}		
		leftMaster.set(-leftSpeed); 
		rightMaster.set(rightSpeed); 
	}
	
	/*private static double setDriveSensitivity(double input){
		if (!Robot.bot.getName().equals("ProgrammingBot")){
			input = RobotMap.DRIVE_SENSITIVITY*Math.pow(input, 3) + (1-RobotMap.DRIVE_SENSITIVITY)*input;
			return input;
		}
		else{
			return (Double) null;
		}
		
	}*/
	
   private static double limit(double num) {
       if (num > 1.0) {
           num= 1.0;
       }
       else if (num < -1.0) {
           num= -1.0;
       }
       	return num;
   }
   
    public void backwardsFullVelocity(){
		setMotorOutputs(1,1,false);
	}
	public void forwardsFullVelocity(){
		setMotorOutputs(-1,-1,false);
	}
   	
	public void arcadeDrive(double moveValue, double rotateValue, boolean sensitivity) {
       double leftMotorSpeed;
       double rightMotorSpeed;

       moveValue = limit(moveValue);
       rotateValue = limit(rotateValue);

       if (moveValue > 0.0) {
           if (rotateValue > 0.0) {
               leftMotorSpeed = moveValue - rotateValue;
               rightMotorSpeed = Math.max(moveValue, rotateValue);
           } else {
               leftMotorSpeed = Math.max(moveValue, -rotateValue);
               rightMotorSpeed = moveValue + rotateValue;
           }
       } else {
           if (rotateValue > 0.0) {
               leftMotorSpeed = -Math.max(-moveValue, rotateValue);
               rightMotorSpeed = moveValue + rotateValue;
           } else {
               leftMotorSpeed = moveValue - rotateValue;
               rightMotorSpeed = -Math.max(-moveValue, -rotateValue);
           }
       }
       setMotorOutputs(leftMotorSpeed, rightMotorSpeed,sensitivity);
   }
	
   public void tankDrive(double leftValue, double rightValue, boolean sensitivity) {

       // square the inputs (while preserving the sign) to increase fine control while permitting full power
       leftValue = limit(leftValue);
       rightValue = limit(rightValue);

       setMotorOutputs(leftValue, rightValue, sensitivity);
   }    
   public TrapezoidThread getTrapThread() {
		return trapThread;
	}
   
   
   public void populateLog(double startTime){
   	if (firstLogFileRun){
   		lastTime = startTime;
   		firstLogFileRun = false;
   	}
   	curTime = Timer.getFPGATimestamp();
   	difTime = curTime - lastTime;
   	
   	if (difTime >= .1){
       	talonLeftPos = leftMaster.getEncPosition();
   		talonLeftRPM = leftMaster.getSpeed();
   		talonRightPos = rightMaster.getEncPosition();
   		talonRightRPM = rightMaster.getSpeed();
   		leftSpeed = leftMaster.getEncVelocity();
   		rightSpeed = rightMaster.getEncVelocity();
   	
       	System.out.format("%s\n", "Time," + (curTime-startTime)/1000);
   		System.out.format("%s\n", "Talon left position: " + talonLeftPos);
   		System.out.format("%s\n", "Talon left rpm: " +  talonLeftRPM);
   		System.out.format("%s\n", "Talon right position: " + talonRightPos);
   		System.out.format("%s\n", "Talon right rpm: " +  talonRightRPM);
   		System.out.format("%s\n", "Talon right velocity: " + rightSpeed);
   		System.out.format("%s\n", "Talon left velocity: " +  leftSpeed);
   		lastTime = curTime;
   	}
   	
		SmartDashboard.putNumber("Talon right velocity", rightSpeed);
		SmartDashboard.putNumber("Talon left velocity", leftSpeed);
		SmartDashboard.putNumber("Talon left Position", talonLeftPos);
		SmartDashboard.putNumber("Talon left rpm", talonLeftRPM);
		SmartDashboard.putNumber("Talon right Position", -talonRightPos);
		SmartDashboard.putNumber("Talon right rpm", -talonRightRPM);
		SmartDashboard.putNumber("Time", (curTime-startTime)/1000);
   	
   }
}

