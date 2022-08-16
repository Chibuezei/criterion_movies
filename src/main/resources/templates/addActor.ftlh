<!DOCTYPE html>

<html>
<head>
    <title>Add Author</title>
       <script>
        function send() {

            let object = {
                "firstname": document.getElementById("firstname").value,
                 "lastname": document.getElementById("lastname").value,
                  "othername": document.getElementById("othername").value
            };

            let json = JSON.stringify(object);

            let xhr = new XMLHttpRequest();
            xhr.open("POST", '/api/actor', false)
            xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
            xhr.send(json);

            if (xhr.status == 200) {
              alert("Success!");
            }
        }
        </script>
</head>
<body>
<form>
    <p><input id="firstname" placeholder="firstname" type="text"/>
    <p><input id="lastname" placeholder="lastname" type="text"/>
     <p><input id="othername" placeholder="othername" type="text"/>

    <button id="addAuthor" type="submit" onclick="send()">Submit</button>

</form>

</body>
</html>