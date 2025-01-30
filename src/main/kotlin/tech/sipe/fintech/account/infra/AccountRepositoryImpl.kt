package tech.sipe.fintech.account.infra

import org.springframework.stereotype.Component
import tech.sipe.fintech.account.domain.Account
import tech.sipe.fintech.account.domain.AccountRepository
import tech.sipe.fintech.global.error.CustomException
import tech.sipe.fintech.global.error.ErrorCode
import kotlin.jvm.optionals.getOrElse

@Component
class AccountRepositoryImpl(
	private val accountJpaRepository: AccountJpaRepository,
) : AccountRepository {
	override fun findByAccountId(accountId: Long): Account {
		val accountEntity =
			accountJpaRepository
				.findById(accountId)
				.getOrElse { throw CustomException(ErrorCode.ACCOUNT_NOT_FOUND) }

		return AccountMapper.toDomain(accountEntity)
	}

	override fun findByUserId(userId: Long): Account {
		val accountEntity =
			accountJpaRepository
				.findByUserId(userId)
				.getOrElse { throw CustomException(ErrorCode.ACCOUNT_NOT_FOUND) }

		return AccountMapper.toDomain(accountEntity)
	}

	override fun save(account: Account): Account =
		AccountMapper.toDomain(accountJpaRepository.save(AccountMapper.toEntity(account)))

	override fun delete(accountId: Long) {
		val accountEntity =
			accountJpaRepository
				.findById(accountId)
				.getOrElse { throw CustomException(ErrorCode.ACCOUNT_NOT_FOUND) }

		accountEntity.softDelete()
	}
}
