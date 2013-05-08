<!DOCTYPE html>
<html lang=en>
	<head>
    	<meta charset=UTF-8> 
		<title>Collaboration Problem Diagnosis</title>
		<link href="css/style.css" rel="stylesheet" type="text/css" media="screen" />
	
<script type="text/javascript" src="js/jquery-1.6.2.min.js"></script>


<script src="js/RGraph.common.core.js" type="text/javascript"></script>
<script src="js/RGraph.common.annotate.js" type="text/javascript"></script>
<script src="js/RGraph.common.context.js" type="text/javascript"></script>
<script src="js/RGraph.common.tooltips.js" type="text/javascript"></script>
<script src="js/RGraph.common.zoom.js" type="text/javascript"></script>
<script src="js/RGraph.pie.js" type="text/javascript"></script>

<script type="text/javascript">
	

	var drawDonut = function(cavasId, chartJSON) {
		
		var chart = jQuery.parseJSON(chartJSON);
		var donut1 = new RGraph.Pie(cavasId, [ chart.percentage_yes,
				chart.percentage_maybe, chart.percentage_no ]);
		donut1.Set('chart.variant', 'donut');
		donut1.Set('chart.linewidth', 5);
		donut1.Set('chart.strokestyle', 'white');
		donut1.Set('chart.linewidth', 5);

		var py = chart.percentage_yes * 100;
		var pm = chart.percentage_maybe * 100;
		var pn = chart.percentage_no * 100;

		donut1.Set('chart.labels', [ py.toFixed(1) + '%', pm.toFixed(1) + '%',
				pn.toFixed(1) + '%' ]);
		donut1.Set('chart.colors', [ 'rgb(255,153,255)', 'rgb(255,163,25)',
				'rgb(153,255,102)' ]);
		donut1.Set('chart.text.size', 8);
		donut1.Set('chart.title', 'Problem ' + chart.problemID);
		donut1.Set('chart.gutter.left', 10);
		donut1.Set('chart.gutter.right', 10);
		donut1.Set('chart.gutter.top', 20);
		donut1.Set('chart.gutter.bottom', 10);
		donut1.Draw();
	};
	
	var drawGroupTable = function(vec) {

		var vecGR = jQuery.parseJSON(vec);
		
		var $table = $('<table/>');
		var $thead = $('<thead/>');
		$thead.append(
				 '<tr>' + 
				 '<td class="cell"></td>' +
				 '<th class="cell" scope="col">Problem 1</th>' + 
				 '<th class="cell" scope="col">Problem 2</th>' + 
				 '</tr>');
		$table.append($thead);
				 
		var $tbody = $('<tbody/>');
		for(var i = 0;i < vecGR.length;i++){
			var $tr = $('<tr/>');
			$tr.append('<th scope=\"row\" class=\"cell\">Group ' + vecGR[i].groupID + '</th>');
			var problem5 = vecGR[i].result_CP5;
			if (problem5 == 1) {
				$tr.append('<td class="cell" bgcolor=\"#FF99FF\"></td>');
			}
			else if (problem5 == 3) {
				$tr.append('<td class="cell" bgcolor=\"#99FF66\"></td>');
			}
			else {
				$tr.append('<td class="cell" bgcolor=\"#FFA319\"></td>');
			}
			var problem6 = vecGR[i].result_CP6;
			if (problem6 == 1) {
				$tr.append('<td class="cell" bgcolor=\"#FF99FF\"></td>');
			}
			else if (problem6 == 3) {
				$tr.append('<td class="cell" bgcolor=\"#99FF66\"></td>');
			}
			else {
				$tr.append('<td class="cell" bgcolor=\"#FFA319\"></td>');
			}
			
			$tbody.append($tr);	
		}
		
		$table.append($tbody);

		$('#GroupTable').append($table);
	};
	
	var drawStudentTable = function(vec) {

		var vecSR = jQuery.parseJSON(vec);
		
		var $table = $('<table/>');
		var $thead = $('<thead/>');
		$thead.append(
				 '<tr>' + 
				 '<td class="cell"></td>' +
				 '<th class="cell" scope="col">Problem 3</th>' + 
				 '<th class="cell" scope="col">Problem 4</th>' +
				 '<th class="cell" scope="col">Problem 5</th>' +
				 '<th class="cell" scope="col">Group ID</th>' +
				 '</tr>');
		$table.append($thead);
				 
		var $tbody = $('<tbody/>');
		for(var i = 0;i < vecSR.length;i++){
			var $tr = $('<tr/>');
			$tr.append('<th scope=\"row\" class=\"cell\">Student ' + vecSR[i].studentID + '</th>');
			var problem1 = vecSR[i].result_CP1;
			if (problem1 == 1) {
				$tr.append('<td class="cell" bgcolor=\"#FF99FF\"></td>');
			}
			else if (problem1 == 3) {
				$tr.append('<td class="cell" bgcolor=\"#99FF66\"></td>');
			}
			else {
				$tr.append('<td class="cell" bgcolor=\"#FFA319\"></td>');
			}
			var problem2 = vecSR[i].result_CP2;
			if (problem2 == 1) {
				$tr.append('<td class="cell" bgcolor=\"#FF99FF\"></td>');
			}
			else if (problem2 == 3) {
				$tr.append('<td class="cell" bgcolor=\"#99FF66\"></td>');
			}
			else {
				$tr.append('<td class="cell" bgcolor=\"#FFA319\"></td>');
			}
			var problem3 = vecSR[i].result_CP3;
			if (problem3 == 1) {
				$tr.append('<td class="cell" bgcolor=\"#FF99FF\"></td>');
			}
			else if (problem3 == 3) {
				$tr.append('<td class="cell" bgcolor=\"#99FF66\"></td>');
			}
			else {
				$tr.append('<td class="cell" bgcolor=\"#FFA319\"></td>');
			}
			$tr.append('<td class="cell" >'+ vecSR[i].groupID + '</td>');
			$tbody.append($tr);	
		}
		
		$table.append($tbody);

		$('#StudentTable').append($table);
	};

	
	window.onload = function() {
		drawDonut('donut1', '${chart1}');
		drawDonut('donut2', '${chart2}');
		drawDonut('donut3', '${chart3}');
		drawDonut('donut4', '${chart4}');
		drawDonut('donut5', '${chart5}');

		drawGroupTable('${vecGR}');
		drawStudentTable('${vecSR}');
	};
</script>


<meta http-equiv="Content-Type" content="text/html; charset=utf-8"></head>

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
                	<h2>Diagnosis results and statistics </h2> <br/>
	
					<p>You can examine the problems of individual groups and students(see tables) and the ratios of the groups or students identified as one of the categories of problem existence to the total number of groups or students analysed (see pie charts).</p>
					<p><font size="2"><i>Note: <font color="#FF99FF">Violet</font> - groups or students with the problem; <font color="#FFA319">Orange</font> - groups or students may have the problem; <font color="#99FF66">LightGreen</font> - groups or students without the problem.</i></font></p>
                    <hr />
                    <p class="rowName"> Problems for Groups </p> <br/>
                </div>  
               
                <div class="pie">
                        <canvas id="donut1" width="205" height="160">[No canvas support]</canvas>
                        <p class="chartfoot">Little feedback on each other's task work</p><br/>
                        <canvas id="donut2" width="205" height="160">[No canvas support]</canvas>
                        <p class="chartfoot">Single student dominating the group</p>
                </div>
                
                <div class="tableresult">
                    <div id="GroupTable" style="overflow:auto"></div>
                </div>
                
                <div style="clear: both;">&nbsp;</div>
                <div>
                	<p class="rowName"> Problems for Students </p> <br/>
                </div>
                
                <div class="pie">
                        <canvas id="donut3" width="205" height="160">[No canvas support]</canvas>
                        <p class="chartfoot">Not contributing much in online discussions</p><br/>
                        <canvas id="donut4" width="205" height="160">[No canvas support]</canvas>
                        <p class="chartfoot">Not actively meeting the deadlines</p><br/>
                        <canvas id="donut5" width="205" height="160">[No canvas support]</canvas>
                        <p class="chartfoot">Not actively completing the assigned work</p><br/>
                 </div>    
                    
                 <div class="tableresult">
                    <div id="StudentTable" style="overflow:auto"></div>
    			 </div>
                 
            </div>
            
            <!-- clear:both is used to extend the margin of this box and clear the float that may fly over it.-->
			<div style="clear: both;">&nbsp;</div>
			<img src="images/bg_banner_grey.gif" width="980" height="5" alt="logo_banner" />
	
			<footer>
				Diag&trade; � 2011 | Design by Shuangyan Liu | All rights reserved.
			</footer>
	
		</div>

</body>
</html>