package com.assignment;

import com.assignment.model.Ball;
import com.assignment.model.Hole;
import com.assignment.model.Response;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


public class BallAssignmentCalculator {

    /**
     * @param ballList - List of balls
     * @param holeList - List of holes
     * @return - Returns a {@linkplain Response}  object that encapsulates the following response:
     * 1. Collection of balls that could not be assigned
     * 2. A collection of holes that where a ball could not be assigned
     * 3. A collection of holes and ball pairs
     */
    public Response assignBallsToHoles(List<Ball> ballList, List<Hole> holeList) {

        // Step 1: Sort the holes by size (descending order) so when we iterate over the holes, we are starting with the largest and working towards
        // the smaller holes
        List<Hole> orderedHoleList = holeList.stream()
                .sorted(Comparator.comparing(Hole::getSize, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        List<Pair<Ball, Hole>> assignedBallsAndHoles = new ArrayList<>();
        List<Hole> unAssignedHoles = new ArrayList<>();
        List<Ball> unAssignedBalls;

        List<Ball> usedBalls = new ArrayList<>();

        orderedHoleList.forEach(hole -> {

            // Get the largest ball that can fit the whole. If there is a match, add to the hole otherwise flag the hole as unassigned
            Ball largestMatchedBall;
            try {
                largestMatchedBall = ballList.stream()
                        .filter(ball -> ball.getSize() <= hole.getSize()) // Find the ball that will fit the hole
                        .filter(ball -> usedBalls.isEmpty() || !usedBalls.contains(ball)) // The ball has not been used previously
                        .max(Comparator.comparing(Ball::getSize)) // Find the largest ball that meet the above 2 filter.
                        .get();

                assignedBallsAndHoles.add(new Pair<>(largestMatchedBall, hole));
                usedBalls.add(largestMatchedBall);

            } catch (NoSuchElementException ex) {
                // When the get() above does not yeild any ball. There is nothing to add to this hole.
                unAssignedHoles.add(hole);
            }
        });

        // Get the list of unused balls
        unAssignedBalls = ballList.stream().filter(ball -> !usedBalls.contains(ball)).collect(Collectors.toList());

        return new Response(unAssignedHoles, unAssignedBalls, assignedBallsAndHoles);
    }
}
