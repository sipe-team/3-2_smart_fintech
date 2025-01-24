package tech.sipe.fintech.payment

import org.springframework.stereotype.Component
import java.math.BigDecimal

@Component
class WalletServiceClient {
	fun getWalletBalance(userId: Long): Long {
		// 구현할 예정
		return 10000L
	}

	fun deductWalletBalance(
		paymentRequestUserId: Long,
		money: BigDecimal,
	) {
		// 구현할 예정
	}
}
