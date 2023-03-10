dependencies {
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
//    implementation("org.jetbrains.kotlin:kotlin-reflect")
//    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}
