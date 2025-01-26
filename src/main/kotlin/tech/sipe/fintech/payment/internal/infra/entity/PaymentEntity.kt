package tech.sipe.fintech.payment.internal.infra.entity

import jakarta.persistence.*
import tech.sipe.fintech.common.BaseEntity
import tech.sipe.fintech.common.Currency
import tech.sipe.fintech.payment.internal.domain.PaymentMethod
import tech.sipe.fintech.payment.internal.domain.PaymentStatus
import java.math.BigDecimal

@Entity
@Table(name = "payments")
class PaymentEntity(
	val paymentRequestUserId: Long,
	val paymentResponseUserId: Long,
	val money: BigDecimal? = BigDecimal.ZERO,
	val currency: Currency,
	@Enumerated(value = EnumType.STRING)
	val paymentMethod: PaymentMethod,
	@Enumerated(value = EnumType.STRING)
	val paymentStatus: PaymentStatus,
) : BaseEntity()
