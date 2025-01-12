package tech.sipe.fintech.account

import org.springframework.web.bind.annotation.RestController

/**
 * @author 김재영 (jaeyeong.kim@navercorp.com)
 */
@RestController
class AccountController {
}

data class Account(
	val id: Long
)
