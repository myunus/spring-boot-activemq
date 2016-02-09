package sample.activemq;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.OutputCapture;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(ActiveMQApplication.class)
public class ActiveMqTest {
	
	@Rule
	public OutputCapture outputCapture = new OutputCapture();
	
	@Autowired
	private Producer producer;
	
	@Test
	public void sendSimpleMessage() throws InterruptedException {
		this.producer.send("Test Message");
		Thread.sleep(1000);
		Assert.assertTrue(this.outputCapture.toString().contains("Test Message sss"));
	}

}
