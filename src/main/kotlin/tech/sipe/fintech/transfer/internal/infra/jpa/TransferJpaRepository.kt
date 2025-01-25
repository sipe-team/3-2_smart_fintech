package tech.sipe.fintech.transfer.internal.infra.jpa

import org.springframework.data.jpa.repository.JpaRepository
import tech.sipe.fintech.transfer.internal.infra.entity.TransferEntity

interface TransferJpaRepository : JpaRepository<TransferEntity, Long>
