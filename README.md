 Cadac
==============
Cadac is a web-based database application system implemented in Model 2 (MVC) architecture using JSP, Java Servlets and DB2 as a backend. The system, similar to flickr and PhotoShelter, can be used by its clients to<br>
• create their own profile and see images via timeline and gallery.<br>
• upload and store images and follow other users.<br>
• enter and update the descriptive information (time, place, caption, owner, category, copyright) for images.<br>
• specify the access privileges for images to public, among followers, and friends.<br>
• search for photos with the given words through image information.<br>

It is not built using any framework.<br>

Its front end is a theme which can be obtained from -(http://tympanus.net/Blueprints/GridGallery/) <br>

You can have an overview of the entire portal in this video<br>
https://www.youtube.com/watch?v=tO25TERG-Cc&feature=youtu.be<br>

###### _Irrespective of the commit here is the original work done by each member(github username in bracket)_


**Ankur Arora**(ankursmooth) - Created the entire database layer(Model of MVC),helped in creation of schema,created database in IBM DB2,created the Java beans class responsible for interfacing with the database and the servlets.Also corrected the bugs in servlets classes.

**Chirag Agarwal**(agarwalchirag81[at]gmail.com) and **Chirag Garg**(cenati0n) - Were majorly responsible for the servlet classes(Controller) which dealt with user sign-up,login,forgot password,image upload and main timeline.They were the first to figure out the working and interfacing of servlets and beans classes.

**Akshat Tandon**(droftware) - Responsible for creation of the database schema,conversion of ER model to relational model,normalization of the schema into BCNF form,creation of servlet classes of bucket(Image Like) and following other users.

**Dhiyavasu**(dhiyavasu) - Suggested the feature of pulse which was used in figuring out the relative ordering of images in a users timeline.Also suggested some features of the portal

Kapil Matani - Found a template which served as the front end.Edited the template so as to suit the portals need.
