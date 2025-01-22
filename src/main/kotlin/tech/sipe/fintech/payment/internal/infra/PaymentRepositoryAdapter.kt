package tech.sipe.fintech.payment.internal.infra

import org.springframework.stereotype.Component
import tech.sipe.fintech.payment.internal.domain.Payment
import tech.sipe.fintech.payment.internal.domain.PaymentRepository
import tech.sipe.fintech.payment.internal.infra.entity.PaymentEntityMapper
import tech.sipe.fintech.payment.internal.infra.jpa.PaymentJpaRepository

@Component
class PaymentRepositoryAdapter(
	private val paymentJpaRepository: PaymentJpaRepository,
) : PaymentRepository {
	override fun save(payment: Payment): Payment {
		val paymentEntity = PaymentEntityMapper.toEntity(payment)
		val savedEntity = paymentJpaRepository.save(paymentEntity)
		return PaymentEntityMapper.toDomain(savedEntity)
	}
}
