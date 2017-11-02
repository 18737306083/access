package honoo.handler.exception;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.coyote.Request;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** 
 * @author 
 * @version 
 *  
 */
@Controller
@RequestMapping("/login")
public class Controll {

	public String test(){
		
		
		return "";
	}
	public void request(HttpServletRequest re,HttpRequest req,Request request,HttpServletResponse resp){
		
		Enumeration en=	re.getParameterNames();
		 
	     
	}
}
