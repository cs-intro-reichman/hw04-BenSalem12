//import java.io.*;
//import java.util.Arrays;
public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        String s = "vowels are fun", check1, s2 = "MMMM";
		char char1 = 'M';
		check1 = capVowelsLowRest (s);
		System.out.println("The capVowelsLowRest is: " + check1);
//		int[] arrCheck = allIndexOf (s2, char1);
//		System.out.println(Arrays.toString(arrCheck));
		//allIndexOf(s2, char1);
    }

    public static String capVowelsLowRest (String string) {
		String vowels = "aeiou";
		int ascii;
        char ch;
        for (int i = 0; i< string.length(); i ++){		
			ch = string.charAt(i);
            ascii = ch;
			// check if it is not a vowel and if it is an upper case letter and then change it to lower case letter
            if(vowels.indexOf(ch) == -1 && (ascii>=65 && ascii<=90)) {
                ascii = ascii + 32; 
                ch = (char)ascii;
                string = string.substring(0, i) + ch + string.substring(i + 1);			
			}
			
			// check if it is a vowel and if it is a lower case letter and then change it to upper case letter
			else if (vowels.indexOf(ch) != -1 && (ascii>=97 && ascii<=122)) {
                ascii = ascii - 32; 
                ch = (char)ascii;
                string = string.substring(0, i) + ch + string.substring(i + 1);			
			}
		}
        return string;
    }

    /*public static String camelCase (String string) {
		char ch;
		int ascii, num = 0;
		while (string.charAt(num) != ' '){
			if(ascii>=65 && ascii<=90) {
                ascii = ascii + 32; 
                ch = (char)ascii;
                string = string.substring(0, num) + ch + string.substring(num + 1);
			}
			num ++;
		}	
        for (int i = 2; i< string.length(); i ++){		
			if (string.charAt(i) != ' ' && 
		}
        return "";
    }*/
	
    public static String camelCase (String string) {
        int ascii;
        char ch1 = ' ', ch2 = ' ';
        int strLen = string.length();
        int i=0 ;
		
        // remove spaces from begining of string
        while (string.charAt(0) == ' '){
			string = string.substring(0,0) + string.substring(1); 
        }
		
        // change the first letter of string to lowercase
        ch1 = string.charAt(0);
        ascii = ch1;
        if(ascii < 97) {
            ascii = ascii + 32; 
            ch1 = (char)ascii;
            string = ch1 + string.substring(1);  
        }

        // change the first letter of each word to uppercase and the remaining letters to lowercase
        strLen = string.length();
        ch1 = string.charAt(0);
        for(i=1;i<strLen; i++){ 
            ch2 = string.charAt(i);
            ascii = ch2;
            if (ch1 == ' '){
                if (ascii >= 97) {
                    ascii = ascii - 32; 
                    ch2 = (char)ascii;
                    string = string.substring(0,i) + ch2 + string.substring(i+1);
                }                
            }else if (ascii >= 65 && ascii <= 90) {
                ascii = ascii + 32; 
                ch2 = (char)ascii;
                string = string.substring(0,i) + ch2 + string.substring(i+1);
            }
            ch1 = ch2;
        }
       
        // remove all spaces from the string
        i = 0;
        strLen = string.length();
        while (i < strLen - 1){
            for(i=0;i<strLen;i++){ 
                ch1 = string.charAt(i);
                ascii = ch1;
                if (i == 0) {
                    if(ascii < 97) {
                        ascii = ascii + 32; 
                        ch1 = (char)ascii;
                        string = ch1 + string.substring(i+1);  
                    }  
                }else if (ascii == 32) {
                    string = string.substring(0,i) + string.substring(i+1);
                    break;  
                }
            }
            strLen = string.length();
        }
        return string;
    }
	
    public static int[] allIndexOf (String string, char chr) {
		int count = 0;
		String sForA = "";
        for (int i = 0; i< string.length(); i ++){		
			if(string.charAt(i) == chr){
				count++;
				sForA += i;
			}
		}
		
		int[] arr = new int[count];
		
        /*for (int i = 0; i< string.length(); i ++){		
			if (string.charAt(i) == chr){
				sForA += i;
			}	
		}*/
		for (int i = 0; i< arr.length; i ++){
			//arr [i] = Character.getNumericValue(sForA.charAt(i));
			//arr [i] = Integer.parseInt(String.valueOf(sForA.charAt(i)));
			//arr [i] = sForA.charAt(i) - 48;
			arr [i] = sForA.charAt(i) - '0';	
		}
        return arr;
    }
	
//    public static /*int[]*/ void allIndexOf (String string, char chr) {
//		int count = 0;
//		String sForA = "";
//        for (int i = 0; i< string.length(); i ++){		
//			if(string.charAt(i) == chr){
//				count++;
//				sForA += i;
//			}
//		}
//		
//		int[] arr = new int[count];
//		
//        /*for (int i = 0; i< string.length(); i ++){		
//			if (string.charAt(i) == chr){
//				sForA += i;
//			}	
//		}*/
//		for (int i = 0; i< arr.length; i ++){
//			//arr [i] = Character.getNumericValue(sForA.charAt(i));
//			//arr [i] = Integer.parseInt(String.valueOf(sForA.charAt(i)));
//			//arr [i] = sForA.charAt(i) - 48;
//			arr [i] = sForA.charAt(i) - '0';	
//		}
//		System.out.println(Arrays.toString(arr));
 //       //return arr;
 //   }
}
