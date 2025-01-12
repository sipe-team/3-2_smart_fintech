package tech.sipe.fintech.transfer

import org.springframework.modulith.ApplicationModule

@ApplicationModule(
	allowedDependencies = ["wallet"]
)
class TransferModuleMetadata {
}
