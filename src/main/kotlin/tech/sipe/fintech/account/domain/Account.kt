package tech.sipe.fintech.account.domain

import tech.sipe.fintech.wallet.internal.domain.Currency
import java.math.BigDecimal

class Account(
	val id: Long,
	val payWalletId: Long,
	val bankName: BankName,
	val iban: Long,
	val accountHolderName: String,
	val currency: Currency,
	balance: BigDecimal,
) {
	var balance: BigDecimal = balance
		private set

	/**
	 * 입금
	 */
	fun deposit(amount: Long) {
		balance += BigDecimal.valueOf(amount)
	}

	/**
	 * 출금
	 */
	fun withdraw(amount: Long) {
		if (balance - BigDecimal.valueOf(amount) < BigDecimal.ZERO) {
			throw IllegalArgumentException("잔액이 부족합니다.")
		}
		balance -= BigDecimal.valueOf(amount)
	}
}
