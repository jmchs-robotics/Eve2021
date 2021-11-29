package org.usfirst.frc5933.Eve2019.commands;

import org.usfirst.frc5933.Eve2019.Robot;
import org.usfirst.frc5933.Eve2019.SocketVisionSender;
import org.usfirst.frc5933.Eve2019.subsystems.Arm.ArmPosition;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Autonomous_AIMSPaths extends CommandGroup {

	
	public Autonomous_AIMSPaths(String message) {
		addSequential(new MoveArmToPos(ArmPosition.Start, false));

		addSequential(new DriveStraightGyro(305, .99, true));

		addSequential(new CloseTongs(false));

		addSequential(new GyroTurn(-90, .5, .025));

		addSequential(new OpenTongs(false));

		addSequential(new DriveStraightGyro(230, .99, true));
	}
}
