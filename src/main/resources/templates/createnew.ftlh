<!DOCTYPE html>

<html>
<head>
    <link rel="shortcut icon" href="#">
    <title>Upload Movie</title>

</head>
<body>
<form>
    <p><input id="title" placeholder="write movie title here" type="text"/>
    <p><input id="genre" placeholder="genre ID: use the genre link to get the id" type="text"/>
     <p><input id="edited" placeholder="is_edited, true or false" type="text"/>
    <p><input id="releaseYear" placeholder="release year in figures" type="text"/>
    <p><input id="duration" placeholder="duration in minutes, figures only" type="text"/>
     <p><input id="actor1" placeholder="1st major actor" type="text"/>
     <p><input id="actor2" placeholder="2nd major actor" type="text"/>
     <p><input id="actor3" placeholder="3rd major actor" type="text"/>

      <p><input id="harddrive" placeholder="Internal hardrive location" type="text"/>
     <p><input id="imdb" placeholder="imdb in figures" type="text"/>
     <p><input id="rottenTomatometer" placeholder="rottenTomatometer in figures, figures only" type="text"/>
      <p><input id="rottenAudience" placeholder="rottenAudience" type="text"/>
     <p><textarea  id="summary" placeholder="summary"> </textarea>

    <button id="send_movie" type="submit" onclick="send()">Submit</button>

</form>
 <script>
        function send() {

            let object = {
                "title": document.getElementById("title").value,
                 "genre": document.getElementById("genre").value,
                  "edited": document.getElementById("edited").value,
                 "releaseYear": document.getElementById("releaseYear").value,
                 "duration": document.getElementById("duration").value,
                  "actor1": document.getElementById("actor1").value,
                "actor2": document.getElementById("actor2").value,
                 "actor3": document.getElementById("actor3").value,
                  "harddrive": document.getElementById("harddrive").value,
                 "imdb": document.getElementById("imdb").value,
                 "rottenTomatometer": document.getElementById("rottenTomatometer").value,
                  "rottenAudience": document.getElementById("rottenAudience").value,
                  "summary": document.getElementById("summary").value
            };

            let json = JSON.stringify(object);

            let xhr = new XMLHttpRequest();
            xhr.open("POST", '/api/movie/new', false)
            xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            xhr.send(json);

            if (xhr.status == 200) {
              alert("Success!");
            }
        }
 </script>
</body>
</html>