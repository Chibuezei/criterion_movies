<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Movies</title>
         <link href="/css/style.css" rel="stylesheet">
    </head>
    <body>
        <#list movieList as movie>
                <h3><span class="title">${movie.title}</span> </h3>
                <p><span class="line2">Genre: ${movie.genre}</span><br>
                <#if movie.releaseYear?has_content> <span class="line2">releaseYear: ${movie.releaseYear} </span></#if>
                <p><#if movie.duration?has_content> <span class="line3">Duration: ${movie.duration} </span></#if><br>
                <#if movie.edited?has_content> <span class="line3">Edited: ${movie.edited?string('yes', 'no')} </span></#if>
                <p><#if movie.summary?has_content> <span class="summary"> ${movie.summary} </span></#if>

        </#list>
   </body>
</html>


