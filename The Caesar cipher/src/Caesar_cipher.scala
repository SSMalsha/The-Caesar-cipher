//19000901

import scala.io.StdIn.readLine
import scala.io.StdIn.readInt

object Caesar_cipher extends App{

  val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ "

  val encrypt = (c:Char, key:Int, alphabet:String) => alphabet((alphabet.indexOf(c.toUpper) + key)%alphabet.size)
  val decrypt = (c:Char, key:Int, alphabet:String) => alphabet((alphabet.indexOf(c.toUpper) - key + alphabet.size)%alphabet.size)

  val cipher = (algo:(Char, Int, String) => Char, message:String, key:Int, alphabet:String) => message.map(algo(_, key, alphabet))

  print("Enter your message: ")
  val input = readLine()

  print("Enter key to shift: ")
  val key = readInt()

  print("Do you want to encrypt or decrypt? ")
  val str = readLine()

  if(str == "encrypt"){
    val encryptedString = cipher(encrypt, input, key, alphabet)
    val decryptedString = cipher(decrypt, encryptedString, key, alphabet)

    printf("Encryption: %s\n",encryptedString)
    printf("Decryption: %s\n",decryptedString)
  }
  else if(str == "decrypt"){
    val decryptedString = cipher(decrypt, input, key, alphabet)
    val encryptedString = cipher(encrypt, decryptedString, key, alphabet)

    printf("Decryption: %s\n",decryptedString)
    printf("Encryption: %s\n",encryptedString)
  }
  else{
    println("ERROR!")
  }
}
