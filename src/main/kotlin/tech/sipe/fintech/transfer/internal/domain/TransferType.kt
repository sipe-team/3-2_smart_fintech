package tech.sipe.fintech.transfer.internal.domain

enum class TransferType {
    ACCOUNT_TO_WALLET,  // 계좌 → 지갑
    WALLET_TO_ACCOUNT,  // 지갑 → 계좌
    WALLET_TO_WALLET    // 지갑 → 지갑
}
