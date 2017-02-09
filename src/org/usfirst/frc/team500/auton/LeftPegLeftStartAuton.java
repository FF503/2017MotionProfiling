package org.usfirst.frc.team500.auton;

import org.usfirst.frc.team500.robot.subsystems.DrivetrainSubsystem;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftPegLeftStartAuton extends CommandGroup {

    public LeftPegLeftStartAuton() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	double[][] leftPinLeftStart = {
				{2,21.5},
				{6,21.5},
				{10.5,17.5}
		};
    	DrivetrainSubsystem.getInstance().setDriveDirectionBackward();
		(new RunMotionProfileCommand(leftPinLeftStart, 2)).start();
		
    }
}
