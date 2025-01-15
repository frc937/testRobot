// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.commands.DriveRobotOriented;
import frc.subsystems.Drive;

public class RobotContainer {
    /* Robot's subsystems and commands are declared here */
    private final Drive driveSubsystem = new Drive();

    private final DriveRobotOriented driveRO = new DriveRobotOriented(driveSubsystem);

    public static XboxController controller = new XboxController(0);

    public RobotContainer() {
        configureBindings();

        driveSubsystem.setDefaultCommand(driveRO);
    }

    private void configureBindings() {
    }

    public Command getAutonomousCommand() {
        return Commands.print("No autonomous command configured");
    }
}
