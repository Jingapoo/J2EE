package xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.crypto.SecretKey;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import org.apache.xml.security.encryption.XMLCipher;
import org.apache.xml.security.utils.EncryptionConstants;

/**
 * Due to the xmlsec is using apache, requiring external modules imported.
 * download xmlsec jar and add external jars in IDEA, File --> Project Structure --> Modules --> Dependencies --> + icon --> Jars or directories
 */
public class XMLUtil {

    static{
        org.apache.xml.security.Init.init();
    }

    /**
     * Return DOM Document object for given xml file
     */

    public static Document getDocument(String xmlFile) throws Exception{
        // Get the instance of BuilderFactory class
        DocumentBuilderFactory builder = DocumentBuilderFactory.newInstance();
        builder.setNamespaceAware(true);

        //Instantiate Documentbuilder object
        DocumentBuilder docBuilder = builder.newDocumentBuilder();

        // get the Document object
        Document doc = docBuilder.parse(xmlFile);

        return doc;
    }

    /**
     * Save Document to a file
     */
    public static void saveDocTo(Document doc, String fileName)throws Exception{
        File encryptionFile = new File(fileName);
        FileOutputStream fOutStream = new FileOutputStream(encryptionFile);

        TransformerFactory factory = TransformerFactory.newInstance();
        Transformer transformer = factory.newTransformer();
        transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(fOutStream);
        transformer.transform(source,result);

        fOutStream.close();
    }

    /**
     * Encrypt document with given algorithm and secret key
     */
    public static Document encryptDoc(Document doc, SecretKey secretKey, String algorithm) throws Exception{
        // Get Document root element
        Element rootElement = doc.getDocumentElement();
        String algorithmURI = algorithm;
        XMLCipher xmlCipher = XMLCipher.getInstance(algorithmURI);

        // Initialize cipher with given secret key and operational mode
        xmlCipher.init(XMLCipher.ENCRYPT_MODE, secretKey);

        // Process the contents of document
        xmlCipher.doFinal(doc, rootElement, true);

        return doc;
    }

    /**
     * Decrypt document using given key and algorithm
     */
    public static Document decryptDoc(Document doc, SecretKey secretKey, String algorithm) throws Exception{

        Element encryptedDataElement = (Element) doc.getElementsByTagNameNS(EncryptionConstants.EncryptionSpecNS, EncryptionConstants._TAG_ENCRYPTEDDATA).item(0);

        XMLCipher xmlCipher = XMLCipher.getInstance();

        xmlCipher.init(XMLCipher.DECRYPT_MODE, secretKey);
        xmlCipher.doFinal(doc, encryptedDataElement);

        return doc;
    }
}
