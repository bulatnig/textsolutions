public class Ex15 {

    static boolean isOneAway(String s1, String s2) {
        var diff = s1.length() - s2.length();
        if (diff > 1 || diff < -1) {
            return false;
        }
        var mismatchSeen = false;
        for (int i = 0, j = 0; i < s1.length() && j < s2.length(); i++, j++) {
            if (s1.charAt(i) != s2.charAt(j)) {
                if (mismatchSeen) {
                    return false;  // second mismatch character
                } else {
                    mismatchSeen = true;
                    if (diff > 0) {
                        i++;
                    } else if (diff < 0) {
                        j++;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneAway("pale", "ple"));
        System.out.println(isOneAway("pales", "pale"));
        System.out.println(isOneAway("pale", "bale"));
        System.out.println(isOneAway("pale", "bake"));
    }

}
