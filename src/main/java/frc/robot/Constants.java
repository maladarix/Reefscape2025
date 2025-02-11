// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.nio.file.Path;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.util.Units;

public final class Constants {

  //////// BasePilotable
  // Driving Parameters - Note that these are not the maximum capable speeds of
  // the robot, rather the allowed maximum speeds
  public static final double maxVitesseLineaire = 4.8;// Vitesse linéaire max du chassis //Valeur original 4.8 a note:à
  // ajuster
  public static final double maxVitesseRotation = Math.PI * 1.4; // radians per second //Originale REV = 2pi soirée 22
                                                                 // fevrier = 1.5

  public static final double maxVitesseModule = 4.46;// Vitesse maximale d'un module en m/s

  // Chassis configuration
  public static final double kTrackWidth = Units.inchesToMeters(26.5);
  // Distance between centers of right and left wheels on robot
  public static final double kWheelBase = Units.inchesToMeters(26.5);
  // Distance between front and back wheels on robot
  public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
      new Translation2d(kWheelBase / 2, kTrackWidth / 2),
      new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
      new Translation2d(-kWheelBase / 2, kTrackWidth / 2),
      new Translation2d(-kWheelBase / 2, -kTrackWidth / 2));

  public static final class Hauteur { // index 0 == hauteur ascenseur index 1 == angle poignet

    public static final double sol[] = { 0, 0 };
    public static final double corailL1[] = { 1, 0 };
    public static final double corailL2[] = { 1.25, 0 };
    public static final double corailL3[] = { 1.5, 0 };
    public static final double corailL4[] = { 2, 180 };

    public static final double algueBas[] = { 1, 180 };
    public static final double algueHaut[] = { 1.5, 180 };

    public static final double processeur[] = {0.5 , 0};
    public static final double station[] = {0.5, 45};  

  }

  public static final class BoutonOperateur {

    public static final int L1 = 2;
    public static final int L2 = 3;
    public static final int L3 = 4;
    public static final int L4 = 5;

    public static final int A = 6;
    public static final int B = 7;
    public static final int C = 8;
    public static final int D = 9;

    public static final int E = 10;
    public static final int F = 11;
    public static final int G = 12;
    public static final int H = 13;

    public static final int I = 14;
    public static final int J = 15;
    public static final int K = 16;
    public static final int L = 17;

  }

  public static class Branche {

    public static final Pose2d A = new Pose2d(3.153, 4.187, Rotation2d.fromDegrees(0));
    public static final Pose2d B = new Pose2d(3.153, 3.851, Rotation2d.fromDegrees(0));
    public static final Pose2d C = new Pose2d(3.680, 2.940, Rotation2d.fromDegrees(60));
    public static final Pose2d D = new Pose2d(3.992, 2.784, Rotation2d.fromDegrees(60));
    public static final Pose2d E = new Pose2d(4.987, 2.784, Rotation2d.fromDegrees(120));
    public static final Pose2d F = new Pose2d(5.311, 2.940, Rotation2d.fromDegrees(120));
    public static final Pose2d G = new Pose2d(5.815, 3.860, Rotation2d.fromDegrees(-180));
    public static final Pose2d H = new Pose2d(5.815, 4.196, Rotation2d.fromDegrees(-180));
    public static final Pose2d I = new Pose2d(5.275, 5.058, Rotation2d.fromDegrees(-120));
    public static final Pose2d J = new Pose2d(5.021, 5.244, Rotation2d.fromDegrees(-120));
    public static final Pose2d K = new Pose2d(3.978, 5.224, Rotation2d.fromDegrees(-60));
    public static final Pose2d L = new Pose2d(3.715, 5.107, Rotation2d.fromDegrees(-60));
  }

  public static class GamePositions {

    public static final Pose2d CoralStationProc = new Pose2d(1.594, 0.710, Rotation2d.fromDegrees(-126));
    public static final Pose2d CoralStationCage = new Pose2d(1.706, 7.369, Rotation2d.fromDegrees(126));
    public static final Pose2d Processeur = new Pose2d(7.369, 0.534, Rotation2d.fromDegrees(-90));
  }

  public static final double distanceMin = 2;

}
