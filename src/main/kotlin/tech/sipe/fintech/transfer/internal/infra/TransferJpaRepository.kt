package tech.sipe.fintech.transfer.internal.infra

import org.springframework.data.jpa.repository.JpaRepository

interface TransferJpaRepository : JpaRepository<TransferEntity, Long>
