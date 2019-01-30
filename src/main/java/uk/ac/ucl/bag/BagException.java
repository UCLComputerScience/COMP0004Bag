package uk.ac.ucl.bag;

public class BagException extends Exception
{
  /**
    * Use the default message.
    */
   public BagException()
   {
     super("Bag error");
   }

   /**
    * Provide a custom message.
    * @param message The message to store in the exception object.
    */
   public BagException(String message)
   {
     super(message);
   }

}
