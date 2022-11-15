package org.usfirst.frc5933.Eve2019.commands;

import org.usfirst.frc5933.Eve2019.Robot;
import org.usfirst.frc5933.Eve2019.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveStraightGyro extends Command {

	double endVal;
	double vBus;
	double initialHeading;
	boolean useFeedback;
	double direction;
	double distThisLeg;
	
    public DriveStraightGyro(double timeToRun, double percentVBus) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.drivetrain);
    	
    	endVal = timeToRun;
    	vBus = -percentVBus;
    	useFeedback = false;
    }
    
    //
    /**
     * 
     * @param inches Needs to be negative for backwards movement, positive otherwise.
     * @param percentVBus Requires same sign as inches.
     * @param useEncoders TRUE to use encoders.
     */
    public DriveStraightGyro(double inches, double percentVBus, boolean useEncoders) {
    	requires(Robot.drivetrain);
    	
    	endVal = inches * Drivetrain.kEncoderTicksPerInch;
    	distThisLeg = endVal;
    	vBus = percentVBus;
    	useFeedback = useEncoders;

    	//direction is positive for forwards and negative for backwards.
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// set our target position as current position plus desired distance
    	endVal += Robot.drivetrain.getRightEncoderPos(0);
    	// get the robot's current direction, so we can stay pointed that way
    	initialHeading = Robot.drivetrain.getGyroHeading();
    	
    	// if we don't want to use the encoders, set a duration to drive
    	if(!useFeedback)
    		setTimeout(endVal);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double proportion = Drivetrain.kPGyroConstant * (Robot.drivetrain.getGyroHeading() - initialHeading);
    	double coefficient = 1;
    	
    	if(useFeedback) {    		
    		// ramp down at the end of this leg of travel
    		// coefficient = Math.pow((endVal - Robot.drivetrain.getRightEncoderPos(0)) / endVal,2/3);  // this won't really work any more because endVal is not relative to resetting encoders to zero    		
    		coefficient = Math.abs( distThisLeg - Robot.drivetrain.getRightEncoderPos(0)) / 2000;    		
    		coefficient = Robot.drivetrain.thresholdVBus(coefficient);
    	}
    	
    	Robot.drivetrain.tankDrive(coefficient * (vBus - proportion), -coefficient * (vBus + proportion));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(useFeedback) {
    		// have we gone far enough?
    		if(Math.signum(vBus) < 0) {
    			return Robot.drivetrain.getRightEncoderPos(0) <= endVal;
    		} else {
    			return Robot.drivetrain.getRightEncoderPos(0) >= endVal;
    		}
    		
    	}
        return isTimedOut();
    }
    
    public boolean exposedIsFinished() {
    	return isFinished();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.tankDrive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}