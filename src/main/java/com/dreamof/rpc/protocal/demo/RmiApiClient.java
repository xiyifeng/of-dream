/**
 * 
 */
package com.dreamof.rpc.protocal.demo;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


/**
 * @description
 * @author Administrator
 * @date 2017年5月23日
 */
public class RmiApiClient {

    public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {

        listAll();
    }


    public static void rpcCall() throws RemoteException, MalformedURLException, NotBoundException {
        RmiApi rhello = (RmiApi) Naming.lookup("rmi://localhost:8888/api");
        rhello.action("dododd");
    }


    public static void unbind() throws RemoteException, MalformedURLException, NotBoundException {
        Naming.unbind("rmi://localhost:8888/api");
    }


    public static void NamingListAll() throws RemoteException, MalformedURLException {
        String[] strs = Naming.list("rmi://localhost:8888");
        for (String str : strs) {
            System.out.println(str);
        }
    }


    public static void listAll() throws RemoteException {
        Registry reg = LocateRegistry.getRegistry(8888);
        String[] strs = reg.list();
        for (String str : strs) {
            System.out.println(str);
        }
    }

}
