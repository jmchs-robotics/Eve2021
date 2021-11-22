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

	/**in MIDDLE, Exchange Only, put jumper on slot 0 (GND to S)
	 * on LEFT side of scale, put jumper on slot 1 (GND to S)
	 * on RIGHT side of scale, put jumper on slot 2 (GND to S)
	 * in MIDDLE, jumper in slot 5: no robots will block us
	 * in MIDDLE, jumper in slot 3: go to right; other robot will block our left
	 * in MIDDLE, jumper in slot 4: go to left; other robot will block our right
	*/
	public Autonomous_AIMSPaths(String message) {
		addSequential(new MoveArmToPos(ArmPosition.Start, false));

		addSequential(new DriveStraightGyro(305, 1, true));

		addSequential(new CloseTongs(false));

		addSequential(new GyroTurn(-90, .5, .025));
	}
}
