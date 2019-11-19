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

    /**
     * Calculates the points that should be added to the Elo rating of the first player.
     * @param first The Elo rating of the first player.
     * @param second The Elo rating of the second player.
     * @param homeAdvantage The points added to the first player's Elo to account for any advantage.
     * @param k A value that can modifies the amount of change in Elo rating.
     * @param win True if the first player wins, false if the second player wins.
     * @param margin The difference in score; (winner's score - loser's score). 0 if there is no score.
     * @return The points that should be added to the Elo rating of the first player.
     */
    public static int result(int first, int second, int homeAdvantage, double k, boolean win, int margin){
        double expecteda = predict(first, second, homeAdvantage);
        double actuala = 0.0;
        if (win) actuala = 1.0;
        double differencea = actuala - expecteda;

        double scoreCoefficient = 1.0;
        if (margin !=0) scoreCoefficient = Math.log(margin + 1);

        return (int)(k * (0.5 + scoreCoefficient) * differencea);
    }
}
