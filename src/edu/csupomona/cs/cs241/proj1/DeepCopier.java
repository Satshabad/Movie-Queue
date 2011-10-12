package edu.csupomona.cs.cs241.proj1;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class DeepCopier
{

   public static Serializable copy(Serializable tobeCopied){
      Serializable copy = null; 
      ByteArrayOutputStream bos = new ByteArrayOutputStream();
      ObjectOutputStream out= null;;
      try
      {
         out = new ObjectOutputStream(bos);
      } catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      try
      {
         out.writeObject(tobeCopied);
      } catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      try
      {
         out.flush();
      } catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      try
      {
         out.close();
      } catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }

      ObjectInputStream in = null;
      try
      {
         in = new ObjectInputStream(
             new ByteArrayInputStream(bos.toByteArray()));
      } catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      try
      {
         copy = (Serializable) in.readObject();
      } catch (IOException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      } catch (ClassNotFoundException e)
      {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      return copy;
      
      
   }
   
}
