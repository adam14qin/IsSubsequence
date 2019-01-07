
public class IsSubsequence {
	
	public boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) return true;

        int index = 0;
        for (char ss : s.toCharArray()) {
            index = t.indexOf(ss, index); // Find the first occurrence of this char in String t starting from index
            if (index == -1) return false;
            index++;
        }
		
        return true;
    }
	
	public boolean isSubstring(String s, String t){
		int index=0;
		index=t.indexOf(s);
		if (index==-1) return false;
		return true;
	}
	
	public String repeatedSubstringPattern(String s){
		int len=s.length();
		String minRepeatedSubString=s.substring(0,len);
		for (int i=1;i<=len/2;i++){
            if(len%i==0){
                int j=0;
                for (;j<len;j+=i){
                    if (!s.substring(0,i).equals(s.substring(j,j+i))){
                        break;
                    }
                }
                if (j==len){
                	minRepeatedSubString=s.substring(0,i);
                    break;
                }
            }
        }
		return minRepeatedSubString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="BABA";
		String str2="CBABA";
		IsSubsequence i=new IsSubsequence();
		String unit=i.repeatedSubstringPattern(str1);
		System.out.println(unit);
		//Is it possible to form str1, given str2?
		System.out.println(i.isSubsequence(unit, str2));
		//What is the minimum number of copies
		int num=str1.length()/unit.length();
		int unitLen=unit.length();
		int minNum=num;
		for (int k=num;k>=1;k--){
			if(num%k==0){
				if (i.isSubsequence(str1.substring(0, k*unitLen), str2)){
					minNum=num/k;
					break;
				}
			}	
		}
		System.out.println(minNum);
		// What is the minimum number of copies if only substring is taken from str2
		for (int k=num;k>=1;k--){
			if(num%k==0){
				if (i.isSubstring(str1.substring(0, k*unitLen), str2)){
					minNum=num/k;
					break;
				}
			}	
		}
		System.out.print(minNum);
	}

}
