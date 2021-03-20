using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace HotelBookingService
    {
        public class Service1 : IService1
        {
            public static bool isCustomerRegistered(string name, string phone, string email)
            {
            SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            con.Open();
            cmd.Parameters.AddWithValue("@name", name);
            cmd.Parameters.AddWithValue("@phone", phone);
            cmd.Parameters.AddWithValue("@email", email);
            cmd.CommandText = "Select C_Name From Customer where C_Name = @name AND C_Email=@email And C_Phone=@phone";
            SqlDataReader sr = cmd.ExecuteReader();
            if (sr.Read())
            {
                con.Close();
                sr.Close();
                return true;
            }
            else
            {
                con.Close();
                sr.Close();
                return false;
            }
        }
        public void updateBookingDate(int bid,string indt,string outdt)
        {
            SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
            SqlCommand cmd = new SqlCommand();
            int totamt = 0, amt = 0, days = 0;
            cmd.Connection = con;
            cmd.Parameters.AddWithValue("@bid", bid);
            cmd.Parameters.AddWithValue("@indt", indt);
            cmd.Parameters.AddWithValue("@outdt", outdt);
            DateTime ind = Convert.ToDateTime(indt);
            DateTime outd = Convert.ToDateTime(outdt);
            TimeSpan diff = outd - ind;
            days = diff.Days;
            cmd.CommandText ="select R_no from Booked where B_Id=@bid";
            con.Open();
            SqlDataReader sr = cmd.ExecuteReader();
            int rno = 0;
            while (sr.Read())
            {
                rno = sr.GetInt32(0);
            }
            con.Close();
            cmd.Parameters.AddWithValue("@rno", rno);
            cmd.CommandText = "select R_Price from Room where R_No=@rno";
            con.Open();
            SqlDataReader sdr1 = cmd.ExecuteReader();
            while (sdr1.Read())
            {
                amt = sdr1.GetInt32(0);
            }
            totamt = amt * days;
            con.Close();
            con.Open();
            cmd.Parameters.AddWithValue("@ta",totamt);
            cmd.Parameters.AddWithValue("@d",days);
            cmd.CommandText = "update Booked set Checkin_Date=@indt,Checkout_Date=@outdt,Tot_Amount=@ta,Tot_Days=@d WHERE B_Id = @bid";
            cmd.ExecuteNonQuery();
            con.Close();

        }
        public int bookRoom(string n, string p, string e, int rno, string indt, string outdt)
            {
                SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
                SqlCommand cmd = new SqlCommand();
                int totamt = 0, amt = 0, id = 0, days = 0;
                cmd.Connection = con;
                cmd.Parameters.AddWithValue("@name", n);
                cmd.Parameters.AddWithValue("@phone", p);
                cmd.Parameters.AddWithValue("@email", e);
                cmd.Parameters.AddWithValue("@rno", rno);
                cmd.Parameters.AddWithValue("@indt", indt);
                cmd.Parameters.AddWithValue("@outdt", outdt);
                if (!Service1.isCustomerRegistered(n, p, e))
                    {
                        cmd.CommandText = "insert into Customer(C_Name,C_Phone,C_Email) values(@name,@phone,@email)";
                        con.Open();
                        cmd.ExecuteNonQuery();
                        con.Close();
                    }

                cmd.CommandText = "select C_Id from Customer where C_Name=@name and C_Phone=@phone and C_Email=@email";
                con.Open();
                SqlDataReader sdr = cmd.ExecuteReader();
                while (sdr.Read())
                {
                    id = sdr.GetInt32(0);
                }
                con.Close();
                DateTime ind = Convert.ToDateTime(indt);
                DateTime outd = Convert.ToDateTime(outdt);
                TimeSpan diff = outd - ind;
                days = diff.Days;
                con.Close();
                cmd.CommandText = "select R_Price from Room where R_No=@rno";
                con.Open();
                SqlDataReader sdr1 = cmd.ExecuteReader();
                while (sdr1.Read())
                {
                    amt = sdr1.GetInt32(0);
                }
                totamt = amt * days;
                con.Close();
                cmd.Parameters.AddWithValue("@id", id);
                cmd.Parameters.AddWithValue("@totamt", totamt);
                cmd.Parameters.AddWithValue("@days", days);
                if (!isRoomBooked(rno))
                {
                    cmd.CommandText = "insert into Booked(C_Id,R_No,Checkin_Date,Checkout_Date,Tot_Amount,Tot_Days) values(@id,@rno,@indt,@outdt,@totamt,@days)";
                    con.Open();
                    cmd.ExecuteNonQuery();
                    con.Close();
                }
                con.Open();
                cmd.CommandText = "update Room set Is_Booked='true' where R_No=@rno";
                cmd.ExecuteNonQuery();
                con.Close();
                return totamt;
            }

        public List<Booked> getBookingInfo(int c_id)
        {
            SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.Parameters.AddWithValue("@id", c_id);
            cmd.CommandText = "Select B_Id,R_No,Checkin_Date,Checkout_Date,Tot_Amount,Tot_Days from Booked where C_Id = @id";
            con.Open();
            SqlDataReader sr = cmd.ExecuteReader();
            List<Booked> l = new List<Booked>();
            while (sr.Read())
            {
                Booked b = new Booked();
                b.BID = sr.GetInt32(0);
                b.CID = c_id;
                b.RoomNos = sr.GetInt32(1);
                b.CheckInDate = sr.GetString(2);
                b.CheckOutDate = sr.GetString(3);
                b.TotalAmount = sr.GetInt32(4);
                b.TotalDays = sr.GetInt32(5);
                l.Add(b);
            }
            sr.Close();
            con.Close();
            return l;
        }
        public void cancelBooking(int bid)
        {
            SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            cmd.Parameters.AddWithValue("@bid", bid);
            cmd.CommandText = "SELECT R_No From Booked where B_Id=@bid";
            con.Open();
            SqlDataReader sr = cmd.ExecuteReader();
            int rno=0;
            if (sr.Read())
                 rno = sr.GetInt32(0);
            con.Close();
            sr.Close();
            con.Open();
            
            cmd.Parameters.AddWithValue("@rno", rno);
            cmd.CommandText = "update Room set Is_Booked='false' where R_No=@rno";
            cmd.ExecuteNonQuery();
            con.Close();
            con.Open();
            cmd.CommandText = "DELETE FROM Booked where B_Id=@bid";
            int i = cmd.ExecuteNonQuery();
            con.Close();
            
        }
        public int getCustomerId(string nm, string ph, string em)
        {
                int id = 0;
                SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = con;
            cmd.Parameters.AddWithValue("@name",nm);
            cmd.Parameters.AddWithValue("@phone",ph);
            cmd.Parameters.AddWithValue("@email",em);
            cmd.CommandText = "select C_Id from Customer where C_Name=@name and C_Phone=@phone and C_Email=@email";
                con.Open();
                SqlDataReader sdr = cmd.ExecuteReader();
                while (sdr.Read())
                {
                    id = sdr.GetInt32(0);
                }
                con.Close();
                return id;
         }

        public List<Room> getRooms()
            {
                List<Room> lr = new List<Room>();
                SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = con;
                cmd.CommandText = "SELECT R_No,R_Type,R_Price,R_Occupacy,Is_Booked FROM Room";
                con.Open();
                SqlDataReader sdr = cmd.ExecuteReader();
                while (sdr.Read())
                {
                    Room r = new HotelBookingService.Room();
                    r.RoomNo = sdr.GetInt32(0);
                    r.RType = sdr.GetString(1);
                    r.RPrice = sdr.GetInt32(2);
                    r.Occupacy = sdr.GetInt32(3);
                    r.IsBooked = sdr.GetString(4);
                    lr.Add(r);
                }
                sdr.Close();
                con.Close();
                return lr;
            }

            public bool isRoomBooked(int rno)
            {
                List<Room> lr = new List<Room>();
                SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
                SqlCommand cmd = new SqlCommand();
                cmd.Connection = con;
                cmd.CommandText = "SELECT Is_Booked FROM Room WHERE R_No=@rno";
                cmd.Parameters.AddWithValue("@rno", rno);
                con.Open();
                SqlDataReader sdr = cmd.ExecuteReader();
                string s = null;
                while (sdr.Read())
                {
                    s = sdr.GetString(0);
                }
                if (s == "true")
                    return true;
                return false;
            }
        public int[] getRoomNos(int rt)
        {
            SqlConnection con = new SqlConnection(@"Data Source=(localdb)\MSSQLLocalDB;Initial Catalog=HotelService;Integrated Security=True;Connect Timeout=30;Encrypt=False;TrustServerCertificate=True;ApplicationIntent=ReadWrite;MultiSubnetFailover=False");
            SqlCommand cmd = new SqlCommand();
            cmd.Connection = con;
            if (rt == 1)
                cmd.CommandText = "select R_No from Room where R_Type='Single 'AND Is_Booked='false'";
            else if (rt == 2)
                cmd.CommandText = "select R_No from Room where R_Type='Double'AND Is_Booked='false'";
            else if (rt == 3)
                cmd.CommandText = "select R_No from Room where R_Type='Quad'AND Is_Booked='false'";
            else if (rt == 4)
                cmd.CommandText = "select R_No from Room where R_Type='Delux'AND Is_Booked='false'";
            con.Open();
            SqlDataReader sdr = cmd.ExecuteReader();
            int[] rnos = new int[10];
            for (int i = 0; sdr.Read(); i++)
            {
                rnos[i] = sdr.GetInt32(0);
            }
            con.Close();
            return rnos;
        }

        
    }
}
