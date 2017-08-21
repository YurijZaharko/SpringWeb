package proj.controller;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

/**
 * Created by SC on 17.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(BrandControllerTest.class);
    }
}
