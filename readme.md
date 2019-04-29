web service client metro or cxf
---------------------------


demo for:

provider independent ws client.

If you comment out the 2 cxf dependencies, then the jdk builtin ws stack (metro) will be used.

Otherwise the cxf stack is used.

demo for:

calculating service name from annotations on the generated javax.xml.ws.Service (Calculator in this case)

loading wsdl from classpath

setting the service url via bindingProvider

demo for:

not providing the wsdl at runtime. If we provide the service name and service url, then wsdl file is not needed at run time!

