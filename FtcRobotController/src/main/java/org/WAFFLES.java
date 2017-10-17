package org;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

/**
 * Created by student on 9/25/2017.
 */
@TeleOp (name="Basic: Waffle Lin OpMode", group="Linear Opmode")
public class WAFFLES extends LinearOpMode {

    @Override
    public void runOpMode(){

        HardwareWaffles robot = new HardwareWaffles();
        robot.init(hardwareMap);
    waitForStart();

    while (opModeIsActive()) {

        robot.leftFront.setPower(gamepad1.left_stick_y);
        robot.leftBack.setPower(gamepad1.left_stick_y);
        robot.rightBack.setPower(gamepad1.right_stick_y);
        robot.rightFront.setPower(gamepad1.right_stick_y);

        if(gamepad1.a == true) {
            robot.leftFront.setPower(-1.0);
            robot.leftBack.setPower(-1.0);
            robot.rightBack.setPower(1.0);
            robot.rightFront.setPower(1.0);
            telemetry.addData("yay your spinning counter clockwise", "");
            telemetry.update();
        }
        if (gamepad1.b == true) {
            robot.leftFront.setPower(1.0);
            robot.leftBack.setPower(1.0);
            robot.rightBack.setPower(-1.0);
            robot.rightFront.setPower(-1.0);
            telemetry.addData("yay your spinning clockwise", "");
            telemetry.update();
        }
    }
}
}