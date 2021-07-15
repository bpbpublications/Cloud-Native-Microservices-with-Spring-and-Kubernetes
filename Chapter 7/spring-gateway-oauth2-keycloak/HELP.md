# Read Me First
The following was discovered as part of building this project:

* The original package name 'com.online.store.demo.spring-gateway-demo' is invalid and this project uses 'com.online.store.demo.springgatewaydemo' instead.

# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/maven-plugin/reference/html/#build-image)
* [Prometheus](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/html/production-ready-features.html#production-ready-metrics-export-prometheus)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#production-ready)
* [Wavefront for Spring Boot documentation](https://docs.wavefront.com/wavefront_springboot.html)
* [Wavefront for Spring Boot repository](https://github.com/wavefrontHQ/wavefront-spring-boot)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.3.2.RELEASE/reference/htmlsingle/#using-boot-devtools)

### Guides
The following guides illustrate how to use some features concretely:

* [Using Spring Cloud Gateway](https://github.com/spring-cloud-samples/spring-cloud-gateway-sample)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

## Observability with Wavefront

If you don't have a Wavefront account, the starter will create a freemium account for you.
The URL to access the Wavefront Service dashboard is logged on startup.

Finally, you can opt-in for distributed tracing by adding the Spring Cloud Sleuth starter.
