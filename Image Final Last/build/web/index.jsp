<%@page import="org.dto.Connecting"%>
<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Sign-Up/Login</title>

  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="css/normalize.css">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

  <div class="form">

      <ul class="tab-group">
        <li class="tab active"><a href="#signup">Sign Up</a></li>
        <li class="tab"><a href="#login">Log In</a></li>
      </ul>

      <div class="tab-content">
        <div id="signup">   
          <h1>Image Sharing Portal</h1>

          <form name="SignUp" action="register" method="post">

          <div class="top-row">
            <div class="field-wrap">
              <label>
                First Name<span class="req">*</span>
              </label>
              <input type="text" name="fname" required autocomplete="on" />
            </div>

            <div class="field-wrap">
              <label>
                Last Name<span class="req">*</span>
              </label>
              <input type="text" name="lname" required autocomplete="on"/>
            </div>
          </div>
                
          <div class="field-wrap">
            <label>
              Email Address<span class="req">*</span>
            </label>
            <input type="email" name="email" required autocomplete="on"/>
          </div>
                  <div class="field-wrap">
            <label>
              Username<span class="req">*</span>
            </label>
            <input type="text" name="uname" required autocomplete="on"/>
          </div>
		
		<div class="field-wrap">
            <label>
              Mobile No.<span class="req">*</span>
            </label>
            <input type="text" name="mob_no"required autocomplete="on"/>
          </div>

	
          <div class="field-wrap">
		<input type="date" name="bdate" name="bday" >
          </div>

          <div class="field-wrap">
            <label>
              Set A Password<span class="req">*</span>
            </label>
            <input type="password" name="pswd" required autocomplete="off"/>
          </div>
          	
          <div class="field-wrap">
            <label>
              Confirm Password<span class="req">*</span>
            </label>
            <input type="password" name="cpswd" required autocomplete="off"/>
          </div>
          
          <div class="field-wrap">
            <label>
              Security Question<span class="req">*</span>
            </label>
            <input type="text" name="sq" required autocomplete="off"/>
          </div>
          	
          <div class="field-wrap">
            <label>
              Answer<span class="req">*</span>
            </label>
            <input type="text" name="ans"required autocomplete="off"/>
          </div>


<button type="submit" class="button button-block"/>Get Started</button>
          </form>

        </div>

        <div id="login">
	  <h1>Image Sharing Portal!</h1>   
		
          <form name="login" action="index" method="post">

            <div class="field-wrap">
            <label>
              Username<span class="req">*</span>
            </label>
            <input type="text" name="unameLog" required autocomplete="on"/>
          </div>

          <div class="field-wrap">
            <label>
              Password<span class="req">*</span>
            </label>
            <input type="password" name="pass" required autocomplete="off"/>
          </div>

          <p class="forgot"><a href="forgot1.jsp">Forgot Password?</a></p>

          <button class="button button-block"/>Log In</button>

          </form>

        </div>

      </div><!-- tab-content -->

</div> <!-- /form -->

  <script src='js/lib.js'></script>

  <script src="js/index.js"></script>

</body>

</html>