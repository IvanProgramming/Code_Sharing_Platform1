<!doctype html>
<html lang="en">
<head>
    <title>Latest</title>
    <style>
        #load_date {
            color: green;
            font-size: 18px;
        }

        pre {
            border: solid black 1px;
            display: inline-block;
        }
    </style>
    <link rel="stylesheet"
          href="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/styles/gruvbox-dark.min.css">
    <script src="//cdn.jsdelivr.net/gh/highlightjs/cdn-release@10.2.1/build/highlight.min.js"></script>
    <script>hljs.initHighlightingOnLoad();</script>
</head>
<body>
<#list recent as snippet>
    <span id="load_date">${snippet.date}</span> <br>
    <pre id="code_snippet">
        <code>${snippet.code}</code>
    </pre>
    <br>
</#list>
</body>
</html>
