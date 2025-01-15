// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.Constants;
import frc.commands.DriveRobotOriented;
import frc.subsystems.Drive;

public class RobotContainer {
    /* Robot's subsystems and commands are declared here */
    private final Drive driveSubsystem = new Drive();

    private final DriveRobotOriented driveRO = new DriveRobotOriented(driveSubsystem);

    public static XboxController controller = new XboxController(Constants.CONTROLLER_ID);

    public RobotContainer() {
        configureBindings();

        driveSubsystem.setDefaultCommand(driveRO);
    }

    private void configureBindings() {
        JoystickButton leftStick = new JoystickButton(controller, Constants.LEFTSTICK_NUMBER);
        JoystickButton rightStick = new JoystickButton(controller, Constants.RIGHTSTICK_NUMBER);
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }

    public Command getDriveRobotOrientedCommand() {
        return driveRO;
    }

    public static double getLeftJoystickXAxis() {
        return controller.getLeftX();
    }

    public static double getScaledLeftJoystickXAxis() {
        return scaleAxis(getLeftJoystickXAxis());
    }

    public static double getLeftJoystickYAxis() {
        return controller.getLeftY() * -1.0;    // reverse left joystick Y output, i guess we did this because the bot was going the wrong wasy ¯\_(ツ)_/¯
    }

    public static double getScaledLeftJoystickYAxis() {
        return scaleAxis(getLeftJoystickYAxis());
    }

    public static double getRightJoystickXAxis() {
        return controller.getRightX();
    }

    public static double getScaledRightJoystickXAxis() {
        return scaleAxis(getRightJoystickXAxis());
    }

    private static double scaleAxis(double axis) {
        return Math.signum(axis) * Math.pow(axis, 2);
    }
}
