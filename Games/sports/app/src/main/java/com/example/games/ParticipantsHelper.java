package com.example.games;

public class ParticipantsHelper {
    String gameId, atId;

    public ParticipantsHelper() {
    }

    public ParticipantsHelper(String gameId, String atId) {
        this.gameId = gameId;
        this.atId = atId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getAtId() {
        return atId;
    }

    public void setAtId(String atId) {
        this.atId = atId;
    }
}
