
package org.usfirst.frc.team500.robot;

import org.usfirst.frc.team500.auton.CenterPegCenterStart;
import org.usfirst.frc.team500.auton.LeftPegLeftStartAuton;
import org.usfirst.frc.team500.auton.RunMotionProfileCommand;
import org.usfirst.frc.team500.robot.commands.ArcadeDriveCommand;
import org.usfirst.frc.team500.robot.subsystems.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static RobotHardwareProgrammingBot bot = null;
	private static double startTime;
	private static Command autonCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		bot = new RobotHardwareProgrammingBot();
		bot.initialize();
		OI.initialize();
	}
 
	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() {
    	DrivetrainSubsystem.getInstance().stopTrapezoidControl();    	
		DrivetrainSubsystem.getInstance().percentVoltageMode();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}


	@Override
	public void autonomousInit() {
		startTime = Timer.getFPGATimestamp();
		autonCommand = new LeftPegLeftStartAuton();
		autonCommand.start();
		//(new RunMotionProfileCommand(centerPinCenterStart, 3)).start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	@Override
	public void autonomousPeriodic() {
		DrivetrainSubsystem.getInstance().populateLog(startTime);
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
    	DrivetrainSubsystem.getInstance().stopTrapezoidControl();    	
		DrivetrainSubsystem.getInstance().percentVoltageMode();
    	DrivetrainSubsystem.getInstance().resetEncoders();
	    startTime = Timer.getFPGATimestamp();
    	(new ArcadeDriveCommand()).start();
    	
	}

	/**
	 * This function is called periodically during operator control
	 */
	@Override
	public void teleopPeriodic() {
		DrivetrainSubsystem.getInstance().populateLog(startTime);
		Scheduler.getInstance().run();
	}
	
	/**
	 * This function is called to initialize the test mode 
	 */
	@Override
	public void testInit(){
		
	}
	
	/**
	 * This function is called periodically during test mode
	 */
	@Override
	public void testPeriodic() {
		//LiveWindow.run();
		Scheduler.getInstance().run();
	}
}
