
package hotelclient;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.11-b150120.1832
 * Generated source version: 2.2
 * 
 */
@WebService(name = "IService1", targetNamespace = "http://tempuri.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface IService1 {


    /**
     * 
     * @return
     *     returns hotelclient.ArrayOfRoom
     */
    @WebMethod(action = "http://tempuri.org/IService1/getRooms")
    @WebResult(name = "getRoomsResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getRooms", targetNamespace = "http://tempuri.org/", className = "hotelclient.GetRooms")
    @ResponseWrapper(localName = "getRoomsResponse", targetNamespace = "http://tempuri.org/", className = "hotelclient.GetRoomsResponse")
    public ArrayOfRoom getRooms();

    /**
     * 
     * @param p
     * @param rno
     * @param indt
     * @param e
     * @param outdt
     * @param n
     * @return
     *     returns java.lang.Integer
     */
    @WebMethod(action = "http://tempuri.org/IService1/bookRoom")
    @WebResult(name = "bookRoomResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "bookRoom", targetNamespace = "http://tempuri.org/", className = "hotelclient.BookRoom")
    @ResponseWrapper(localName = "bookRoomResponse", targetNamespace = "http://tempuri.org/", className = "hotelclient.BookRoomResponse")
    public Integer bookRoom(
        @WebParam(name = "n", targetNamespace = "http://tempuri.org/")
        String n,
        @WebParam(name = "p", targetNamespace = "http://tempuri.org/")
        String p,
        @WebParam(name = "e", targetNamespace = "http://tempuri.org/")
        String e,
        @WebParam(name = "rno", targetNamespace = "http://tempuri.org/")
        Integer rno,
        @WebParam(name = "indt", targetNamespace = "http://tempuri.org/")
        String indt,
        @WebParam(name = "outdt", targetNamespace = "http://tempuri.org/")
        String outdt);

    /**
     * 
     * @param rno
     * @return
     *     returns java.lang.Boolean
     */
    @WebMethod(action = "http://tempuri.org/IService1/isRoomBooked")
    @WebResult(name = "isRoomBookedResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "isRoomBooked", targetNamespace = "http://tempuri.org/", className = "hotelclient.IsRoomBooked")
    @ResponseWrapper(localName = "isRoomBookedResponse", targetNamespace = "http://tempuri.org/", className = "hotelclient.IsRoomBookedResponse")
    public Boolean isRoomBooked(
        @WebParam(name = "rno", targetNamespace = "http://tempuri.org/")
        Integer rno);

    /**
     * 
     * @param rt
     * @return
     *     returns hotelclient.ArrayOfint
     */
    @WebMethod(action = "http://tempuri.org/IService1/getRoomNos")
    @WebResult(name = "getRoomNosResult", targetNamespace = "http://tempuri.org/")
    @RequestWrapper(localName = "getRoomNos", targetNamespace = "http://tempuri.org/", className = "hotelclient.GetRoomNos")
    @ResponseWrapper(localName = "getRoomNosResponse", targetNamespace = "http://tempuri.org/", className = "hotelclient.GetRoomNosResponse")
    public ArrayOfint getRoomNos(
        @WebParam(name = "rt", targetNamespace = "http://tempuri.org/")
        Integer rt);

}
