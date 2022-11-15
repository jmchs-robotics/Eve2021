package org.usfirst.frc5933.Eve2019.commands;

import org.usfirst.frc5933.Eve2019.Robot;
import org.usfirst.frc5933.Eve2019.SocketVisionSender;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous_AMESPaths extends CommandGroup {

	
	public Autonomous_AMESPaths() {

		addSequential(new DriveStraightGyro(135.5, 1, true)); 

		//addSequential(new DriveStraightGyro(5, 1));
		
		//grab 

		addSequential(new DriveStraightGyro(-12, -1, true));

		addSequential(new GyroTurn(90, .5, .025));

		addSequential(new DriveStraightGyro(132.5, 1, true));
	}
}

