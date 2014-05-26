#!/usr/bin/env ruby1.9

require 'thrift'
$:.push('gen-rb')

require 'authentication'
require 'myauth_constants'

transport = Thrift::BufferedTransport.new(Thrift::Socket.new('localhost', 9090))
protocol = Thrift::BinaryProtocol.new(transport)
auth = MyAuth::Authentication::Client.new(protocol)
transport.open()

puts auth.say_hello()

user = MyAuth::User.new
user.username = 'hello'
user.password = 'world'

puts "Login: #{auth.login(user)}"

user2 = MyAuth::User.new
user2.username = 'failed'
user2.password = 'world'

puts "Login: #{auth.login(user2)}"
