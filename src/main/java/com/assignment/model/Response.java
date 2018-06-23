package com.assignment.model;

import javafx.util.Pair;

import java.util.List;

/**
 * Created by alimtiaz on 23/6/18.
 */

public class Response {

    private List<Hole> unAssignedHoles;

    private List<Ball> unAssignedBalls;

    private List<Pair<Ball, Hole>> assignedBallsAndHoles;

    public Response(List<Hole> unAssignedHoles, List<Ball> unAssignedBalls, List<Pair<Ball, Hole>> assignedBallsAndHoles) {
        this.unAssignedHoles = unAssignedHoles;
        this.unAssignedBalls = unAssignedBalls;
        this.assignedBallsAndHoles = assignedBallsAndHoles;
    }


    public List<Hole> getUnAssignedHoles() {
        return unAssignedHoles;
    }

    public void setUnAssignedHoles(List<Hole> unAssignedHoles) {
        this.unAssignedHoles = unAssignedHoles;
    }

    public List<Ball> getUnAssignedBalls() {
        return unAssignedBalls;
    }

    public void setUnAssignedBalls(List<Ball> unAssignedBalls) {
        this.unAssignedBalls = unAssignedBalls;
    }

    public List<Pair<Ball, Hole>> getAssignedBallsAndHoles() {
        return assignedBallsAndHoles;
    }

    public void setAssignedBallsAndHoles(List<Pair<Ball, Hole>> assignedBallsAndHoles) {
        this.assignedBallsAndHoles = assignedBallsAndHoles;
    }
}
