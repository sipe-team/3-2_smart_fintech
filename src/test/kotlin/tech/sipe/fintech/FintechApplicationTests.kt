package tech.sipe.fintech

import org.junit.jupiter.api.Test
import org.springframework.modulith.core.ApplicationModules
import org.springframework.modulith.docs.Documenter
import org.springframework.modulith.test.ApplicationModuleTest

@ApplicationModuleTest
class FintechApplicationTests {
	val modules: ApplicationModules = ApplicationModules.of(FintechApplication::class.java)

	@Test
	fun contextLoads() {
		println("modules: $modules")

		modules.verify()
	}

	@Test
	fun wri2teDocumentationSnippets() {
		Documenter(modules)
			.writeModulesAsPlantUml(
// 				DiagramOptions.defaults()
// 					.withStyle(DiagramOptions.DiagramStyle.UML)
// 					.withDependencyTypes(DependencyType.USES_COMPONENT)
			).writeIndividualModulesAsPlantUml()
			.writeAggregatingDocument()
// 			.writeModulesAsPlantUml(
// 				DiagramOptions.defaults()
// 					.withStyle(DiagramOptions.DiagramStyle.UML)
// 					.withDependencyTypes(DependencyType.USES_COMPONENT)
// 			)
	}
}
