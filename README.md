# KidsSecure

![Dialog(2)](https://github.com/AnoukMartinez/EP_WS23_Ganz_Khamkaew_Martinez/assets/22712239/1715f0ce-81c4-460b-a8d5-454526c7e066)



## Darstellung des Problems

Es ist ein weitverbreitetes Phänomen, dass viele User unbedacht Links in Mails und / oder Foren z.B. öffnen und so schnell Opfer von verschiedenen Arten der Cyberkriminalität werden können. Besonders anfällig dafür sind Kinder, da sie oft die Gefahren aus dem Internet noch gar nicht kennen bzw. diese nicht einschätzen können. Es hat sich gezeigt, dass die "Medienführerscheine" aus den Schulen nicht auszureichend sind. Kinder und Jugendliche hinterfragen nicht, wenn ihnen ein Fremder in einem Forum/ Chat einen Link zu einem angesagten Game oder Thema für ein Spiel schicken, sondern freuen sich über die Nettigkeit und klicken vertrauensvoll auf den Link. 

Da Eltern oft selbst nicht im Bilde darüber sind, welche Seiten und Links vertrauenswürdig sind, stellen diese keine große Hilfe für ihre Kinder dar. Diese Problematik beläuft sich nicht nur im heimischen Umfeld, sondern auch in der Schule. Lehrer\*innen fordern z.b. Schüler auf ein bestimmes Programm zu installieren und verteilen z.T. selbst unwissend Links zu schadhafter Software. Aber auch wenn Schüler\*innen die Computer der Schule nutzen möchten bzw. müssen, um für Referate zu recherchieren, können sie schnell in Virenfallen z.B. treten. Wie erwähnt hat auch das Lehrpersonal in diesem Bereich Wissenslücken, kann besonders dann, wenn sie nicht aus dem Fachbereich der Informatik kommen, und können den Schüler\*innen nur bedingt helfen. 

![Aufgabe_Schüler](https://github.com/AnoukMartinez/EP_WS23_Ganz_Khamkaew_Martinez/assets/22712239/48bd1d86-07c2-4bf2-9aa7-57794317faae)

## Zielsetzung / Vision
Ziel von KidsSecure ist es, ein System zu entwickeln, dass es Schüler\*innen ermöglicht spielerisch und verständlich über die Gefahren im Internet aufgeklärt zu werden und so vor Viren, Trojanern, Identitäsklau etc. geschützt zu werden. Die Vision dahinter ist, dass Kinder und Jugendliche sich nicht von der Thematik erschlagen fühlen, weil sie haufenweise Regeln vorgesetzt bekommen, sondern ein nachhaltiges Verständnis und Vorsicht entwickeln und so auch anderen aktiv helfen können. 

## Relevanz
Die Relevanz, durch die Umsetzung des vorliegenden Projekts ist offensichtlich: dadurch, dass Schüler\*innen gezielt den Umgang mit Gefahren im Internet lernen, sind Familien im privaten Umfeld geschützter, weil sich mindestens eine Person mit dem Thema IT-Sicherheit auseinander gesetzt hat. Ein solches System entlastet darüber hinaus auch das Lehrpersonal, da auch im schulischen Kontext die Lehr- und Lerneinheiten im Internet stattfinden und die Lehrer\*innen oft selbst nicht über die entsprechenden Kompetenzen verfügen. 
Darüber hinaus reicht die Relevanz bis in die berufliche Zukunft der Kinder. Gefahren, die die Kinder heute schon kennengelernt haben, werden sie auf der Arbeit selbstsicher erkennen und aus dem Weg gehen können. Dadurch wird auch das IT Team in Firmen entlastet, da sie sich so voll und ganz auf ihre Arbeit konzentrieren können und nicht mehr so oft die Schäden beheben müssen, die Mitarbeiter\*innen unbedacht angerichtet haben. 

## Installation
Hier eine kleine Erklärung dazu, wie man das Projekt laufen lassen kann.
1. Projekt klonen und in Android Studio öffnen
2. Projekt mit Gradle syncen und alle nötigen Dependencies herunterladen lassen
3. Seperat Server Module mit ```npm install``` installieren, dann den Webserver mit ```node server.js``` starten (Zum Beispiel in einem neuem Fenster oder in einer anderen IDE wie VSCode)
4. Mit ipconfig eigene IP Adresse finden und ip Variable in GetScriptFromServer.kt ersetzen auf Port 3000 (z.B val ip = "192.163.178.110:3000")
5. In Android Studio mit Run Anything folgendem Command ausführen ```gradle composeApp:run``` (Mobile Konfiguration sollte automatisch verfügbar sein. Mobile Version ist allerdings momentan nicht funktional.)
6. Jetzt sollte die App auf dem Desktop laufen. Momentan sind im Code folgende Dummy Profile mit denen man sich anmelden kann:
   * Jan Müller (email = student, password = hi)
   * Susi Mongus (email = student2, password = hi)
   * Frank Ozean (email = student3, password = hi)
   * Herr Lehrer (email = teacher, password = hi)
   * Hannah Mongus (email = teacher2, password = hi)

[Sonst bei Fragen oder Rückmeldung bitte eine Mail schicken.](mailto:anouk_olivia_elsa.martinez_wieczorek@smail.th-koeln.de?subject=[GitHub]%20Entwicklungsprojekt%20Rückfrage)
