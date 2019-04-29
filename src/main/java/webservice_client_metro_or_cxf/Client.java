package webservice_client_metro_or_cxf;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceClient;

import org.tempuri.Calculator;
import org.tempuri.CalculatorSoap;

public class Client {
	
	public void callWs() {
		{
			Calculator calculator = new Calculator(
				getWsdlLocationOnClasspathForServiceClass(Calculator.class),
				getQNameForServiceClass(Calculator.class)
			);
			
			CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();
			
			BindingProvider bindingProvider = (BindingProvider) calculatorSoap;
			bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://www.dneonline.com/calculator.asmx");
			int result = calculatorSoap.add(1, 1);
			System.out.println("result: " + result);
		}
		
		System.out.println("now use the service without using the wsdl at run time");

		{
			Calculator calculator = new Calculator(
				null,
				getQNameForServiceClass(Calculator.class)
			);
				
			CalculatorSoap calculatorSoap = calculator.getCalculatorSoap();
			
			BindingProvider bindingProvider = (BindingProvider) calculatorSoap;
			bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://www.dneonline.com/calculator.asmx");
			int result = calculatorSoap.add(2, 3);
			System.out.println("result: " + result);
		}

	}
	
    private static <T extends javax.xml.ws.Service> URL getWsdlLocationOnClasspathForServiceClass(Class<T> serviceClass) {
        try {
            WebServiceClient webServiceClientAnnotation = serviceClass.getAnnotation(WebServiceClient.class);
            String wsdlLocation = webServiceClientAnnotation.wsdlLocation();
            String wsdlFileName;
            wsdlFileName = Paths.get(new URL(wsdlLocation).getPath()).getFileName().toString();
            System.out.println("wsdl file name: " + wsdlFileName);
            URL wsdlLocationOnClasspath = Start.class.getClassLoader().getResource(wsdlFileName);
            System.out.println("wsdlLocationOnClasspath: " + wsdlLocationOnClasspath);
            return wsdlLocationOnClasspath;
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    private static <T extends javax.xml.ws.Service> QName getQNameForServiceClass(Class<T> serviceClass) {
        WebServiceClient webServiceClientAnnotation = serviceClass.getAnnotation(WebServiceClient.class);
        String targetNameSpace = webServiceClientAnnotation.targetNamespace();
        String name = webServiceClientAnnotation.name();
        QName qName = new QName(targetNameSpace, name);
        return qName;
    }



}
