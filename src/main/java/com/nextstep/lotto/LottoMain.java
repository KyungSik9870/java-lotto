package com.nextstep.lotto;

import java.util.Set;

import com.nextstep.lotto.lotto.LottoNumber;
import com.nextstep.lotto.lotto.Lottos;
import com.nextstep.lotto.lotto.WinningLotto;
import com.nextstep.lotto.result.LottoResult;
import com.nextstep.lotto.store.LottoFactory;
import com.nextstep.lotto.store.LottoStore;

public class LottoMain {

	public static void main(String[] args) {
		LottoInput lottoInput = new LottoInput();
		LottoOutput lottoOutput = new LottoOutput();

		lottoOutput.printMoneyForLotto();
		int money = lottoInput.inputMoney();

		LottoStore lottoStore = new LottoStore(money);
		lottoOutput.printLottoCount(lottoStore.lottoCount());

		LottoFactory lottoFactory = new LottoFactory(lottoStore.lottoCount());
		Lottos lottos = lottoFactory.lottos();
		lottoOutput.printLottos(lottos);

		lottoOutput.printWinningNumber();
		Set<LottoNumber> winningNumbers = lottoInput.inputWinningNumber();
		WinningLotto winningLotto = new WinningLotto(winningNumbers);

		LottoResult lottoResult = lottos.matchRank(winningLotto);
		lottoOutput.printStatistics(lottoResult);
		lottoOutput.printRevenueRatio(lottoResult.revenueRatio(money));
	}
}
