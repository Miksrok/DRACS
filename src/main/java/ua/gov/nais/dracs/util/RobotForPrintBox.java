package ua.gov.nais.dracs.util;

import java.awt.*;

import static java.awt.event.KeyEvent.*;

public class RobotForPrintBox {

    private Robot robot;

    public void enterInfo(String number){
        try {
            robot = new Robot();
            robot.delay(1000);
            robot.keyPress(VK_DOWN);
            robot.keyRelease(VK_DOWN);
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
            Thread.sleep(5000);
            enterNumber(robot, number);
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveCertificate(String number){
        try {
                robot = new Robot();
            for (int i = 0; i < 3; i++){
                robot.keyPress(VK_TAB);
                robot.keyRelease(VK_TAB);
            }
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
            Thread.sleep(5000);
            enterNumber(robot, number);
            robot.keyPress(VK_A);
            robot.keyRelease(VK_A);
            robot.keyPress(VK_9);
            robot.keyRelease(VK_9);
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void saveExtract(String number){
        try {
            robot = new Robot();
            robot.keyPress(VK_DOWN);
            robot.keyRelease(VK_DOWN);
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
            Thread.sleep(5000);
            enterNumber(robot, number);
            System.out.println(number);
            robot.keyPress(VK_E);
            robot.keyRelease(VK_E);
            robot.keyPress(VK_X);
            robot.keyRelease(VK_X);
            robot.keyPress(VK_T);
            robot.keyRelease(VK_T);
            robot.keyPress(VK_R);
            robot.keyRelease(VK_R);
            robot.keyPress(VK_ENTER);
            System.out.println(VK_ENTER);
            robot.keyRelease(VK_ENTER);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void enterNumber(Robot robot, String number){
        for (int i = 0; i<number.length(); i++){
            int keyCode = 0;
            switch (number.charAt(i)){
                case '0': keyCode = 0x30; break;
                case '1': keyCode = 0x31; break;
                case '2': keyCode = 0x32; break;
                case '3': keyCode = 0x33; break;
                case '4': keyCode = 0x34; break;
                case '5': keyCode = 0x35; break;
                case '6': keyCode = 0x36; break;
                case '7': keyCode = 0x37; break;
                case '8': keyCode = 0x38; break;
                case '9': keyCode = 0x39; break;
            }
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
            System.out.println(keyCode);
        }
    }


}
