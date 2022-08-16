<!DOCTYPE html>
<html>
    <head>
        <title>Genre</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css">
        </head>
    <body>
        <h2>Genre</h2>

        <table>
            <tr>
                <th>Id</th>
                <th>Name</th>
            </tr>

            <#list genreList as genre>
                <tr>
                    <td>${genre.id}</td>
                    <td>${genre.name}</td>
                </tr>
            </#list>
        </table>

    </body>
</html>