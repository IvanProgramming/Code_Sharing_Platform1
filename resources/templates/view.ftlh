<!doctype html>
<html lang="en">
<head>
    <title>Code</title>
    <style>
        #load_date {
            color: green;
            font-size: 18px;
        }

        pre {
            border: solid black 1px;
            display: inline-block;
        }

        #time_restrictions {
            font-weight: bold;
        }

        #views_restrictions {
            font-weight: bold;
        }
    </style>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/gruvbox-dark.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<span id="load_date">${snippet.date}</span> <br>
<div id="restrictions">
    Time left: <span id="time_restrictions">${snippet.time}</span>
    <br>
    Views left: <span id="views_restrictions">${snippet.views}</span>
</div>
<pre id="code_snippet">
    <code>${snippet.code}</code>
</pre>
</body>
</html>