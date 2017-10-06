package org;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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

    leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
    leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
    rightFront.setDirection(DcMotorSimple.Direction.REVERSE);
    rightBack.setDirection(DcMotorSimple.Direction.REVERSE);

    waitForStart();

    while (opModeIsActive()) {

        leftFront.setPower(gamepad1.left_stick_y);
        leftBack.setPower(gamepad1.left_stick_y);
        rightBack.setPower(gamepad1.right_stick_y);
        rightFront.setPower(gamepad1.right_stick_y);

        if(gamepad1.a == true) {
            leftFront.setPower(-1.0);
            leftBack.setPower(-1.0);
            rightBack.setPower(1.0);
            rightFront.setPower(1.0);
            telemetry.addData("yay your spining", "");
            telemetry.update();
        }
    }
}
}