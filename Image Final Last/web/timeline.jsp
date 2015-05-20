
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html lang="en" class="no-js">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Timeline</title>
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

                Hello, ${username}!

                <%List<String> caption = (List) request.getAttribute("caption");%>
                <%List<String> filenames = (List) request.getAttribute("filenames");%>
                <!--<c:set var="path" value=(String)filenames.get(0);/>-->
                <!--String path_set="img/thumb/"+(String)filenames.get(0);-->
                <!--(String)filenames.get(0)%>-->
                <span>Timeline <span class="bp-icon bp-icon-about" data-content="Where you can see the posts by your friends!"></span></span>
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
                            <a href="searchUser.jsp" class="bp-icon bp-icon-archive" data-info="Explore Users"><span>Explore User</span></a>
                            <!--<a href="http://tympanus.net/codrops/category/blueprints/" class="bp-icon bp-icon-archive" data-info="Blueprints archive"><span>Go to the archive</span></a>-->
                        </div>
                        <div style="float:right;">
                            <a href="addBucket.jsp" class="bp-icon bp-icon-archive" data-info="Bucket It"><span>Bucket It</span></a>
                            <!--<a href="http://tympanus.net/codrops/category/blueprints/" class="bp-icon bp-icon-archive" data-info="Blueprints archive"><span>Go to the archive</span></a>-->
                        </div>                        
                    </div>
                </nav>
            </header>

            <div id="grid-gallery" class="grid-gallery">
                <section class="grid-wrap">
                    <ul class="grid">
                        <li class="grid-sizer"></li><!-- for Masonry column width -->
                        <c:forEach items="${caption}" var="item">
                            <li>
                                <figure>

                                    <img src="img/thumb/<%=(String) filenames.get(0)%>" alt="img01"/>

                                    <figcaption><h3><%=(String) caption.get(0)%></h3><p><c:out value="${item}" /></p></figcaption>
                                </figure>
                            </li>
                        </c:forEach>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(1)%>" alt="img02"/>
                                <figcaption><h3><%=(String) caption.get(1)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(2)%>" alt="img03"/>
                                <figcaption><h3><%=(String) caption.get(2)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(3)%>" alt="img04"/>
                                <figcaption><h3><%=(String) caption.get(3)%></p></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(4)%>" alt="img05"/>
                                <figcaption><h3><%=(String) caption.get(4)%> </p></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(5)%>" alt="img06"/>
                                <figcaption><h3><%=(String) caption.get(5)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(6)%>" alt="img07"/>
                                <figcaption><h3><%=(String) caption.get(6)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(7)%>" alt="img08"/>
                                <figcaption><h3><%=(String) caption.get(7)%></p></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(8)%>" alt="img09"/>
                                <figcaption><h3><%=(String) caption.get(8)%></p></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(9)%>" alt="img10"/>
                                <figcaption><h3><%=(String) caption.get(9)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(10)%>" alt="img11"/>
                                <figcaption><h3><%=(String) caption.get(10)%></h3></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(11)%>" alt="img12"/>
                                <figcaption><h3><%=(String) caption.get(11)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(12)%>" alt="img13"/>
                                <figcaption><h3><%=(String) caption.get(12)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(13)%>" alt="img14"/>
                                <figcaption><h3><%=(String) caption.get(13)%> </p></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(14)%>" alt="img15"/>
                                <figcaption><h3><%=(String) caption.get(14)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(15)%>" alt="img16"/>
                                <figcaption><h3><%=(String) caption.get(15)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(16)%>" alt="img17"/>
                                <figcaption><%=(String) filenames.get(16)%> </p></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(17)%>" alt="img18"/>
                                <figcaption><h3><%=(String) caption.get(17)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(18)%>" alt="img19"/>
                                <figcaption><h3><%=(String) caption.get(9)%></p></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(19)%>" alt="img20"/>
                                <figcaption><%=(String) filenames.get(19)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(20)%>" alt="img21"/>
                                <figcaption><%=(String) filenames.get(20)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(21)%>" alt="img22"/>
                                <figcaption><h3><%=(String) caption.get(21)%></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(22)%>" alt="img23"/>
                                <figcaption><h3><%=(String) caption.get(22)%></p></figcaption>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <img src="img/thumb/<%=(String) filenames.get(23)%>" alt="img24"/>
                                <figcaption><%=(String) caption.get(23)%></figcaption>
                            </figure>
                        </li>
                    </ul>
                </section><!-- // grid-wrap -->
                <section class="slideshow">
                    <ul>
                        <li>
                            <figure>
                                <figcaption>
                                   <%=(String) caption.get(0)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(0)%>" alt="img01"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(1)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(1)%>" alt="img02"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(2)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(2)%>" alt="img03"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(3)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(3)%>" alt="img04"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(4)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(4)%>" alt="img05"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(5)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(5)%>" alt="img06"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(6)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(6)%>" alt="img07"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(7)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(7)%>" alt="img08"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(8)%>
                                </figcaption>
                                <img src="img/large/<%=(String) filenames.get(8)%>" alt="img03"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(9)%>
                                </figcaption>
                                <img src="<%=(String) filenames.get(9)%>" alt="img10"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(10)%>
                                </figcaption>
                                <button type="button">Appreciate!</button>
                                <img src="img/large/<%=(String) filenames.get(10)%>" alt="img11"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(11)%>
                                </figcaption>
                                <button type="button">Appreciate!</button>
                                <img src="img/large/<%=(String) filenames.get(11)%>" alt="img12"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(12)%>
                                </figcaption>
                                	
                                <img src="img/large/<%=(String) filenames.get(12)%>" alt="img13"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(13)%>
                                </figcaption>
                              	
                                <img src="img/large/<%=(String) filenames.get(13)%>" alt="img14"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(14)%>
                                </figcaption>
                                	
                                <img src="img/large/<%=(String) filenames.get(14)%>" alt="img15"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(15)%>
                                </figcaption>
                                
                                <img src="img/large/<%=(String) filenames.get(15)%>" alt="img16"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(16)%>
                                </figcaption>
                              	
                                <img src="img/large/<%=(String) filenames.get(16)%>" alt="img17"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(17)%>
                                </figcaption>
                                
                                <img src="img/large/<%=(String) filenames.get(17)%>" alt="img18"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(18)%>
                                </figcaption>
                                
                                <img src="img/large/<%=(String) filenames.get(18)%>" alt="img19"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(19)%>
                                </figcaption>
                                
                                <img src="img/large/<%=(String) filenames.get(19)%>" alt="img20"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(20)%>
                                </figcaption>
                                
                                <img src="img/large/<%=(String) filenames.get(20)%>" alt="img21"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <fig<%=(String) caption.get(21)%>
                                </figcaption>
                                
                                <img src="img/large/<%=(String) filenames.get(21)%>" alt="img22"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(22)%>
                                </figcaption>
                                
                                <img src="img/large/<%=(String) filenames.get(22)%>" alt="img23"/>
                            </figure>
                        </li>
                        <li>
                            <figure>
                                <figcaption>
                                    <%=(String) caption.get(23)%>

                                </figcaption>
                                
                                <img src="img/large/<%=(String) filenames.get(23)%>" alt="img24"/>
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
                                    new CBPGridGallery(document.getElementById('grid-gallery'));
        </script>
    </body>
</html>
