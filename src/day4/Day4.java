void main() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("input"));

    ArrayList<char[]> characters = new ArrayList<>();
    int lineNum = 1;
    String line = f.readLine();

    characters.add(new char[line.length()+2]);
    Arrays.fill(characters.getFirst(), '?');

    while (line != null) {

        characters.add(new char[line.length()+2]);

        characters.get(lineNum)[0] = '?';
        characters.get(lineNum)[line.length()+1] = '?';

        for (int i=1; i<line.length()+1; i++) {

            characters.get(lineNum)[i] = line.charAt(i-1);

        }

        line = f.readLine();
        lineNum++;

    }

    characters.add(new char[characters.getFirst().length]);
    Arrays.fill(characters.getLast(), '?');

    System.out.println("Part 1: " + part1(characters));
    System.out.println("Part 2: " + part2(characters, 0));
}

int part1(ArrayList<char[]> characters) {

    int total = 0;

    for (int y=1; y<characters.size()-1; y++) {

        char[] row = characters.get(y);
        char[] nextRow = characters.get(y+1);
        char[] lastRow = characters.get(y-1);

        for (int x=1; x<row.length-1; x++) {

            if (row[x] == '@') {

                char[] surroundings = {
                        row[x-1], row[x+1], nextRow[x-1], nextRow[x], nextRow[x+1], lastRow[x-1], lastRow[x], lastRow[x+1]
                };

                int count = 0;

                for (char c: surroundings)
                    if (c == '@')
                        count++;

                if (count < 4)
                    total++;

            }

        }

    }

    return total;
}

int part2(ArrayList<char[]> characters, int total) {

    int removed = 0;

    for (int y=1; y<characters.size()-1; y++) {

        char[] row = characters.get(y);
        char[] nextRow = characters.get(y+1);
        char[] lastRow = characters.get(y-1);

        for (int x=1; x<row.length-1; x++) {

            if (row[x] == '@') {

                char[] surroundings = {
                        row[x-1], row[x+1], nextRow[x-1], nextRow[x], nextRow[x+1], lastRow[x-1], lastRow[x], lastRow[x+1]
                };

                int count = 0;

                for (char c: surroundings)
                    if (c == '@')
                        count++;


                if (count < 4) {
                    removed++;
                    row[x] = '.';
                }

            }

        }

    }

    total += removed;

    if (removed != 0)
        total = part2(characters, total);

    return total;
}