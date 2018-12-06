An example service using thrift. With 2 clients written in ruby and python and a server in ruby.

test **ok** with Thrift version 0.9.1

## usage ##

generate
--------

    thrift --gen rb --gen py myauth.thrift

server
------

    ruby myauthserver.rb 
    [alternative] python myauthserver.py

client
------

    python myauthclient.py  
    ruby myauthclient.rb


enjoy.
