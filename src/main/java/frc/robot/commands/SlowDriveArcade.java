/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
//import frc.robot.OI;
import frc.robot.Robot;
import frc.robot.RobotMap;
public class SlowDriveArcade extends Command {
  public SlowDriveArcade() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(Robot.m_drivetrain);

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    double moveSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.DRIVER_CONTROLLER_MOVE_AXIS) * 0.40;
    double rotateSpeed = Robot.m_oi.driverController2.getRawAxis(RobotMap.DRIVER_CONTROLLER_TURN) * 0.40;
    // double joystickMoveSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.JOYSTICK_MOVE_AXIS)*-1;
    // double joystickRotateSpeed = Robot.m_oi.driverController.getRawAxis(RobotMap.JOYSTICK_ROTATE_AXIS);
    Robot.m_drivetrain.arcadeDrive(moveSpeed, rotateSpeed);
    //Robot.m_drivetrain.arcadeDrive(joystickMoveSpeed, joystickRotateSpeed);

  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.m_drivetrain.arcadeDrive(0, 0);

  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
