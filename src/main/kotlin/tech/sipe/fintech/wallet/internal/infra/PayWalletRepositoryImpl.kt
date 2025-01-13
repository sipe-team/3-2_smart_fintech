package tech.sipe.fintech.wallet.internal.infra

import org.springframework.stereotype.Component
import tech.sipe.fintech.wallet.internal.domain.PayWallet
import tech.sipe.fintech.wallet.internal.domain.PayWalletMapper
import tech.sipe.fintech.wallet.internal.domain.PayWalletRepository

@Component
class PayWalletRepositoryImpl(
	private val payWalletJpaRepository: PayWalletJpaRepository,
) : PayWalletRepository {
	override fun findByUserId(userId: Long): PayWallet {
		payWalletJpaRepository.findByUserId(userId)?.let {
			return PayWalletMapper.toDomain(it)
		} ?: throw RuntimeException("PayWallet not found")
	}

	override fun save(payWalletEntity: PayWallet): PayWallet =
		PayWalletMapper.toDomain(payWalletJpaRepository.save(PayWalletMapper.toEntity(payWalletEntity)))
}
