package tech.sipe.fintech.account.infra

import org.springframework.dao.DataIntegrityViolationException
import tech.sipe.fintech.account.domain.Account

class AccountMapper {
	companion object {
		fun toDomain(entity: AccountEntity): Account =
			Account(
				accountId = entity.id ?: throw DataIntegrityViolationException("Id is null"),
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
