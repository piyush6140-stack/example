
package com.CLIENT;
import java.io.*;
import java.net.*;

public class IM {
    public static void main(String args[])
    {
        /* for mac and os */
        mac w=new mac();

        //String macAddress = w.getSystemMac();
        //System.out.println("System Mac Address : "+macAddress);
        register regi=new register ();
        // for public and private ip
        ip y=new ip();
        menu m=new menu();
	/*try 
	{
		//String publicip=y.getpublic();
		//String privateip=y.getprivate();
		//System.out.println("Public IP Address: " + publicip );
		//System.out.println("Private IP Address: " + privateip);
	}
		catch(Exception e)
		{System.out.println(e);}*/

        //Connection with server

        try
        {

            Socket s=new Socket("localhost",20000);
            DataOutputStream dout=new DataOutputStream(s.getOutputStream());
            DataInputStream dis=new DataInputStream(s.getInputStream());
            dout.writeUTF(y.getpublic());
            dout.writeUTF(y.getprivate());
            dout.writeUTF(w.getSystemMac());
            dout.writeUTF(w.getosname());

            if(((String) dis.readUTF ()).equals ("1")) {
            m.start ();
            }
            else
            {
                dout.flush();
                dout.close();
                dis.close ();
                s.close();
                regi.registe ();
            }

        }
        catch(Exception e)
        {
            System.out.println(e);
        }



    }
}
