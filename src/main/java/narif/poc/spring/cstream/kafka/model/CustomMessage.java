/**
 * 
 */
package narif.poc.spring.cstream.kafka.model;

/**
 * @author narif
 * a simple pojo which will hold the message to be published to kafka topic
 */
public class CustomMessage {
	
	private String message;
	private String action;
	private String outcome;
	
	public CustomMessage withMessage(String msg) {
		this.setMessage(msg);
		return this;
	}
	
	public CustomMessage withAction(String action) {
		this.setAction(action);
		return this;
	}
	
	public CustomMessage withOutcome(String outCome) {
		this.setOutcome(outCome);
		return this;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getOutcome() {
		return outcome;
	}
	public void setOutcome(String outcome) {
		this.outcome = outcome;
	}
	public CustomMessage(String message, String action, String outcome) {
		super();
		this.message = message;
		this.action = action;
		this.outcome = outcome;
	}
	public CustomMessage() {
		super();
	}
	@Override
	public String toString() {
		return "CustomMessage [message=" + message + ", action=" + action + ", outcome=" + outcome + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((action == null) ? 0 : action.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((outcome == null) ? 0 : outcome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomMessage other = (CustomMessage) obj;
		if (action == null) {
			if (other.action != null)
				return false;
		} else if (!action.equals(other.action))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (outcome == null) {
			if (other.outcome != null)
				return false;
		} else if (!outcome.equals(other.outcome))
			return false;
		return true;
	}
	
	
}
