package webservice_client_metro_or_cxf;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void test() {
		Client c = new Client();
		c.callWs();
	}

}
