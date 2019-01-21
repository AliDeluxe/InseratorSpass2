<html>
<head>
<title>User Profile</title>

</head>
 
<body>
    <div id="header">
    		<h1> User Profile </h1>
    </div>



    <h2> ${titel} <h2> <br>
    <h5> Erstellt am: ${erstellungsdatum} von <a href="benutzer">${benutzer}</a> <br>
    <h4> ${beschreibung} <br> <br>
    <h2> ${preis} € <h2> <br>


  <form name="kaufen" action="/anzeige_erstellen" method="post">
  <input type="submit" value="Erstellen" />
  </form>

  <form name="anzeige" action="/anzeige_erstellen" method="post">
  <input type="submit" value="Erstellen" />
  </form>

  <form name="anzeige" action="/anzeige_erstellen" method="post">
  <input type="submit" value="Erstellen" />
  </form>



 

</body>
</html>
