package webservice_client_cxf_spring;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClientTest {

	@Test
	public void test() {
		Client c = new Client();
		c.callWs();
	}

}
