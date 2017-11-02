package com.honoo.controll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URLDecoder;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.InputBuffer;
import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.future.mybatis.mapper.PersonMapper;
import com.future.mybatis.mapper.Wechat;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.honoo.utils.Base64s;
import com.honoo.utils.RC4entry;
import com.honoo.utils.SMSUtils;

@Controller
@RequestMapping(value = "weixin")
public class Applets {
	/**
	 * 
	 * @Description: ģʽ1���ɶ�ά��
	 *@param:   
	 *@return: void
	 *@throws
	 */
	@Resource
	Wechat wechatMapper;
	@Resource
	PersonMapper personMapper;
	 
	 @SuppressWarnings("unchecked")
	@RequestMapping("/model1")
	public void findData(HttpServletRequest request, HttpServletResponse response) {
		SimpleDateFormat sim;
		Calendar ca;
		Date moment;
		String first;
		String second;
		byte[] str;
		String number;
		//String phone = "12345667";
		int width = 200;// ��ά��ͼƬ�Ŀ��
		int height = 200;// ��ά��ͼƬ�ĸ߶�
		byte[] by;
		String format = "jpg";// ��ά���ʽ
		String content;
		BitMatrix bitMatrix;
		/**
		 * ��ȡ�ֻ���
		 */
		     /// System.out.println("ģʽ1���ɶ�ά��");
					 String phone=request.getParameter("phone");
				
					number = phone.substring(3);
					sim = new SimpleDateFormat("ddHHmmss");
					Timer timer=new Timer();
					ca = Calendar.getInstance();
					moment = new Date();
					ca.setTime(moment);
					first = sim.format(ca.getTime());
					ca.add(Calendar.SECOND, 10);
					second = sim.format(ca.getTime());
					str = RC4entry.encry_RC4_byte("a|" + number + "|" + second,
							"1234567890");
					by = Base64s.encode(str);
					content = "#*" + new String(by);// ��ά������
			
					// �����ά�����ݲ���
					@SuppressWarnings("rawtypes")
					HashMap hints = new HashMap();
					// �����ַ��������ʽ
					hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
					// �����ݴ�ȼ�������������ʹ��M����
					hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
					// ���ñ߿��
					hints.put(EncodeHintType.MARGIN, 2);
			
					// ���ɶ�ά��
					try {
						// ָ����ά������
						bitMatrix = new MultiFormatWriter().encode(content,
								BarcodeFormat.QR_CODE, width, height, hints);
						Path file = new File("/model1"+phone+".jpg").toPath();
						// MatrixToImageWriter.writeToFile(matrix, format, file);
						MatrixToImageWriter.writeToPath(bitMatrix, format, file);
					} catch (Exception e) {
						e.printStackTrace();
					}
	}

	// ģʽ1�鿴��ά��
	@RequestMapping("/model1Pic")
	public void responsble(HttpServletRequest request,HttpServletResponse response) {
		OutputStream out;
		File file;
		byte[] bytes;
		InputStream input;
		int i;
		            // System.out.println("ģʽ1�鿴��ά��");
	                 String phone=request.getParameter("phone");
	                 //findData(phone);
	                
		                   file = new File("/model1"+phone+".jpg");
						try {
							 out = response.getOutputStream();
							 input = new FileInputStream(file);
							 BufferedReader buf=new BufferedReader(new InputStreamReader(input, "utf-8"));
							 bytes = new byte[11024];
							 
							while ((i = input.read(bytes)) != -1) {
								out.write(bytes);
								
							} 
							/*out.write(buf.);*/
							out.flush();
							out.close();
							input.close();
				
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	}

	// ģʽ2
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "model2")
	public void model2(HttpServletRequest request, HttpServletResponse response) {
		//System.out.println("ģʽ2���ɶ�ά��");
		SimpleDateFormat sim;
		Calendar ca;
		Date moment;
		String first;
		String second;
		byte[] str;
		String number;
		//String phone = "1223344";
		int width = 200;// ��ά��ͼƬ�Ŀ��
		int height = 200;// ��ά��ͼƬ�ĸ߶�
		BitMatrix bitMatrix;
						String format = "jpg";// ��ά���ʽ
				
						String phone=request.getParameter("phone");
						number = phone.substring(3);
						sim = new SimpleDateFormat("HHmmss");
						ca = Calendar.getInstance();
						moment = new Date();
						ca.setTime(moment);
						first = sim.format(ca.getTime());
						ca.add(Calendar.SECOND, 10);
						second = sim.format(ca.getTime());
						str = RC4entry.encry_RC4_byte("b|" + number + "|" + second,
								"1234567890");
						byte[] by = Base64s.encode(str);				
						String content = "#*" + new String(by);// ��ά������
						// �����ά�����ݲ���
						HashMap hints = new HashMap();
						// �����ַ��������ʽ
						hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
						// �����ݴ�ȼ�������������ʹ��M����
						hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
						// ���ñ߿��
						hints.put(EncodeHintType.MARGIN, 2);				
						// ���ɶ�ά��
						try {
							// ָ����ά������
							     bitMatrix = new MultiFormatWriter().encode(content,
									BarcodeFormat.QR_CODE, width, height, hints);
							Path file = new File("/model2"+phone+".jpg").toPath();
							MatrixToImageWriter.writeToPath(bitMatrix, format, file);
						} catch (Exception e) {
							e.printStackTrace();
						}
	}

	@RequestMapping("model2Pic")
	public void model2response(HttpServletRequest request,HttpServletResponse response) {
		//System.out.println("ģʽ2�鿴");
		File file;
		OutputStream out;
		InputStream input;
		byte[] bytes;
		int i;
		      String phone=request.getParameter("phone");
				file = new File("/model2"+phone+".jpg");
				try {
					 out = response.getOutputStream();
					 input = new FileInputStream(file);
					  bytes = new byte[1024];
					
					while ((i = input.read(bytes)) != -1) {
						out.write(bytes);
						 
					}
					out.flush();
					out.close();
					input.close();
				
				} catch (Exception e) {
					
					e.printStackTrace();
				}
	}

	// ģʽ3
	@SuppressWarnings({ "deprecation", "unchecked" })
	@RequestMapping("model3")
	public void model3(HttpServletRequest request, HttpServletResponse response)
			throws ParseException {
					//System.out.println("ģʽ3���ɶ�ά��");
					SimpleDateFormat sim;
					SimpleDateFormat simple1;
					//String first = "10:20";
					//String second = "20:10";
					byte[] str;
					String number;
					SimpleDateFormat simple2 ;
				//	String phone = "1223344";
					int width = 200;// ��ά��ͼƬ�Ŀ��
					int height = 200;// ��ά��ͼƬ�ĸ߶�
					String  phone=request.getParameter("phone");
					String first=request.getParameter("time1");
					String second=request.getParameter("time2");
					String date11=request.getParameter("date1");
					String date22=request.getParameter("date2");
					System.out.println(date11);
					System.out.println(date11+" "+first);
					number = phone.substring(3);
					sim = new SimpleDateFormat("ddHHmmss");
			
					  simple1 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
					   simple2 = new SimpleDateFormat("ddHHmmss");
					Date d = simple1.parse(date11+" "+first);
					Date d2 = simple1.parse(date22+" "+second);
					// String end = simple2.format(simple1.parse(second));
			System.out.println("d"+d.toLocaleString());
					String format = "jpg";// ��ά���ʽ
					Calendar calendar = Calendar.getInstance();
					//Date date1 = calendar.getTime();
					//System.out.println("hh"+d.getHours());
					//System.out.println("dd"+d.getDay());
					/*calendar.set(Calendar.HOUR_OF_DAY, d.getHours());
					calendar.set(Calendar.MINUTE, d.getMinutes());
					calendar.set(Calendar.SECOND, 00);
					calendar.set(Calendar.DAY_OF_MONTH, d.getDay());*/
					calendar.setTime(d);
					System.out.println(calendar.getTime().toLocaleString());

					String begin = simple2.format(calendar.getTime());
					//date1.setHours(d.getHours());
					//date1.setMinutes(d.getMinutes());
					Calendar calendar1 = Calendar.getInstance();
					//Date date1 = calendar.getTime();
					/*calendar1.set(Calendar.HOUR_OF_DAY, d2.getHours());
					calendar1.set(Calendar.MINUTE, d2.getMinutes());
					calendar1.set(Calendar.SECOND, 00);
					calendar1.set(Calendar.DAY_OF_MONTH, d2.getDay());*/
					calendar1.setTime(d2);
					System.out.println(calendar1.getTime().toLocaleString());
					/*Date date2 = calendar.getTime();
					date2.setHours(d2.getHours());
					date2.setMinutes(d2.getMinutes());
					date2.setSeconds(0);
					date2.setDate();*/
					String end = simple2.format(calendar1.getTime());
					System.out.println(begin+end);
					str = RC4entry.encry_RC4_byte("c|" + phone.substring(3) + "|" + begin
							+ "|" + end, "1234567890");
					byte[] by = Base64s.encode(str);
					// �����ά�����ݲ���
					@SuppressWarnings("rawtypes")
					HashMap hints = new HashMap();
					// �����ַ��������ʽ
					hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
					// �����ݴ�ȼ�������������ʹ��M����
					hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
					// ���ñ߿��
					hints.put(EncodeHintType.MARGIN, 2);
			
					// ���ɶ�ά��
					try {
						// ָ����ά������
						BitMatrix bitMatrix = new MultiFormatWriter().encode("#*"
								+ new String(by), BarcodeFormat.QR_CODE, width, height,
								hints);
			
						
						Path file = new File("/model3"+phone+".jpg").toPath();
						// MatrixToImageWriter.writeToFile(matrix, format, file);
						MatrixToImageWriter.writeToPath(bitMatrix, format, file);
					} catch (Exception e) {
						e.printStackTrace();
					}

	}

	// ��ȡmodel3
	@RequestMapping("model3Pic")
	public void model3Pic(HttpServletRequest request,HttpServletResponse response) {
		//System.out.println("model3�鿴��ά��");
		File  file;                   
		OutputStream out;
		InputStream input;
		byte[] bytes;
		    String  phone=request.getParameter("phone");
		                         file = new File("/model3"+phone+".jpg");
								try {
									 out = response.getOutputStream();
									 input = new FileInputStream(file);
									  bytes = new byte[1024];
									int i;
									while ((i = input.read(bytes)) != -1) {
										out.write(bytes);
										
									}
									out.flush();
									out.close();
									input.close();
						
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
						
								}
	}
	/**
	 * @throws IOException 
	 * @Description: С�������������֤
	 *@param:    1.request2.response
	 *@return: void
	 *@throws 
	 */
	@SuppressWarnings("static-access")
	@RequestMapping("/applyMsm")
		public void applySMS(HttpServletRequest request, HttpServletResponse response) throws IOException{
			
			// System.out.println("ģʽ3�鿴");
			String vertifi = null;//������֤��
			Random random; 
			int s ;
			SMSUtils sms = null; 
			OutputStream out;
			 String phone=request.getParameter("phone");
		         random = new Random();
		         s = random.nextInt(10000)%(10000-1000+1) + 1000;
		         vertifi=String.valueOf(s);
		         System.out.println(phone);
		     	String result=personMapper.selectExsistPhone(phone);
		     	 response.setContentType("application/json");
		         out=response.getOutputStream();
		     	if(result ==null){
		     		 out.write("faile".getBytes());
		     	}else{
		     		
		     		 sms.sendMsg(phone, vertifi); 
		     		 out.write(vertifi.getBytes());
		     	}
		       
		        
		        
		         out.flush();
		         out.close();
		         
		}
	/**
	 * @throws IOException 
	 * 
	 * @Description: С�����¼��֤
	 *@param:   request response
	 *@return: void
	 *@throws
	 */
		@RequestMapping("/login")
		@SuppressWarnings("unused")
		public void loginByValidate(HttpServletRequest request, HttpServletResponse response) throws IOException{
			
			 String phone=request.getParameter("phone");
			 String password=request.getParameter("password");
			 String md5PWD=DigestUtils.md5Hex(password);
			  Person person= personMapper.select_password(phone, md5PWD);
			 if(person==null){
				//��¼ʧ�� 
				 System.out.println("��¼ʧ��");
				OutputStream out= response.getOutputStream();
				out.write("faile".getBytes());
			 }else{
				 //�ж��Ƿ������¼
				 if(person.getAllow().equals("1")){
					 //�����¼
					 
				 }
				 else{
					 //û��Ȩ��
					 OutputStream out=response.getOutputStream();
						out.write("auth".getBytes());
					 
				 }
					 
				 System.out.println("��¼�ɹ�");
				OutputStream out=response.getOutputStream();
				out.write(person.getModel().getBytes());
			 }
			
		}
		/**
		 *@Description: ΢��С����ע��
		 *@param: request response
		 *@return: void
		 *@throws  
		 */
		@RequestMapping("/register")
		public void registerByWeChart(HttpServletRequest request, HttpServletResponse response){
			 	
			String phone=request.getParameter("phone");
			String passWord=request.getParameter("password");
			String md5Password=DigestUtils.md5Hex(passWord);
			String model=request.getParameter("model");
			System.out.println(model);
			/**
			 * �ж��Ƿ��Ѿ�ע��,��ע������ʾ��ע��
			 * ����ע��
			 */
			//String result=personMapper.selectExsistPhone(phone);
			personMapper.registerByChat(md5Password,phone,model);
			System.out.println("�ɹ�");
			try {
				OutputStream out=response.getOutputStream();
				out.write("success".getBytes());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			/*if(result !=null ){
				//�Ѿ�ע���
				try {
					OutputStream out=response.getOutputStream();
					out.write("faile".getBytes());
					System.out.println("ʧ��");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
			}
			else{
				Person person=new Person();
				person.setAllow("1");
				person.setName("444");
				person.setNumber("18737306083");
				person.setPassword("1111");
				person.setSex("��");
			//personMapper.insertPersonByAll(person);��
			//wechatMapper.registerByWeChat("187555", "12222");;
				personMapper.registerByChat(md5Password,phone,model);
			System.out.println("�ɹ�");
			try {
				OutputStream out=response.getOutputStream();
				out.write("success".getBytes());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}*/
		}
		/**
		 * 
		 * @Description: ��������
		 *@param:   
		 *@return: void
		 *@throws 
		 */
		
		@RequestMapping("/forget")
		public void forgetPassWordByWechat(HttpServletRequest request, HttpServletResponse response){
		
			 String phone=request.getParameter("phone");
			 String password=request.getParameter("password");
			 String md5PWD=DigestUtils.md5Hex(password);
			/**
			 * �ж��ֻ����Ƿ����
			 * 
			 * if true  �޸�
			 * else ��ʾ�˺Ų�����
			 */
			 String result=personMapper.selectExsistPhone(phone);
			 
				if(result !=null ){
					personMapper.updatePassword(md5PWD, phone);
				     System.out.println("�޸ĳɹ�");
				     try {
				    	 OutputStream out=response.getOutputStream();
						out.write("success".getBytes());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					  try {
						  System.out.println("�޸�ʧ��");
					    	 OutputStream out=response.getOutputStream();
							out.write("failer".getBytes());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					
				}
			 
			 
		}
}
