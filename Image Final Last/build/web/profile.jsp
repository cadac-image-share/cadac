<%@page import="org.dto.User"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
	
		<link rel="stylesheet" type="text/css" href="css/demo.css" />
		<link rel="stylesheet" type="text/css" href="css/component.css" />
		<script src="js/modernizr.custom.js"></script>
	</head>
	<body>
            <%User u=(User)request.getAttribute("user");%>
		<div class="container">
			<header class="clearfix">
				<span>Profile</span>
				<h1>            <%=u.getFname()%> <%=u.getLname()%>
                                </h1><%u.getP_image();%>
				<nav>
					<!--<a href="http://tympanus.net/Blueprints/FullWidthTabs/" class="bp-icon bp-icon-prev" data-info="previous Blueprint"><span>Previous Blueprint</span></a>-->
					<!--a href="" class="bp-icon bp-icon-next" data-info="next Blueprint"><span>Next Blueprint</span></a-->
					<!--<a href="http://tympanus.net/codrops/?p=18699" class="bp-icon bp-icon-drop" data-info="back to the Codrops article"><span>back to the Codrops article</span></a>
					<a href="http://tympanus.net/codrops/category/blueprints/" class="bp-icon bp-icon-archive" data-info="Blueprints archive"><span>Go to the archive</span></a>-->
				</nav>
			</header>
			<div>
			<div id="img" style="margin-left:160px; width:500px;float:left;"><img src="C:\Users\Chirag Agarwal\Documents\NetBeansProjects\Image Final Last\web\img\profilepic.jpg" height="300" width="400"></img></div>
			<div style="width:500px;float:right;">
                            <b>Email </b>:<%=u.getEmail()%><br><br>
                            <b>Username</b>: <%=u.getUsername()%><br><br>
                            <b>DOB</b> <%=u.getDob()%><br><br>
                            <b>Mobile</b> <%=u.getM()%><br><br>
                            <b>Number of followers</b> <%=u.getNumfrs()%><br><br>
                            <b>Number of followees</b> <%=u.getNumfes()%><br><br>
                            <b>Images uploaded</b> <%=u.getNumimages()%><br><br>
			</div>
			</div>
			
		</div>
		<script src="js/imagesloaded.pkgd.min.js"></script>
		<script src="js/masonry.pkgd.min.js"></script>
		<script src="js/classie.js"></script>
		<script src="js/cbpGridGallery.js"></script>
		<script>
			new CBPGridGallery( document.getElementById( 'grid-gallery' ) );
		</script>
	</body>
</html>
