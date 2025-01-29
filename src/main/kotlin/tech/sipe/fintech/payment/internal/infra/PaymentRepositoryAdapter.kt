package tech.sipe.fintech.payment.internal.infra

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import tech.sipe.fintech.global.error.CustomException
import tech.sipe.fintech.global.error.ErrorCode
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

	override fun findByPaymentId(paymentId: Long): Payment {
		val paymentEntity =
			paymentJpaRepository.findByIdOrNull(paymentId) ?: throw CustomException(ErrorCode.RESOURCE_NOT_FOUND)
		return PaymentEntityMapper.toDomain(paymentEntity)
	}
}
