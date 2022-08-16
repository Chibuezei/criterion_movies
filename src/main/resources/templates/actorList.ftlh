<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Actors</title>
         <link href="/css/style.css" rel="stylesheet">
    </head>
    <body>
        <h2>List of Actors</h2>
        <#list actorList as actor>
                <p><span class="line2">ID: ${actor.a_id} ==> ${actor.firstname}
                <#if actor.lastname?has_content>,${actor.lastname}</#if>
                <#if actor.othername?has_content> ,${actor.lastname} </#if></span>
        </#list>
   </body>
</html>


