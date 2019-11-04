package com.test;

import java.text.DecimalFormat;

public class NumberToWordConverterProgram {

 
  private static final String[] numNames = {
		  // Following code is used to declare digit names
    "",
    " one",
    " two",
    " three",
    " four",
    " five",
    " six",
    " seven",
    " eight",
    " nine",
    " ten",
    " eleven",
    " twelve",
    " thirteen",
    " fourteen",
    " fifteen",
    " sixteen",
    " seventeen",
    " eighteen",
    " nineteen"
  };

  private NumberToWordConverterProgram() {}

  private static String convertLessThanOneThousand(int number) {
    String tempVar;

    if (number % 100 < 20){
      tempVar = numNames[number % 100];
      number /= 100;
    }
    else {
      tempVar = numNames[number % 10];
      number /= 10;

      tempVar = tensNames[number % 10] + tempVar;
      number /= 10;
    }
    if (number == 0) return tempVar;
    return numNames[number] + " hundred" + tempVar;
  }

  private static final String[] tensNames = {
		    "",
		    " ten",
		    " twenty",
		    " thirty",
		    " forty",
		    " fifty",
		    " sixty",
		    " seventy",
		    " eighty",
		    " ninety"
		  };

  public static void convert(long number) {
    // 0 to 999 999 999 999
    if (number == 0) { System.out.println("Given Number is 0 => zero");  }

    String snumber = Long.toString(number);

    // pad with "0"
    String mask = "000000000000";
    DecimalFormat df = new DecimalFormat(mask);
    snumber = df.format(number);

    // XXXnnnnnnnnn
    int billions = Integer.parseInt(snumber.substring(0,3));
    // nnnXXXnnnnnn
    int millions  = Integer.parseInt(snumber.substring(3,6));
    // nnnnnnXXXnnn
    int hundredThousands = Integer.parseInt(snumber.substring(6,9));
    // nnnnnnnnnXXX
    int thousands = Integer.parseInt(snumber.substring(9,12));

    String tradBillions;
    switch (billions) {
    case 0:
      tradBillions = "";
      break;
    case 1 :
      tradBillions = convertLessThanOneThousand(billions)
      + " billion ";
      break;
    default :
      tradBillions = convertLessThanOneThousand(billions)
      + " billion ";
    }
    String result =  tradBillions;

    String tradMillions;
    switch (millions) {
    case 0:
      tradMillions = "";
      break;
    case 1 :
      tradMillions = convertLessThanOneThousand(millions)
         + " million ";
      break;
    default :
      tradMillions = convertLessThanOneThousand(millions)
         + " million ";
    }
    result =  result + tradMillions;

    String tradHundredThousands;
    switch (hundredThousands) {
    case 0:
      tradHundredThousands = "";
      break;
    case 1 :
      tradHundredThousands = "one thousand ";
      break;
    default :
      tradHundredThousands = convertLessThanOneThousand(hundredThousands)
         + " thousand ";
    }
    result =  result + tradHundredThousands;

    String tradThousand;
    tradThousand = convertLessThanOneThousand(thousands);
    result =  result + tradThousand;

    // remove extra spaces!
    System.out.println("Given Number is "+number+" => "+result.replaceAll("^\\s+", "").replaceAll("\\b\\s{2,}\\b", " "));
    
  }

  /**
   * testing
   * @param args
   */
  public static void main(String[] args) {
	  // Give an input to given below format
	  long inputNum1=1;
	  long inputNum2=21;
	  long inputNum3=105;
	  long inputNum4=56945781;
	  long inputNum5=999999999;

	  NumberToWordConverterProgram.convert(inputNum1);
	  NumberToWordConverterProgram.convert(inputNum2);
	  NumberToWordConverterProgram.convert(inputNum3);
	  NumberToWordConverterProgram.convert(inputNum4);
	  NumberToWordConverterProgram.convert(inputNum5);
	  
    
  }
}
