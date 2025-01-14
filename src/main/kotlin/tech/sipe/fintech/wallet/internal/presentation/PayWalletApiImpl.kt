package tech.sipe.fintech.wallet.internal.presentation

import org.springframework.stereotype.Service
import tech.sipe.fintech.wallet.PayWalletApi
import tech.sipe.fintech.wallet.internal.service.PayWalletService

/**
 * @author 김재영 (jaeyeong.kim@navercorp.com)
 */
@Service
class PayWalletApiImpl(
	private val payWalletService: PayWalletService,
) : PayWalletApi {
	override fun charge(
		amount: Long,
		payWalletId: Long,
	) {
		TODO("Not yet implemented")
	}

	override fun pay(
		amount: Long,
		payWalletId: Long,
	) {
		TODO("Not yet implemented")
	}

	override fun getBalance(payWalletId: Long): Long {
		TODO("Not yet implemented")
	}
}
