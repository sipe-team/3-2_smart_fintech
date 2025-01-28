package tech.sipe.fintech.account.infra

import tech.sipe.fintech.account.domain.Account
import tech.sipe.fintech.global.error.CustomException
import tech.sipe.fintech.global.error.ErrorCode

class AccountMapper {
	companion object {
		fun toDomain(entity: AccountEntity): Account =
			Account(
				accountId = entity.id ?: throw CustomException(ErrorCode.ENTITY_ID_NULL),
				userId = entity.userId,
				bankName = entity.bankName,
				iban = entity.iban,
				accountHolderName = entity.accountHolderName,
				currency = entity.currency,
				balance = entity.balance,
			)

		fun toEntity(domain: Account) =
			AccountEntity(
				userId = domain.userId,
				bankName = domain.bankName,
				iban = domain.iban,
				accountHolderName = domain.accountHolderName,
				currency = domain.currency,
				balance = domain.balance,
			)
	}
}
