void main() throws IOException {

    System.out.println("Part 1: " + part1());
    System.out.println("Part 2: " + part2());

}

public static int part1() throws IOException{

    BufferedReader f = new BufferedReader(new FileReader("input"));

    char n1;
    int n1Index = 0;
    char n2;
    int n2Index = 0;
    int total = 0;
    String line = f.readLine();

    while (line != null) {

        n1 = '0';
        n2 = '0';

        for (int i=0; i<line.length(); i++) {

             char c = line.charAt(i);
             if (c > n1 && i+1<line.length()) {
                 n2 = '0';
                 n1 = c;
                 n1Index = i;
             } else if (c > n2) {
                 n2 = c;
                 n2Index = i;
             }

        }

        if (n1Index < n2Index) {
            total += Integer.parseInt("" + n1 + n2);
        } else {
            total += Integer.parseInt("" + n2 + n1);
        }
        line = f.readLine();

    }

    return total;

}

public static long part2() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("input"));

    char[] nums;
    long total = 0;
    int startIndex;
    String line = f.readLine();

    while (line != null) {

        nums = new char[12];
        startIndex = 0;

        System.out.println(line);

        for (int i=0; i<12; i++) {

            for (int j=0; j<line.length()-(11-i); j++) {

                if (nums[i] < line.charAt(j)) {
                    nums[i] = line.charAt(j);
                    startIndex = j;
                }

            }

            line = line.substring(startIndex+1);

//            System.out.println();

        }

        String totalString = "";
        for (char num: nums) {

            totalString += num;

        }

        total += Long.parseLong(totalString);

        line = f.readLine();

    }


    return total;
}