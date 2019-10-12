package edu.cscc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Lance Beachy
 * @version 1.0
 * Date 10/12/2019
 * Purpose: To test the RPSLSpock class using the JUnit test library
 */



public class RPSLSpock_Test {
    private RPSLSpock spock;

    //A simple method to generate a test instance
    @Before
    public void pretests() {
        spock = new RPSLSpock();
    }

    //A suite of tests to test the validPick() method
    @Test
    public void validPickTestSuite() {
        Assert.assertTrue(spock.isValidPick("rock"));
        Assert.assertTrue(spock.isValidPick("paper"));
        Assert.assertTrue(spock.isValidPick("scissors"));
        Assert.assertTrue(spock.isValidPick("lizard"));
        Assert.assertTrue(spock.isValidPick("spock"));
        Assert.assertFalse(spock.isValidPick("sandwiches"));
    }

    //A suite of tests to test the generatePick() method
    @Test
    public void generatePickTestSuite() {
        String pickTest;
        boolean testValue;
        for(int i = 0; i < 1000000; i++) {
            pickTest = spock.generatePick();
            if (pickTest.equals(spock.ROCK) || pickTest.equals(spock.PAPER) || pickTest.equals(spock.SCISSORS) ||
                pickTest.equals(spock.LIZARD) || pickTest.equals(spock.SPOCK)) {
                testValue = true;
            } else {
                testValue = false;
            }
            Assert.assertTrue(testValue==true);
        }
    }

    //A suite of tests to test the isComputerWin() method
    @Test
    public void isComputerWinTestSuite() {
        Assert.assertTrue(spock.isComputerWin(spock.ROCK, spock.LIZARD));
        Assert.assertTrue(spock.isComputerWin(spock.ROCK, spock.SCISSORS));
        Assert.assertTrue(spock.isComputerWin(spock.PAPER, spock.ROCK));
        Assert.assertTrue(spock.isComputerWin(spock.PAPER, spock.SPOCK));
        Assert.assertTrue(spock.isComputerWin(spock.SCISSORS, spock.PAPER));
        Assert.assertTrue(spock.isComputerWin(spock.SCISSORS, spock.LIZARD));
        Assert.assertTrue(spock.isComputerWin(spock.LIZARD, spock.PAPER));
        Assert.assertTrue(spock.isComputerWin(spock.LIZARD, spock.SPOCK));
        Assert.assertTrue(spock.isComputerWin(spock.SPOCK, spock.ROCK));
        Assert.assertTrue(spock.isComputerWin(spock.SPOCK, spock.SCISSORS));
        Assert.assertFalse(spock.isComputerWin(spock.ROCK, spock.PAPER));
    }
}
