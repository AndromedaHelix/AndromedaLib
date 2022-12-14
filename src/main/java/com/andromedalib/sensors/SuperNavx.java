package com.andromedalib.sensors;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Rotation2d;

/**
 * Wrapper for the AHRS Navx class
 */
public class SuperNavx extends AHRS {

    /**
     * Configures SuperNavx & resets it
     */
    public SuperNavx() {
        super();
        zeroHeading();
    }

    /**
     * Resets the heading of the Navx
     */
    public void zeroHeading() {
        calibrate();
        reset();
    }

    /**
     * Gets the heading of the Navx
     * 
     * @return Heading of the Navx in degrees
     */
    public double getHeading() {
        return -getRotation2d().getDegrees();
    }

    /**
     * Gets the turn rate of the Navx
     * 
     * @return Turn rate of the Navx in degrees per second
     */
    public double getTurnRate() {
        return getRate();
    }

    /**
     * Gets the current heading of the Navx
     * 
     * @return Current rotation as a negative {@link edu.wpi.first.math.geometry.Rotation2d}
     */
    public Rotation2d getRotation() {
        return getRotation2d().times(-1);
    }
}
