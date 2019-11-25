/**
 * StringManipulator
 */
public class StringManipulator {
    public String trimAndConcat(String str1, String str2) {
        String newStr;
        newStr = (str1.trim()).concat((str2.trim()));
        return newStr;
    }
    public Integer getIndexOrNull(String str3, char c){
        int index = 0;
        index = str3.indexOf(c);
        if(index == -1){
            return null;
        }
        return index;
    }
    public Integer getIndexOrNull(String str4, String str5){
        int result = 0;
        result = str4.indexOf(str5);
        if(result== -1){
            return null;
        }
        return result;
    }

    public String concatSubstring(String str6, int int1, int int2, String str7){
        String newStr1, newStr2;
        newStr1 = str6.substring(int1, int2);
        newStr2 = newStr1.concat(str7);
        return newStr2;
    }
}