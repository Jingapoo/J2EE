package xml;

import org.apache.xml.security.encryption.XMLCipher;
import org.w3c.dom.Document;

import javax.crypto.SecretKey;

/**
 * Encrypt and Decrypt XML files using symmetric keys,
 * when use the symmetric algorithm like AES to encrypt XML data, must use the same key to encrypt and decrypt the XML data
 *
 */

public class mainProcess {

    public static void main(String args[]) throws Exception{

        // The PATH to save the original XML file, encrypted XML file and decrypted XML file

        String xmlFile = ".../xml_encrypt_decryption/src/files_inProcess/ITs.xml";
        String encryptedFile =".../xml_encrypt_decryption/src/files_inProcess/encrypted.xml";
        String decryptedFile = ".../xml_encrypt_decryption/src/files_inProcess/decrypted.xml";

        SecretKey secretKey = SecretKeyUtil.getSecretKey("AES"); // AES algorithm
        Document doc = XMLUtil.getDocument(xmlFile);

        // Get the original document from the path, and encrypt the document
        Document encryptedDoc = XMLUtil.encryptDoc(doc, secretKey, XMLCipher.AES_128);
        XMLUtil.saveDocTo(encryptedDoc, encryptedFile); // save the file to the path

        // get the encrypted file from above, then decrypt it save to the destined path.
        Document decryptedDoc = XMLUtil.decryptDoc(encryptedDoc, secretKey, XMLCipher.AES_128);
        XMLUtil.saveDocTo(decryptedDoc, decryptedFile);

        System.out.println("Done!");
    }
}
