package tech.sipe.fintech.wallet

interface PayWalletRepository {
	fun transfer()
	fun withdraw()
}
