// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
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
        /* innitialize drive motor controllers */
        frontLeft = new WPI_TalonSRX(Constants.ID_TALON_FRONT_LEFT);
        backLeft = new WPI_TalonSRX(Constants.ID_TALON_BACK_LEFT);
        frontRight = new WPI_TalonSRX(Constants.ID_TALON_FRONT_RIGHT);
        backRight = new WPI_TalonSRX(Constants.ID_TALON_BACK_RIGHT);


        /* set default drive configs  */
        frontLeft.setInverted(false);
        backLeft.setInverted(false);
        frontRight.setInverted(true);
        backRight.setInverted(true);

        frontLeft.setNeutralMode(NeutralMode.Brake);
        backLeft.setNeutralMode(NeutralMode.Brake);
        frontRight.setNeutralMode(NeutralMode.Brake);
        backRight.setNeutralMode(NeutralMode.Brake);

        /* innitialize a mecanum drivetrain */
        mecanumDrive = new MecanumDrive(frontLeft, backLeft, frontRight, backRight);
    }

    public void moveMecanum(double x, double y, double z) {
        mecanumDrive.driveCartesian(x, y, z);
    }

    public void stop() {
        frontLeft.stopMotor();
        backLeft.stopMotor();
        frontRight.stopMotor();
        backRight.stopMotor();
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run
    }
}
