package com.github.jiahut.thrift.impl;

import org.apache.thrift.TException;

import com.github.jiahut.thrift.gen.*;
import com.github.jiahut.util.Bootstrap;

public class Auth implements Authentication.Iface {

	@Override
	public String say_hello() throws TException {
		return "hello world"
	}

	@Override
	public LoginStatus login(User cred) throws TException {
		if (cred.username.equals("hello") && cred.password.equals("world")) {
			return LoginStatus.SUCCESS;
		}
		return LoginStatus.FAIL;
	}

}
