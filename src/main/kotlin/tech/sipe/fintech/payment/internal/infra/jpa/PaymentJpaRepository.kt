package tech.sipe.fintech.payment.internal.infra.jpa

import org.springframework.data.jpa.repository.JpaRepository
import tech.sipe.fintech.payment.internal.infra.entity.PaymentEntity

interface PaymentJpaRepository : JpaRepository<PaymentEntity, Long>
