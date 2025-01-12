package tech.sipe.fintech.payment

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import tech.sipe.fintech.account.Account

/**
 * @author 김재영 (jaeyeong.kim@navercorp.com)
 */
@RestController
class PaymentController {

	@GetMapping("/payment")
	fun getPayment(
		@RequestParam id: Long
	): Payment {
		return Payment(
			id = id
		)
	}
}


data class Payment(
	val id: Long
)
