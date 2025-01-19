package tech.sipe.fintech.wallet

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
	type = ApplicationModule.Type.CLOSED,
	allowedDependencies = ["common"],
)
class WalletModuleMetadata
