package ua.gov.nais.dracs.util;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class RobotForPrintBox {

    private Robot robot;

    public void enterInfo(){
        try {
            robot = new Robot();
            robot.keyPress(VK_DOWN);
            robot.keyRelease(VK_DOWN);
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
            Thread.sleep(5000);
            robot.keyPress(VK_2);
            robot.keyRelease(VK_2);
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }


}
