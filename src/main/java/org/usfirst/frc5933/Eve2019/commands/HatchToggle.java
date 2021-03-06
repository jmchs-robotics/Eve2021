/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc5933.Eve2019.commands;

import org.usfirst.frc5933.Eve2019.Robot;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;

public class HatchToggle extends Command {
  public HatchToggle(){
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);

    requires(Robot.hatch);
  }
  int numberOTimesPressed = 0;

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    numberOTimesPressed++;
    Robot.hatch.pressCheck(numberOTimesPressed);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute(){
    setTimeout(0.2);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.hatch.setTriggerSolenoidHatch(Value.kOff);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
