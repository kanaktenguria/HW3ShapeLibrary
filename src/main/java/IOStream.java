import java.io.*;

public class IOStream {

    public CompositeShape readShape(String filename) throws Exception {

        File file = new File(filename);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        String currentLine = bufferedReader.readLine();
        String shape ="";

        while (currentLine != null) {
            shape = shape.concat(currentLine + System.lineSeparator());
            currentLine= bufferedReader.readLine();
        }
        ShapeFactory shapeFactory = new ShapeFactory();
        CompositeShape compositeShape = shapeFactory.create(shape);
        return compositeShape;
    }

    public void writeShape(String filename, CompositeShape shape) throws Exception {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename), "utf-8"))) {
            writer.write(shape.toString());
        }
    }

}
