package tech.sipe.fintech.wallet.presentation

import org.springframework.stereotype.Component
import tech.sipe.fintech.wallet.PayWalletInternalApi
import tech.sipe.fintech.wallet.presentation.response.GetBalanceResponse
import tech.sipe.fintech.wallet.service.PayWalletService

@Component
class PayWalletInternalApiImpl(
	private val payWalletService: PayWalletService,
) : PayWalletInternalApi {
	override fun pay(
		amount: Long,
		payWalletId: Long,
	) {
		payWalletService.pay(amount, payWalletId)
	}

	override fun getBalance(payWalletId: Long): GetBalanceResponse = payWalletService.getBalance(payWalletId)
}
