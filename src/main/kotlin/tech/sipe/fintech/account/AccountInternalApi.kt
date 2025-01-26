package tech.sipe.fintech.account

import java.math.BigDecimal

interface AccountInternalApi {
	fun link(payWalletId: Long)

	fun unlink(accountId: Long)

	fun getBalance(accountId: Long): BigDecimal

	fun deposit(
		accountId: Long,
		amount: Long,
	)

	fun withdraw(
		accountId: Long,
		amount: Long,
	)
}
