class Ex19 {

    static boolean isStringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        String s = s1 + s1;
        return s.contains(s2);
    }

    public static void main(String[] args) {
        System.out.println(isStringRotation("waterbottle", "erbottlewat"));
        System.out.println(isStringRotation("volleyball", "eybalkvoll"));
        System.out.println(isStringRotation("aa", "aab"));
    }

}