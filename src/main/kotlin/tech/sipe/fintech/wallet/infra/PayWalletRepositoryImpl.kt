package tech.sipe.fintech.wallet.infra

import org.springframework.stereotype.Component
import tech.sipe.fintech.wallet.domain.PayWallet
import tech.sipe.fintech.wallet.domain.PayWalletRepository
import kotlin.jvm.optionals.getOrElse

@Component
class PayWalletRepositoryImpl(
	private val payWalletJpaRepository: PayWalletJpaRepository,
) : PayWalletRepository {
	override fun findByUserId(userId: Long): PayWallet {
		payWalletJpaRepository.findByUserId(userId)?.let {
			return PayWalletMapper.toDomain(it)
		} ?: throw RuntimeException("PayWallet not found")
	}

	override fun findByPayWalletId(payWalletId: Long): PayWallet {
		val payWalletEntity =
			payWalletJpaRepository
				.findById(payWalletId)
				.getOrElse { throw RuntimeException("PayWallet not found") }

		return PayWalletMapper.toDomain(payWalletEntity)
	}

	override fun save(payWalletEntity: PayWallet): PayWallet =
		PayWalletMapper.toDomain(payWalletJpaRepository.save(PayWalletMapper.toEntity(payWalletEntity)))
}
