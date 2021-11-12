package org.usfirst.frc5933.Eve2019.commands;

import org.usfirst.frc5933.Eve2019.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GrabCube extends Command {

    double timeout = -1;

	public GrabCube() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }
    
    public GrabCube(double time) {
    	
    	timeout = time;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    
    	if(timeout >= 0) {
    		setTimeout(timeout);
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
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
