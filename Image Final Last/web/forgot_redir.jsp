<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">

  <title>Image Sharing Portal! Forgot Password</title>

  <link href='http://fonts.googleapis.com/css?family=Titillium+Web:400,300,600' rel='stylesheet' type='text/css'>

  <link rel="stylesheet" href="css/normalize.css">

    <link rel="stylesheet" href="css/style.css">

</head>

<body>

  <div class="form">
        <div class="tab-conte">
        <div id="signup">   
          <h1>Image Sharing Portal!</h1>
	  <h1>Forgot Password</h1>
          <h2>Security Question</h2>
          <form action="forgotRedir" method="post">
          <div class="field-wrap">
            <input type="text" name="uname"  value="${username}"/>
          </div>
          <div class="field-wrap">
            <input type="text" name="sq" disabled value="${ques}"/>
          </div>
	 <div class="field-wrap">
            <label>
              Answer<span class="req">*</span>
            </label>
            <input type="text" name="ans" required autocomplete="off"/>
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
          

<button type="submit" class="button button-block"/>Get Started</button>
          </form>

        </div>

  

      </div><!-- tab-content -->

</div> <!-- /form -->

  <script src='http://codepen.io/assets/libs/fullpage/jquery.js'></script>

  <script src="js/index.js"></script>

</body>

</html>
<footer>
  <div style="float:right; margin-right:50px; margin-bottom:30px; margin-bottom:30px;">
    Contact Us
    <br>+91-99101-88803</div>
</footer>

