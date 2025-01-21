package tech.sipe.fintech.account.presentation

import org.springframework.stereotype.Service
import tech.sipe.fintech.account.AccountApi
import tech.sipe.fintech.account.service.AccountService
import java.math.BigDecimal

@Service
class AccountApiImpl(
	private val accountService: AccountService,
) : AccountApi {
	override fun link(payWalletId: Long) {
	}

	override fun unlink(accountId: Long) {
		accountService.unlink(accountId)
	}

	override fun getBalance(accountId: Long): BigDecimal = accountService.getBalance(accountId)

	override fun deposit(
		accountId: Long,
		amount: Long,
	) {
		accountService.deposit(accountId, amount)
	}

	override fun withdraw(
		accountId: Long,
		amount: Long,
	) {
		accountService.withdraw(accountId, amount)
	}
}
