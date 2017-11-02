package honoo.handler.exception;
/** 
 * @author 
 * @version 
 *  
 */
public class A {
	CallBack call;
	public void setCall(CallBack call) {
		this.call = call;
	}
	public void test(){
		call.exe("1112");
		
		
	}
}
interface CallBack{
	void exe(String s);
	
}