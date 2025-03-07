package tech.sipe.fintech.wallet.domain

import tech.sipe.fintech.common.Currency
import java.math.BigDecimal

class PayWallet(
	val id: Long,
	val userId: Long,
	val accountId: Long?,
	val walletStatus: WalletStatus,
	balance: BigDecimal,
	val currency: Currency,
) {
	companion object {
		private const val MINIMUM_CHARGE_AMOUNT = 1000

		fun initialize(userId: Long): PayWallet =
			PayWallet(
				id = 0L,
				userId = userId,
				accountId = null,
				walletStatus = WalletStatus.INACTIVE,
				balance = BigDecimal.ZERO,
				currency = Currency.KRW,
			)
	}

	var balance: BigDecimal = balance
		private set

	/**
	 * 충전
	 */
	fun charge(amount: Long) {
		if (amount < MINIMUM_CHARGE_AMOUNT) {
			throw IllegalArgumentException("최소 충전 금액은 1,000원입니다.")
		}
		balance += BigDecimal.valueOf(amount)
	}

	/**
	 * 차감
	 */
	fun debit(amount: Long) {
		if (balance - BigDecimal.valueOf(amount) < BigDecimal.ZERO) {
			throw IllegalArgumentException("잔액이 부족합니다.")
		}
		balance -= BigDecimal.valueOf(amount)
	}
}
