package dong.activemq;

import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class ProducerTest {
	private static final String url = "tcp://192.168.67.133:61616";
	private static final String queueName = "q-test" ;
	public static void main(String[] args) throws JMSException {
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
		Connection connection = connectionFactory.createConnection();
		connection.start();
		
		Session session= connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		
		Destination destination = session.createQueue(queueName);
		
		MessageProducer producer = session.createProducer(destination);
		
		TextMessage message = session.createTextMessage("qw11reqweqw23");
		producer.send(message);
		session.close();
		producer.close();
		connection.close();
		
	}
}
