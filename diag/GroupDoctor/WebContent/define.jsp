<!DOCTYPE html>
<html lang=en>
	<head>
    	<meta charset=UTF-8>
		<title>Collaboration Problem Diagnosis</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
		<link href="css/buttons.css" rel="stylesheet" type="text/css" media="screen" />
	</head>
    <script type="text/javascript" charset="utf-8" src="js/jquery.placeholder.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/jquery.placeholder.min.js"></script>
    <script type="text/javascript" charset="utf-8" src="js/jquery-1.6.2.min.js"></script>
    
	<script type="text/javascript" charset="utf-8">
		$('input[placeholder]').placeholder();
	</script>
    
    <script type="text/javascript">
    function getUrlVars()
    {
        var vars = [], hash;
        var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
        for(var i = 0; i < hashes.length; i++)
        {
            hash = hashes[i].split('=');
            vars.push(hash[0]);
            vars[hash[0]] = hash[1];
        }
        return vars;
    }
    window.onload = function() {
    	var allVars = getUrlVars();
    	var count = 0;
    	for (var key in allVars) {
    		if (count == 2 || count == 3) {
    			document.getElementById("file"+(count-1)).name = key;
    		}
    		
    		count++;
    	}
	}
	</script>
	
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
							<li><a href="define.jsp">Define diagnostic parameters</a></li>
							<li><a href="#">Diagnosis report</a></li>
							<li><a href="#">FAQs</a></li>
							<li><a href="#">About the project</a></li>
							<li><a href="#">Contact us</a></li>
						</ul>
					</li>
				</ul>
				
				<br />
			    <div id="logout">
					<p>Signed in as </p> <br/>
					<p><i><b><%=request.getRemoteUser()%> </b></i></p> <br/>
					<p><a href="logout.jsp"> logout </a></p>
					<br />
               </div>
               
			</div>
			
			<div id="content">
				<div class="post">
					<h2>Define diagnostic parameters </h2>
					<br />
    
					<p>Here you need to specify the values of the parameters that Diag will use for diagnosing. </p>
	
					<hr /> <br/> 
          <form action="MainController" method="post">         
                    <p> Course ID: <input type="text" name="course" id="courseID" placeholder="please input your course id here"/> (e.g. CS001) </p> <br />
	
    		 <fieldset id="paraArea">
				<legend>List of diagnostic parameters:</legend> 

				<p> 
					<label for="groupsize">Problem 1 - percentage_groupsize_most:</label> 
                  <input type="text" name="p1" id="groupsize" size="10" /> % <br/>
                    <i>i.e. the percentage of the size of a group defining relative majority</i>
				</p> 
				<p> 
					<label for="feedback">Problem 1 - percentage_avegroupfeedback_large:</label> 
					<input type="text" name="p2" id="feedback" size="30" /> % <br/>
                    <i>i.e. the percentage of the average number of feedback by all groups for defining relatively large number of feedback produced by a group</i>
				</p> 
				<p> 
					<label for="grouppost">Problem 2 - grouppost_few:</label> 
                    <input type="text" name="p3" id="grouppost" size="30" /> <br />
                    <i>i.e. the number of posts that can be defined as relatively few for a group project</i>
				</p> 
				<p> 
					<label for="postmost">Problem 2 - percentage_grouppost_most:</label> 
                    <input type="text" name="p4" id="postmost" size="30" /> % <br />
                    <i>i.e. the percentage of the overall number of posts made by a group for defining relative majority</i>
				</p> 
				<p> 
					<label for="groupsize">Problem 2 - percentage_groupsize_most:</label> 
                    <input type="text" name="p5" id="groupsize" size="30" /> % <br />
                    <i>i.e. the percentage of the size of a group defining relative majority of a group</i>
				</p> 
				<input type="hidden" id="file1" name="" value="on"/>
   				<input type="hidden" id="file2" name="" value="on"/>
              </fieldset>

                <p> 
					<button type="submit" class='super orange button' style="border: none; position:relative; top:365px;">Diagnose</button> 
				</p> 
		   </form>
		       </div>
		
			</div>
			
			<div style="clear: both;">&nbsp;</div>
			<img src="images/bg_banner_grey.gif" width="980" height="5" alt="logo_banner" />
	
			<footer>
				Diag&trade; © 2011 | Design by Shuangyan Liu | All rights reserved.
			</footer>
	
		</div>
	</body>
</html>
