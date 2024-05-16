import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader in = new FileReader("C:\\Users\\Patthadol Raksapram\\Desktop\\Workshop-Exam\\jujube_log.csv");
        try (BufferedReader reader = new BufferedReader(in)) {
            Stream<String> lines = reader.lines().skip(1);
            List<Item> list = new ArrayList<>();
            lines.forEach(data -> {
                String[] line = data.split(",");
                Item item = new Item(
                        line[0],
                        line[1],
                        line[2],
                        line[3]);
                list.add(item);
            });

            // PPP - Pre-process
            System.out.println("Pre-process is running...");

            // XXX - Remove spaces
            class spaceRemoval {
                public String removeSpace(String str) {
                    return str.trim();
                }
            } // method reference
            spaceRemoval sr = new spaceRemoval();
            list.stream().forEach((Item item) -> {
                item.setName(sr.removeSpace(item.getName()));
                item.setSurname(sr.removeSpace(item.getSurname()));
                item.setEmail(sr.removeSpace(item.getEmail()));
                item.setHours(sr.removeSpace(item.getHours()));
            });

            // YYY - Convert to uppercase
            class upperCase {
                public String toUpperCase(String str) {
                    return str.toUpperCase();
                }
            } // method reference
            upperCase uc = new upperCase();
            list.stream().forEach((Item item) -> {
                item.setName(uc.toUpperCase(item.getName()));
                item.setSurname(uc.toUpperCase(item.getSurname()));
                item.setEmail(uc.toUpperCase(item.getEmail()));
                item.setHours(uc.toUpperCase(item.getHours()));
            }); //

            // DDD - Process data
            System.out.println("Process data is running...");
            List<Item> processedData = new ArrayList<>();
            list.stream().sorted((Item i1, Item i2) -> i2.getSurname().compareTo(i1.getSurname()))
                    .forEach((Item item) -> {
                        processedData.add(item);
                    });

            // ZZZ - Generate unique ID
            List<String> uid = new ArrayList<>();
            processedData.stream().forEach((Item item) -> {
                uid.add(item.getName() + "_" + item.getSurname());
            });

            // ZZZ 1
            long uniqueParticipants = uid.stream().distinct().count();
            System.out.println("Number of unique participants: " + uniqueParticipants);

            // ZZZ 2-4 Can't be done T-T. I'm sorry.
            // List<Integer> hours = new ArrayList<>();
            // List<Integer> minutes = new ArrayList<>();

            // ZZZ 5
            System.out.print("Individuals with duplicate unique ID: ");
            uid.stream().filter((String id) -> uid.stream().filter(id::equals).count() > 1).distinct()
                    .forEach((String id) -> {
                        System.out.print(id + ", ");
                    });
            System.out.println();

            // OOO - Output Result
            System.out.println("Output Result:");
            processedData.stream().forEach((Item item) -> {
                System.out.println(
                        item.getName() + " " + item.getSurname() + " " + item.getEmail() + " " + item.getHours() + " "
                                + uid.get((processedData.indexOf(item))));
            });
        }
    }
}
