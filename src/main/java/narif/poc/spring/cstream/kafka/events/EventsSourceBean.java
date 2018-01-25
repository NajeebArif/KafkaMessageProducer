/**
 * 
 */
package narif.poc.spring.cstream.kafka.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import narif.poc.spring.cstream.kafka.model.CustomMessage;

/**
 * @author narif
 *
 */
@Component
public class EventsSourceBean {
	
	private Source source;
	
	@Autowired
	public EventsSourceBean(Source source) {
		this.source = source;
	}
	
	public void publishCustomMessage(String action, String outCome, String msg) {
		CustomMessage cm = new CustomMessage()
				.withAction(action)
				.withOutcome(outCome)
				.withMessage(msg);
		
		source.output().send(MessageBuilder.withPayload(cm).build());
	}
}
