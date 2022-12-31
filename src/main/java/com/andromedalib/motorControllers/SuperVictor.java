package com.andromedalib.motorControllers;

import com.andromedalib.motorControllers.IdleManager.GlobalIdleMode;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/*
 * Wrapper for the WPI_VictorSPX class
 * That  implements the HyperMotorController interface
 */
public class SuperVictor extends WPI_VictorSPX implements HyperMotorController {

    private double currentLimit = 1;

    /**
     * Configures SuperVictor motor controller
     * 
     * @param id           ID of the motor controller
     * @param idleMode     Idle mode of the motor controller
     * @param inverted     Inverted state of the motor controller
     * @param currentLimit Current limit of the motor controller in amps
     */
    public SuperVictor(int motorID, GlobalIdleMode idleMode, boolean isInverted, int currentLimit) {
        super(motorID);
        configFactoryDefault();
        setMode(idleMode);
        setInverted(isInverted);
        // TODO SET CURRENT LIMIT
    }

    @Override
    public void outputTelemetry() {
        SmartDashboard.putNumber("Victor Motor " + getBaseID() + "Voltage:", getBusVoltage());
        SmartDashboard.putNumber("Victor Motor " + getBaseID() + "Temperature", getTemperature());
    }

    /**
     * Sets the idle mode of the motor controller
     * 
     * @param idleMode Idle mode of the motor controller
     */
    @Override
    public void setMode(GlobalIdleMode idleMode) {
        setNeutralMode(IdleManager.idleToNeutral(idleMode));
    }

    /**
     * Sets the current limit of the motor controller
     * 
     * @param currentLimit Current limit of the motor controller in amps
     */
    @Override
    public void setLimit(int currentLimit) {
        this.currentLimit = currentLimit;
    }

    /**
     * Gets the current limit of the motor controller
     * 
     * @return the current limit of the motor controller
     */
    @Override
    public double getLimit() {
        return currentLimit;
    }

    /**
     * Gets the velocity of the motor controller
     * 
     * @param conversionFactor Conversion factor to convert encoder ticks to
     *                         desired units
     * 
     * @return the velocity of the motor deisred units
     */
    public double getVelocity(double conversionFactor) {
        //TODO FINISH
        return getSelectedSensorVelocity() * conversionFactor;
    }

    /**
     * Gets the position of the motor controller
     * 
     * @param conversionFactor Conversion factor to convert encoder ticks to
     *                         desired units
     * 
     * @return the position of the motor in desired units
     */
    public double getPosition(double conversionFactor) {
        //TODO FINISH
        return getSelectedSensorPosition() * conversionFactor;
    }

    @Override
    public void resetEncoder(){
        //TODO COMPLETE
    }

}