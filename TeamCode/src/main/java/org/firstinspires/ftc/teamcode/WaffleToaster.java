package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

/**
 * Created by student on 10/9/2017.
 */

@TeleOp (name = "WaffleTeleOp", group = "TeleOp")
//@Disabled
public class WaffleToaster extends LinearOpMode {

    private DcMotor leftFront = null;
    private DcMotor leftBack = null;
    private DcMotor rightFront = null;
    private DcMotor rightBack = null;

    private DcMotor arm = null;

    private Servo leftServo = null;
    private Servo rightServo = null;

    long millis = System.currentTimeMillis() % 1000;
    long millisReset;
    boolean openRight= false;
    boolean openLeft = false;

    @Override
    public void runOpMode() throws InterruptedException {
        leftFront = hardwareMap.get(DcMotor.class, "leftFront");
        leftBack = hardwareMap.get(DcMotor.class, "leftBack");
        rightFront = hardwareMap.get(DcMotor.class, "rightFront");
        rightBack = hardwareMap.get(DcMotor.class, "rightBack");

        arm = hardwareMap.get(DcMotor.class, "arm");

        leftServo = hardwareMap.get(Servo.class, "leftServo");
        rightServo = hardwareMap.get(Servo.class, "rightServo");

        leftFront.setDirection(DcMotorSimple.Direction.FORWARD);
        leftBack.setDirection(DcMotorSimple.Direction.FORWARD);
        rightBack.setDirection(DcMotorSimple.Direction.REVERSE);
        rightFront.setDirection(DcMotorSimple.Direction.REVERSE);

        arm.setDirection(DcMotorSimple.Direction.FORWARD);

        leftServo.setDirection(Servo.Direction.FORWARD);
        rightServo.setDirection(Servo.Direction.REVERSE);

        waitForStart();

        while (opModeIsActive()) {
            millis = System.currentTimeMillis() % 1000;
            leftFront.setPower(gamepad1.left_stick_y);
            leftBack.setPower(gamepad1.left_stick_y);
            rightFront.setPower(gamepad1.right_stick_y);
            rightBack.setPower(gamepad1.right_stick_y);

            rightServo.setPosition(gamepad1.right_trigger);
            leftServo.setPosition(gamepad1.left_trigger);

            if (gamepad1.a) {
                arm.setPower(.75);
            } else if (gamepad1.b) {
                arm.setPower(-.25);
            } else if (gamepad1.x) {
              arm.setPower(1);
            } else{
                arm.setPower(.25);
            }

            telemetry.addData("leftServo", leftServo.getPosition());
            telemetry.addData("rightServo", rightServo.getPosition());
            telemetry.addData("Time", millis);
            telemetry.update();
        }
    }
}
