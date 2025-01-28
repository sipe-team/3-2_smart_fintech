package tech.sipe.fintech.account.domain

import tech.sipe.fintech.account.presentation.request.CreateAccountRequest
import tech.sipe.fintech.common.Currency
import tech.sipe.fintech.global.error.CustomException
import tech.sipe.fintech.global.error.ErrorCode
import java.math.BigDecimal

class Account(
	val accountId: Long,
	val userId: Long,
	val bankName: BankName,
	val iban: Long,
	val accountHolderName: String,
	val currency: Currency,
	balance: BigDecimal,
) {
	companion object {
		fun initialize(createAccountRequest: CreateAccountRequest): Account =
			Account(
				accountId = 0L,
				userId = createAccountRequest.userId,
				bankName = createAccountRequest.bankName,
				iban = createAccountRequest.iban,
				accountHolderName = createAccountRequest.accountHolderName,
				currency = Currency.KRW,
				balance = BigDecimal.ZERO,
			)
	}

	var balance: BigDecimal = balance
		private set

	/**
	 * 입금
	 */
	@Synchronized
	fun deposit(amount: Long) {
		balance += BigDecimal.valueOf(amount)
	}

	/**
	 * 출금
	 */
	@Synchronized
	fun withdraw(amount: Long) {
		if (balance - BigDecimal.valueOf(amount) < BigDecimal.ZERO) {
			throw CustomException(ErrorCode.INSUFFICIENT_BALANCE)
		}
		balance -= BigDecimal.valueOf(amount)
	}
}
