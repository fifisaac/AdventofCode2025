public static void main(String[] args) throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("input"));

    String[] strRanges = f.readLine().split(",");
    Long[][] ranges = new Long[strRanges.length][2];

    int i = 0;
    int dash;

    for (String range: strRanges) {
        dash = range.indexOf("-");
        ranges[i] = new Long[]{Long.parseLong(range.substring(0, dash)),
                Long.parseLong(range.substring(dash + 1))};
        i++;
    }

    System.out.println(part1(ranges));
    System.out.println(part2(ranges));


}

public static long part1(Long[][] ranges) {

    String jString;
    String firstHalf;
    String secondHalf;
    long count = 0;

    for (Long[] range: ranges) {

        for (Long j=range[0]; j<=range[1]; j++) {

            jString = j.toString();

            if (jString.length() % 2 == 0) {

                firstHalf = jString.substring(0, jString.length() / 2);
                secondHalf = jString.substring(jString.length() / 2);

                if (secondHalf.compareTo(firstHalf) == 0)
                    count += j;

            }

        }

    }

    return count;
}

public static long part2(Long[][] ranges) {

    String iString;
    String initial;
    boolean flag = false;
    long count = 0;

    for (Long[] range: ranges) {

        for (Long i=range[0]; i<=range[1]; i++) {

            iString = i.toString();

            for (int j=1; j<iString.length(); j++) {

                if (iString.length() % j == 0) {

                    flag = true;

                    initial = iString.substring(0, j);

                    for (int k=0; k<iString.length(); k+=j) {

                        if (iString.substring(k, k + j).compareTo(initial) != 0) {
                            flag = false;
                            break;
                        }

                    }

                    if (flag)
                        break;

                }

            }

            if (flag) {
                count += i;
            }

        }

    }

    return count;

}