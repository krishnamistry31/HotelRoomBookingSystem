
package hotelclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Room complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Room"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="IsBooked" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="Occupacy" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="RPrice" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *         &lt;element name="RType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="RoomNo" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Room", namespace = "http://schemas.datacontract.org/2004/07/HotelBookingService", propOrder = {
    "isBooked",
    "occupacy",
    "rPrice",
    "rType",
    "roomNo"
})
public class Room {

    @XmlElementRef(name = "IsBooked", namespace = "http://schemas.datacontract.org/2004/07/HotelBookingService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> isBooked;
    @XmlElement(name = "Occupacy")
    protected Integer occupacy;
    @XmlElement(name = "RPrice")
    protected Integer rPrice;
    @XmlElementRef(name = "RType", namespace = "http://schemas.datacontract.org/2004/07/HotelBookingService", type = JAXBElement.class, required = false)
    protected JAXBElement<String> rType;
    @XmlElement(name = "RoomNo")
    protected Integer roomNo;

    /**
     * Gets the value of the isBooked property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getIsBooked() {
        return isBooked;
    }

    /**
     * Sets the value of the isBooked property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setIsBooked(JAXBElement<String> value) {
        this.isBooked = value;
    }

    /**
     * Gets the value of the occupacy property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getOccupacy() {
        return occupacy;
    }

    /**
     * Sets the value of the occupacy property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setOccupacy(Integer value) {
        this.occupacy = value;
    }

    /**
     * Gets the value of the rPrice property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRPrice() {
        return rPrice;
    }

    /**
     * Sets the value of the rPrice property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRPrice(Integer value) {
        this.rPrice = value;
    }

    /**
     * Gets the value of the rType property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getRType() {
        return rType;
    }

    /**
     * Sets the value of the rType property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setRType(JAXBElement<String> value) {
        this.rType = value;
    }

    /**
     * Gets the value of the roomNo property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getRoomNo() {
        return roomNo;
    }

    /**
     * Sets the value of the roomNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setRoomNo(Integer value) {
        this.roomNo = value;
    }

}
