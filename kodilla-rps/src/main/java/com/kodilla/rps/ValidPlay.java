package com.kodilla.rps;

public enum ValidPlay {
    ROCK, PAPER, SCISSORS;

    private ValidPlay beats;
    private ValidPlay beatenBy;

    static {
        ROCK.beats = SCISSORS;
        ROCK.beatenBy = PAPER;
        PAPER.beats = ROCK;
        PAPER.beatenBy = SCISSORS;
        SCISSORS.beats = PAPER;
        SCISSORS.beatenBy = ROCK;
    }

    public ValidPlay getBeats() {
        return beats;
    }

    public ValidPlay getBeatenBy() {
        return beatenBy;
    }

}
