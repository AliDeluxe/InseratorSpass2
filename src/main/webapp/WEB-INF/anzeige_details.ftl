<html>
<head>
<title>Anzeige Details</title>

</head>
 
<body>
    <div id="header">
    		<h1> Anzeige Details </h1>
    </div>

    <fieldset style="width:270px">

        <legend> <h4> ${titel} </h4> </legend>
        <label>Preis: ${preis} €<br /></label>
        <label>Erstellt am: ${erstellungsdatum}<br />
        <label>Ersteller: <a href="user_profile.ftl">${benutzer}</a> <br />

        </fieldset>


    <p> ${beschreibung} </p>


  <form name="kaufen" action="/anzeige_details" method="post">
  <input type="submit" value="Kaufen" /> ${status}
  </form>

  <form name="editieren" action="/anzeige_editieren" method="get">
  <input type="submit" value="Editieren" />
  </form>

  <form name="löschen" action="/anzeige_erstellen" method="post">
  <input type="submit" value="Löschen" />
  </form>



 

</body>
</html>
