class S2027 {
    public static void main(String args[]) throws Exception {
        final int length = 5;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                sb.append(i == j ? '#' : '+');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}