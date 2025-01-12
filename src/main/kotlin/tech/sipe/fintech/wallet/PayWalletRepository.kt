package tech.sipe.fintech.wallet

interface PayWalletRepository {
	fun charge()
	fun withdraw()
}
