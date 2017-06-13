/**
 * 
 */
package com.dreamof.rpc.protocal.demo;

import java.rmi.RemoteException;
import java.rmi.dgc.Lease;
import java.rmi.dgc.VMID;
import java.rmi.server.ObjID;
import java.rmi.server.UnicastRemoteObject;


/**
 * @description
 * @author Administrator
 * @date 2017年5月23日
 */
public class RmiApiImpl extends UnicastRemoteObject implements RmiApi {

    /**
     * @throws RemoteException
     */
    protected RmiApiImpl() throws RemoteException {
        super();
    }

    /**
     * 
     */
    private static final long serialVersionUID = 1L;


    @Override
    public void action(String name) throws RemoteException {
        System.out.println("调用服务Action[" + name + "]");
    }


    @Override
    public Lease dirty(ObjID[] ids, long sequenceNum, Lease lease) throws RemoteException {
        System.out.println("idsID[" + ids + "] seq [" + sequenceNum + "] +[" + lease + "]");
        return null;
    }


    @Override
    public void clean(ObjID[] ids, long sequenceNum, VMID vmid, boolean strong) throws RemoteException {
        System.out.println("idsID[" + ids + "] seq [" + sequenceNum + "] +[" + strong + "]");
    }

}
