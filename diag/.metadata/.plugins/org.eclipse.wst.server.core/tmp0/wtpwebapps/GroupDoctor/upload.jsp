<!DOCTYPE html>
<html lang=en>
	<head>
		<meta charset=UTF-8>
		<title>Collaboration Problem Diagnosis</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
		<link href="css/buttons.css" rel="stylesheet" type="text/css" media="screen" />
	</head>

<script type="text/javascript" charset="utf-8"
	src="js/jquery-1.6.2.min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/JSON2.js"></script>

<!-- automatically check if data files are already uploaded.
If yes, list the data files-->
<script type="text/javascript" charset="utf-8">
	$.get('FileQuery', function(data, textStatus) {
		// this gives an array of objects
		var files = JSON.parse(data);
		$("#filecheck").empty();
		// iterate over files and produce a list of checkboxes
		for ( var x = 0; x < files.length; x++) {
			var fileName = files[x];
			var file = '<input type="checkbox" name="' + fileName + '"/>'
					+ fileName + '<br>';
			$("#filecheck").prepend(file);
		}
	}, 'text');
</script>

<script type="text/javascript">

	function getFiles() {
		$.get('FileQuery', function(data, textStatus) {
			var files = JSON.parse(data);
			$("#filecheck").empty();
			for ( var x = 0; x < files.length; x++) {
				var fileName = files[x];
				var file = '<input type="checkbox" name="' + fileName
						+ '"/>' + fileName + '<br>';
				$("#filecheck").prepend(file);
			}
		}, 'text');
	}

	var req;

	function ajaxFunction() {
		var url = "HandleFileUpload";

		req = new XMLHttpRequest();
		req.onreadystatechange = checkFileUploadStatus;

		try {
			req.open("GET", url, true);
		} catch (e) {
			alert(e);
		}
		req.send(null);

	}

	function checkFileUploadStatus() {
		if (req.readyState == 4) {
			if (req.status == 200) {
				var xml = req.responseText;

				if (xml == "tryagain") {

					window.setTimeout("ajaxFunction();", 100);
				} else if (xml == "uploaddone") {
					getFiles();
				}
			}
		}

	}
</script>

<body>
	<div id="page">
		<header>
			<img src="images/logo.png" width="980" height="150" alt="logo"
				style="vertical-align: middle;" /> <br /> <img
				src="images/bg_banner_grey.gif" width="980" height="5"
				alt="logo_banner" />
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
				<h2>Upload your data files</h2>

				<p>Here you need to upload the data that you have collected and
					represent student interactions with a collaborative learning
					system.</p>

				<p>Two data files (.csv files) are expected. The first file is
					to contain data accounting for the behaviours of collaborative
					groups, namely group data. The second is to include data revealing
					the behaviours of individual students, namely student data. A data
					file should start with the prefix "group_" (for group data) or
					"student_"(for student data).</p>

				<p>You could refer to the example data files (<a href="res/group_1.csv">group_1.csv</a>,
					<a href="res/student_1.csv">student_1.csv</a>) for further details when you prepare your own data
					files.</p>

				<hr />

			</div>


			<div id="left">
				<h2>List of data files uploaded</h2>
				<br />
				<p>Please select your data files from the list below.</p>
				
				<form id="filecheck" name="selectedFileForm" action="define.jsp" method="get"></form>
				<br />
				
				<p>If no files uploaded before, use the following upload button
					for uploading:</p>

				<!-- file upload -->
				<div id="uploadform">
					<form id="myForm" enctype="multipart/form-data" method="post"
						target="uploadFrame" action="HandleFileUpload"
						onsubmit="ajaxFunction()">
						<input type="file" name="txtFile" id="txtFile" /><br /> 
						<input type="submit" style="border: none;" class='large green button'  name="submit" value="Upload"  />
					</form>
				</div>

				<iframe id="uploadFrameID" name="uploadFrame" height="0" width="0"
					frameborder="0" scrolling="yes"></iframe>

			</div>


			<div id="right">

				<br /> <br />

				<p>Proceed with the diagnosis procedure, press the 'next'
					button.</p>
				<a href='#' class='super orange button' onclick='document.forms["selectedFileForm"].submit();'>Next</a>

			</div>

		</div>

		<!-- clear:both is used to extend the margin of this box and clear the float that may fly over it.-->
		<div style="clear: both;">&nbsp;</div>
		<img src="images/bg_banner_grey.gif" width="980" height="5"
			alt="logo_banner" />

		<footer> Diag&trade; © 2011 | Design by Shuangyan Liu | All
			rights reserved. </footer>

	</div>
</body>
</html>
