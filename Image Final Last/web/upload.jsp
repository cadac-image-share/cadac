<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Upload Image</title>
        <meta name="description" content="Blueprint: Blueprint: Google Grid Gallery" />
        <meta name="keywords" content="google getting started gallery, image gallery, image grid, template, masonry" />
        <meta name="author" content="Codrops" />
        <link rel="shortcut icon" href="../favicon.ico">
        <link rel="stylesheet" type="text/css" href="css/demo.css" />
        <link rel="stylesheet" type="text/css" href="css/component.css" />
        <script src="js/modernizr.custom.js"></script>
    </head>
    <body>
        <div class="container">
            <header class="clearfix">

                
                <!--<c:set var="path" value=(String)filenames.get(0);/>-->
                <!--String path_set="img/thumb/"+(String)filenames.get(0);-->
                <!--(String)filenames.get(0)%>-->
                <span>Upload Image <span class="bp-icon bp-icon-about" data-content="Where you can see the posts by your friends!"></span></span>
                <h1>Image Sharing Portal</h1>
                <nav>
                    <div style="float:left;"> <div style="float:left;"><form id="myform" method="post" action="Anchor">
                                <a onclick="document.getElementById('myform').submit();" class="bp-icon bp-icon-archive" data-info="Logout"></a>
                                <input type="hidden" name="uname"  value="${username}"/>
                            </form></div>
                        <div style="float:right"><form id="myform1" method="post" action="Profile">
                                <a onclick="document.getElementById('myform1').submit();" class="bp-icon bp-icon-preve" data-info="Profile"></a>
                                <input type="hidden" name="uname"  value="${username}"/>
                            </form>
                        </div></div>

                    <!--<a href="http://tympanus.net/Blueprints/FullWidthTabs/" class="bp-icon bp-icon-prev" data-info="previous Blueprint"><span>Previous Blueprint</span></a>
                    <a href="" class="bp-icon bp-icon-next" data-info="next Blueprint"><span>Search</span></a-->
                    <div style="float:right;">
                        <div style="float:left;">
                            <a href="upload.jsp" class="bp-icon bp-icon-drop" data-info="Upload Image"><span>Upload Image</span></a>
                        </div>
                        <div style="float:right;">
                            <a href="search.jsp" class="bp-icon bp-icon-archive" data-info="Search Image"><span>Search Image</span></a>
                            <!--<a href="http://tympanus.net/codrops/category/blueprints/" class="bp-icon bp-icon-archive" data-info="Blueprints archive"><span>Go to the archive</span></a>-->
                        </div>
                         <div style="float:right;">
                            <a href="searchUser.jsp" class="bp-icon bp-icon-archive" data-info="Search User"><span>Explore User</span></a>
                            <!--<a href="http://tympanus.net/codrops/category/blueprints/" class="bp-icon bp-icon-archive" data-info="Blueprints archive"><span>Go to the archive</span></a>-->
                        </div>
                    </div>
                </nav>
            </header>
<body>
	<center>
		<h1>Image Sharing Portal</h1>
		<h2>Upload Image</h2>
		<form method="post" action="uploadServlet" enctype="multipart/form-data">
			<table border="0">
				<tr>
					<td>Caption: </td>
					<td><input type="text" name="caption" size="30"/></td>
				</tr>
				<tr>
					<td>Tags: </td>
					<td><input type="text" name="tags" size="30"/></td>
				</tr>
				<tr>
					<td>Album: </td>
					<td><input type="text" name="album" size="30"/></td>
				</tr>
				<tr>
					<td>Location: </td>
					<td><input type="text" name="loc" size="30"/></td>
				</tr>
				<tr>
					<td>Visible To: </td>
					<td><input type="text" name="visible_to" size="30"/></td>
				</tr>
				<tr>
					<td>Photo: </td><br>
					<td><input type="file" name="photo" size="30"/></td>
				</tr>
				 <tr>
                                <td colspan="2">
                                    <input type="submit" value="Save">
                                </td>
                                 </tr>
			</table>
		</form>
	</center>
</body>
</html>