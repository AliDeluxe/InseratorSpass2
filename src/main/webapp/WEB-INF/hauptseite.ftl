<html>
<head>
<title>Hauptseite</title>
    <h1> Hauptseite </h1>
</head>
 
<body>


  <#list anzeigeListe as anzeige>

    <fieldset style="width:270px">
    <!--TODO links muessen ueber id zu der richtigen Anzeigedetail seite fuehren-->
    <legend> <h4> <a href="anzeige_detail.ftl"> ${anzeige.titel} </a> </h4> </legend>
    <label>Preis: ${anzeige.preis} €<br /></label>
    <label>Erstellt am: ${anzeige.erstellungsDatum}<br />
    <label>Ersteller: ${anzeige.user} <br />

    </fieldset>
    <br>

   </#list>

</body>
</html>
