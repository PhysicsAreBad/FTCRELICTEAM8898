package org;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by student on 9/25/2017.
 */
@TeleOp (name="Basic: Waffle Lin OpMode", group="Linear Opmode")
public class WAFFLES extends LinearOpMode {
private DcMotor leftFront = null;
    private DcMotor rightFront = null;
    private DcMotor leftBack = null;
    private DcMotor rightBack = null;

@Override
    public void runOpMode(){
    leftFront = hardwareMap.get(DcMotor.class, "frontLeft");
    rightFront = hardwareMap.get(DcMotor.class, "frontRight");
    leftBack = hardwareMap.get(DcMotor.class, "backLeft");
    rightBack = hardwareMap.get(DcMotor.class, "backRight");
}
}