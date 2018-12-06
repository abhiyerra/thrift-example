package com.github.jiahut.util;

import com.github.jiahut.thrift.gen.*;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

public class ThriftClient {

	public void startClient() {
		TTransport transport;
		try {
			transport = new TSocket("localhost", 9090);
			TProtocol protocol = new TBinaryProtocol(transport);
			Authentication.Client client = new Authentication.Client(protocol);
			transport.open();
			System.out.println(client.say_hello());
			transport.close();
		} catch (TTransportException e) {
			e.printStackTrace();
		} catch (TException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		ThriftClient client = new ThriftClient();
		client.startClient();
	}
}