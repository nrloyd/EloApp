package com.example.eloapp;

public class Calculator {

    /**
     * Calculates the probability of the first player winning.
     * @param first The Elo rating of the first player.
     * @param second The Elo rating of the second player.
     * @param homeAdvantage The points added to the first player's Elo to account for any advantage.
     * @return The odds, as a decimal 0 <= n <= 1, of the first player winning.
     */
    public static double predict(int first, int second, int homeAdvantage){
        double difference = second-first-homeAdvantage;
        double exponent = difference / 400.0;
        double right = Math.pow(10.0, exponent);
        double bottom = 1.0 + right;
        return 1.0 / bottom;
    }
}
