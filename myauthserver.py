import sys
sys.path.append('gen-py')

from myauth import Authentication
from myauth.constants import *

from thrift.transport import TSocket
from thrift.transport import TTransport
from thrift.protocol import TBinaryProtocol
from thrift.server   import TServer

class AuthenticationHandler:
  def __init__(self):
    pass

  def say_hello(self):
    print("thrift client connected")
    return "hello thrift client"

  def login(self, cred):
    if cred.username == 'hello' and cred.password == 'world':
      print("logged in")
      return LoginStatus.SUCCESS

    print("great pie of fail")
    return LoginStatus.FAIL


if __name__ == '__main__':
  handler = AuthenticationHandler()
  processor = Authentication.Processor(handler)
  transport = TSocket.TServerSocket(port=9090)
  tfactory = TTransport.TBufferedTransportFactory()  
  pfactory = TBinaryProtocol.TBinaryProtocolFactory()  
  server = TServer.TSimpleServer(processor, transport, tfactory, pfactory)  
  print 'Starting the server...'  
  server.serve()  
