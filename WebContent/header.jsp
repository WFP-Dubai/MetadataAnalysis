<%@page import="meta.*"%>
<!DOCTYPE html>
<html>
     <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>FLS Meta-Data</title>
         <link href="css/styles.css" rel="stylesheet" type="text/css" 
media="screen">
         <script 
src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
         <script type="text/javascript" 
src="./js/tablesorter/jquery.tablesorter.js"></script>
     </head>
     <body>

     <div id="wrapper">
     <div id="top">
         <p>FITTEST Location Services Meta-Data</p>
     </div>
     <div id="topnav">
         <ul>
              <li><a href="index.jsp"></a></li>
         </ul>
     </div>

     <script>
         
         $(document).ready(function() { 
           // call the tablesorter plugin 
           $("table").tablesorter({ 
               // sort on the first column and third column, order asc 
               sortList: [[0,0]] 
           }); 
       }); 





     </script>


