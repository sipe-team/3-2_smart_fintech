package tech.sipe.fintech.transfer.internal.infra

import jakarta.persistence.Entity
import jakarta.persistence.Table
import tech.sipe.fintech.common.BaseEntity

@Entity
@Table(name = "transfer")
class TransferEntity : BaseEntity()
