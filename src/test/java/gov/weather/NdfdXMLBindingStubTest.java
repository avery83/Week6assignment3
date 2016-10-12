package gov.weather;

import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;

import static org.junit.Assert.*;

/**
 * Created by student on 10/12/16.
 */
public class NdfdXMLBindingStubTest {


    @Test
    public void latLonListZipCode() throws Exception {
        NdfdXMLBindingStub binding = (NdfdXMLBindingStub)
                new NdfdXMLLocator().getndfdXMLPort();
        String result = binding.latLonListZipCode("53711");
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(DwmlType.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            DwmlType dwml = (DwmlType) jaxbUnmarshaller.unmarshal(new StringReader(result));

            assertEquals("Result did not match expected value", "43.0798,-89.3875", dwml.getLatLonList());
        } catch (JAXBException e) {
            // some exception occured
            e.printStackTrace();
        }

    }
}