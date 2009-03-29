import sys
sys.path.append('gen-py')

from myauth import Authentication
from myauth.constants import *

from thrift import Thrift
from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol

transport = TSocket.TSocket('localhost', 9090)
transport = TTransport.TBufferedTransport(transport)
protocol = TBinaryProtocol.TBinaryProtocol(transport)

auth = Authentication.Client(protocol)

transport.open()

print auth.say_hello()

#user = User()
#user.username = 'hello'
#user.password = 'world'
#
#print "Login: %s" % auth.login(user)
#
#user2 = User()
#user2.username = 'failed'
#user2.password = 'world'
#
#print "Login: %s" % auth.login(user2)
