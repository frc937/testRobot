// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.MecanumDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {

    /* variables */
    WPI_TalonSRX frontLeft;
    WPI_TalonSRX backLeft;
    WPI_TalonSRX frontRight;
    WPI_TalonSRX backRight;

    MecanumDrive mecanumDrive;
    
    public Drive() {
        mecanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
