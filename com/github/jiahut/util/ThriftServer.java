package com.github.jiahut.util;

import com.github.jiahut.thrift.gen.*;
import com.github.jiahut.thrift.impl.Auth;

import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.server.TThreadPoolServer.Args;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;

public class ThriftServer {
	public void start() {
		try {
			TServerSocket serverTransport = new TServerSocket(9090);
			Authentication.Processor process = new Authentication.Processor(
					new Auth());

			Factory portFactory = new TBinaryProtocol.Factory(true, true);

			Args args = new Args(serverTransport);
			args.processor(process);
			args.protocolFactory(portFactory);

			TServer server = new TThreadPoolServer(args);
			server.serve();
		} catch (TTransportException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThriftServer server = new ThriftServer();
		server.start();
	}
}