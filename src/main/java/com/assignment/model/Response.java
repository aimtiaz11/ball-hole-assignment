package com.assignment.model;

import javafx.util.Pair;

import java.util.List;

/**
 * Captures the desired output of the function.
 */
public class Response {

    /**
     * List of holes that have been unused (no ball fits)
     */
    private List<Hole> unAssignedHoles;

    /**
     * List of balls that could not be fit into any of the holes.
     */
    private List<Ball> unAssignedBalls;

    /**
     * Pair of holes and ball where ball can fit the hole
     */
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
