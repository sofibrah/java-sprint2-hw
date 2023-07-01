import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path; //поможет вытащить из нужной папки таблицы с данными
import java.util.ArrayList; //распределит данные папки resourses по листам


public class FileReader {
    //в этом классе происходит привязка программы к отчетам их обработка
    // с помощью IOException и блока try catch предотвращаем возможную ошибку
    ArrayList<String> readFileContents(String fileName) {
        String path = "./resources/" + fileName;
        try {
            return new ArrayList<>(Files.readAllLines(Path.of(path)));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с отчётом. Возможно, файл отсутствует в нужной директории.");
            return new ArrayList<>();

        }
    }

}
