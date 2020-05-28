package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoGameProperty.*;

public class AutoLottoNumberGenerator implements LottoNumberGenerator {
    private static final int LOTTO_BALL_START_INDEX = 0;

    private final List<LottoNumber> lottoBalls;

    public AutoLottoNumberGenerator() {
        this.lottoBalls = IntStream.rangeClosed(LOTTO_NUMBER_BEGIN_BOUND, LOTTO_NUMBER_END_BOUND)
                .mapToObj(LottoNumber::of)
                .collect(toList());
    }

    @Override
    public Set<LottoNumber> generate() {
        Collections.shuffle(lottoBalls);
        return Collections.unmodifiableSet(new HashSet<>(pickLottoBalls()));
    }

    private List<LottoNumber> pickLottoBalls() {
        return lottoBalls.subList(LOTTO_BALL_START_INDEX, COUNT_OF_LOTTO_NUMBER);
    }
}