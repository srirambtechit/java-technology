// Skeleton class generated by rmic, do not edit.
// Contents subject to change without notice.

package com.msrm.rmi;

public final class ShipperImpl_Skel
    implements java.rmi.server.Skeleton
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("java.util.Map ship(java.lang.Integer[], java.lang.String[], java.lang.Float[])")
    };
    
    private static final long interfaceHash = 8906216377752392609L;
    
    public java.rmi.server.Operation[] getOperations() {
	return (java.rmi.server.Operation[]) operations.clone();
    }
    
    public void dispatch(java.rmi.Remote obj, java.rmi.server.RemoteCall call, int opnum, long hash)
	throws java.lang.Exception
    {
	if (hash != interfaceHash)
	    throw new java.rmi.server.SkeletonMismatchException("interface hash mismatch");
	
	com.msrm.rmi.ShipperImpl server = (com.msrm.rmi.ShipperImpl) obj;
	switch (opnum) {
	case 0: // ship(Integer[], String[], Float[])
	{
	    java.lang.Integer[] $param_arrayOf_Integer_1;
	    java.lang.String[] $param_arrayOf_String_2;
	    java.lang.Float[] $param_arrayOf_Float_3;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_arrayOf_Integer_1 = (java.lang.Integer[]) in.readObject();
		$param_arrayOf_String_2 = (java.lang.String[]) in.readObject();
		$param_arrayOf_Float_3 = (java.lang.Float[]) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    java.util.Map $result = server.ship($param_arrayOf_Integer_1, $param_arrayOf_String_2, $param_arrayOf_Float_3);
	    try {
		java.io.ObjectOutput out = call.getResultStream(true);
		out.writeObject($result);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	default:
	    throw new java.rmi.UnmarshalException("invalid method number");
	}
    }
}