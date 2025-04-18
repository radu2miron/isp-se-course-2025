package edu.tucn.ispse.lecture7.iostreams;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

/**
 * @author <a href="mailto:radu.miro@aut.utcluj.ro">Radu Miron</a>
 */
public class Ex4JsonSerializationGSON {
    public static void main(String[] args) throws IOException {
        // create a GSON object
        Gson gson = new Gson();

        System.out.println("1.Serialize (Write object to file) / 2.Deserialize (Read object from file)");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        if (choice.equals("1")) {
            Controller controller = new Controller(1, "Omron", "PLC-1");

            // object to JSON String
            String controllerJson = gson.toJson(controller);
            System.out.println(controllerJson);

            // write JSON to file
            Writer writer = new FileWriter("testfiles/ctrl" + controller.getId() + ".json");
            gson.toJson(controller, writer);
            writer.flush();
            writer.close();
        } else if (choice.equals("2")) {
            System.out.println("Controller id:");

            // read object from JSON file
            Controller controller = gson.fromJson(
                    new FileReader("testfiles/ctrl" + scanner.nextLine() + ".json"), Controller.class);

            System.out.println(controller);
        } else {
            throw new IllegalArgumentException("Invalid choice");
        }
    }

    private static class Controller {
        private int id;
        private String vendor;
        private String model;

        public Controller(int id, String vendor, String model) {
            this.vendor = vendor;
            this.model = model;
            this.id = id;
        }

        public String getVendor() {
            return vendor;
        }

        public void setVendor(String vendor) {
            this.vendor = vendor;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Controller{" +
                    "id=" + id +
                    ", vedor='" + vendor + '\'' +
                    ", model='" + model + '\'' +
                    '}';
        }
    }
}
