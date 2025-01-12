package tech.sipe.fintech.transfer

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import tech.sipe.fintech.account.AccountService

/**
 * @author 김재영 (jaeyeong.kim@navercorp.com)
 */
@RestController
class TransferController(
	private val accountService: AccountService
) {
	@GetMapping
	fun getTransfer(): Transfer {
		return Transfer(
			id = 1
		)
	}
}

data class Transfer(
	val id: Long
)
