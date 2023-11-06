package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.InvalidRangeLottoNumberException;

public class WinningLotto {
    private static final Integer MIN_RANGE = 1;
    private static final Integer MAX_RANGE = 45;
    private static final Integer WINNING_LOTTO_SIZE = 7;

    private final Lotto winningLotto;
    private final Integer bonusNumber;


    public WinningLotto(List<Integer> winningLotto, Integer bonusNumber) {
        this.winningLotto = new Lotto(winningLotto);
        validateBonusNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> winningLotto, Integer bonusNumber) {
        validateDuplicate(winningLotto, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicate(List<Integer> winningLotto, Integer number) {
        Set<Integer> nonDuplicateNumbers = new HashSet<>(winningLotto);
        nonDuplicateNumbers.add(number);
        if (nonDuplicateNumbers.size() != WINNING_LOTTO_SIZE) {
            throw new DuplicateLottoNumberException();
        }
    }

    private void validateRange(Integer number) {
        if (number < MIN_RANGE && number > MAX_RANGE) {
            throw new InvalidRangeLottoNumberException();
        }
    }

    public boolean isContain(int number) {
        return winningLotto.isContain(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
