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

    public void saveExtract(String path, String number, String name){
        try {
            robot = new Robot();
            robot.keyPress(VK_DOWN);
            robot.keyRelease(VK_DOWN);
            robot.keyPress(VK_ENTER);
            robot.keyRelease(VK_ENTER);
            Thread.sleep(5000);
            enterPath(robot, path);
            enterNumber(robot, number);
            enterPath(robot, name);
            robot.keyPress(VK_MINUS);
            robot.keyRelease(VK_MINUS);
            robot.keyPress(VK_E);
            robot.keyRelease(VK_E);
            robot.keyPress(VK_X);
            robot.keyRelease(VK_X);
            robot.keyPress(VK_T);
            robot.keyRelease(VK_T);
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
    private void enterPath(Robot robot, String path){
        for (int i = 0; i<path.length(); i++){
            int keyCode = 0;
            System.out.println(path.charAt(i));
            switch (path.charAt(i)){
                case 'a': keyCode = 0x41; break;
                case 'b': keyCode = 0x42; break;
                case 'c': keyCode = 0x43; break;
                case 'd': keyCode = 0x44; break;
                case 'e': keyCode = 0x45; break;
                case 'f': keyCode = 0x46; break;
                case 'g': keyCode = 0x47; break;
                case 'h': keyCode = 0x48; break;
                case 'i': keyCode = 0x49; break;
                case 'j': keyCode = 0x4A; break;
                case 'k': keyCode = 0x4B; break;
                case 'l': keyCode = 0x4C; break;
                case 'm': keyCode = 0x4D; break;
                case 'n': keyCode = 0x4E; break;
                case 'o': keyCode = 0x4F; break;
                case 'p': keyCode = 0x50; break;
                case 'q': keyCode = 0x51; break;
                case 'r': keyCode = 0x52; break;
                case 's': keyCode = 0x53; break;
                case 't': keyCode = 0x54; break;
                case 'u': keyCode = 0x55; break;
                case 'v': keyCode = 0x56; break;
                case 'w': keyCode = 0x57; break;
                case 'x': keyCode = 0x58; break;
                case 'y': keyCode = 0x59; break;
                case 'z': keyCode = 0x5A; break;
                case ':': robot.keyPress(VK_SHIFT);
                    robot.keyPress(VK_SEMICOLON);
                    robot.keyRelease(VK_SEMICOLON);
                    robot.keyRelease(VK_SHIFT); break;
                case '.': keyCode = 0x2E; break;
                case '-': keyCode = 0x2D; break;
                case '\\': keyCode = 0x5C; break;
            }
            if (path.charAt(i) != ':'){
                System.out.println(keyCode);
                robot.keyPress(keyCode);
                robot.keyRelease(keyCode);
            }


        }
    }


}
