package tech.sipe.fintech.wallet.infra

import org.springframework.dao.DataIntegrityViolationException
import tech.sipe.fintech.wallet.domain.PayWallet

class PayWalletMapper {
	companion object {
		fun toDomain(entity: PayWalletEntity): PayWallet =
			PayWallet(
				id = entity.id ?: throw DataIntegrityViolationException("Id is null"),
				userId = entity.userId,
				accountId = entity.accountId,
				walletStatus = entity.walletStatus,
				balance = entity.balance,
				currency = entity.currency,
			)

		fun toEntity(domain: PayWallet) =
			PayWalletEntity(
				userId = domain.userId,
				accountId = domain.accountId,
				walletStatus = domain.walletStatus,
				balance = domain.balance,
				currency = domain.currency,
			)
	}
}
