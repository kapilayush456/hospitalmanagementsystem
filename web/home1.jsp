<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="java.util.Iterator"%>
<%@page import="org.hibernate.*"%>
<%@page import="DAO.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>Doctor | Home</title>
</head>

<style type="text/css">
	body{
		margin: 0;
		
	}
	img{
		height: 100%;
		width: 100%;
		opacity: 0.5;
		
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
	#two{
		position: relative; 
   		width: 100%;
	}
	h1{
		position: absolute;
		top: 300px; 
   		left: 30%; 
   		width: 1000px;
   		font-size: 60px;
   		font-family: Arctic;
   		
	}
	h2{
		position: absolute;
		top: 400px; 
   		left: 40%; 
   		width: 900px;
   		font-size: 30px;
   		font-family: Arctic;
	}
        table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #f2f2f2;}
</style>
<body>

<div id="one">
	
	<nav id="nav">
		<ul>
			
			<li><a href="patients.html">Patients</a></li>
			<li><a href="prescriptions.html">Prescriptions</a></li>
			
		</ul>
		
	</nav>
	
</div>
  <div class="tbl-header">
      <br>
      <br>
      <table>
    <tr>      
    <th>Firstname</th>
    <th>Lastname</th>
    <th>Gender</th>
    <th>Description</th>
    </tr>
         <% 
                    String firstname;
                    String lastname;
                    String gender;
                    String description;
                    SessionFactory sf = null;
                    Session s = null;
                    appointment sch = null;
                    try{
                       Configuration cf = new Configuration();
                        cf.configure();
                        sf = cf.buildSessionFactory();
                        s = sf.openSession();
                        Query q = s.createQuery("from appointment");
                        Iterator it = q.iterate();
                        while (it.hasNext()){
                            
                            sch = (appointment)it.next();
                            firstname= sch.getFirstname();
                           lastname= sch.getLastname();
                           gender=sch.getGender();
                           description=sch.getDescription();
                            
                %>        
                
			<tr>
                            <td><%=firstname%></td>
                            <td><%=lastname%></td>
                            <td><%=gender%></td>
                            <td><%=description%></td>  
			</tr>
                        <%
                            }
                    }catch(Exception e){
                        e.printStackTrace();
                    }  
                %>      
    </table>
  </div>
</body>
</html>