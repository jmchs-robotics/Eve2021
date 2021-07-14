package org.usfirst.frc5933.Eve2019.commands;

import org.usfirst.frc5933.Eve2019.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class WaitForCommand extends Command {

	boolean useLatch;
	Command commandObj;
	
    public WaitForCommand( Command c ) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	
    	commandObj = c;
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	return !commandObj.isRunning(); //isRunning is true while a command is in Scheduler to be executed, so invert that to get true when the command leaves scheduler.
    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
