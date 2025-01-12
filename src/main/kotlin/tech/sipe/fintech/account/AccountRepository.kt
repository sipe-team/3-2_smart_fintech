package tech.sipe.fintech.account

interface AccountRepository {
	fun save(account: Account)
	fun delete(account: Account)
}
