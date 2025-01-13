package tech.sipe.fintech.wallet.internal.domain

interface PayWalletRepository {
	fun findByUserId(userId: Long): PayWallet

	fun save(payWalletEntity: PayWallet): PayWallet
}
