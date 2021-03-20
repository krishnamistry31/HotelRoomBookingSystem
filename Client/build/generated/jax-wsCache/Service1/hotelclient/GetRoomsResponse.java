
package hotelclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="getRoomsResult" type="{http://schemas.datacontract.org/2004/07/HotelBookingService}ArrayOfRoom" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getRoomsResult"
})
@XmlRootElement(name = "getRoomsResponse")
public class GetRoomsResponse {

    @XmlElementRef(name = "getRoomsResult", namespace = "http://tempuri.org/", type = JAXBElement.class, required = false)
    protected JAXBElement<ArrayOfRoom> getRoomsResult;

    /**
     * Gets the value of the getRoomsResult property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRoom }{@code >}
     *     
     */
    public JAXBElement<ArrayOfRoom> getGetRoomsResult() {
        return getRoomsResult;
    }

    /**
     * Sets the value of the getRoomsResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link ArrayOfRoom }{@code >}
     *     
     */
    public void setGetRoomsResult(JAXBElement<ArrayOfRoom> value) {
        this.getRoomsResult = value;
    }

}
