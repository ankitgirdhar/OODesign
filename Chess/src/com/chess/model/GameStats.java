package com.chess.model;

public class GameStats extends Auditable {
    private long matchesWonCount;
    private long matchesLostCount;
    private long totalCoins;

    public long getMatchesWonCount() {
        return matchesWonCount;
    }

    public void setMatchesWonCount(long matchesWonCount) {
        this.matchesWonCount = matchesWonCount;
    }

    public long getMatchesLostCount() {
        return matchesLostCount;
    }

    public void setMatchesLostCount(long matchesLostCount) {
        this.matchesLostCount = matchesLostCount;
    }

    public long getTotalCoins() {
        return totalCoins;
    }

    public void setTotalCoins(long totalCoins) {
        this.totalCoins = totalCoins;
    }
}
