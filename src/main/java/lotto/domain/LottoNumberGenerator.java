package lotto.domain;

import java.util.Set;

public interface LottoNumberGenerator {
    Set<LottoNumber> generate();
}