package example;/**
 * Created by student on 10/12/16.
 */
public class HelloWorldClient {
  public static void main(String[] argv) {
      try {
          NdfdXMLLocator locator = new NdfdXMLLocator();
          Activator service = locator.get();
          // If authorization is required
          //((NdfdXMLBindingStub)service).setUsername("user3");
          //((NdfdXMLBindingStub)service).setPassword("pass3");
          // invoke business method
          service.businessMethod();
      } catch (javax.xml.rpc.ServiceException ex) {
          ex.printStackTrace();
      } catch (java.rmi.RemoteException ex) {
          ex.printStackTrace();
      }
  }
}
