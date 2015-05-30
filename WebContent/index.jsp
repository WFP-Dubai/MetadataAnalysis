<%@include file="./header.jsp" %>

     <div id="content">

         <h1>Contents of metadata.properties</h1>

         <div id="tablediv">

<% 
     GetMeta metaData = new GetMeta();
     String allMeta = metaData.getAllMeta();

     String Table = "<table id='elrtable' class='tablesorter'><thead>"
             + "<tr>"
             + "<th>Data Category <br><br> &#9650;&#9660;</th>"
             + "<th>Data Layer<br><br> &#9650;&#9660;</th>"
             + "<th id='description'>Layer Description <br><br> &#9650;&#9660;</th>"
             + "<th>Data Sources and Update Frequency<br><br> &#9650;&#9660;</th>"
             + "<th id='owner'>Data Owner <br><br> &#9650;&#9660;</th>"
             + "<th>Layer Author<br><br> &#9650;&#9660;</th>"
             + "<th>Layer Creation Date<br><br> &#9650;&#9660;</th>"
             + "<th>Layer Modification Author<br><br> &#9650;&#9660;</th>"
             + "<th>Layer Modification Date<br><br> &#9650;&#9660;</th>"
             + "<th>Change Logs<br><br> &#9650;&#9660;</th>"
             + "</tr></thead><tbody>";             
             
     Table = Table + allMeta;
     Table = Table + "</tbody></table>";

     out.print(Table);


%>
        </div>
     </div>


<%@include file="./footer.jsp" %>


