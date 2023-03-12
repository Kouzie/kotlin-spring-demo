package com.example.chapter5.component


//@Configuration
//class DatabaseInitializer {
//    companion object {
//        val customers = listOf(
//            Customer(1, "Kotlin", Customer.Telephone("+82", "010-1234-1111")),
//            Customer(2, "Spring"),
//            Customer(3, "Microservice"),
//        )
//    }
//    @Autowired
//    lateinit var customerRepository: CustomerRepository
//    @Autowired
//    lateinit var reactiveMongoTemplate: ReactiveMongoTemplate
//    @PostConstruct
//    fun initData() {
//        reactiveMongoTemplate.collectionExists("Customers").subscribe {
//            if (it != true) {
//                reactiveMongoTemplate.createCollection("Customers").subscribe {
//                    println("customers collections created")
//                }
//            } else {
//                println("customers Collections already exist")
//            }
//        }
//        customerRepository.saveAll(customers).subscribe{
//            println("Default Customers created")
//        }
//    }
//}