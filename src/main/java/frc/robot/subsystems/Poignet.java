// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.spark.SparkFlex;
import com.revrobotics.spark.SparkBase.PersistMode;
import com.revrobotics.spark.SparkBase.ResetMode;
import com.revrobotics.spark.SparkLowLevel.MotorType;
import com.revrobotics.spark.config.SparkFlexConfig;
import com.revrobotics.spark.config.SparkBaseConfig.IdleMode;

import edu.wpi.first.math.controller.ArmFeedforward;
import edu.wpi.first.math.controller.ProfiledPIDController;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Poignet extends SubsystemBase {

  // Créer le moteur + config
  private SparkFlex moteur = new SparkFlex(14, MotorType.kBrushless);
  private SparkFlexConfig configMoteur = new SparkFlexConfig();

  // Créer le capteur
  private DigitalInput limitSwitch = new DigitalInput(7);

  // Créer PID + FeedForward
  private ProfiledPIDController pidPoignet = new ProfiledPIDController(0.1, 0, 0,
      new TrapezoidProfile.Constraints(320, 420));

  private ArmFeedforward feedforward = new ArmFeedforward(0, 0, 0);

  private double cible;

  public Poignet() {
    // associe configs au moteur
    configMoteur.inverted(false);
    configMoteur.idleMode(IdleMode.kBrake);
    moteur.configure(configMoteur, ResetMode.kResetSafeParameters, PersistMode.kPersistParameters);

  }

  @Override
  public void periodic() {
    // SmartDashboard
    SmartDashboard.putNumber("Angle Poignet", getAngle());
    SmartDashboard.putNumber("Cible : ", cible);
  }

  public void setVoltage(double voltage) {
    moteur.setVoltage(voltage);
  }

  // retourne la position poignet 
  public double getAngle() {
    return moteur.getEncoder().getPosition();
  }

  public void resetEncoders() {
    moteur.getEncoder().setPosition(0);
  }


  /// monter/descendre/stop avec poignet 
  public void monter() {
    setVoltage(1);
  }

  public void descendre() {
    setVoltage(-1);
  }

  public void stop() {
    setVoltage(0);
  }
  // Matisse est passé par ici :) 
  // PID + feedForward 
  public void setPID(double cible) {
    double voltagePID = pidPoignet.calculate(getAngle(), cible);

    double voltageFF = feedforward.calculate(
        Math.toRadians(getAngle()),
        pidPoignet.getSetpoint().velocity);

    setVoltage(voltagePID + voltageFF);

  }

  public void resetPID() {
    pidPoignet.reset(getAngle());
  }

  //angles Cible 
  public void setCible(double cible) {
    cible = cible;
  }

  public double getCibleRecif() {
    return cible;
  }

  public boolean atCible() {
    return pidPoignet.atGoal();
  }

  //LimitSwitch 
  public boolean isHome(){
    return !limitSwitch.get(); // verifier pour le not !
  }


}
