package tech.sipe.fintech.account.infra

import org.springframework.stereotype.Component
import tech.sipe.fintech.account.domain.Account
import tech.sipe.fintech.account.domain.AccountRepository
import kotlin.jvm.optionals.getOrElse

@Component
class AccountRepositoryImpl(
	private val accountJpaRepository: AccountJpaRepository,
) : AccountRepository {
	override fun findByAccountId(accountId: Long): Account {
		val accountEntity =
			accountJpaRepository
				.findById(accountId)
				.getOrElse { throw RuntimeException("Account not found") }

		return AccountMapper.toDomain(accountEntity)
	}

	override fun findByUserId(userId: Long): Account {
		val accountEntity =
			accountJpaRepository
				.findByUserId(userId)
				.getOrElse { throw RuntimeException("Account not found") }

		return AccountMapper.toDomain(accountEntity)
	}

	override fun save(account: Account): Account =
		AccountMapper.toDomain(accountJpaRepository.save(AccountMapper.toEntity(account)))

	override fun delete(accountId: Long) {
		val accountEntity =
			accountJpaRepository
				.findById(accountId)
				.getOrElse { throw RuntimeException("Account not found") }

		accountEntity.softDelete()
	}
}
