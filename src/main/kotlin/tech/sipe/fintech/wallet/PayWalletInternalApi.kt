package tech.sipe.fintech.wallet

import tech.sipe.fintech.wallet.presentation.response.GetBalanceResponse

interface PayWalletInternalApi {
	fun charge(
		amount: Long,
		payWalletId: Long,
	)

	fun pay(
		amount: Long,
		payWalletId: Long,
	)

	fun getBalance(payWalletId: Long): GetBalanceResponse
}
