package tech.sipe.fintech.wallet.domain

interface PayWalletRepository {
	fun findByUserId(userId: Long): PayWallet

	fun findByPayWalletId(payWalletId: Long): PayWallet

	fun save(payWalletEntity: PayWallet): PayWallet
}
