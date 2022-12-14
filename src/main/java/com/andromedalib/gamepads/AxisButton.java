package com.andromedalib.gamepads;

import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import edu.wpi.first.wpilibj.XboxController.Axis;

/*
 * Button Wrapper that creates an from a button
 * Copied over and mofiied from 
 * https://github.com/Spectrum3847/SpectrumLib/blob/main/src/main/java/frc/SpectrumLib/gamepads/AxisButton.java
 */
//TODO: REMOVE DEPRECATED
public class AxisButton extends Trigger {
    private final GenericHID joy;
    private final int axis;
    private double targetVal;
    private ThresholdType thresholdType;
    
    public static enum ThresholdType
    {
        LESS_THAN, GREATER_THAN, EXACT, POV, DEADBAND;	
    }

    public AxisButton(GenericHID joystick, int axis, double threshold, ThresholdType thresholdType) {
        this.joy = joystick;
        this.axis = axis;
        this.targetVal = threshold;
        this.thresholdType = thresholdType;
    }
        
    public AxisButton(Joystick joystick, Axis axis, double threshold, ThresholdType thresholdType) {
        this(joystick, axis.value, threshold, thresholdType);
    }

    public AxisButton(XboxController joystick, Axis axis, double threshold, ThresholdType thresholdType) {
        this(joystick, axis.value, threshold, thresholdType);
    }


    public boolean get() {
        switch (this.thresholdType) {
        case EXACT:
            //System.out.println("axis value: " + joy.getRawAxis(this.axis));
            return joy.getRawAxis(this.axis) == this.targetVal;
        case LESS_THAN:
            return joy.getRawAxis(this.axis) < this.targetVal;
        case GREATER_THAN:
            return joy.getRawAxis(this.axis) > this.targetVal;
        case POV:
            return joy.getPOV() == this.targetVal;
        case DEADBAND:
            return Math.abs(joy.getRawAxis(this.axis)) > this.targetVal;
        default:
        return false;
        }
    }

}
