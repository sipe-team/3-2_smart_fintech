package tech.sipe.fintech.account.presentation

import org.springframework.stereotype.Service
import tech.sipe.fintech.account.AccountInternalApi
import tech.sipe.fintech.account.presentation.response.GetAccountResponse
import tech.sipe.fintech.account.service.AccountService
import java.math.BigDecimal

@Service
class AccountInternalApiImpl(
	private val accountService: AccountService,
) : AccountInternalApi {
	override fun deleteAccount(accountId: Long) {
		accountService.delete(accountId)
	}

	override fun getBalance(accountId: Long): BigDecimal = accountService.getBalance(accountId)

	override fun getAccountByUserId(userId: Long): GetAccountResponse = accountService.getAccountByUserId(userId)

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
