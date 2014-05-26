#!/usr/bin/env ruby1.9

require 'thrift'
$:.push('gen-rb')

require 'authentication'
require 'myauth_constants'

class AuthenticationHandler
  def say_hello
    puts "thrift client connected"
    "hello thrift client"
  end

  def login cred
    if cred.username == 'hello' && cred.password == 'world'
      puts "logged in"
      return MyAuth::LoginStatus::SUCCESS 
    end

    puts "great pie of fail"
    MyAuth::LoginStatus::FAIL
  end
end

handler = AuthenticationHandler.new
processor = MyAuth::Authentication::Processor.new(handler)
transport = Thrift::ServerSocket.new(9090)
transportFactory = Thrift::BufferedTransportFactory.new()
server = Thrift::SimpleServer.new(processor, transport, transportFactory)

puts "Starting the server..."
server.serve()
puts "done."

