package com.assignment;

import com.assignment.model.Ball;
import com.assignment.model.Hole;
import com.assignment.model.Response;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.junit.runners.JUnit4;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class BallAssignmentCalculatorTest {


    private BallAssignmentCalculator ballAssignmentCalculator;

    @Before
    public void setUp() throws Exception {

        this.ballAssignmentCalculator = new BallAssignmentCalculator();
    }


    @Test
    public void test_assignBallsToHoles1() {

        List<Ball> inputBalls = Arrays.asList(new Ball(0), new Ball(1), new Ball(4));
        List<Hole> inputHoles = Arrays.asList(new Hole(0), new Hole(1), new Hole(2));

        Response response = ballAssignmentCalculator.assignBallsToHoles(inputBalls, inputHoles);

        assertEquals("Ball of size 4 should be unassigned", 1, response.getUnAssignedBalls().size());
        assertEquals("Hole of size 2 should be unassigned", 1, response.getUnAssignedHoles().size());
        assertEquals("The remaining two should pair", 2, response.getAssignedBallsAndHoles().size());
    }

    @Test
    public void test_assignBallsToHoles2() {

        List<Ball> inputBalls = Arrays.asList(new Ball(0), new Ball(1), new Ball(2));
        List<Hole> inputHoles = Arrays.asList(new Hole(0), new Hole(1), new Hole(2));

        Response response = ballAssignmentCalculator.assignBallsToHoles(inputBalls, inputHoles);

        assertEquals("No unassigned ball", 0, response.getUnAssignedBalls().size());
        assertEquals("No Unassigned holes", 0, response.getUnAssignedHoles().size());
        assertEquals("All 3 hole and ball should match", 3, response.getAssignedBallsAndHoles().size());
    }
}