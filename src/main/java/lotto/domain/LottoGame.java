package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoGame {
    private List<Integer> numbers;

    public LottoGame(LottoNumber lottoNumber) {
        this(lottoNumber.numbers());
    }

    public LottoGame(List<Integer> givenLottoNumbers) {
        Collections.sort(givenLottoNumbers);
        this.numbers = givenLottoNumbers;
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

    public LottoMatchNumbers matchNumbers(List<Integer> winningNumbers) {
        return matchNumbers(new WinningNumber(winningNumbers));
    }

    public LottoMatchNumbers matchNumbers(WinningNumber winningNumber) {
        return new LottoMatchNumbers(winningNumber.matchCount(this));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(numbers, lottoGame.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    public List<Integer> numbers() {
        return numbers;
    }
}