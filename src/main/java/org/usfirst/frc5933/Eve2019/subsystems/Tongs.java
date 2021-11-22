package org.usfirst.frc5933.Eve2019.subsystems;

import org.usfirst.frc5933.Eve2019.RobotMap;
import org.usfirst.frc5933.Eve2019.commands.NullCommand;
import org.usfirst.frc5933.Eve2019.commands.DefaultPiston;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Tongs extends Subsystem {
	DoubleSolenoid tongsDefaultPiston = RobotMap.armTongsPiston;
	//DoubleSolenoid rampsDefaultPiston = RobotMap.EndGameDefaultPiston;

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	@Override
	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		//setDefaultCommand(new MySpecialCommand());
		setDefaultCommand(new DefaultPiston());
	}
	
	@Override
	public void periodic() {
		SmartDashboard.putString("Solenoid Position: ", tongsDefaultPiston.get().toString());
	}	

	public void RetractTongs() {
		tongsDefaultPiston.set(Value.kReverse);
	}

	public void ExtendTongs() {
		tongsDefaultPiston.set(Value.kForward);
	}

	public void turnArmDefaultPistonOff() {
		tongsDefaultPiston.set(Value.kOff);
	}

	public void init() {
		// TODO Auto-generated method stub
		turnArmDefaultPistonOff();
	}
}

