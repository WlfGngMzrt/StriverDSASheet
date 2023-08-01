public class Main {
    public static void main(String[] args) {
        //the edge case that we need to take care of in terms of passing
        //the power as int as per question.
        System.out.println(binaryExponentiation(2,Integer.MIN_VALUE));
    }

    public static double bruteForce(double base, int pow)
    {
        // this is a brute force method where we just iterate to get the
        // power of the given number
        double ans = 1.0;
        long expo = pow;
        //if its negative we first make it positive and then we try to find it's
        //power
        expo = expo < 0 ? (expo*(-1)) : expo;
        for(int i = 0;i < expo; i++)
        {
            ans *= base;
        }

        if(pow < 0)
        {
            return 1.0/ans;
        }
        return ans;
    }


    public static double binaryExponentiation(double base, int pow)
    {
        double ans = 1.0;
        long expo = pow;
        expo = expo < 0 ? (expo*(-1)) : expo;
        while(expo > 0)
        {
            if(expo % 2 == 1)
            {
                ans *= base;
                expo--;
            }
            else
            {
                base *= base;
                expo /= 2;
            }
        }

        if(pow < 0)
        {
            return 1.0/ans;
        }
        return ans;
    }
}