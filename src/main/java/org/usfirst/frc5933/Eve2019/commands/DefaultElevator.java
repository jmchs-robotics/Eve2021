package org.usfirst.frc5933.Eve2019.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5933.Eve2019.Robot;
import org.usfirst.frc5933.Eve2019.subsystems.Elevator;

public class DefaultElevator extends Command {

    public static Elevator m_subsystem;
    private double control;

    public DefaultElevator() {
        requires(Robot.elevator);
    }

    @Override
    protected void initialize() {
    }
    
    @Override
    protected boolean isFinished() {
        return false;
    }

}
