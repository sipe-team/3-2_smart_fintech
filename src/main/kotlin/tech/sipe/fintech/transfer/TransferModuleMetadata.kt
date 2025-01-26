package tech.sipe.fintech.transfer

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
	allowedDependencies = ["wallet", "common", "global"],
)
class TransferModuleMetadata
