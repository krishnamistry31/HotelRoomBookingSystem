using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace HotelClient
{
    public partial class Show : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            HotelClient.HSReference.Service1Client proxy = new HSReference.Service1Client("BasicHttpBinding_IService1");
            //Label1.Text = proxy();
            GridView1.DataSource = proxy.getRooms();
            proxy.Close();
        }
    }
}