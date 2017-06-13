/**
 * 
 */
package com.dreamof.rpc.protocal.demo;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;


/**
 * @description
 * @author Administrator
 * @date 2017年5月23日
 */
public class RmiApiServer {

    public static void main(String[] args) throws RemoteException, MalformedURLException,
            AlreadyBoundException, NotBoundException {
        RmiApi api = new RmiApiImpl();
        LocateRegistry.createRegistry(8888);
        Naming.bind("rmi://localhost:8888/api", api);
        Naming.bind("rmi://localhost:8888/api1", api);
        Naming.bind("rmi://localhost:8888/api2s", api);

        System.out.println(Naming.list("rmi://localhost:8888/api"));

        System.out.println(">>>>>INFO:远程对象绑定成功！");

    }
}
