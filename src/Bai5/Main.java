package Bai5;
import java.io.*;
import java.util.*;
class InvalidConfigException extends Exception {
    public InvalidConfigException(String message) {
        super(message);
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BufferedReader br = null;
        Map<String, String> config = new HashMap<>();

        try {
            System.out.print("Enter config file path: ");
            String file = sc.nextLine();

            br = new BufferedReader(new FileReader(file));

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("=", 2);

                if (parts.length != 2 || parts[0].trim().isEmpty())
                    throw new InvalidConfigException("Invalid line: " + line);
                String key = parts[0].trim();
                String value = parts[1].trim();
                config.put(key, value);
            }

            if (!config.containsKey("username"))
                throw new InvalidConfigException("Missing username.");

            if (!config.containsKey("timeout"))
                throw new InvalidConfigException("Missing timeout.");

            int timeout = Integer.parseInt(config.get("timeout"));

            if (timeout <= 0)
                throw new InvalidConfigException("timeout must be > 0.");

            if (config.containsKey("maxConnections")) {
                int max = Integer.parseInt(config.get("maxConnections"));

                if (max < 1)
                    throw new InvalidConfigException(
                            "maxConnections must be >= 1.");
            }

            for (Map.Entry<String, String> entry : config.entrySet())
                System.out.println(entry.getKey() + "=" + entry.getValue());

            System.out.println("Config loaded successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Config file not found.");
        } catch (IOException e) {
            System.out.println("I/O error.");
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (InvalidConfigException e) {
            System.out.println("Invalid config: " + e.getMessage());
        } finally {
            try {
                if (br != null)
                    br.close();
            } catch (IOException e) {
                System.out.println("I/O error.");
                e.printStackTrace();
            }

            System.out.println("Program finished.");
        }
    }

}
