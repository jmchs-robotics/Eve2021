package org.usfirst.frc5933.Eve2019.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc5933.Eve2019.Robot;
import org.usfirst.frc5933.Eve2019.subsystems.Elevator;

public class LowerElevator extends Command {

    private Elevator m_subsystem;

    public LowerElevator() {
        requires(Robot.elevator);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        m_subsystem.setMotor(-0.2);
    }

    @Override
    public void end() {
        m_subsystem.stopMotor();
    }

    @Override
    protected boolean isFinished() {
        return false;
    }    
}
