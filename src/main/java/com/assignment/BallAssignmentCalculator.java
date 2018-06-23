package com.assignment;

import com.assignment.model.Ball;
import com.assignment.model.Hole;
import com.assignment.model.Response;
import javafx.util.Pair;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public class BallAssignmentCalculator {

    public Response assignBallsToHoles(List<Ball> ballList, List<Hole> holeList) {

        // Step 1: Sort the holes by size (descending order) so when we iterate over the holes, we are starting with the largest and working towards
        // the smaller holes
        List<Hole> orderedHoleList = holeList.stream()
                .sorted(Comparator.comparing(Hole::getSize, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        List<Pair<Ball, Hole>> assignedBallsAndHoles = new ArrayList<>();
        List<Hole> unAssignedHoles = new ArrayList<>();
        List<Ball> unAssignedBalls = new ArrayList<>();


        List<Ball> usedBalls = new ArrayList<>();

        orderedHoleList.forEach(hole -> {

            // Get the largest ball that can fit the whole. If there is a match, add to the hole otherwise flag the hole as unassigned
            Ball largestMatchedBall;
            try {
                largestMatchedBall = ballList.stream()
                        .filter(ball -> ball.getSize() <= hole.getSize()) // Ball will fit the hole
                        .filter(ball -> usedBalls.isEmpty() || !usedBalls.contains(ball)) // The ball has not been used previously
                        .max(Comparator.comparing(Ball::getSize))
                        .get();

                if (largestMatchedBall != null) {
                    assignedBallsAndHoles.add(new Pair<>(largestMatchedBall, hole));
                    usedBalls.add(largestMatchedBall);
                }

            } catch (NoSuchElementException ex) {
                unAssignedHoles.add(hole);
            }

        });

        // Get the list of unused balls
        unAssignedBalls = ballList.stream().filter(ball -> !usedBalls.contains(ball)).collect(Collectors.toList());

        return new Response(unAssignedHoles, unAssignedBalls, assignedBallsAndHoles);
    }
}
