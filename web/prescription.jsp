<%-- 
    Document   : prescription
    Created on : Apr 14, 2019, 9:38:24 PM
    Author     : HP
--%>
<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.*"%>
<%@page import="DAO.*"%>
<%@page import="Controller.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Prescriptions</title>
</head>
<style type="text/css">
	
	body{
		margin: 0;
		
	}
        .row
        {
            background-color: rgb(255,255,255,0.5);
			height: 220px;
			width: 250px;
			padding: 30px;
			margin-top: 50px;
			margin-left:    50px;
			display: inline-block;
			box-shadow: 0 2px 4px rgba(0,0,0,0.4);
			border-radius: 5px;
            }
            p
            {
   		font-size: 28px;
   		font-family: Arctic;
            }
	#nav{
		background-color:#6699ff;
		height: 58px;
		display: flex;
	}
	ul li{
		display: inline;

		}
	ul a{
		text-decoration: none;
		color: white;
		padding: 20px;
		font-family: arctic;
		
	}
	a:hover{
		background-color: #ddd;
  		color: black;
	}
</style>
<body>
<div id="one">
	
	<nav id="nav">
		<ul>
			<li><a href="home.html">Home</a></li>
			<li><a href="appointment.html">Book an Appointment</a></li>
			<li><a href="prescription.jsp">Prescriptions</a></li>
		</ul>
	</nav>
</div>
         <% 
                    String name;
                    String gender;
                    String medicine;
                    SessionFactory sf = null;
                    Session s = null;
                    prescription sch = null;
                    try{
                       Configuration cf = new Configuration();
                        cf.configure();
                        sf = cf.buildSessionFactory();
                        s = sf.openSession();
                        Query q = s.createQuery("from prescription ");
                        Iterator it = q.iterate();
                        while (it.hasNext()){
                            
                            sch = (prescription)it.next();
                            name= sch.getName();
                           gender=sch.getGender();
                           medicine=sch.getMedicine();
                            
                %>        
                <div class="row">
                <p><%=medicine%></p> 
                </div>
                        <%
                            }
                    }catch(Exception e){
                        e.printStackTrace();
                    }  
                %>      
    </table>
</body>
</html>
