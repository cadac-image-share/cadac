
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
	<head>
		<meta charset="UTF-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
		<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
		<title>Search results</title>
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
                            
                            Hello, ${username}! , <br> we searched in caption and tags.
                           
                            <%List<String> caption = (List)request.getAttribute("caption");%>
                           <%List<String> filenames = (List)request.getAttribute("filenames");%>
                            <!--<c:set var="path" value=(String)filenames.get(0);/>-->
                            <!--String path_set="searchresult/thumb/"+(String)filenames.get(0);-->
                            <!--(String)filenames.get(0)%>-->
				<span>Search Results <span class="bp-icon bp-icon-about" data-content="Where you can see the posts by your friends!"></span></span>
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
					<div style="float:right;"><div style="float:left;"><a href="upload.jsp" class="bp-icon bp-icon-drop" data-info="Upload Image"><span>Upload Image</span></a>
                                        </div><div style="float:right;"><a href="search.jsp" class="bp-icon bp-icon-archive" data-info="Search Image"><span>Search Image</span></a>
					<!--<a href="http://tympanus.net/codrops/category/blueprints/" class="bp-icon bp-icon-archive" data-info="Blueprints archive"><span>Go to the archive</span></a>-->
                                        </div></div>
				</nav>
			</header>
                 
			<div id="grid-gallery" class="grid-gallery">
				<section class="grid-wrap">
					<ul class="grid">
						<li class="grid-sizer"></li><!-- for Masonry column width -->
						<c:forEach items="${caption}" var="item">
                                                <li>
							<figure>
                                               
								<img src="searchresult/thumb/<%=(String)filenames.get(0)%>" alt="img01"/>
                                                                
								<figcaption><h3><%=(String)caption.get(0)%></h3><p><c:out value="${item}" /></p></figcaption>
							</figure>
						</li>
                                                </c:forEach>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(1)%>" alt="img02"/>
								<figcaption><h3><%=(String)caption.get(1)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(2)%>" alt="img03"/>
								<figcaption><h3><%=(String)caption.get(2)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(3)%>" alt="img04"/>
								<figcaption><h3><%=(String)caption.get(3)%></p></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(4)%>" alt="img05"/>
								<figcaption><h3><%=(String)caption.get(4)%> </p></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresultg/thumb/<%=(String)filenames.get(5)%>" alt="img06"/>
								<figcaption><h3><%=(String)caption.get(5)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(6)%>" alt="img07"/>
								<figcaption><h3><%=(String)caption.get(6)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(7)%>" alt="img08"/>
								<figcaption><h3><%=(String)caption.get(7)%></p></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(8)%>" alt="img09"/>
								<figcaption><h3><%=(String)caption.get(8)%></p></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(9)%>" alt="img10"/>
								<figcaption><h3><%=(String)caption.get(9)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(10)%>" alt="img11"/>
                                                                <figcaption><h3><%=(String)caption.get(10)%></h3></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(11)%>" alt="img12"/>
								<figcaption><h3><%=(String)caption.get(11)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(12)%>" alt="img13"/>
								<figcaption><h3><%=(String)caption.get(12)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(13)%>" alt="img14"/>
								<figcaption><h3><%=(String)caption.get(13)%> </p></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(14)%>" alt="img15"/>
								<figcaption><h3><%=(String)caption.get(14)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(15)%>" alt="img16"/>
								<figcaption><h3><%=(String)caption.get(15)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(16)%>" alt="img17"/>
								<figcaption><%=(String)filenames.get(16)%> </p></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(17)%>" alt="img18"/>
								<figcaption><h3><%=(String)caption.get(17)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(18)%>" alt="img19"/>
								<figcaption><h3><%=(String)caption.get(9)%></p></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(19)%>" alt="img20"/>
								<figcaption><%=(String)filenames.get(19)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(20)%>" alt="img21"/>
								<figcaption><%=(String)filenames.get(20)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(21)%>" alt="img22"/>
								<figcaption><h3><%=(String)caption.get(21)%></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(22)%>" alt="img23"/>
								<figcaption><h3><%=(String)caption.get(22)%></p></figcaption>
							</figure>
						</li>
						<li>
							<figure>
								<img src="searchresult/thumb/<%=(String)filenames.get(23)%>" alt="img24"/>
								<figcaption><%=(String)filenames.get(23)%></figcaption>
							</figure>
						</li>
					</ul>
				</section><!-- // grid-wrap -->
				<section class="slideshow">
					<ul>
						<li>
							<figure>
								<figcaption>
									<h3>Letterpress asymmetrical</h3>
									<p>Kale chips lomo biodiesel stumptown Godard Tumblr, mustache sriracha tattooed cray aute slow-carb placeat delectus. Letterpress asymmetrical fanny pack art party est pour-over skateboard anim quis, ullamco craft beer.</p>
									<button type="button">Appreciate!</button>
								</figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(0)%>" alt="img01"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Vice velit chia</h3>
									<p>Chillwave Echo Park Etsy organic Cosby sweater seitan authentic pour-over. Occupy wolf selvage bespoke tattooed, cred sustainable Odd Future hashtag butcher.</p>
                                                                        <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(1)%>" alt="img02"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Brunch semiotics</h3>
									<p>IPhone PBR polaroid before they sold out meh you probably haven't heard of them leggings tattooed tote bag, butcher paleo next level single-origin coffee photo booth.</p>
                                                                        <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(2)%>" alt="img03"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Chillwave nihil occupy</h3>
									<p>Vice cliche locavore mumblecore vegan wayfarers asymmetrical letterpress hoodie mustache. Shabby chic lomo polaroid, scenester 8-bit Portland Pitchfork VHS tote bag.</p>
                                                                          <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(3)%>" alt="img04"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Kale chips lomo biodiesel</h3>
									<p>Chambray Schlitz pug YOLO, PBR Tumblr semiotics. Flexitarian YOLO ennui Blue Bottle, forage dreamcatcher chillwave put a bird on it craft beer Etsy.</p>
                                                                        <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(4)%>" alt="img05"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Exercitation occaecat</h3>
									<p>Cosby sweater hella lomo Thundercats VHS occupy High Life. Synth pop-up readymade single-origin coffee, fanny pack tousled retro. Fingerstache mlkshk ugh hashtag, church-key ethnic street art pug yr.</p>
                                                                        <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(5)%>" alt="img06"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Selfies viral four</h3>
									<p>Ethnic readymade pug, small batch XOXO Odd Future normcore kogi food truck craft beer single-origin coffee banh mi photo booth raw denim. XOXO messenger bag pug VHS. Forage gluten-free polaroid, twee hoodie chillwave Helvetica.</p>
                                                                        <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(6)%>" alt="img07"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Photo booth skateboard</h3>
									<p>Thundercats pour-over four loko skateboard Brooklyn, Etsy sriracha leggings dreamcatcher narwhal authentic 3 wolf moon synth Portland. Shabby chic photo booth Blue Bottle keffiyeh, McSweeney's roof party Carles.</p>
                                                                        <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(7)%>" alt="img08"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Ex fashion axe</h3>
									<p>Ennui Blue Bottle shabby chic, organic butcher High Life tattooed meggings jean shorts Brooklyn sartorial polaroid. Cray raw denim +1, bespoke High Life Odd Future banh mi chillwave Marfa kogi disrupt paleo direct trade 90's Godard. </p>
                                                                        <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="searchresult/large/<%=(String)filenames.get(8)%>" alt="img03"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Thundercats next level</h3>
									<p>Typewriter authentic PBR, iPhone mixtape fixie post-ironic fingerstache Pitchfork artisan. Wayfarers master cleanse occupy, Tonx lo-fi swag Truffaut irony whatever Blue Bottle readymade PBR gluten-free. Lomo Pinterest Banksy fap. Retro ennui you probably haven't heard of them iPhone, PBR fashion axe polaroid.</p>
                                                                        <button type="button">Appreciate!</button>
                                                                </figcaption>
								<img src="<%=(String)filenames.get(9)%>" alt="img10"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Bushwick selvage synth</h3>
									<p>Schlitz deserunt pour-over consectetur. Selfies plaid asymmetrical farm-to-table, cred gastropub photo booth narwhal non roof party velit raw denim slow-carb meggings pug. Tempor post-ironic seitan cliche bicycle rights. Meh viral Williamsburg, quinoa 8-bit kale chips YOLO Marfa accusamus.</p>
								</figcaption>
                                                                  <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(10)%>" alt="img11"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Bottle wayfarers locavore</h3>
									<p>Aliqua High Life art party fixie farm-to-table. Kitsch Echo Park shabby chic, narwhal fugiat Cosby sweater asymmetrical gastropub tofu. Authentic minim Pinterest Blue Bottle beard, aliqua chia XOXO dolor freegan banh mi vegan fugiat.</p>
								</figcaption>
                                                                      <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(11)%>" alt="img12"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Letterpress asymmetrical</h3>
									<p>Pickled hoodie Pinterest 90's proident church-key chambray. Salvia incididunt slow-carb ugh skateboard velit, flannel authentic hoodie lomo fixie photo booth farm-to-table. Minim meggings Bushwick, semiotics Vice put a bird.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>	
                                                            <img src="searchresult/large/<%=(String)filenames.get(12)%>" alt="img13"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Vice velit chia</h3>
									<p>Tattooed assumenda chambray cray officia. 90's mollit ethnic church-key ex eu pop-up gentrify. Tonx raw denim eu, bitters nesciunt distillery Neutra pop-up. Drinking vinegar Helvetica Truffaut tattooed.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>	
                                                            <img src="searchresult/large/<%=(String)filenames.get(13)%>" alt="img14"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Brunch semiotics</h3>
									<p>Gentrify High Life adipisicing, duis slow-carb kogi Tumblr raw denim freegan Echo Park. Fingerstache laboris pork belly messenger bag, you probably haven't heard of them vegan twee Intelligentsia Vice Etsy pickled put a bird on it Godard roof party. Meggings small batch dreamcatcher velit.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>	
                                                            <img src="searchresult/large/<%=(String)filenames.get(14)%>" alt="img15"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Chillwave nihil occupy</h3>
									<p>Marfa exercitation non, beard +1 hashtag cardigan gluten-free mixtape church-key ugh eu Portland leggings. Ennui farm-to-table fingerstache keytar Echo Park tattooed. Seitan qui artisan, aliquip cupidatat sunt Portland wayfarers duis.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(15)%>" alt="img16"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Kale chips lomo biodiesel</h3>
									<p>Lomo church-key whatever, seitan laborum drinking vinegar lo-fi semiotics nihil meh. Skateboard irure before they sold out Banksy. Narwhal High Life lomo aliqua drinking vinegar. PBR&B placeat proident, craft beer forage DIY nostrud meh flexitarian keytar Helvetica.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>	
                                                            <img src="searchresult/large/<%=(String)filenames.get(16)%>" alt="img17"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Exercitation occaecat</h3>
									<p>Skateboard Truffaut bicycle rights seitan normcore. Culpa lo-fi ennui, Pinterest before they sold out Echo Park roof party sapiente aesthetic consequat Truffaut freegan voluptate. Kogi banh mi vero nihil, freegan gluten-free cliche. Forage Etsy laboris anim normcore, McSweeney's ex.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>	
                                                            <img src="searchresult/large/<%=(String)filenames.get(17)%>" alt="img18"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Selfies viral four</h3>
									<p>Viral roof party locavore flexitarian nihil fanny pack actually Odd Future anim commodo. Sunt yr aute, enim quis plaid sartorial duis leggings lo-fi gluten-free. Tote bag flexitarian pug stumptown, Cosby sweater try-hard ethnic scenester. Mumblecore +1 hoodie accusamus skateboard slow-carb, Thundercats Godard placeat craft beer meh enim trust fund.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(18)%>" alt="img19"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Photo booth skateboard</h3>
									<p>Culpa pour-over cray nesciunt dreamcatcher. Meggings distillery cillum raw denim voluptate, single-origin coffee lo-fi ethical iPhone four loko nihil salvia. Biodiesel ea Intelligentsia quis deep v, American Apparel trust fund slow-carb synth semiotics quinoa Brooklyn pour-over nulla Godard.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(19)%>" alt="img20"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Ex fashion axe</h3>
									<p>Bespoke irony tousled nihil flexitarian, salvia tempor nostrud Bushwick hashtag Austin ethnic disrupt. Beard Helvetica nihil, chia craft beer Wes Anderson keytar dolore. Irure incididunt flexitarian photo booth cillum, YOLO deserunt Brooklyn artisan. Brunch assumenda irony, Blue Bottle roof party DIY ullamco quis.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(20)%>" alt="img21"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Thundercats next level</h3>
									<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
									tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
									quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(21)%>" alt="img22"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Bushwick selvage synth</h3>
									<p>Ethical Truffaut tofu food truck cred cornhole. Irure umami Austin cornhole blog ethical. Aliqua yr Truffaut, adipisicing hashtag Shoreditch eiusmod tempor literally vinyl.</p>
								</figcaption>
							  <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(22)%>" alt="img23"/>
							</figure>
						</li>
						<li>
							<figure>
								<figcaption>
									<h3>Bottle wayfarers locavore</h3>
									<p>Pork belly irony Shoreditch fashion axe DIY. Portland banjo irony, squid gentrify Austin fixie church-key magna. Marfa artisan Echo Park, McSweeney's banjo sunt keytar tofu. Brooklyn PBR single-origin coffee disrupt polaroid ut, gluten-free XOXO plaid magna.</p>
								
                                                                </figcaption>
							  <button type="button">Appreciate!</button>
                                                            <img src="searchresult/large/<%=(String)filenames.get(23)%>" alt="img24"/>
							</figure>
						</li>
					</ul>
					<nav>
						<span class="icon nav-prev"></span>
						<span class="icon nav-next"></span>
						<span class="icon nav-close"></span>
					</nav>
					<div class="info-keys icon">Navigate with arrow keys</div>
				</section><!-- // slideshow -->
			</div><!-- // grid-gallery -->
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
