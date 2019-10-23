public class ShapeFactory {

    public CompositeShape create(String string) throws Exception {
            CompositeShape compositeShape = new CompositeShape();
            String shapeString = string.toLowerCase();
            String[] shapeArray = shapeString.split(System.getProperty("line.separator"));

            for (int i = 1; i < shapeArray.length; i++) {

                String shapeName = shapeArray[i].split(":")[0];
                String shapeInfo = shapeArray[i].split(":")[1];

                if (shapeName.equals("composite")) {
                    int shapesCount = Integer.valueOf(shapeArray[i].split(":")[1]);
                    String compositeInfo = "";
                    for (int j = 0; j <= shapesCount; j++) {
                        compositeInfo = compositeInfo.concat(shapeArray[i + j] + System.lineSeparator());
                    }
                    ShapeFactory factory = new ShapeFactory();
                    compositeShape.addShape(factory.create(compositeInfo));
                    i += shapesCount;
                }
                if (shapeName.equals("point")) {
                    Point point = new Point(shapeInfo);
                    compositeShape.addShape(point);
                }
                if (shapeName.equals("line")) {
                    Line line = new Line(shapeInfo);
                    compositeShape.addShape(line);
                }
                if (shapeName.equals("circle")) {
                    Circle circle = new Circle(shapeInfo);
                    compositeShape.addShape(circle);
                }
                if (shapeName.equals("triangle")) {
                    Triangle triangle = new Triangle(shapeInfo);
                    compositeShape.addShape(triangle);
                }
                if (shapeName.equals("rectangle")) {
                    Rectangle rectangle = new Rectangle(shapeInfo);
                    compositeShape.addShape(rectangle);
                }
                if (shapeName.equals("embeddedimage")) {
                    EmbeddedImage embeddedImage= new EmbeddedImage(shapeInfo);
                    compositeShape.addShape(embeddedImage);
                }
            }
            return compositeShape;
    }

}
