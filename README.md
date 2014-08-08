Play & Akka Websockets Echo server
==================================

This application is simply an echo server which creates an actor per websocket connection

Run
===

`arefaey@arefaey-MacBook-Pro ~/w/p/s/w/ws-echo-server> ./activator run`

This file will be packaged with your application, when using `activator dist`.

From any websocket client just initiate connection to `ws://localhost:9000/ws`, you will reciveack message with the
connection ID. Sending any message to the server the server will reply with the same message sent.

