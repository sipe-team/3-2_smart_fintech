package tech.sipe.fintech.wallet

import org.springframework.web.bind.annotation.RestController

/**
 * @author 김재영 (jaeyeong.kim@navercorp.com)
 */
@RestController
class WalletController {
}

data class Wallet(
	val id: Long
)
