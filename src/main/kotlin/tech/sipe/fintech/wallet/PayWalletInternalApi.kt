package tech.sipe.fintech.wallet

import java.math.BigDecimal

/**
 * @author 김재영 (jaeyeong.kim@navercorp.com)
 */
interface PayWalletInternalApi {
	fun charge(
		amount: Long,
		payWalletId: Long,
	)

	fun pay(
		amount: Long,
		payWalletId: Long,
	)

	fun getBalance(payWalletId: Long): BigDecimal
}
