package tech.sipe.fintech.wallet.presentation

import org.springframework.stereotype.Service
import tech.sipe.fintech.wallet.PayWalletInternalApi
import tech.sipe.fintech.wallet.service.PayWalletService
import java.math.BigDecimal

/**
 * @author 김재영 (jaeyeong.kim@navercorp.com)
 */
@Service
class PayWalletInternalApiImpl(
	private val payWalletService: PayWalletService,
) : PayWalletInternalApi {
	override fun charge(
		amount: Long,
		payWalletId: Long,
	) {
		payWalletService.charge(amount, payWalletId)
	}

	override fun pay(
		amount: Long,
		payWalletId: Long,
	) {
		payWalletService.pay(amount, payWalletId)
	}

	override fun getBalance(payWalletId: Long): BigDecimal = payWalletService.getBalance(payWalletId)
}
