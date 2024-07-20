package com.teeles.tol.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {
    double fullProb = 0;
    private Random rand = new Random();
    private List<RandomElement> results = new LinkedList<>();

    public void AddResult(String result, double prob) {
        results.add(new RandomElement(result, prob));
        fullProb += prob;
    }

    public String GetElement() {
        if (results.isEmpty()) { throw new RuntimeException("Cannot get random result from zero long result list."); }
        double randomNumber = rand.nextDouble(fullProb);
        double currSum = 0.0;
        int i = 0;
        do {
            currSum = currSum + results.get(i).probability;
            i++;
        } while (currSum < randomNumber);
        return results.get(i).element;
    }
}
