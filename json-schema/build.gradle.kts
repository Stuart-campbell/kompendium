plugins {
  kotlin("jvm")
  kotlin("plugin.serialization")
  id("io.bkbn.sourdough.library.jvm")
  id("io.gitlab.arturbosch.detekt")
  id("com.adarshr.test-logger")
  id("org.jetbrains.dokka")
  id("maven-publish")
  id("java-library")
  id("signing")
}

sourdoughLibrary {
  libraryName.set("Kompendium JSON Schema")
  libraryDescription.set("Json Schema Generator")
  compilerArgs.set(listOf("-opt-in=kotlin.RequiresOptIn"))
}

dependencies {
  implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.10")
  implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.0")

  testImplementation(testFixtures(projects.kompendiumCore))
}

testing {
  suites {
    named("test", JvmTestSuite::class) {
      useJUnitJupiter()
    }
  }
}
