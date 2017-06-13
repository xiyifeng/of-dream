/**
 * 
 */
package com.dreamof.rpc.protocal.demo;

import java.rmi.RemoteException;
import java.rmi.dgc.DGC;


/**
 * @description
 * @author Administrator
 * @date 2017年5月23日
 */
public interface RmiApi extends DGC {

    public void action(String name) throws RemoteException;

}
