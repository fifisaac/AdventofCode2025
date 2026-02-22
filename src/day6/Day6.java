void main() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("input"));

    String line = f.readLine();

    ArrayList<ArrayList<Integer>> nums = new ArrayList<>();

    while (Character.isDigit(line.charAt(0)) || line.charAt(0) == ' ') {

        int j = 0;

        for (String s: line.split("[ \\t]+")) {
            nums.add(new ArrayList<>());
            if (!s.isEmpty()) {
                nums.get(j).add(Integer.parseInt(s));
                j++;
            }
        }
        line = f.readLine();
    }

    String[] symbols = line.split("[ \\t]+");

    System.out.println("Part 1: " + part1(nums, symbols));

}

long part1(ArrayList<ArrayList<Integer>> nums, String[] symbols) {

    long total = 0;

    int i = 0;
    for (String s: symbols) {

        ArrayList<Integer> column = nums.get(i);
        long temp = column.getFirst();

        if (s.compareTo("*") == 0) {
            for (int j = 1; j < column.size(); j++) {
                temp = temp * column.get(j);
            }
        } else  {
            for (int j = 1; j < column.size(); j++) {
                temp = temp + column.get(j);
            }
        }

        total += temp;
        i++;


    }

    return total;

}