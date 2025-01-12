package tech.sipe.fintech.wallet.internal.domain

import java.math.BigDecimal

class PayWallet(
	val id: Long,
	val userId: Long,
	val accountId: Long,
	val walletStatus: WalletStatus,
	balance: BigDecimal,
	val currency: Currency,
) {
	var balance: BigDecimal = balance
		private set

	private val MINIMUM_CHARGE_AMOUNT = 1000

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
	fun withdraw(amount: Long) {
		if (balance - BigDecimal.valueOf(amount) < BigDecimal.ZERO) {
			throw IllegalArgumentException("잔액이 부족합니다.")
		}
		balance -= BigDecimal.valueOf(amount)
	}
}
