package lotto.enums;

import java.util.Arrays;

public enum WinningRank {
    FIRST_PLACE(6, 2_000_000_000),
    SECOND_PLACE(5, 30_000_000),
    THIRD_PLACE(5, 1_500_000),
    FOURTH_PLACE(4, 50_000),
    FIFTH_PLACE(3, 5_000),
    ETC(0, 0);

    private final int matchedCount;
    private final int prize;

    WinningRank(int matchedCount, int prize) {
        this.matchedCount = matchedCount;
        this.prize = prize;
    }

    public static WinningRank findByMacthedCount(int matchedCount, boolean matchBonus) {

        if (matchedCount < FIFTH_PLACE.matchedCount()) {
            return ETC;
        }

        WinningRank winningRank = findByMacthedCount(matchedCount);

        if (matchBonus & winningRank.matchedCount == SECOND_PLACE.matchedCount) {
            return SECOND_PLACE;
        }

        if (winningRank.matchedCount == SECOND_PLACE.matchedCount) {
            return THIRD_PLACE;
        }

        return winningRank;
    }

    private static WinningRank findByMacthedCount(int matchedCount) {
        return Arrays.stream(values())
                .filter(winningRank -> winningRank.matchedCount == matchedCount)
                .findAny()
                .orElse(ETC);
    }

    public int prize() {
        return prize;
    }

    public int matchedCount() {
        return matchedCount;
    }
}
