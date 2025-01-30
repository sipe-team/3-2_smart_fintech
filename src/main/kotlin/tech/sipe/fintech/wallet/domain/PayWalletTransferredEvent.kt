package tech.sipe.fintech.wallet.domain

import tech.sipe.fintech.common.DomainEvent

data class PayWalletTransferredEvent(
	val transferId: Long,
) : DomainEvent
