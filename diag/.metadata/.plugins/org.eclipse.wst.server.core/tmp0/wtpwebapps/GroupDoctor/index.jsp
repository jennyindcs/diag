<!DOCTYPE html>
<html lang=en>
	<head>
    	<meta charset=UTF-8>
		<title>Collaboration Problem Diagnosis</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
		<link href="css/buttons.css" rel="stylesheet" type="text/css" media="screen" />
	</head>

	<body>
		<div id="page">
			<header>
				<img src="images/logo.png" width="980" height="150" alt="logo" style="vertical-align:middle;"/> 
				<br />
				<img src="images/bg_banner_grey.gif" width="980" height="5" alt="logo_banner" />
			</header>
	
			<div id="sidebar">
				<ul>
					<li>
						<ul>
							<li><a href="index.jsp">Home</a></li>
							<li><a href="upload.jsp">Upload your data files</a></li>
							<li><a href="#">Define diagnostic parameters</a></li>
							<li><a href="#">Diagnosis report</a></li>
							<li><a href="#">FAQs</a></li>
							<li><a href="#">About the project</a></li>
							<li><a href="#">Contact us</a></li>
						</ul>
					</li>
				</ul>
				
				<br/>
               <div id="logout">
				<p>Signed in as </p> <br/>
				<p><i><b><%=request.getRemoteUser()%> </b></i></p> <br/>
				<p><a href="logout.jsp"> logout </a></p>
				<br />
               </div>
			
			</div>
			
			<div id="content">
				<div class="post">
					<h2>Welcome to Diag&trade; </h2>
	
					<p>Diag is a web application capable of supporting teachers or facilitators to assess group collaboration problems that are possessed by the online collaborative learning groups examined. It incorporates the latest research in online collaborative learning - a diagnostic mechanism for ascertaining the existence of major collaboration problems. </p>
	
					<p>With Diag, teachers or facilitators can understand and evaluate how individual groups and students perform in completing a piece of collaborative group work.
	</p>
	
					<hr />
	
				</div>
			
			
				<div id="left">
					<h2>Overview</h2>
					
					<br /> <br />
			
					<img src="images/overview.jpg" title="overview" alt="overview" /><br />
					
				</div>
			
			
				<div id="right">
					<h2>Start Diagnosing</h2>
					
                    <br /> 
                    
					<p>To achieve a diagnostic goal, you need to complete the first two stages of the overall procedure - upload your data files and define the parameters for diagnosing.</p>
					
					<a href='upload.jsp' class='super orange button'>Start Now</a>
				</div>
		
			</div>
		
			<!-- clear:both is used to extend the margin of this box and clear the float that may fly over it.-->
			<div style="clear: both;">&nbsp;</div>
			<img src="images/bg_banner_grey.gif" width="980" height="5" alt="logo_banner" />
	
			<footer>
				Diag&trade; © 2011 | Design by Shuangyan Liu | All rights reserved.
			</footer>
	
		</div>
	</body>
</html>
