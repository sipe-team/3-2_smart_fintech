package tech.sipe.fintech.transfer

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
	allowedDependencies = ["common", "wallet", "account"],
)
class TransferModuleMetadata
