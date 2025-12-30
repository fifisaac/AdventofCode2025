void main() throws IOException {

    IO.println(part1());
    IO.println(part2());

}

public static int part1() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("input"));

    int count = 0;

    int pos = 50;
    boolean left;
    int num;
    String line = f.readLine();

    while (line != null) {
        left = (line.charAt(0) == 'L');
        num = Integer.parseInt(line.substring(1));

        if (left)
            pos = (pos - num) % 100;
        else
            pos = (pos + num) % 100;

        if (pos < 0)
            pos = 100 + pos;

        if (pos == 0)
            count += 1;

        line = f.readLine();
    }

    return count;

}

public static int part2() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("input"));

    int count = 0;

    int pos = 50;
    boolean left;
    int num;
    String line = f.readLine();

    while (line != null) {
        left = (line.charAt(0) == 'L');
        num = Integer.parseInt(line.substring(1));

        if (left)
            pos = (pos - num);
        else
            pos = (pos + num);

        if (pos > 99 || pos <= 0) {
            count += Math.abs(pos) / 100;
            if (pos <= 0 && pos != -num)
                count += 1;
        }

        pos = pos % 100;
        if (pos < 0)
            pos = 100 + pos;
        IO.println("Pos: " + pos);
        IO.println("Count: " + count);

        line = f.readLine();

    }

    return count;

}