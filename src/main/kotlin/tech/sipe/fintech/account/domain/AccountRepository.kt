package tech.sipe.fintech.account.domain

interface AccountRepository {
	fun findByAccountId(accountId: Long): Account

	fun save(account: Account): Account

	fun delete(accountId: Long)
}
