import java.net.*;  
import java.io.*;  
class TCPServer{  
public static void main(String args[])throws Exception{  
System.out.println("Waiting for connection...");   
ServerSocket ss=new ServerSocket(9999);  
Socket s=ss.accept();  
DataInputStream din=new DataInputStream(s.getInputStream());  
DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
  
String str="",str2="",str1="";  
while(!str.equals("stop")){  
str=din.readUTF();  
System.out.println("client says: "+str);  
 
int count = 0,count1=0;
            for (int i = 0; i < str.length(); i++) {
               if (Character.isLetter(str.charAt(i)))
                 count++;
             }
			 
			 str2=Integer.toString(count);
			 
dout.writeUTF(str2);  
dout.flush();
 char ch[]= new char[str.length()];     
            for(int i=0;i<str.length();i++)  
            {  
                ch[i]= str.charAt(i);  
                if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                    count1++;  
            }
 str1=Integer.toString(count1);
			 
dout.writeUTF(str1);  
dout.flush();			
}  
din.close();  
s.close();  
ss.close();  
}}  

