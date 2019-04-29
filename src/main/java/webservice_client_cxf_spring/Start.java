package webservice_client_cxf_spring;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceClient;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

/**
 * demo for:
 *   provider independent ws client. If you comment out the 2 cxf dependencies, then the jdk builtin ws stack (metro) will be used.
 *   otherwise the cxf stack is used.
 *   
 * 
 * demo for:
 * - calculating service name from annotations on the generated javax.xml.ws.Service (Calculator in this case)
 * - loading wsdl from classpath
 * - setting the service url via bindingProvider
 * 
 * demo for:
 * - not providing the wsdl at runtime. If we provide the service name and service url, then wsdl file is not needed at run time!
 * 
 * @author riskop
 *
 */
public class Start {

	public static void main(String[] args) {
		Client c = new Client();
		c.callWs();
	}

}
