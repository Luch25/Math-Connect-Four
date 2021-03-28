import java.util.Scanner;
import java.text.DecimalFormat;

class Grades
{
  Scanner scan;
  DecimalFormat f1;

  public Grades (){
    scan = new Scanner(System.in);
    f1 = new DecimalFormat("#.####");
  }

  public int greatestCommonFactor(int num1, int num2)
  {
    int result = 0;
    
    if(num2 % num1 == 0)
      return num1;
    if(num1 % num2 == 0)
      return num2;

    int small = (int)(Math.min(num1, num2));
    int large = (int)(Math.max(num1, num2));

    for(int i = 1; i < small / 2 + 1; i++)
      if(small % i == 0 && large % i == 0)
        result = i;
    
    return result;
  }
  //notPrime

  public boolean isPrime(int num)
  {
    for(int i = 2; i < num / 2; i++)
      if(num % i == 0)
        return false;
    
    return true;
  }

  public boolean addition(int num1, int num2, int lBound, int hBound)
    {
      int ans = num1 + num2;
      int result;

      do
      {
        System.out.print("Addition:\t" + num1 + " + " + num2 + ":\t");
        result = scan.nextInt();
      }
      while(result < lBound || result > hBound);

      return ans == result;
    }

  public boolean subtraction(int num1, int num2, int lBound, int hBound)
  {
    int ans;
    int result;

    if(num1 >= num2)
      ans = num1 - num2;
    else
      ans = num2 - num1;

    do
    {
      if(num1 >= num2)
        System.out.print("Subtraction:\t" + num1 + " - " + num2 + ":\t");
      else
        System.out.print("Subtraction:\t" + num2 + " - " + num1 + ":\t");
      result = scan.nextInt();
    }
    while(result < lBound || result > hBound);

    return ans == result;
  }

  public boolean multiplication(int num1, int num2, int lBound, int hBound)
  {
    int ans = num1 * num2;
    int result;

    do
    {
      System.out.print(num1 + " * " + num2 + ":\t");
      result = scan.nextInt();
    }
    while(result < lBound || result > hBound);

    return ans == result;
  }

  public boolean division(int num1, int num2, int lBound, int hBound)
  {
    int result;
    int ans = num1 / num2;
      
    do
    {
      System.out.print("Divison\t" + num1 + " / " + num2 + ":\t");
      result = scan.nextInt();
    }
    while(result < lBound || result > hBound);

    return ans == result;
  }

  public boolean simplifyFrac(int numerator, int denominator)
  {
    int resultN;
    int resultD;

    int gcf = greatestCommonFactor(numerator, denominator);
    int simpN = numerator / gcf;
    int simpD = denominator / gcf;
    
    do
    {
      System.out.print("Simplify\t" + numerator + " / " + denominator + ":\nNumerator:\t\t");
      resultN = scan.nextInt();
      System.out.print("Denominator:\t");
      resultD = scan.nextInt();
    }
    while(resultN < 1 || resultD < 1);

    return resultN == simpN && resultD == simpD;
  }

  public boolean fracAdd(int numerator1, int denominator1, int numerator2, int denominator2)
  {
    int resultN;
    int resultD;
    double ans;

    double result = (((double)(numerator1)) / denominator1) + (((double)(numerator2)) / denominator2);
    
    do
    {
      System.out.print("Add\t(" + numerator1 + " / " + denominator1 + ") + (" + numerator2 + " / " + denominator2 + "):\nNumerator:\t\t");
      resultN = scan.nextInt();
      System.out.print("Denominator:\t");
      resultD = scan.nextInt();
    }
    while(resultN < 1 || resultD < 1);

    ans = (((double)(resultN)) / resultD);

    return f1.format(ans).equals(f1.format(result));
  }

  public boolean fracSubtract(int numerator1, int denominator1, int numerator2, int denominator2)
  {
    int resultN;
    int resultD;
    double ans;

    double first = (((double)(numerator1)) / denominator1);
    double second = (((double)(numerator2)) / denominator2);
    double small = Math.min(first, second);
    double large = Math.max(first, second);

    double result = large - small;
    
    do
    {
      if(large == first)
        System.out.print("Subtract\t(" + numerator1 + " / " + denominator1 + ") - (" + numerator2 + " / " + denominator2 + "):\nNumerator:\t\t");
      else
        System.out.print("Subtract\t(" + numerator2 + " / " + denominator2 + ") - (" + numerator1 + " / " + denominator1 + "):\nNumerator:\t\t");
      resultN = scan.nextInt();
      System.out.print("Denominator:\t");
      resultD = scan.nextInt();
    }
    while(resultN < 1 || resultD < 1);

    ans = (((double)(resultN)) / resultD);

    return f1.format(ans).equals(f1.format(result));
  }

  public boolean fracMultiply(int numerator1, int denominator1, int numerator2, int denominator2)
  {
    int resultN;
    int resultD;
    double ans;

    double result = (((double)(numerator1)) / denominator1) * (((double)(numerator2)) / denominator2);
    do
    {
      System.out.print("Multiply\t(" + numerator1 + " / " + denominator1 + ") * (" + numerator2 + " / " + denominator2 + "):\nNumerator:\t\t");
      resultN = scan.nextInt();
      System.out.print("Denominator:\t");
      resultD = scan.nextInt();
    }
    while(resultN < 1 || resultD < 1);

    ans = (((double)(resultN)) / resultD);

    return f1.format(ans).equals(f1.format(result));
  }

  public boolean fracDivide(int numerator1, int denominator1, int numerator2, int denominator2)
  {
    int resultN;
    int resultD;
    double ans;

    double result = (((double)(numerator1)) / denominator1) * (((double)(denominator2)) / numerator2);
    do
    {
      System.out.print("Divide\t(" + numerator1 + " / " + denominator1 + ") / (" + numerator2 + " / " + denominator2 + "):\nNumerator:\t\t");
      resultN = scan.nextInt();
      System.out.print("Denominator:\t");
      resultD = scan.nextInt();
    }
    while(resultN < 1 || resultD < 1);

    ans = (((double)(resultN)) / resultD);

    return f1.format(ans).equals(f1.format(result));
  }
}

class Kindergarten extends Grades
{
  public Kindergarten()
  {
    super();
  }

  public boolean kindMeth()
  {
    return kindAddition();
  }

  public boolean kindAddition()
  {
    int num1 = (int)(Math.random() * 5 + 1);
    int num2 = (int)(Math.random() * 5 + 1);

    return addition(num1, num2, 2, 10);
  }
}

class First extends Grades
{
  public First()
  {
    super();
  }

  public boolean firstMeth()
  {
    int problem = (int)(Math.random() * 2 + 1);

    if(problem == 1)
      return firstAddition();
    else
      return firstSubtract();
  }

  public boolean firstAddition()
  {
    int num1 = (int)(Math.random() * 7 + 1);
    int num2 = (int)(Math.random() * 7 + 1);

    return addition(num1, num2, 2, 14);
  }

  public boolean firstSubtract()
  {
    int num1 = (int)(Math.random() * 5 + 1);
    int num2 = (int)(Math.random() * 5 + 1);

    return subtraction(num1, num2, 0, 4);
  }
}

class Second extends Grades
{
  public Second()
  {
    super();
  }

  public boolean secondMeth()
  {
    int problem = (int)(Math.random() * 3 + 1);

    if(problem == 1)
      return secondAddition();
    else if(problem == 2)
      return secondSubtract();
    else
      return secondMult();
  }

  public boolean secondAddition()
  {
    int num1 = (int)(Math.random() * 10 + 1);
    int num2 = (int)(Math.random() * 10 + 1);

    return addition(num1, num2, 2, 20);
  }

  public boolean secondSubtract()
  {
    int num1 = (int)(Math.random() * 10 + 1);
    int num2 = (int)(Math.random() * 10 + 1);

    return subtraction(num1, num2, 0, 9);
  }

  public boolean secondMult()
  {
    int num1 = (int)(Math.random() * 5 + 1);
    int num2 = (int)(Math.random() * 5 + 1);

    return multiplication(num1, num2, 1, 25);
  }
}

class Third extends Grades
{
  public Third()
  {
    super();
  }

  public boolean thirdMeth()
  {
    int problem = (int)(Math.random() * 4 + 1);

    if(problem == 1)
      return thirdAddition();
    else if(problem == 2)
      return thirdSubtract();
    else if(problem == 3)
      return thirdMult();
    else
      return thirdDiv();
  }

  public boolean thirdAddition()
  {
    int num1 = (int)(Math.random() * 100 + 1);
    int num2 = (int)(Math.random() * 100 + 1);

    return addition(num1, num2, 2, 200);
  }

  public boolean thirdSubtract()
  {
    int num1 = (int)(Math.random() * 50 + 1);
    int num2 = (int)(Math.random() * 50 + 1);

    return subtraction(num1, num2, 0, 49);
  }

  public boolean thirdMult()
  {
    int num1 = (int)(Math.random() * 10 + 1);
    int num2 = (int)(Math.random() * 10 + 1);

    return multiplication(num1, num2, 1, 100);
  }

  public boolean thirdDiv()
  {
    int num1;
    int num2;

    do
    {
      num1 = (int)((Math.random() + 26)*(Math.random() + 1));
    }
    while(isPrime(num1));

    do
    {
      num2 = (int)((Math.random()) * (num1 / 2) + 1);
    }
    while(num1 % num2 != 0);

    return division(num1, num2, 1, num1);
  }
}

class Fourth extends Grades
{
  public Fourth()
  {
    super();
  }

  public boolean fourthMeth()
  {
    int problem = (int)(Math.random() * 5 + 1);

    if(problem == 1)
      return fourthAddition();
    else if(problem == 2)
      return fourthSubtract();
    else if(problem == 3)
      return fourthMult();
    else if(problem == 4)
      return fourthDiv();
    else
      return fourthSimplifyFrac();
  }

  public boolean fourthAddition()
  {
    int num1 = (int)(Math.random() * 250 + 1);
    int num2 = (int)(Math.random() * 250 + 1);

    return addition(num1, num2, 2, 500);
  }

  public boolean fourthSubtract()
  {
    int num1 = (int)(Math.random() * 250 + 1);
    int num2 = (int)(Math.random() * 250 + 1);

    return subtraction(num1, num2, 0, 249);
  }

  public boolean fourthMult()
  {
    int num1 = (int)(Math.random() * 100 + 1);
    int num2 = (int)(Math.random() * 20 + 1);

    return multiplication(num1, num2, 1, 2000);
  }

  public boolean fourthDiv()
  {
    int num1;
    int num2;

    do
    {
      num1 = (int)((Math.random() + 100) * (Math.random() + 1));
    }
    while(isPrime(num1));

    do
    {
      num2 = (int)((Math.random()) * (num1 / 2) + 1);
    }
    while(num1 % num2 != 0);

    return division(num1, num2, 1, num1);
  }

  public boolean fourthSimplifyFrac()
  {
    int numerator;
    int denominator;

    numerator = (int)(Math.random() * 10 + 2 );
    denominator = (int)(Math.pow(numerator, 2));

    return simplifyFrac(numerator, denominator);
  }
}

class Fifth extends Grades
{
  public Fifth()
  {
    super();
  }

  public boolean fifthMeth()
  {
    int problem = (int)(Math.random() * 9 + 1);

    if(problem == 1)
      return fifthAddition();
    else if(problem == 2)
      return fifthSubtract();
    else if(problem == 3)
      return fifthMult();
    else if(problem == 4)
      return fifthDiv();
    else if(problem == 5)
      return fifthSimplifyFrac();
    else if(problem == 6)
      return fifthFracAdd();
    else if(problem == 7)
      return fifthFracSub();
    else if(problem == 8)
      return fifthFracMult();
    else
      return fifthFracDiv();
  }

  public boolean fifthAddition()
  {
    int num1 = (int)(Math.random() * 1000 + 1);
    int num2 = (int)(Math.random() * 1000 + 1);

    return addition(num1, num2, 2, 2000);
  }

  public boolean fifthSubtract()
  {
    int num1 = (int)(Math.random() * 1000 + 1);
    int num2 = (int)(Math.random() * 1000 + 1);

    return subtraction(num1, num2, 0, 999);
  }

  public boolean fifthMult()
  {
    int num1 = (int)(Math.random() * 200 + 1);
    int num2 = (int)(Math.random() * 20 + 1);

    return multiplication(num1, num2, 1, 4000);
  }

  public boolean fifthDiv()
  {
    int num1;
    int num2;

    do
    {
      num1 = (int)((Math.random() + 500) * (Math.random() + 1));
    }
    while(isPrime(num1));

    do
    {
      num2 = (int)(Math.random() * (num1 / 2) + 1);
    }
    while(num1 % num2 != 0);

    return division(num1, num2, 1, num1);
  }

  public boolean fifthSimplifyFrac()
  {
    int numerator;
    int denominator;

    numerator = (int)(Math.random() * 19 + 2);

    int gcf;

    do
    {
      denominator = (int)(Math.random()* 100 + 1);
      gcf = greatestCommonFactor(numerator, denominator);
    }
    while(gcf == 1 || numerator >= denominator || gcf == 0);

    return simplifyFrac(numerator, denominator);
  }

  public boolean fifthFracAdd()
  {
    int denominator1 = (int)(Math.random() * 10 + 1);
    int denominator2 = (int)(Math.random() * 10 + 1);
    int numerator1 = (int)(Math.random() * 10 + 1);
    int numerator2 = (int)(Math.random() * 10 + 1);

    return fracAdd(numerator1, denominator1, numerator2, denominator2);
  }

  public boolean fifthFracSub()
  {
    int denominator1 = (int)(Math.random() * 10 + 1);
    int denominator2 = (int)(Math.random() * 10 + 1);
    int numerator1 = (int)(Math.random() * 10 + 1);
    int numerator2 = (int)(Math.random() * 10 + 1);

    return fracSubtract(numerator1, denominator1, numerator2, denominator2);
  }

  public boolean fifthFracMult()
  {
    int denominator1 = (int)(Math.random() * 10 + 1);
    int denominator2 = (int)(Math.random() * 10 + 1);
    int numerator1 = (int)(Math.random() * 10 + 1);
    int numerator2 = (int)(Math.random() * 10 + 1);

    return fracMultiply(numerator1, denominator1, numerator2, denominator2);
  }

  public boolean fifthFracDiv()
  {
    int denominator1 = (int)(Math.random() * 10 + 1);
    int denominator2 = (int)(Math.random() * 10 + 1);
    int numerator1 = (int)(Math.random() * 10 + 1);
    int numerator2 = (int)(Math.random() * 10 + 1);

    return fracDivide(numerator1, denominator1, numerator2, denominator2);
  }
}