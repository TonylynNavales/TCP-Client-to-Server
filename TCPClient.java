import java.net.*;  
import java.io.*;  
class TCPClient{  
public static void main(String args[])throws Exception{  
Socket s=new Socket("localhost",9999);  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2="",str1=""; 
System.out.println("Connected to the Server"); 
while(!str.equals("stop")){ 
System.out.println("Please put a message.Note:if you put stop the program will end"); 
str=br.readLine();  
dout.writeUTF(str);  
dout.flush();  
str2=din.readUTF();  
str1=din.readUTF();
System.out.println("Server says:Your message was '"+str+"'. There are "+str2 +" letters in your message. And there are "+str1+" words");  
}  
  
dout.close();  
s.close();  
}}  
