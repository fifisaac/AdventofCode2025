import java.sql.SQLOutput;

void main() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("input"));

    ArrayList<long[]> ranges = new ArrayList<>();
    String line = f.readLine();

    while (!line.isEmpty()) {

        long[] range = {Long.parseLong(line.split("-")[0]),  Long.parseLong(line.split("-")[1])};
        ranges.add(range);
        line = f.readLine();

    }

    ArrayList<Long> nums = new ArrayList<>();
    line = f.readLine();

    while (line != null) {
        nums.add(Long.parseLong(line));
        line = f.readLine();
    }

    long max = Collections.max(nums);

    System.out.println("Part 1: " + part1(nums, ranges));
    System.out.println("Part 2: " + part2(ranges));

}

int part1(ArrayList<Long> nums, ArrayList<long[]> ranges) {

    int total = 0;

    for (long num : nums) {
        for (long[] range : ranges) {
            if (range[0] <= num && num <= range[1]) {
                total++;
                break;
            }
        }
    }

    return total;

}

long part2(ArrayList<long[]> ranges) {

    long total = 0;

    ArrayList<long[]> newRanges = new ArrayList<>();

    ranges.sort(Comparator.comparingLong(l -> l[0]));

    int i = 0;
    int j = 0;
    while (j < ranges.size() && i < ranges.size()) {
        newRanges.add(ranges.get(i));
        while (i < ranges.size() && ranges.get(i)[0] <= newRanges.get(j)[1]) {

            if (ranges.get(i)[1] >= newRanges.get(j)[1]) {
                newRanges.set(j, new long[]{newRanges.get(j)[0], ranges.get(i)[1]});

            }
            i++;
        }
        j++;
    }

    for (long[] range : newRanges) {
        System.out.println(range[0] + " " + range[1]);
    }

    for (long[] range : newRanges) {
        total += 1 + range[1] - range[0];
    }

    return total;

}
