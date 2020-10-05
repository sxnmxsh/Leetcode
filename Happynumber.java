class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while(n != 1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            n = sum(n);
        }
        return true;
    }
    
    public int sum(int n){
        int sum = 0;
        while(n > 0){
            sum += (n%10) * (n%10);
            n = n/10;
        }
        return sum;
    }
    
    /*
    1 - happy
    2 - (4),16,37,58,89,145,42,20,(4)
    3 - 9,81,65,61,(37),58,89,145,42,20,4,16,(37)
    4 - (16),37,58,89,145,42,20,4,(16)
    5 - 25,29,85,(89),145,42,20,4,16,37,58,(89)
    6 - 36,45,41,17,50,25,29,85,(89),145,42,20,4,16,37,58,(89)
    7 - 49,97,130,10,1 - happy
    8 - 64,52,29,85,(89),145,42,20,4,16,37,58,(89)
    9 - 81,65,61,(37),58,89,145,42,20,4,16,(37)
    
    Space complexity : O(1)
    */
    public boolean isHappyOptimized(int n) {
        // loop until you get a single digit number
        while(!isSingleDigit(n)) {
            n = sum(n);
        }
        // number is now a single digit check if it is 1 or 7 for happy number
        return (n == 1 || n == 7);
    }
    
    public boolean isSingleDigit(int num) {
        return num / 10 == 0;
    }
}
