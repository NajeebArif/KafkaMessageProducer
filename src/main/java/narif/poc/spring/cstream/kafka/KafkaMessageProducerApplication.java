package narif.poc.spring.cstream.kafka;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;

@SpringBootApplication
@EnableCircuitBreaker
@EnableBinding(Source.class)
public class KafkaMessageProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaMessageProducerApplication.class, args);
	}
}
