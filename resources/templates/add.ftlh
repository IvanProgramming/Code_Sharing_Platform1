<!doctype html>
<html lang="en">
<head>
    <title>Create</title>
    <style>
        #code_snippet {
            width: 400px;
            height: 200px;
        }
    </style>
</head>
<body>
<div class="form">
    <textarea id="code_snippet">
           Write your code here...
       </textarea>
    <br>
    <label for="views">View restriction</label>
    <input type="number" id="views">
    <br>
    <label for="time">Time restriction</label>
    <input type="number" id="time">
    <button id="send_snippet" type="submit" onclick="send()">Submit</button>
</div>
<script>
    function send() {
        let object = {
            "code": document.getElementById("code_snippet").value,
            "allowedViews": document.getElementById("views").value,
            "availableTime": document.getElementById("time").value
        };

        let json = JSON.stringify(object);

        let xhr = new XMLHttpRequest();
        xhr.open("POST", '/api/code/new', false)
        xhr.setRequestHeader('Content-type', 'application/json; charset=utf-8');
        xhr.send(json);

        if (xhr.status == 200) {
            alert("Success!");
        }
    }   </script>
</body>
</html>